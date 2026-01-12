package NewAutomationFramework.pageobjects.TestComponents;

import NewAutomationFramework.resources.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {
    ExtentReports extent = ExtentReporterNG.getReportObject();
    /// While Running Concurrently We will create new Object
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal();

    WebDriver driver;
    @Override
    public void onTestStart(ITestResult result){
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        //will assign new thread for this above test
        extentTest.set(test);
    }


    @Override
    public void onTestSuccess(ITestResult result){
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result){
        //if Fails it prints Test Failed
        extentTest.get().log(Status.FAIL, "Test Failed");
        //Prints error message
        extentTest.get().fail(result.getThrowable());
        try {
            //get driver info
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //attach to Report

        String filepath = null;
        try {
            //filepath(local path) represent where the screenshot is saved
            filepath = getScreenshot(result.getMethod().getMethodName(),driver);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //take path from local system attach to extent rport
        extentTest.get().addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
        }

    @Override
    public void onTestSkipped(ITestResult result){
        extentTest.get().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext result){
        extent.flush();
    }
    }

