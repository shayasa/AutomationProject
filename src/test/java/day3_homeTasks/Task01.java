package day3_homeTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class Task01 {
    public static void main(String[] args) {
//        1. go to https://loopcamp.vercel.app/forgot-password.html
//        2. locate 5 elements, forgot password, email, email input, retrieve password, powered by LOOPCAMP
//        3. use css
//        4. verify those elements are displayed
        WebDriver driver = WebDriverFactory.getDriver("chrome");
       // driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/forgot-password.html");

        WebElement forgotPassword = driver.findElement(By.cssSelector("div[class='example']>h2"));

        WebElement email = driver.findElement(By.cssSelector("label[for='email']"));
        WebElement emailInput = driver.findElement(By.cssSelector("input[type='text']"));
        WebElement retrievePassword =driver.findElement(By.cssSelector("button[id='form_submit']>i"));
        WebElement poweredByLoopcamp = driver.findElement(By.cssSelector("div[class='large-4 large-centered columns']>div"));


        System.out.println("forgotPassword.isDisplayed() = " + forgotPassword.isDisplayed());

        System.out.println("email.isDisplayed() = " + email.isDisplayed());

        System.out.println("emailInput.isDisplayed() = " + emailInput.isDisplayed());
        System.out.println("retrievePassword.isDisplayed() = " + retrievePassword.isDisplayed());
        System.out.println("poweredByLoopcamp.isDisplayed() = " + poweredByLoopcamp.isDisplayed());

        driver.quit();

    }
}
