package com.Bitrix24.pages;

import com.Bitrix24.utilities.ConfigurationReader;
import com.Bitrix24.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage () {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(name = "USER_LOGIN")
    public WebElement userNameInput;

    @FindBy(name = "USER_PASSWORD")
    public WebElement passwordInput;

    @FindBy(className = "login-btn")
    public WebElement loginButton;

    public void loginAsHR() {
        userNameInput.sendKeys(ConfigurationReader.get("hr_username"));
        passwordInput.sendKeys(ConfigurationReader.get("hr_password"));
        loginButton.click();

        }

    }
