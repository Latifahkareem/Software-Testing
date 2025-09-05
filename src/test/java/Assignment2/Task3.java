package Assignment2;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3 {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Set Browser Size to 800x600")
    void setBrowserSizeTest() {
        driver.get("https://www.bbc.com/");
        driver.manage().window().setSize(new Dimension(800, 600));

        Dimension size = driver.manage().window().getSize();
        assertEquals(800, size.getWidth(), "Width did not match!");
        assertEquals(600, size.getHeight(), "Height did not match!");
    }

    @Test
    @DisplayName("Set Browser Position to (100,100)")
    void setBrowserPositionTest() {
        driver.get("https://www.bbc.com/");
        driver.manage().window().setPosition(new Point(100, 100));

        Point position = driver.manage().window().getPosition();
        assertEquals(100, position.getX(), "X position did not match!");
        assertEquals(100, position.getY(), "Y position did not match!");
    }
}
