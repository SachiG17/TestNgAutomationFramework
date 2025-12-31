package NewAutomationFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpLoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public SignUpLoginPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);
    }

    @FindBy(name="name")
    WebElement Username;

    @FindBy(xpath="//input[@data-qa='signup-email']")
    WebElement Usermail;

    @FindBy(xpath = "//button[contains(text(),\"Signup\")]")
    WebElement SignUpBtn;

    public void FillDetails(String usernameVal,String usermailVal){
        Username.sendKeys(usernameVal);
        wait.until(ExpectedConditions.visibilityOf(Usermail));
        Usermail.sendKeys(usermailVal);
        SignUpBtn.click();
    }
}
