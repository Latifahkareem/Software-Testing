package Assignment2;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1 {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Navigate Back and Forward Between Wikipedia and Google")
    void browserHistoryTest() {
        driver.get("https://www.wikipedia.org/");
        assertTrue(driver.getTitle().contains("Wikipedia"), "Wikipedia title did not match!");

        driver.get("https://www.google.com/");
        assertTrue(driver.getTitle().contains("Google"), "Google title did not match!");

        driver.navigate().back();
        assertTrue(driver.getTitle().contains("Wikipedia"), "Back navigation failed!");

        driver.navigate().forward();
        assertTrue(driver.getTitle().contains("Google"), "Forward navigation failed!");
    }

    @Test
    @DisplayName("Refresh Google Page Test")
    void refreshTest() {
        driver.get("https://www.google.com/");
        driver.navigate().refresh();
        assertTrue(driver.getTitle().contains("Google"), "Google title not found after refresh!");
    }
}
