package assignment7;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4 {
    WebDriver driver;
    Faker faker = new Faker(new Locale("en-GB"));

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    void fakerFormTest() {
        driver.get("https://demoqa.com/text-box");

        String fullName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String currentAddress = faker.address().fullAddress();
        String permanentAddress = faker.address().secondaryAddress();

        driver.findElement(By.id("userName")).sendKeys(fullName);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
        driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddress);
        driver.findElement(By.id("submit")).click();

        WebElement output = driver.findElement(By.id("output"));
        String outputText = output.getText();

        assertTrue(outputText.contains(fullName));
        assertTrue(outputText.contains(email));
        assertTrue(outputText.contains(currentAddress));
        assertTrue(outputText.contains(permanentAddress));

        System.out.println("Form submitted successfully with Faker data ✅");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
