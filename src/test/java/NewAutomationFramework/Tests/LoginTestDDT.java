package NewAutomationFramework.Tests;
import NewAutomationFramework.pageobjects.HomePage;
import NewAutomationFramework.pageobjects.LoginPage;
import NewAutomationFramework.pageobjects.TestComponents.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginTestDDT extends BaseTest {

    @Test(dataProvider ="getData",groups = "LogInMatrix")
    public void LogInTest(HashMap<String,String> input) throws IOException {
        homePage = new HomePage(driver);
        homePage.clickSignInBtn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(input.get("email"),input.get("password"));
        homePage.verifyLoggedIn();
        homePage.logOut();
        //
    }
    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//NewAutomationFramework//Data//MultipleLoginDetails.json");
        return new Object[][] {{data.get(0)},{data.get(1)}};
    }
}
