package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class PIMAddUserPage extends BasePage {

    // Locator
    private By firstnameField = By.xpath("//input[contains(@name, 'firstName')]");
    private By middlenameField = By.xpath("//input[contains(@name, 'middleName')]");
    private By lastnameField = By.xpath("//input[contains(@name, 'lastName')]");
    private By employeeIdField = By.xpath("//div[label[text()='Employee Id']]/following-sibling::div//input[contains(@class, 'oxd-input')]");

    //login details
    private By loginDetailsToggle = By.xpath("//input[contains(@type, 'checkbox')]/following-sibling::span");
    //upload image
    private By addImageButton = By.xpath("//i[contains(@class, 'bi-plus')]/parent::button");
    private By usernameField = By.xpath("//div[label[text()='Username']]/following-sibling::div//input[contains(@class, 'oxd-input')]");
    private By passwordField = By.xpath("//div[label[text()='Password']]/following-sibling::div//input[contains(@class, 'oxd-input')]");
    private By confirmPasswordField = By.xpath("//div[label[text()='Confirm Password']]/following-sibling::div//input[contains(@class, 'oxd-input')]");

    // Constructor
    public PIMAddUserPage(WebDriver driver) {
        super(driver);
    }

    // Method to click on add button
    public void clickAddImageButton() {
        click(addImageButton);
    }

    //enter text into firstname and last name
    public void addName(String firstname, String lastname) {
        sendKeysText(firstnameField, firstname);
        sendKeysText(lastnameField, lastname);
    }

    //enter text into middle name
    public void addMiddleName( String middlename) {
        sendKeysText(middlenameField, middlename);
    }

    public void addEmployeeId(String id) {
        //need to be unique
        sendKeysText(employeeIdField, id);
    }
    public void clickLoginDetails( ) {
        click(loginDetailsToggle);
    }

    // Method to send text to username field
    public void textUsername(String username) {
        sendKeysText(usernameField,username);
    }

    // Method to send text to password field
    public void textPassowrd(String password) {
        sendKeysText(passwordField,password);
    }

    // Method to send text to username field
    public void textConfirmPassowrd(String password) {
        sendKeysText(confirmPasswordField,password);
    }

    //upload image
    public void uploadFileWithRobot(String filePath) throws AWTException {
        Robot robot = new Robot();

        // Copy file path to clipboard
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // Paste and Press Enter
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


}
