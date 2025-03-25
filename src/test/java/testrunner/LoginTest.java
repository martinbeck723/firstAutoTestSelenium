package testrunner;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import com.aventstack.extentreports.Status;
import utils.ExtentManager;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void testLoggingIntoApplication() {
        test = ExtentManager.createTest("Test Login Functionality");

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);

        logger.info("Entering login credentials...");
        test.log(Status.INFO, "Entering login credentials.");

        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        logger.info("Checking dashboard page.");
        test.log(Status.INFO, "Checking if the user is on the dashboard page.");

        // Verify successful login
        String expectedText = "Dashboard";
        String actualText = dashboardPage.getDashboardHeading();
        Assert.assertEquals(actualText, expectedText, "Login failed!");

    }
}
