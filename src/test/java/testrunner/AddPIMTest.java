package testrunner;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ExtentManager;

public class AddPIMTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    PIMPage pimPage;

    @Test
    public void testAddAdmin() {
        test = ExtentManager.createTest("Test Login Functionality");

        //initialized before calling the pages
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        pimPage = new PIMPage(driver);

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

        logger.info("Checking PIM page.");
        test.log(Status.INFO, "Navigating to add PIM page.");
        driver.findElement(By.linkText("PIM")).click();
        pimPage.clickAddButton();

        logger.info("On the add PIM page.");
        pimPage.addName("Oscar","Liu");
        pimPage.addEmployeeId("asd3");

    }
}
