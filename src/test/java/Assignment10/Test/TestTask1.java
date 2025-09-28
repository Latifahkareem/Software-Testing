package Assignment10.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestTask1 {

    WebDriver driver;
    pages.LoginPage loginPage;
    pages.ContactListPage contactListPage;
    pages.AddContactPage addContactPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://thinking-tester-contact-list.herokuapp.com/login");

        loginPage = new pages.LoginPage(driver);
        contactListPage = new pages.ContactListPage(driver);
        addContactPage = new pages.AddContactPage(driver);
    }

    @Test
    public void createUserAndAddContacts() {
        loginPage.login("admin", "admin123");

        Assert.assertTrue(contactListPage.isLoaded(), "Contact list page did not load after login!");

        contactListPage.goToAddContact();

        addContactPage.addContact("Latifah", "K", "latifah@example.com");

        Assert.assertTrue(contactListPage.isContactDisplayed("Latifah K"), "Contact was not displayed in the list!");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
