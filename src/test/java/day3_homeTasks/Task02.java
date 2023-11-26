package day3_homeTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DocuportConstants;
import utilities.WebDriverFactory;

public class Task02 {
    public static void main(String[] args) throws InterruptedException {
//        1. login to docuport application
//        2. logout from docuport application
//        3. Validate successful login
//        4. Validate successful logout
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
        driver.get("https://beta.docuport.app");

        WebElement userName = driver.findElement(By.id("input-14"));
        userName.sendKeys(DocuportConstants.USERNAME_CLIENT);
        WebElement password = driver.findElement(By.id("input-15"));
        password.sendKeys(DocuportConstants.PLACEHOLDER_FOR_PASSWORD);
        Thread.sleep(3000);
        WebElement loginBtn = driver.findElement(By.cssSelector("span[class='v-btn__content']"));
        loginBtn.click();
        System.out.println(driver.getCurrentUrl().equals("https://beta.docuport.app/") ? " TEST1 PASSED" : "TEST1 FAILED") ;
        Thread.sleep(3000);
        WebElement continueBTtn = driver.findElement(By.cssSelector("button[type='submit']"));
        continueBTtn.click();

        Thread.sleep(3000);
        WebElement bg = driver.findElement(By.cssSelector("span[class='subtitle-2 text-none pl-2 pr-3 gray--text text--darken-3']"));
        bg.click();
        Thread.sleep(3000);
        WebElement logOUT = driver.findElement(By.xpath("(//span[@class='body-2'])[5]"));
        logOUT.click();
        Thread.sleep(3000);
        System.out.println(driver.getCurrentUrl().equals("https://beta.docuport.app/login") ? " TEST2 PASSED" : "TEST 2 FAILED");
        driver.close();
    }
}
