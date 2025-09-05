package Assignment3;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Task2 {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testpages.eviltester.com/styled/index.html");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void task2_calculator() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to Calculator under Micro Apps
        driver.findElement(By.linkText("Calculator")).click();

        // Enter numbers
        WebElement firstInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("number1")));
        WebElement secondInput = driver.findElement(By.id("number2"));
        WebElement calculateButton = driver.findElement(By.id("calculate"));

        firstInput.sendKeys("15");
        secondInput.sendKeys("5");
        calculateButton.click();

        // Get result
        WebElement answer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("answer")));
        String result = answer.getText();

        // Verify result
        Assertions.assertEquals("20", result, "Calculation result is incorrect!");

        System.out.println("Result = " + result);
    }
}
