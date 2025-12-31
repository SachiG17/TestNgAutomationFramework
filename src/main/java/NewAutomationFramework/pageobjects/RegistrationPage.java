package NewAutomationFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "password")
    WebElement SignUpPassword;

    @FindBy(id="first_name")
    WebElement FirstName;

    @FindBy(id="last_name")
    WebElement LastName;

    @FindBy(id="address1")
    WebElement Address1;

    @FindBy(name="country")
    WebElement CountryEle;

    @FindBy(name="state")
    WebElement State;

    @FindBy(name="city")
    WebElement City;

    @FindBy(id="zipcode")
    WebElement Zipcode;

    @FindBy(name="mobile_number")
    WebElement Mobilenumber;

    @FindBy(xpath = "//button[contains(text(),\"Create Account\")]")
    WebElement CreateBtn;



    public void FillRegistrationForm(String passVal,String firstnameVal,String lastnameVal,
                                     String add1Val,String countryVal,String stateVal,String cityVal,String zipcodeVal,String mblnum){
        SignUpPassword.sendKeys(passVal);
        FirstName.sendKeys(firstnameVal);
        LastName.sendKeys(lastnameVal);
        Address1.sendKeys(add1Val);
        Select Country = new Select(CountryEle);
        Country.selectByValue(countryVal);
        State.sendKeys(stateVal);
        City.sendKeys(cityVal);
        Zipcode.sendKeys(zipcodeVal);
        Mobilenumber.sendKeys(mblnum);
        CreateBtn.click();
    }


}
