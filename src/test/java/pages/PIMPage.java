package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PIMPage extends BasePage {

    // Locator
    private By addButton = By.xpath("//i[contains(@class, 'bi-plus')]/parent::button");

    // Constructor
    public PIMPage(WebDriver driver) {
        super(driver);
    }

    // Method to click on add button
    public void clickAddButton() {
        click(addButton);
    }


}
