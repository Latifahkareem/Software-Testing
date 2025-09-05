package Assignment2;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2 {

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
    @DisplayName("Verify Selenium Page Contains 'WebDriver'")
    void seleniumPageSourceTest() {
        driver.get("https://www.selenium.dev/");
        assertTrue(driver.getPageSource().contains("WebDriver"), "Page source did not contain 'WebDriver'");
    }

    @Test
    @DisplayName("Verify Python Page Contains 'Python'")
    void pythonPageSourceTest() {
        driver.get("https://www.python.org/");
        assertTrue(driver.getPageSource().contains("Python"), "Page source did not contain 'Python'");
    }
}
