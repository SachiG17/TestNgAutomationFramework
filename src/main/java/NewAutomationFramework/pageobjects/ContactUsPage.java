package NewAutomationFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    WebDriver driver;

    public  ContactUsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
