package day05_homeTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.time.Duration;

public class Task02 {
//    1. go to https://www.etsy.com/
//            2. search for rings
//3. validate that Estimated Arrival shows any time
//3. click Estimated Arrival dropdown
//4. click Select custom date
//5. choose may 30 from dropdown
//6. validate Estimated Arrival shows may 30

    WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.etsy.com");}
    @AfterClass
    public void tearDown() {driver.quit();}
    @Test
    public void test1() throws InterruptedException {
        WebElement searchBtn = driver.findElement(By.xpath("//input[contains(@id,'global-enhancements-')]"));
        searchBtn.sendKeys("rings" + Keys.ENTER);
        //3. validate that Estimated Arrival shows any time
        WebElement estimatedBTn = driver.findElement(By.xpath("(//div[@class='wt-panel__trigger-container']button/span/span/span"));
        Thread.sleep(2000);
        Assert.assertEquals(estimatedBTn.getText(),"Any time");


//        //4. click Select custom date
//        WebElement selectCustom = driver.findElement(By.xpath("(//div[@class='wt-panel__trigger-container']/button)[1]"));
//        Thread.sleep(2000);
//        selectCustom.click();
//
//        Select dropDown = new Select(driver.findElement(By.xpath("(//select[@name='delivery_days'])[2]")));
//        Thread.sleep(2000);
//
//        //5. choose may 30 from dropdown
//        dropDown.selectByVisibleText("By Dec 30");
//        Thread.sleep(2000);
//
//        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(),"By Dec 30");




    }
}