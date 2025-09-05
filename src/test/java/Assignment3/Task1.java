package Assignment3;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Task1 {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testpages.herokuapp.com/styled/index.html");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void task1_navigationAndLocators() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to "Locators - Find By Playground Test Page"
        driver.findElement(By.linkText("Locators - Find By Playground Test Page")).click();
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Navigate back
        driver.navigate().back();
        System.out.println("URL after going back: " + driver.getCurrentUrl());

        // Navigate to "WebDriver Example Page"
        driver.findElement(By.linkText("WebDriver Example Page")).click();
        System.out.println("WebDriver page URL: " + driver.getCurrentUrl());

        // Try different locators for number input
        WebElement numberInput;
        try {
            numberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numentry")));
        } catch (TimeoutException e) {
            numberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("number-entry")));
        }

        numberInput.sendKeys("20", Keys.ENTER);

        // Wait for the message
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String actualMessage = message.getText();

        Assertions.assertTrue(actualMessage.toLowerCase().contains("two, zero"),
                "Expected 'two, zero' but got: " + actualMessage);

        System.out.println("Verification Passed: " + actualMessage);
    }
}
