package day7_windows;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T0_iframe_practice extends TestBase {
    @Test
    public void navigate(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");}
    @Test
    public void nestedIframe() {
       navigate();
        driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.xpath("//*[contains(text(),'LEFT')]"));
        String actualLeft = left.getText();
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-button");}
    @Test
    public void right() {
       navigate();
        driver.switchTo().frame("frame-right");
        WebElement right = driver.findElement(By.xpath("//*[contains(text(),'RIGHT')]"));
        Assert.assertEquals(right.getText(),"RIGHT","Dosent match");}
    @Test
    public void middle() {
       navigate();
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.xpath("//*[contains(text(),'MIDDLE')]"));
        Assert.assertEquals(middle.getText(),"MIDDLE","Dosent match");}
    @Test
    public void bottom() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.xpath("//*[contains(text(),'BOTTOM')]"));
        Assert.assertEquals(bottom.getText(),"BOTTOM","DOSENT MATCH");}
}