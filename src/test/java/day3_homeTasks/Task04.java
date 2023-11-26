package day3_homeTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class Task04 {
    public static void main(String[] args) {
//        1- Open a chrome browser
//        2- Go to: https://google.com
//        3- Click to Gmail from top right.
//        4- Verify title contains:
//        Expected: Gmail
//        5- Go back to Google by using the .back();
//        6- Verify title equals:
//        Expected: Google

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://google.com");
        WebElement gmailBtn = driver.findElement(By.linkText("Gmail"));
        gmailBtn.click();
        if (driver.getTitle().contains("Gmail")){
            System.out.println("TEST1 PASSED");
        }else{
            System.out.println("TEST1 FAILED");
        }
        driver.navigate().back();

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("TEST2 PASSED");
        }else{
            System.out.println("TEST2 FAILED");
        }
        driver.close();
    }
}
