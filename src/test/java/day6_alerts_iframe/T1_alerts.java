package day6_alerts_iframe;

import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static  org.testng.Assert.*;

public class T1_alerts extends TestBase {
    /*
    Information alert practice
    1. Open browser
    2. Go to website: https://loopcamp.vercel.app/javascript-alerts.html
    3. Click to “Click for JS Alert” button
    4. Click to OK button from the alert
    5. Validate “You successfully clicked an alert” text is displayed

    Confirmation alert practice
    1. Click to “Click for JS Confirm” button
    2. Click to OK button from the alert
    3. Verify “You clicked: Ok” text is displayed.
    4. Click to “Click for JS Confirm” button
    5. Click to Cancel button from the alert
    6. Validate “You clicked: Cancel” text is displayed.

    Prompt alert practice
    1. Click to “Click for JS Prompt” button
    2. Send "Loop Academy"
    3. Click Ok
    4. Validate "You entered: Loop Academy" text is displayed


     */
    @Test
    public void informationAlert() {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        clickForJSAlert.click();


        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement successMessageForInformation = driver.findElement(By.xpath("//p[@id='result']"));

        String expected = "You successfully clicked an alert";
        String actual = successMessageForInformation.getText();
        assertEquals(actual, expected, "actual dosent match the expected");

    }

    @Test
    public void confirmationAlert() {

        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSConfirm = driver.findElement(By.xpath("//button[confirm(text(),'Click for JS Confirm')]"));
        clickForJSConfirm.click();

        driver.switchTo().alert().accept();
        WebElement successMessageForConfirmation = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "You clicked: Ok";
        String actual = successMessageForConfirmation.getText();
        assertEquals(actual, expected, "Actual dosent match the expected ");

        clickForJSConfirm.click();
        driver.switchTo().alert().dismiss();
        actual = clickForJSConfirm.getText();
        expected = "You clicked: Cancel";
        assertEquals(actual, expected, "actual does not match the expected");

    }

    @Test
    public void promptAlert() throws InterruptedException {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickJSPrompt = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));

        clickJSPrompt.click();
        String text = "Loop Academy";
//                 driver.switchTo().alert().sendKeys(text);
        Thread.sleep(2000);
//                 driver.switchTo().alert().accept();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();

        WebElement successMessagePromptAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = successMessagePromptAlert.getText();
        String expected = "You entered: " + text;
        assertEquals(actual, expected, "actual does not match the expected");

    }


}