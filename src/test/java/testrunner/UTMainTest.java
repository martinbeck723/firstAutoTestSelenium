package testrunner;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UTMainPage;
import utils.ExtentManager;

public class UTMainTest extends BaseTest {
    UTMainPage utMainPage;

    @Test
    public void testUTMainPage() {
        test = ExtentManager.createTest("Test UT Main Functionality");

        utMainPage = new UTMainPage(driver);

        logger.info("Entering search word...");
        test.log(Status.INFO, "Entering search word.");

        utMainPage.inputSearchText("Economics");
        utMainPage.clickSearchButton();

        // Verify successful login
//        String expectedText = "Search Results from all of U of T";
//        String actualText = dashboardPage.getDashboardHeading();
//        Assert.assertEquals(actualText, expectedText, "Login failed!");

    }
}
