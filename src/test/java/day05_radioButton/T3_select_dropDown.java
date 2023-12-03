package day05_radioButton;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class T3_select_dropDown {
    //1. Open Chrome browse
    //2. Go to http://the-internet.herokuapp.com/dropdown
    //3. Verify “Dropdown list” default selected value is correct - Expected: “Please select an option”

    WebDriver driver;
    String expected = "Please select an option";
    String actual;

    @BeforeClass
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void dropDownTest(){
        driver.get("http://the-internet.herokuapp.com/dropdown");
    }
}
