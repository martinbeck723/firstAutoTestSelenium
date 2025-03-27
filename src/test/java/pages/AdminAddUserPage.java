package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminAddUserPage extends BasePage {

    // Locator
    private By saveButton = By.xpath("//button[@type='submit']");

    //user role
    //status
    //employee name
    //username
    //password
    //confirm password

    // Constructor
    public AdminAddUserPage(WebDriver driver) {
        super(driver);
    }

    // Method to click on save button
    public void clickSaveButton() {
        click(saveButton);
    }


}
