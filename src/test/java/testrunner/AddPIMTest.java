package testrunner;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ExtentManager;

import java.awt.*;

public class AddPIMTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    PIMPage pimPage;
    PIMAddUserPage pimAddUserPage;

    @Test
    public void testAddAdmin() throws AWTException {
        test = ExtentManager.createTest("Test Login Functionality");

        //initialized before calling the pages
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        pimPage = new PIMPage(driver);
        pimAddUserPage = new PIMAddUserPage(driver);

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
        pimAddUserPage.addName("Oscar","Liu");
        pimAddUserPage.addEmployeeId("asd3");
        pimAddUserPage.clickLoginDetails();

        pimAddUserPage.textUsername("martin1222");

        pimAddUserPage.textPassowrd("a1234567a");

        pimAddUserPage.textConfirmPassowrd("a1234567a");
        pimAddUserPage.clickAddImageButton();
        pimAddUserPage.uploadFileWithRobot("C:\\Users\\liuyuan\\IdeaProjects\\firstAutoTestSelenium\\src\\test\\resources\\21-4.jpg");


    }
}
