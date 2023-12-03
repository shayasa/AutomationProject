package day3_locators_css_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DocuportConstants;
import utilities.WebDriverFactory;

public class T3_getAttribute_css {
    public static void main(String[] args) {
        /*
         * go to docuport application
         * identify docuport with css
         * get value of the attribute
         * Validate if  it is "Docuport"
         */


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app");
        WebElement logo = driver.findElement(By.cssSelector("/img/logo.d7557277.svg"));
        String docuport = logo.getAttribute("alt");

        if (DocuportConstants.LOGO_DOCUPORT.equalsIgnoreCase(docuport)) {
            System.out.println("Expected logo text: " +  DocuportConstants.LOGO_DOCUPORT + " , matches actual logo text: " + docuport);
        } else {
            System.out.println("Wxpected logo text: " + DocuportConstants.LOGO_DOCUPORT + " ,  DOES NOT matches actual logo text: " + docuport);
        }


    }
}
