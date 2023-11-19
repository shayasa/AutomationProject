package com.loop.test.day3_locators_css_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    /**
     * Navigate to Google search
     * maximize the page
     * get title of the page
     * get url of the page
     * validate the title, expected title is "Google"
     * validate the url of the page, expected url is "https://www.google.com/"
     * close the brower
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        driver.manage().window().maximize();

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        String expectedURL = "https://www.google.com/";
        String actualURL = driver.getCurrentUrl();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        driver.quit();
    }
}
