package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
    }

    // Wait for an element to be visible
    protected WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Click an element
    protected void click(By locator) {
        waitForElementToBeVisible(locator).click();
    }

    // Send key stroke
    protected void sendKeysNonText (By locator, Keys k) {
        waitForElementToBeVisible(locator).sendKeys(k);
    }

    // Send text to an input field
    protected void sendKeysText(By locator, String text) {
        WebElement element = waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Get text from an element
    protected String getText(By locator) {
        return waitForElementToBeVisible(locator).getText();
    }
}
