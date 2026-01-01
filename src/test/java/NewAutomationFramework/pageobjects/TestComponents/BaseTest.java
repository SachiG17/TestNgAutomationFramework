package NewAutomationFramework.pageobjects.TestComponents;

import NewAutomationFramework.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public HomePage homePage;
    public WebDriverWait wait;

    public WebDriver initializeDriver() throws IOException {
        //properties class
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java/NewAutomationFramework//resources//GlobalData.properties");
        prop.load(fis);
        String browsername = prop.getProperty("browser");

        if(browsername.equalsIgnoreCase("chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            //disable notifications
            options.addArguments("--disable-notifications");
            //Initialize Driver
            driver = new ChromeDriver(options);

        }
        else if(browsername.equalsIgnoreCase("edge")){
            driver=new EdgeDriver();
        }
        else if(browsername.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return driver;
    }
    @BeforeClass(alwaysRun = true)
    public HomePage launchApplication() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        homePage.goTo();
        return homePage;
    }

    @AfterClass(alwaysRun = true)
    public void Teardown(){
        driver.close();
    }
}
