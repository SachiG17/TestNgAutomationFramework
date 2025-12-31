package NewAutomationFramework.Tests;
import NewAutomationFramework.pageobjects.HomePage;
import NewAutomationFramework.pageobjects.RegistrationPage;
import NewAutomationFramework.pageobjects.SignUpLoginPage;
import NewAutomationFramework.pageobjects.TestComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class UserRegistrationTest extends BaseTest {

    @Test
    public void RegisterDeleteUserTest() throws IOException {
        homePage.clickSignInBtn();
        SignUpLoginPage signUpLoginPage = new SignUpLoginPage(driver);
        signUpLoginPage.FillDetails("Sachin","SachinxydfszzMzzz@gmail.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.FillRegistrationForm("Shetty@143","Sachin","Shetty","At post Hosur","United States","Goa","Goa","123456","9008953628");
        homePage.verifyProfileCreated();
        homePage.clickcontinue();
        homePage.deleteProfile();
        homePage.verifyProfileDeleted();
    }

}
