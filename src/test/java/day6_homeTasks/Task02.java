package day6_homeTasks;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task02 extends TestBase {
//    1. go to https://demoqa.com/nestedframes


    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demoqa.com/nestedframes");
        Thread.sleep(3000);
        WebElement parentIframe = driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(parentIframe);

        WebElement childIframe = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        driver.switchTo().frame(childIframe);

        WebElement childText = driver.findElement(By.xpath("//p[text()='Child Iframe']"));
        String actual = childText.getText();
        String expected = "Child Iframe";
        Assert.assertEquals(actual, expected, "Test Fail");
        driver.switchTo().defaultContent();

        driver.switchTo().frame(parentIframe);
        WebElement parentText = driver.findElement(By.xpath("//body[text()='Parent frame']"));
        Assert.assertEquals(parentText.getText(), "Parent frame", "Test Fail");
        driver.switchTo().defaultContent();

        WebElement nestedIframe = driver.findElement(By.xpath("//div[@id='framesWrapper']/div"));
         actual = nestedIframe.getText();
         expected = "Sample Nested Iframe page. There are nested iframes in this page. Use browser " +
                "inspecter or firebug to check out the HTML source. " +
                "In total you can switch between the parent frame and the nested child frame.";
        Assert.assertEquals(actual, expected, "Test Fail");

    }



    }
//2. Validate "Child Iframe" text
//3. Validate "Parent Iframe" text
//4. Validate the "Sample Nested Iframe page. There are nested iframes in this page. Use browser " +
//        "inspecter or firebug to check out the HTML source. " +
//        "In total you can switch between the parent frame and the nested child frame."






