package NewAutomationFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;
    public ProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
