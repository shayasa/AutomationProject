package day3_locators_css_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        WebElement searchBoxID = driver.findElement(By.id("APjFqb"));
        WebElement searchBoxName = driver.findElement(By.name("q"));

        WebElement aboutLink = driver.findElement(By.linkText("About"));

       // aboutLink.click();
        String textToSearch = "Loop Academy";

        searchBoxID.sendKeys(textToSearch);
        searchBoxID.click();
        searchBoxID.sendKeys("Loop Academy " + Keys.ENTER);

        String expectedUrl= "";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
        String actualTitle = driver.getTitle();

        if (actualTitle.contains("Loop Academy")){
            System.out.println("Actual Title contains \"Loop\"");
        }else{
            System.out.println("Actual Title DOES NOT MATCH \"Loop\"");
        }


//
//        System.out.println(driver.getCurrentUrl().contains("Loop")? "Actual URL contains \"LOOP\" in it -- PASSED" : "Current URL does not " +
//                "match -- FAILED");
//
//        System.out.println(driver.getTitle().contains("Loop academy - Google'da axtarış")? "Actual Title contains \"LOOP\" in it -- PASSED" :
//                "Current URL does not " +
//                        "match -- FAILED");
    }
}
