package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RecruitmentAddVacanciesPage extends BasePage {

    // Locator

    private By vacancyNameField = By.xpath("//div[label[text()='Vacancy Name']]/following-sibling::div//input[contains(@class, 'oxd-input')]");
    private By jobTitleSelect = By.xpath("//div[label[text()='Job Title']]/following-sibling::div//div[contains(@class, 'oxd-select-text-input')]");

    private By firstnameField = By.xpath("//input[contains(@name, 'firstName')]");
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
    public RecruitmentAddVacanciesPage(WebDriver driver) {
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

    //enter text into vacancy name
    public void addVacancyName( String vacancyName) {
        sendKeysText(vacancyNameField, vacancyName);
    }

    // Method to click on JobTitle select
    public void clickJobTitle() {
        click(jobTitleSelect);
    }

    // Method to arrow down JobTitle select
    public void arrowDownJobTitle() {
        sendKeysNonText(jobTitleSelect, Keys.ARROW_DOWN);
    }
 
    // Method to enter JobTitle
    public void enterJobTitle() {
        driver.findElement(jobTitleSelect).sendKeys(Keys.ENTER);
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


}
