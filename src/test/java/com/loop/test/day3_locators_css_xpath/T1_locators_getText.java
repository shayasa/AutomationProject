package com.loop.test.day3_locators_css_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.DocuportConstants;
import utilities.WebDriverFactory;

public class T1_locators_getText {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app");
        WebElement userName = driver.findElement(By.id("input-14"));
        userName.sendKeys(DocuportConstants.USERNAME_CLIENT);

        WebElement loginBtn = driver.findElement(By.className("v-btn__content"));
        loginBtn.click();

        WebElement errorMessage = driver.findElement(By.className("v-messages__message"));
        String actualErrorMessage = errorMessage.getText();

        if (actualErrorMessage.equals(DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD)){
            System.out.println("expected error message: " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD  + " , matches actual error message: " + actualErrorMessage + " . TEST PASSED");
        }else {
            System.out.println("Expected error message: " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + ", DOES NOT match actual error message: " + actualErrorMessage);
            System.err.println("TEST FAILED");
            driver.quit();
        }

    }
}
