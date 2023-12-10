package day05_radioButton;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class T00_checkbox {
    public static void main(String[] args) {
          /*
        1. Go to http://the-internet.herokuapp.com/checkboxes
        2. Confirm checkbox #1 is NOT selected by default
        3. Confirm checkbox #2 is SELECTED by default.
        4. Click checkbox #1 to select it.
        5. Click checkbox #2 to deselect it.
        6. Confirm checkbox #1 is SELECTED.
        7. Confirm checkbox #2 is NOT selected.

         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        WebElement checkBox1 = driver.findElement
                (By.xpath("//input/following-sibling::text()[contains(.," +
                        "'checkbox 1')]/preceding-sibling::input"));

        // 2. Confirm checkbox #1 is NOT selected by default
        if(!checkBox1.isSelected()){
            System.out.println(" Checkbox is not selected");
        } else {
            System.out.println(" Checkbox is selected");
        }

        checkBox1.click();

        if(checkBox1.isSelected()){
            System.out.println("Checkbox is selected");
        } else {
            System.out.println("Checkbox is not selected");
        }


    }
}
