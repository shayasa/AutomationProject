package day3_homeTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class Task05 {
    public static void main(String[] args) {
//        1. Open Chrome browser
//        2. Go to https://www.etsy.com
//        3. Search for “wooden spoon”
//        4. Verify title:
//        Expected: “Wooden spoon | Etsy”

        WebDriver driver = WebDriverFactory.getDriver("chrome");
       // driver.manage().window().maximize();
        driver.get("https://www.etsy.com");

        WebElement searchBtn = driver.findElement(By.id("global-enhancements-search-query"));
        searchBtn.sendKeys("wooden spoon" + Keys.ENTER);

        System.out.println(driver.getTitle().contains("Wooden spoon | Etsy") ? "TEST PASSED" : "TEST FAILED");

        System.out.println("It should be : " +driver.getTitle());

        driver.close();

    }
}
