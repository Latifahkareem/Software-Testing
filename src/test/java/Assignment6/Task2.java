package Assignment6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Task2 {
    WebDriver driver;
    String url = "https://demoqa.com/select-menu";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void testStandardMultiSelect() throws InterruptedException {
        WebElement multiSelectElement = driver.findElement(By.id("cars"));
        Select multiSelect = new Select(multiSelectElement);

        // Verify it is multi-select
        System.out.println("Is multiple: " + multiSelect.isMultiple());

        // Select Opel by index and then deselect
        multiSelect.selectByIndex(2);
        Thread.sleep(1000);
        multiSelect.deselectByIndex(2);

        // Select Saab by value and then deselect
        multiSelect.selectByValue("saab");
        Thread.sleep(1000);
        multiSelect.deselectByValue("saab");

        // Deselect all
        multiSelect.deselectAll();
    }
}
