package NewAutomationFramework.pageobjects.TestComponents;

import NewAutomationFramework.pageobjects.HomePage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public HomePage homePage;


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

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws  IOException{
        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<>(){
    });
        return data;
    }

    @AfterClass(alwaysRun = true)
    public void Teardown(){
        driver.close();
    }
}
