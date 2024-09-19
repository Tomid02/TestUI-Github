package org.qaautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage extends BasePage {

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(name = "user[password]")
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement userField;

    @FindBy(css = "[data-continue-to='password-container']")
    WebElement emailContinueBtn;

    @FindBy(css = "[data-continue-to='username-container']")
    WebElement passwordContinueBtn;

    @FindBy(css = "[data-continue-to='opt-in-container']")
    WebElement userContinueBtn;

    @FindBy(css = "[data-continue-to='captcha-and-submit-container']")
    WebElement signUpContinueBtn;

    @FindBy(className = "text-mono text-bold signup-text-prompt mt-4 px-sm-0 px-4")
    WebElement signUpText;

    public SignUpPage(WebDriver driver){
        super(driver);
    }

    public void enterEmail(String email){emailField.sendKeys(email);}

    public void enterPassword(String password){passwordField.sendKeys(password);}

    public void enterUsername(String username){userField.sendKeys(username);}

    public void waitAndClickEmailBtn(int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(emailContinueBtn)); // Espera hasta que el botón sea clickeable
        emailContinueBtn.click();
    }

    public void waitAndClickPasswordBtn(int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(passwordContinueBtn)); // Espera hasta que el botón sea clickeable
        passwordContinueBtn.click();
    }

    public void waitAndClickUserBtn(int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(userContinueBtn)); // Espera hasta que el botón sea clickeable
        userContinueBtn.click();
    }

    public void waitAndClickSignUpBtn(int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(signUpContinueBtn)); // Espera hasta que el botón sea clickeable
        signUpContinueBtn.click();
    }

    public String getMessage(){
        return signUpText.getText();
    }


}
