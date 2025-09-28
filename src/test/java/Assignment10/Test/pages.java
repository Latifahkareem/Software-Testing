package Assignment10.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class pages {
    public static class LoginPage {

        WebDriver driver;
        WebDriverWait wait;

        private final By usernameField = By.id("username"); // تحقق من id أو name على الموقع
        private final By passwordField = By.id("password");
        private final By loginButton = By.cssSelector("button[type='submit']");

        public LoginPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // انتظار أطول
        }

        public void login(String username, String password) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
            driver.findElement(passwordField).sendKeys(password);
            driver.findElement(loginButton).click();
        }
    }

    public static class ContactListPage {

        WebDriver driver;
        WebDriverWait wait;

        private final By addContactButton = By.id("add-contact");
        private final By contactNames = By.cssSelector(".contact-name");

        public ContactListPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public boolean isLoaded() {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(addContactButton));
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        public void goToAddContact() {
            wait.until(ExpectedConditions.elementToBeClickable(addContactButton)).click();
        }

        public int getContactCount() {
            List<WebElement> contacts = driver.findElements(contactNames);
            return contacts.size();
        }

        public boolean isContactDisplayed(String name) {
            List<WebElement> contacts = driver.findElements(contactNames);
            for (WebElement contact : contacts) {
                if (contact.getText().equals(name)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class AddContactPage {

        WebDriver driver;
        WebDriverWait wait;

        private final By firstNameField = By.id("first-name");
        private final By lastNameField = By.id("last-name");
        private final By emailField = By.id("email");
        private final By addButton = By.cssSelector("button[type='submit']");

        public AddContactPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public void addContact(String firstName, String lastName, String email) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
            driver.findElement(lastNameField).sendKeys(lastName);
            driver.findElement(emailField).sendKeys(email);
            driver.findElement(addButton).click();
        }
    }
}
