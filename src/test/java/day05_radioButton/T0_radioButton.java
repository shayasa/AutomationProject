package day05_radioButton;

import com.loop.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T0_radioButton {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/radio-buttons.html");
        // wait the whole page loads - selenium 3
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // wait the whole page load - selenium 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement red = driver.findElement(By.xpath("//input[@id='red']"));
        WebElement green = driver.findElement(By.xpath("//input[@id='green']"));

        // isSelected()

        System.out.println(red.isSelected() + " before clicking");
        red.click();
        Thread.sleep(5000);
        System.out.println(red.isSelected() + " after clicking");
        green.click();

        // isEnabled
        System.out.println(red.isEnabled() + " checking if enabled");
        System.out.println(green.isEnabled() + " checking if enabled");
    }
}
