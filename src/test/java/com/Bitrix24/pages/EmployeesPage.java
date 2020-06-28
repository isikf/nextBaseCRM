package com.Bitrix24.pages;

import com.Bitrix24.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeesPage extends BasePage {

    @FindBy (xpath ="//span[contains(text(), 'Find Employee')]")
    public WebElement findEmployeeModule;

    public String getEmailAddress(String name) {
        String emailPath= "//a[contains(text(),'" + name + "')]/../../../following-sibling::td/a[contains(text(),'@')]";
        WebElement emailElement = Driver.get().findElement(By.xpath(emailPath));
        return emailElement.getText();

    }



}
