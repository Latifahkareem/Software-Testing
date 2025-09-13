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
import java.util.List;

public class Task1 {
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
    void testOldStyleSelectMenu() {
        WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(dropdown);

        // Print all options
        List<WebElement> options = select.getOptions();
        options.forEach(opt -> System.out.println(opt.getText()));

        // Select by index
        select.selectByIndex(4); // Purple

        // Select by visible text
        select.selectByVisibleText("Magenta");

        // Select by value
        select.selectByValue("4"); // Yellow
    }
}
