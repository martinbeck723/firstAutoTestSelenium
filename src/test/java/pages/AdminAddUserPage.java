package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AdminAddUserPage extends BasePage {

    // Locator
    private By saveButton = By.xpath("//button[@type='submit']");
    private By userRoleSelect = By.xpath("//div[label[text()='User Role']]/following-sibling::div//div[contains(@class, 'oxd-select-text-input')]");
    private By statusSelect = By.xpath("//div[label[text()='Status']]/following-sibling::div//div[contains(@class, 'oxd-select-text-input')]");
    private By usernameField = By.xpath("//div[label[text()='Username']]/following-sibling::div//input[contains(@class, 'oxd-input')]");

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

    // Method to click on user role select
    public void clickUserRole() {
        click(userRoleSelect);
    }

    // Method to click on status select
    public void clickStatus() {
        click(statusSelect);
    }

    // Method to arrow down user role select
    public void arrowDownUserRole() {
        sendKeysNonText(userRoleSelect, Keys.ARROW_DOWN);
    }

    // Method to arrow down status select
    public void arrowDownStatus() {
        sendKeysNonText(statusSelect, Keys.ARROW_DOWN);
    }

    // Method to enter user role select
    public void enterUserRole() {
        driver.findElement(userRoleSelect).sendKeys(Keys.ENTER);
    }

    // Method to enter Status
    public void enterStatus() {
        driver.findElement(statusSelect).sendKeys(Keys.ENTER);
    }

    // Method to send text to username field
    public void textUsername(String username) {
        sendKeysText(usernameField,username);
    }







}
