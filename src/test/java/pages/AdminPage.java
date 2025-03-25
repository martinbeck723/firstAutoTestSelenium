package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage {

    // Locator
    private By addButton = By.xpath("//button[contains(@class, 'oxd-button') and contains(@class, 'oxd-button--secondary')]//i[contains(@class, 'bi-plus')]/parent::button");

    // Constructor
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    // Method to get the page heading
    public void clickAddButton() {
        click(addButton);
    }


}
