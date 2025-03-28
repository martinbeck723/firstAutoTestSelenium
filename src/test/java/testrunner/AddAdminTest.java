package testrunner;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminAddUserPage;
import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ExtentManager;

import java.time.Duration;

public class AddAdminTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AdminPage adminPage;
    AdminAddUserPage adminAddUserPage;

    @Test
    public void testAddAdmin() {
        test = ExtentManager.createTest("Test Login Functionality");

        //initialized before calling the pages
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        adminPage = new AdminPage(driver);
        adminAddUserPage = new AdminAddUserPage(driver);

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

        logger.info("Checking admin page.");
        test.log(Status.INFO, "Navigating to add admin page.");
        driver.findElement(By.linkText("Admin")).click();
        adminPage.clickAddButton();

        logger.info("On the add admin page.");
        //1user role
        adminAddUserPage.clickUserRole();
        adminAddUserPage.arrowDownUserRole();
        adminAddUserPage.enterUserRole();

        //2status
        adminAddUserPage.clickStatus();
        adminAddUserPage.arrowDownStatus();
        adminAddUserPage.enterStatus();

        //3employee name - dynamic select
        adminAddUserPage.textEmployeeName("sara");
// Forcefully wait for 10 seconds
        try {
            Thread.sleep(3000); // 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        adminAddUserPage.arrowEmployeeName();
        adminAddUserPage.enterEmployeeName();

        //4username
        adminAddUserPage.textUsername("martin12345mar");
        //5password
        adminAddUserPage.textPassowrd("1234567a");
        //6confirm password
        adminAddUserPage.textConfirmPassowrd("1234567a");

        //submit button
      //  adminAddUserPage.clickSaveButton();
      //  logger.info("Submitted admin user information.");

      //  logger.info("Checking on admin page the newly added user."); below need to refine
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div/div/div[2]/input")).click();
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div/div/div[2]/input")).sendKeys("mar12345");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
}
