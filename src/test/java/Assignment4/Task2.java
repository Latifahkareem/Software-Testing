package Assignment4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Task2 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void checkboxesTest() {
        // Wait until all checkboxes are visible
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input[type='checkbox']")));

        // Get all checkboxes
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

        // Ensure there are exactly two checkboxes
        Assertions.assertEquals(2, checkboxes.size(), "There should be exactly two checkboxes");

        // Check each checkbox and click it if not already selected
        for (int i = 0; i < checkboxes.size(); i++) {
            WebElement checkbox = checkboxes.get(i);
            System.out.println("Checkbox " + (i+1) + " selected before: " + checkbox.isSelected());
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }

        // Verify that both checkboxes are selected after the operation
        for (int i = 0; i < checkboxes.size(); i++) {
            WebElement checkbox = checkboxes.get(i);
            System.out.println("Checkbox " + (i+1) + " selected after: " + checkbox.isSelected());
            Assertions.assertTrue(checkbox.isSelected(), "Checkbox " + (i+1) + " should be selected");
        }
    }
}
