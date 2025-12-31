package NewAutomationFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));;
        PageFactory.initElements(driver,this);
    }

    //PageFactory
    @FindBy(linkText = "Signup / Login")
    WebElement loginLocator;

    @FindBy(xpath = "//a[contains(normalize-space(.),'Logged in as')]")
    WebElement LoggedInas;

    @FindBy(linkText = "Logout")
    WebElement LogOutBtn;

    @FindBy(xpath = "//b[contains(text(),'Account Created!')]")
    WebElement AccountcreatedMessage;


    @FindBy(linkText = "Continue")
    WebElement ContinueBtn;


    @FindBy(linkText = "Delete Account")
    WebElement DeleteBtn;

    @FindBy(xpath = "//b[contains(text(),'Account Deleted!')]")
    WebElement DeleteMsg;


    public void goTo(){
        driver.get("https://automationexercise.com/");
    }

    public void clickSignInBtn(){
        loginLocator.click();
    }
    public void verifyLoggedIn(){
        wait.until(ExpectedConditions.visibilityOf(LoggedInas));
        String actualAlert = LoggedInas.getText();
        Assert.assertTrue(actualAlert.contains("Logged in as"),"Login Message not Found");
    }

    public void clickcontinue(){
        ContinueBtn.click();
    }
    public void logOut(){
        LogOutBtn.click();
    }
    public void deleteProfile(){
        DeleteBtn.click();
    }

    public void verifyProfileCreated(){
        Assert.assertEquals(AccountcreatedMessage.getText(),"ACCOUNT CREATED!");
    }

    public void verifyProfileDeleted(){
        Assert.assertEquals(DeleteMsg.getText(),"ACCOUNT DELETED!");
    }
}
