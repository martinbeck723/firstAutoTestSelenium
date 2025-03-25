package testrunner;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ExtentManager;

public class AddAdminTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AdminPage adminPage;

    @Test
    public void testAddAdmin() {
        test = ExtentManager.createTest("Test Login Functionality");

        //initialized before calling the pages
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        adminPage = new AdminPage(driver);

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

//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div/div/div/div/div[2]/div/div/div[2]/i")).click();
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div/div/div[3]/div/div[2]/div/div/div[2]/i")).click();
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div/div/div[2]/div/div[2]/div/div/input")).click();
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div/div/div[2]/div/div[2]/div/div/input")).clear();
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div/div/div[2]/div/div[2]/div/div/input")).sendKeys("Broderick  Friesen");
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div/div/div[4]/div/div[2]/input")).click();
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div/div/div[4]/div/div[2]/input")).sendKeys("mar12345");
//        driver.findElement(By.xpath("//input[@type='password']")).click();
//        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234567a");
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).click();
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys("1234567a");
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div[2]")).click();
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div/div/div[2]/input")).click();
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div/div/div[2]/input")).sendKeys("mar12345");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
}
