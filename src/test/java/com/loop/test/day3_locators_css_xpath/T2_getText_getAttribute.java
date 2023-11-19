package com.loop.test.day3_locators_css_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.LoopCampConstants;
import utilities.WebDriverFactory;

public class T2_getText_getAttribute {
    public static void main(String[] args) {


        /*
    go to url: https://loopcamp.vercel.app/registration_form.html
    verify header text expected:  Registration form
    verify placeholder attribute value expected - username
     */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/registration_form.html");

        WebElement headerForForm = driver.findElement(By.tagName("h2"));
        String actualHeaderForForm = headerForForm.getText();

        if (actualHeaderForForm.equals(LoopCampConstants.EXPECTED_HEADER_FOR_FORM)){
            System.out.println("Expected header far form: \"" +  LoopCampConstants.EXPECTED_HEADER_FOR_FORM + "\", matches actual header: \"" +
                    actualHeaderForForm + "\" = TEST PASSED");
        }else{
            System.out.println("Expected header far form: \"" +  LoopCampConstants.EXPECTED_HEADER_FOR_FORM + "\", DOES NOT matches actual header: \"" +
                    actualHeaderForForm + "\" = TEST Failed");
        }

        WebElement userNamePlaceHolder = driver.findElement(By.name("username"));
        String actualPlaceHolderForUsername = userNamePlaceHolder.getAttribute("placeholder");
        System.out.println("actualPlaceHolderForUsername = " + actualPlaceHolderForUsername);

        if (actualPlaceHolderForUsername.equals(LoopCampConstants.EXPECTED_PLACEHOLDER_USERNAME)){
            System.out.println("Expected placeholder for username: \"" +  LoopCampConstants.EXPECTED_HEADER_FOR_FORM + "\", matches actual placeholder: \"" +
                    actualPlaceHolderForUsername + "\" = TEST PASSED");
        }else{
            System.out.println("Expected placeholder for username: \"" +  LoopCampConstants.EXPECTED_HEADER_FOR_FORM + "\", DOES NOT matches actual placeholder: \"" +
                    actualPlaceHolderForUsername + "\" = TEST Failed");

        }
    }
}