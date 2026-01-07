package NewAutomationFramework.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Page Factory
    @FindBy(name="email")
    WebElement nameLocator;

    @FindBy(name="password")
    WebElement passwordLocator;

    @FindBy(xpath = "//button[@data-qa = 'login-button']")
    WebElement loginBtnLocator;

    @FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
    WebElement errorMessage;

    public void logIn(String email,String password){
        nameLocator.sendKeys(email);
        passwordLocator.sendKeys(password);
        loginBtnLocator.click();
    }



    public String getErrorMessage(){
        return errorMessage.getText();
    }
}