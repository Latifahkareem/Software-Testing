package Assignment13.tests;

import Assignment13.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ContactTest {

    private RemoteWebDriver driver;
    private final String baseUrl = "https://thinking-tester-contact-list.herokuapp.com";

    @BeforeAll
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
    }

    @AfterAll
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    public void fullContactWorkflow() {
        new LoginPage(driver)
                .open(baseUrl)
                .enterUsername("testuser")
                .enterPassword("password123")
                .clickLogin()
                .clickAddContact()
                .enterName("John Doe")
                .enterEmail("john@example.com")
                .enterPhone("1234567890")
                .clickSave();
    }
}
