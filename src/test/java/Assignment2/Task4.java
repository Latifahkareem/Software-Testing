package Assignment2;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4 {

    WebDriver driver;

    @BeforeEach
    void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Navigate Google → YouTube → LinkedIn and Verify Titles")
    void navigationTitlesTest() {
        // Navigate to Google
        driver.get("https://www.google.com/");
        assertTrue(driver.getTitle().contains("Google"), "Title did not contain Google!");

        // Navigate to YouTube
        driver.get("https://www.youtube.com/");
        assertTrue(driver.getTitle().contains("YouTube"), "Title did not contain YouTube!");

        // Navigate to LinkedIn
        driver.get("https://www.linkedin.com/");
        assertTrue(driver.getTitle().contains("LinkedIn"), "Title did not contain LinkedIn!");
    }

    @Test
    @DisplayName("Navigate Back Twice to Google, Forward Twice to LinkedIn")
    void navigationBackAndForwardTest() {
        // Navigate Google → YouTube → LinkedIn
        driver.get("https://www.google.com/");
        driver.get("https://www.youtube.com/");
        driver.get("https://www.linkedin.com/");

        // Go back twice → should reach Google
        driver.navigate().back(); // back to YouTube
        driver.navigate().back(); // back to Google
        assertTrue(driver.getCurrentUrl().contains("google.com"), "Did not return to Google!");

        // Go forward twice → should reach LinkedIn
        driver.navigate().forward(); // forward to YouTube
        driver.navigate().forward(); // forward to LinkedIn
        assertTrue(driver.getCurrentUrl().contains("linkedin.com"), "Did not return to LinkedIn!");
    }

    @AfterEach
    void closeBrowser() {
        driver.quit();
    }
}
