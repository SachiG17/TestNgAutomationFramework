package NewAutomationFramework.Tests;
import NewAutomationFramework.pageobjects.HomePage;
import NewAutomationFramework.pageobjects.LoginPage;
import NewAutomationFramework.pageobjects.TestComponents.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestDDT extends BaseTest {

    @Test(dataProvider ="getData",groups = "LogInMatrix")
    public void LogInTest(String email,String password) throws IOException {
        homePage = new HomePage(driver);
        homePage.clickSignInBtn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(email,password);
        homePage.verifyLoggedIn();
        homePage.logOut();
    }
    @DataProvider
    public Object[][] getData(){
        return new Object[][]{{"sachinshetty@gmail.com","shettysachin"},{"sachinshetty@gmail.com","shettysachin1"}};
    }
}
