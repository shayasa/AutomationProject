package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.InputMismatchException;

public class DocuportUtils {
    /**
    *logins to the docuport application
     * @param driver, which initialized in test base
     * @param role, comes from docuport constants
     * @author aydan
     */
    public static void login(WebDriver driver, String role){
        driver.get("https://beta.docuport.app/");
        WebElement username = driver.findElement(By.xpath("//label[.='Username or email']//following-sibling::input"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));

        WebElement logInBtn = driver.findElement(By.xpath("//button[@type='submit']"));

        switch (role.toLowerCase()){
            case "client":
                username.sendKeys(DocuportConstants.USERNAME_CLIENT);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;

            case "supervisor":
               username.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
               password.sendKeys(DocuportConstants.PASSWORD);
               break;

            case "advisor":
                username.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "employee":
                username.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
                password.sendKeys(DocuportConstants.PASSWORD);
            default:throw new InputMismatchException("There us not such a role: " + role);

}
        logInBtn.click();
         if (role.toLowerCase().equals("client")){


             WebElement cont = driver.findElement(By.xpath("//button[@type='submit']"));
             cont.click();
         }
    }
    /**
     * logs out fro the application
     * @param driver
     * @auther nadir
     */

    public static void logOut(WebDriver driver){
        WebElement userIcon = driver.findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement logOut = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOut.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

}
