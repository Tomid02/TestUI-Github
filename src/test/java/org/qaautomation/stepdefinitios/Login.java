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
import org.qaautomation.pages.LoginPage;

import java.time.Duration;

public class Login {
    WebDriver driver ;
    LoginPage loginPage;

    @Given("the user is on the login page of Github")
    public void userIsOnLoginPage(){
        ChromeOptions options = new ChromeOptions();
        String pathChromeDriver = System.getProperty("user.dir") + "\\rsc\\drivers\\chromedriver.exe";

        System.out.println("[Info]Ruta driver " + pathChromeDriver);

        System.setProperty("webdriver.chrome.driver", pathChromeDriver);

        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.setPageLoadTimeout(Duration.ofSeconds(60));

        options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);
        driver.get("https://github.com/login");
        loginPage = new LoginPage(driver);
    }

    //Scenario LoginOk
    @When("the user enters username {string} and password {string}")
    public void userEntersCredentialsValids(String username, String password){
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("the user clicks the login button")
    public void userClicksLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be logged in")
    public void userShouldBeLoggedIn() {
        Assert.assertTrue("[WARNING] Erorr al iniciar sessión", loginPage.isLoginSuccessful());
    }

    //Scenario LoginInvalid
    @When("the user enters username {string} and password {string} invalids")
    public void userEntersCredentialsInvalids(String username, String password){
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Then("the user should see an error message {string}")
    public void userShoulSeeErrorMessage(String expectedErrorMessage) {
        Assert.assertEquals("[WARNING] the error message does not match what was expected", expectedErrorMessage, loginPage.getErrorMessage());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Navegador cerrado despues del escenario");
        }
    }
}
