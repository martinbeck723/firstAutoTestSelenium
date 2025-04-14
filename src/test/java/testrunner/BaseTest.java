package testrunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {
        logger.info("Starting test setup on " + browser);
        extent = ExtentManager.getInstance();

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        logger.info("Navigated to login page.");
    }

    @AfterMethod
    public void captureFailureScreenshot(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.error("Test Failed: " + result.getName());
            test.log(Status.FAIL, "Test Failed: " + result.getThrowable());

            // Capture screenshot
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
            test.addScreenCaptureFromPath(screenshotPath);
            logger.info("Screenshot captured: " + screenshotPath);
        }
    }

    @AfterClass
    public void tearDown() {
        //logger.info("Closing the browser...");
        //driver.quit();
        ExtentManager.flushReport();
    }
}
