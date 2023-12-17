package day7_homeTasks;

import base.TestBase;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Task02<Set> extends TestBase {
//     1. go to https://loopcamp.vercel.app/
//            2. click "Multiple Windows" link
//    3. Validate "Powered by Loopcamp" is displayed
//    4. Validate title is "Windows"
//            5. Click - click here
//    6. Switch to new window and validate title

    @Test
    public void test(){
        driver.get("https://loopcamp.vercel.app/");
        WebElement multiWindows = driver.findElement(By.xpath("//a[text()='Multiple Windows']"));
        multiWindows.click();
        WebElement poweredBtn = driver.findElement(By.xpath("//div[text()='Powered by ']"));
        System.out.println("Powered by Loopcamp is displayed" + poweredBtn.isDisplayed());

        Assert.assertEquals(driver.getTitle(),"Windows","TEST FAILED");

        WebElement clickHereBtn = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHereBtn.click();

        java.util.Set<String> windowsHandle = driver.getWindowHandles();
        for (String each : windowsHandle) {
            driver.switchTo().window(each);
        }


        Assert.assertEquals(driver.getTitle(),"New Window","TEST FAILED");



    }
}
