package org.qaautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "login_field")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(name = "commit")
    WebElement loginButton;

    @FindBy(className = "avatar circle")
    WebElement userAvatar;

    @FindBy(className = "js-flash-alert")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username){
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        clickButton(loginButton);
    }

    public Boolean isLoginSuccessful(){
        return userAvatar.isDisplayed();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
}
