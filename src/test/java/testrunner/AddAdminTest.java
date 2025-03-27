package testrunner;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminAddUserPage;
import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ExtentManager;

import java.time.Duration;
import java.util.List;

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

        // Create explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate and click the dropdown (Select --)
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'oxd-select-text-input') and text()='-- Select --']")));
        dropdown.click();
        driver.findElement(By.xpath("//div[contains(@class, 'oxd-select-text-input') and text()='-- Select --']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//div[contains(@class, 'oxd-select-text-input') and text()='-- Select --']")).sendKeys(Keys.ENTER);


        //2status
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div/div/div[3]/div/div[2]/div/div/div[2]/i")).click();
        //3employee name
        //        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div/div/div[2]/div/div[2]/div/div/input")).click();
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div/div/div[2]/div/div[2]/div/div/input")).clear();
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div/div/div[2]/div/div[2]/div/div/input")).sendKeys("adana");
        //wait then click

        //4username
        //        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div/div/div[4]/div/div[2]/input")).click();
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div/div/div[4]/div/div[2]/input")).sendKeys("mar12345");
        //5password
        //        driver.findElement(By.xpath("//input[@type='password']")).click();
//        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234567a");
        //6confirm password
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).click();
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys("1234567a");


//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div[2]")).click();

        //submit button
      //  adminAddUserPage.clickSaveButton();
      //  logger.info("Submitted admin user information.");

      //  logger.info("Checking on admin page the newly added user."); below need to refine
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div/div/div[2]/input")).click();
//        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div/div/div[2]/input")).sendKeys("mar12345");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
}
