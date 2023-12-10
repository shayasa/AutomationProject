package day05_homeTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.DocuportConstants;
import utilities.WebDriverFactory;

import java.time.Duration;

public class Task03 {
//    . login as an advisor
//2. go to received document
//3. click search
//4. click status dropdown
//5. choose in progress

    WebDriver driver;
    @BeforeClass
    public void setUo() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://beta.docuport.app/login");
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        WebElement logInBtn = driver.findElement(By.xpath("//input[@id='input-14']"));
        logInBtn.sendKeys("b1g2_advisor@gmail.com" + Keys.ENTER );
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.xpath("//input[@id='input-15']"));
        password.sendKeys("Group2" + Keys.ENTER);
        Thread.sleep(2000);
        WebElement receivedDoc = driver.findElement(By.xpath("//span[text()='Received docs']"));
        receivedDoc.click();
        Thread.sleep(2000);
        WebElement searchBtn = driver.findElement(By.xpath("//span[text()='Search']"));
        searchBtn.click();
        Thread.sleep(2000);
       WebElement all = driver.findElement(By.xpath("//input[@id='input-143']"));
        all.click();
        Thread.sleep(2000);
       WebElement inProgress = driver.findElement(By.xpath("(//div[text()='In progress'])[2]"));
       inProgress.click();


    }
}