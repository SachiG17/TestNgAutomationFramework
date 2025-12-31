package NewAutomationFramework.Tests;
import NewAutomationFramework.pageobjects.HomePage;
import NewAutomationFramework.pageobjects.LoginPage;
import NewAutomationFramework.pageobjects.TestComponents.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test
    public void LogInTest() throws IOException {
        homePage = new HomePage(driver);
        homePage.clickSignInBtn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn("sachinshetty@gmail.com","shettysachin");
        homePage.verifyLoggedIn();
    }
    @Test(dependsOnMethods = {"LogInTest"})
    public void LogoutTest(){
        homePage.logOut();
    }
}
