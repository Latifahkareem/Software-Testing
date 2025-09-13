package assignment7;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task3 {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    void radioButtonTest() {
        driver.get("https://demoqa.com/radio-button");

        WebElement yesRadio = driver.findElement(By.id("yesRadio"));
        WebElement impressiveRadio = driver.findElement(By.id("impressiveRadio"));
        WebElement noRadio = driver.findElement(By.id("noRadio"));

        if (yesRadio.isEnabled()) {
            yesRadio.click();
            System.out.println("Yes radio selected ✅");
        }
        if (impressiveRadio.isEnabled()) {
            impressiveRadio.click();
            System.out.println("Impressive radio selected ✅");
        }
        System.out.println("Is 'No' enabled? " + noRadio.isEnabled());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
