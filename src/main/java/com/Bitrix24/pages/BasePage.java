package com.Bitrix24.pages;

import com.Bitrix24.utilities.BrowserUtils;
import com.Bitrix24.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage () {
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(id = "pagetitle")
    public WebElement pageTitle;

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void navigateToModule(String tab) {

        String tabLocator = "//span[@class='menu-item-link-text'][contains(text(),'"+tab+"')]";

        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            tabElement.click();
            //new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();//span[@class='menu-item-link-text'][contains(text(),'Mail')]
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }

    }





}
