package day6_alerts_iframe;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Extra extends TestBase {
    @Test
    public void info(){
        driver.get("https://loopcamp.vercel.app/dropdown.html");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.getFirstSelectedOption().getText();

        List<String> list = new ArrayList<>();

        List<WebElement> listWeb = dropdown.getOptions();
        for (WebElement each : listWeb){
            list.add(each.getText());
        }

//        dropdown.selectByIndex(1);
//        Assert.assertTrue(dropdown.isMultiple());
    }

}
