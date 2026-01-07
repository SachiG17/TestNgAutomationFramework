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
    ExtentTest test;
    WebDriver driver;
    @Override
    public void onTestStart(ITestResult result){
        test = extent.createTest(result.getMethod().getMethodName());
    }


    @Override
    public void onTestSuccess(ITestResult result){
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result){
        //if Failes it prints Test Failed
        test.log(Status.FAIL, "Test Failed");
        //Prints error message
        test.fail(result.getThrowable());
        try {
            //get driver info
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //attach to Report

        String filepath=null;
        try {
            //filepath(local path) represent where the screenshot is saved
            filepath = getScreenshot(result.getMethod().getMethodName());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //take path from local system attch to extent rport
        test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
        }

    @Override
    public void onTestSkipped(ITestResult result){
        test.log(Status.PASS, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext result){
        extent.flush();
    }
    }

