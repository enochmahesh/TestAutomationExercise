package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;

public class TestReport {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initialize() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static void startTest(String testName,String browser,String author,String category) {
        test = extent.createTest(testName)
                .assignAuthor(author)
                .assignCategory(category)
                .assignDevice(browser);;
    }

    public static void logInfo(String info) {
        test.log(Status.INFO, info);
    }

    public static void logPass(String passMessage) {
        test.log(Status.PASS, passMessage);
    }

    public static void logFail(String failMessage) {
        test.log(Status.FAIL, failMessage);
    }

    public static void logScreenshot(String screenshotPath) {
        test.addScreenCaptureFromPath(screenshotPath);
    }

    public static void onFinish(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logFail("Test Failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logPass("Test Passed");
        }

        extent.flush();
    }
}
