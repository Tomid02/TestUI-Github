package org.qaautomation.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        PageFactory.initElements(driver, this);
    }

//    public void takeScreenshot(String filePath) {
//        TakesScreenshot screenshot = (TakesScreenshot) driver;
//        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
//        File destFile = new File(filePath);
//        try {
//            FileUtils.copyFile(srcFile, destFile);
//            System.out.println("Captura de pantalla tomada y guardada en: " + destFile.getAbsolutePath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public void clickButton(WebElement element){
        if(isButton(element)){
            element.click();
        }
        else {
            throw new IllegalArgumentException("This element is not a button");
        }
    }

    public boolean isButton(WebElement element){
        String tagName = element.getTagName();
        String typeAttribute = element.getAttribute("type");
        return tagName.equalsIgnoreCase("button") || typeAttribute.equalsIgnoreCase("submit");
    }

}
