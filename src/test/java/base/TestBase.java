package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.WebDriverFactory;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setUPMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

}
