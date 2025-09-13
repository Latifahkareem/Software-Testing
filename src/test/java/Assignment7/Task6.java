package assignment7;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task6 {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    void captchaHandlingTest() {
        driver.get("https://form.jotform.com/73302671092956");

        String captcha = driver.findElement(By.id("input_2")).getText(); // adjust if locator differs
        System.out.println("Captcha text = " + captcha);

        String[] parts = captcha.split(" ");
        int num1 = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int num2 = Integer.parseInt(parts[2]);
        int result = 0;

        switch (operator) {
            case "+": result = num1 + num2; break;
            case "-": result = num1 - num2; break;
            case "*": result = num1 * num2; break;
            case "/": result = (num2 != 0) ? Math.round((float) num1 / num2) : 0; break;
        }

        System.out.println("Calculation: " + num1 + " " + operator + " " + num2 + " = " + result);

        driver.findElement(By.id("number")).sendKeys(String.valueOf(result)); // adjust locator
        // fill rest of form if required, then submit
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
