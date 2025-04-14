package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    // Locator
    private By dashboardHeading = By.tagName("h6");


    // Constructor
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    // Method to get the page heading
    public String getDashboardHeading() {
        return getText(dashboardHeading);
    }


}
