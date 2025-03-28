package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PIMPage extends BasePage {

    // Locator
    private By addButton = By.xpath("//i[contains(@class, 'bi-plus')]/parent::button");
    private By firstnameField = By.xpath("//input[contains(@name, 'firstName')]");
    private By middlenameField = By.xpath("//input[contains(@name, 'middleName')]");
    private By lastnameField = By.xpath("//input[contains(@name, 'lastName')]");
    private By employeeIdField = By.xpath("//div[label[text()='Employee Id']]/following-sibling::div//input[contains(@class, 'oxd-input')]");

    // Constructor
    public PIMPage(WebDriver driver) {
        super(driver);
    }

    // Method to click on add button
    public void clickAddButton() {
        click(addButton);
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


}
