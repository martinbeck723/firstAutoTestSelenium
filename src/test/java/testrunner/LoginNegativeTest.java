package testrunner;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ExtentManager;

public class LoginNegativeTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void testLoggingIntoApplicationNegative() {
        test = ExtentManager.createTest("Test Login Functionality");

        loginPage = new LoginPage(driver);

        logger.info("Entering login credentials...");
        test.log(Status.INFO, "Entering login credentials.");

        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin1234");
        loginPage.clickLogin();

        logger.info("Checking Login page error message.");
        test.log(Status.INFO, "Checking if the user see the error message on the login page.");

        // Verify unsuccessful login error message
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");
    }
}
