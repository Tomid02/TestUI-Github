package org.qaautomation.stepdefinitios;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.qaautomation.pages.SignUpPage;

import java.time.Duration;

public class SingUp {
    WebDriver driver ;
    SignUpPage signUpPage;

    @Given("the user is on the sing up page of Github")
    public void userIsOnSingUpPage(){
        ChromeOptions options = new ChromeOptions();
        String pathChromeDriver = System.getProperty("user.dir") + "\\rsc\\drivers\\chromedriver.exe";

        System.out.println("[Info]Ruta driver " + pathChromeDriver);

        System.setProperty("webdriver.chrome.driver", pathChromeDriver);

        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.setPageLoadTimeout(Duration.ofSeconds(60));

        options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);
        driver.get("https://github.com/signup");
        signUpPage = new SignUpPage(driver);
    }

    @When("the user enters a valid email {string} and clicks continue")
    public void entersEmailValid(String email){
        signUpPage.enterEmail(email);
        signUpPage.waitAndClickEmailBtn(1);
    }

    @When("the user enters a invalid email {string}")
    public void entersEmailInvalid(String email){
        signUpPage.enterEmail(email);
    }

    @Then("the user should see the message {String} ")//Email is invalid or already taken

    @And("the user enters a valid password {string} and clicks continue")
    public void entersPasswordValid(String password){
        signUpPage.enterPassword(password);
        signUpPage.waitAndClickPasswordBtn(10);
    }

    @And("the user enters a valid username {string} and clicks continue")
    public void entersUsernameValid(String username){
        signUpPage.enterUsername(username);
        signUpPage.waitAndClickUserBtn(10);
    }

    @And("the user clicks sign up button")
    public void userClcksSignUpBtn(){
        signUpPage.waitAndClickSignUpBtn(10);
    }

    @Then("the user should see the message {string} along with a captcha to verify")
    public void userSeeCaptcha(String expectedMessage){
        Assert.assertEquals("[WARNING] the message does not match what was expected", expectedMessage, signUpPage.getMessage());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Navegador cerrado despues del escenario");
        }
    }
}
