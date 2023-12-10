package day05_homeTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.time.Duration;

public class Task01 {
//        1. go to http://the-internet.herokuapp.com/dropdown
//        2. validate "Please select an option" is selected by default
//        3. Choose option 1 and validate that it is selected
//        4. Choose option 2 and validate that it is selected
//        5. Validate dropdown name is "Dropdown List"
        WebDriver driver;
        @BeforeClass
                public void setUpMethod(){
             driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.get("http://the-internet.herokuapp.com/dropdown");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        @AfterClass
                public void tearDownMethod(){
            driver.close();
        }
        @Test
                public void test() throws InterruptedException {
            Select dropDown = new Select(driver.findElement(By.id("dropdown")));
            Thread.sleep(2000);
            String actualResult = dropDown.getFirstSelectedOption().getText();
            String expectedResult = "Please select an option";
            Assert.assertEquals(actualResult,expectedResult);


            dropDown.selectByValue("1");
            Assert.assertEquals(dropDown.getFirstSelectedOption().getText(),
                    "Option 1","Option 1 is selected");
            Thread.sleep(2000);
            dropDown.selectByValue("2");
            Assert.assertEquals(dropDown.getFirstSelectedOption().getText(),
                    "Option 2","Option 2 is selected");
            Thread.sleep(2000);

            WebElement name = driver.findElement(By.xpath("//div[@class='example']/h3"));
            Thread.sleep(2000);
            Assert.assertEquals(name.getAccessibleName(),"Dropdown List");
        }

        }






