package day3_homeTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DocuportConstants;
import utilities.WebDriverFactory;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Task03 {
    public static void main(String[] args) {
//        1. navigate to docuport application
//        2. validate placeholders for user name and password
//        3. without sending username and password click login button
//        4. validate username and password error messages

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //driver.manage().window().maximize();
        driver.get("https://beta.docuport.app");

        WebElement userName = driver.findElement(By.cssSelector("label[for='input-14']"));
        String userNamePlaceHolder = userName.getText();
        System.out.println(userNamePlaceHolder.equals(DocuportConstants.USERNAME_PLACEHOLDER) ?
                "TEST PASSED" : "TEST FAILED");
        WebElement password = driver.findElement(By.cssSelector("label[for='input-15']"));
        String passwordPlaceHolder = password.getText();
        System.out.println(passwordPlaceHolder.equals(DocuportConstants.PASSWORD_PLACEHOLDER) ? " TEST PASSED" : "TEST FAILED");

        WebElement loginBtn = driver.findElement(By.cssSelector("span[class='v-btn__content']"));
        loginBtn.click();

        ArrayList<WebElement> errorMessages = (ArrayList<WebElement>) driver.findElement(By.cssSelector("div[class='v-messages__message']"));
       // String userNameErr= errorMessages.get(0).getText();

        System.out.println(errorMessages.get(0).getText().equals(DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_USERNAME) ? "TEST PASSED":
                "TEST FAILED GO HOME THAT'S IT FOR TODAY");
        //String passwordErr = errorMessages.get(1).getText();
        System.out.println(errorMessages.get(1).getText().equals(DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD)? "TEST PASSED" : "TEST FAILED");

        driver.close();

    }

}
