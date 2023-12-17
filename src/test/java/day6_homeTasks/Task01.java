package day6_homeTasks;

import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task01  extends TestBase {

    //    1. go to https://demoqa.com/alerts
    @Test
    public void test1() {
        driver.get("https://demoqa.com/alerts");
        WebElement alertBtn = driver.findElement(By.xpath("//button[@id='alertButton']"));
        alertBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();}
    @Test
    public void test2() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement onBtn = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        onBtn.click();Thread.sleep(7000);
         Alert alert = driver.switchTo().alert();
         alert.accept();}
    @Test
    public void test3() {
        driver.get("https://demoqa.com/alerts");
        //6. click - On button click, confirm box will appear
        WebElement confirmBtn = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        confirmBtn.click();
        //7. click ok and validate - You selected Ok
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement selected = driver.findElement(By.xpath("//span[@id='confirmResult']"));
        String actual = selected.getText();
        String exc = "You selected Ok";
        Assert.assertEquals(actual, exc, "Test Failed");}
    @Test
    public void test4() {
        driver.get("https://demoqa.com/alerts");
        WebElement promptBtn = driver.findElement(By.xpath("//button[@id='promtButton']"));
        promptBtn.click();
         Alert alert = driver.switchTo().alert();
         alert.sendKeys("Loop Academy");
         alert.accept();
        WebElement validatePrompt = driver.findElement(By.xpath("//span[@class='text-success']"));
        String actual = validatePrompt.getText();
        String expected = "You entered Loop Academy";
        Assert.assertEquals(actual, expected, "Test Failed");


    }
}




//4. click - On button click, alert will appear after 5 seconds
//5. handle alert
//6. click - On button click, confirm box will appear
//7. click ok and validate - You selected Ok
//8. after that do it again this time cancel and validate - You selected Cancel
//9. click - On button click, prompt box will appear
//10. enter "Loop Academy" and validate You entered Loop Academy


