package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UTMainPage extends BasePage {

    // Locator
    private By searchText = By.xpath("//input[@id='edit-query']");
    private By searchButton = By.xpath("//button[@id='edit-submit-search']");

    // Constructor
    public UTMainPage(WebDriver driver) {
        super(driver);
    }

    // Method to click on add button
    public void inputSearchText(String searchWord) {
        sendKeysText(searchText,searchWord);
    }

    // Method to click on vacancies button
    public void clickSearchButton() {
        click(searchButton);
    }

}
