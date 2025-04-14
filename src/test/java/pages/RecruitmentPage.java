package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruitmentPage extends BasePage {

    // Locator
    private By addButton = By.xpath("//i[contains(@class, 'bi-plus')]/parent::button");
    private By vacanciesButton = By.xpath("//li/a[text()='Vacancies']");

    // Constructor
    public RecruitmentPage(WebDriver driver) {
        super(driver);
    }

    // Method to click on add button
    public void clickAddButton() {
        click(addButton);
    }

    // Method to click on vacancies button
    public void clickVacanciesButton() {
        click(vacanciesButton);
    }

}
