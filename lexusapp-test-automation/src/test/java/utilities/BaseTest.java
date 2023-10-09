package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        if ("chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if ("ie".equalsIgnoreCase(browser)) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @BeforeSuite
    public void setUpSuite() {
        TestReport.initialize();
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) {
        TestReport.onFinish(result);
    }

    protected void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
