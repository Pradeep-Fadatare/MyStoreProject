package pradeepfadatareacademy.Tests.TestComponent;

import PradeepFadatareAutomation.Resources.ExtentReportNg;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listners extends BaseTest implements ITestListener  {
    ExtentTest test;
    ExtentReports reports=ExtentReportNg.getReportObject();
    ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        test=reports.createTest(result.getMethod().getMethodName());
        extenttest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extenttest.get().log(Status.PASS,"Test Passed Successfully");


    }

    @Override
    public void onTestFailure(ITestResult result) {
        extenttest.get().log(Status.FAIL,"Test Failed Unexpectedly");
        extenttest.get().fail(result.getThrowable());
        String path=null;
        try {
            driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            path=getScreenshot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.addScreenCaptureFromPath(path,result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
    }
}
