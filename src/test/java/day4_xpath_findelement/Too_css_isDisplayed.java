package day4_xpath_findelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class Too_css_isDisplayed {
    public static void main(String[] args) {

         /*
    http://the-internet.herokuapp.com/forgot_password
     */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/forgot_password");


        WebElement forgetPasswordHeading = driver.findElement(By.cssSelector("div[class='example']>h2"));

        if (forgetPasswordHeading.isDisplayed()){
            System.out.println("Forget password heading is displayed");
        }else{
            System.out.println("Forget password heading is  NOT displayed");

        }
    }
}
