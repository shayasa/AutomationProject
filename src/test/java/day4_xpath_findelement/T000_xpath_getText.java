package day4_xpath_findelement;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DocuportConstants;
import utilities.WebDriverFactory;

public class T000_xpath_getText {
         /*
    1. Open Chrome browser
    2. Go to docuport
    3. Click on forgot password
    4. validate URL contains: reset-password
    5. validate - Enter the email address associated with your account
    6. enter forgotpasswordg1@gmail.com to email box
    7. validate cancel button is displayed
    8. validate send button is displayed
    9. click send button
    10. validate - We've sent you an email with a link to reset your password. Please check your email
     */
         public static void main(String[] args) throws InterruptedException {



    WebDriver driver = WebDriverFactory.getDriver("chrome");
    driver.get("https://beta.docuport.app");
    driver.manage().window().maximize();
             WebElement forgetPassword = driver.findElement(By.xpath("//a[@href='/reset-password']"));

             forgetPassword.click();
             String actualURLForResetPassword = driver.getCurrentUrl();

             if (actualURLForResetPassword.contains(DocuportConstants.RESET_PASSWORD_URL)){
                 System.out.println("TEST PASS:");
             }else{
                 System.out.println("TEST Failed");
             }

             WebElement validateMessage = driver.findElement(By.xpath("//div[@class='v-messages__message']"));

             String actualValidateMessage = validateMessage.getText();

             if (actualValidateMessage.contains(DocuportConstants.RESET_PASSWORD_MESSAGE)){
                 System.out.println("TEST PASS: => Actual validate message: \\\"\"+actualValidateMessage+\"\\\" " +
                         "contains expected message \\\"\"+DocuportConstants.RESET_PASSWORD_MESSAGE");
             }else{
                 System.out.println("TEST FAIL: => Actual validate message: \\\"\"+actualValidateMessage+\"\\\"" +
                         " doesnt contains expected message \\\"\"+DocuportConstants.RESET_PASSWORD_MESSAGE");
             }


             WebElement emailInputBox = driver.findElement(By.xpath("//input[starts-with(@id, 'input-')] "));
             emailInputBox.sendKeys(DocuportConstants.EMAIL_FOR_RESET_PASSWORD);

             WebElement cancelButton = driver.findElement(By.xpath("//span[text()=' Cancel ']"));
             ////span[normalize-space()='Cancel']
             WebElement sendButton = driver.findElement(By.xpath("//span[normalize-space() = 'Send']"));
               driver.quit();

               if (cancelButton.isDisplayed()){
                   System.out.println("TEST PASSED");
               }else{
                   System.out.println("TEST FAILED");
               }


               if (sendButton.isDisplayed()){
                   System.out.println("TEST PASSED");
               }else{
                   System.out.println("TEST FAILED");
               }
               sendButton.click();
             Thread.sleep(3000);
               WebElement successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));
               Thread.sleep(3000);

               try {

               }catch (StaleElementReferenceException e){
                   System.out.println("Element is not there anymore");
                 //  e.printStackTrace();
               }


             System.out.println("successMessage.getText() = " + successMessage.getText());

         }
}