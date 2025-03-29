package testrunner;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ExtentManager;

import java.awt.*;

public class AddVacancyTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    RecruitmentPage recruitmentPage;
    RecruitmentAddVacanciesPage recruitmentAddVacanciesPage;

    @Test
    public void testAddAdmin() throws AWTException {
        test = ExtentManager.createTest("Test Login Functionality");

        //initialized before calling the pages
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        recruitmentPage = new RecruitmentPage(driver);
        recruitmentAddVacanciesPage = new RecruitmentAddVacanciesPage(driver);


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

        logger.info("Checking Recruitment page.");
        test.log(Status.INFO, "Navigating to add Recruitment page.");
        driver.findElement(By.linkText("Recruitment")).click();
        //click on Vacancies button
        recruitmentPage.clickVacanciesButton();
        //click on add button
        recruitmentPage.clickAddButton();

        //on recruitment add vacancies page
        recruitmentAddVacanciesPage.addVacancyName("martin");
    }
}
