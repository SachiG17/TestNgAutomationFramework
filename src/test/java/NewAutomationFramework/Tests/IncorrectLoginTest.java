package NewAutomationFramework.Tests;

import NewAutomationFramework.pageobjects.LoginPage;
import NewAutomationFramework.pageobjects.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IncorrectLoginTest extends BaseTest {

    @Test
    public void IncorrectLoginTest(){
        homePage.clickSignInBtn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn("sachinshetty@gmail.com","shettysach");
        String errormsg = loginPage.getErrorMessage();
        Assert.assertEquals("Your email or password is incorrect!",errormsg);
    }
}
