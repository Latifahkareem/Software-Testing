package Assignment5;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Task1 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
    }

    @Test
    void testEmojisForm() {
        // switch to iframe
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("emoojis")));
        driver.switchTo().frame(iframe);

        // click on second emoji category
        WebElement secondEmojiTab = driver.findElement(By.xpath("//a[@href='#nature']"));
        secondEmojiTab.click();

        // click on all emojis under "nature" category
        List<WebElement> allEmojis = driver.findElements(By.xpath("//div[@id='nature']/div/img"));
        for (WebElement emoji : allEmojis) {
            emoji.click();
        }

        // switch back to parent frame
        driver.switchTo().defaultContent();

        // fill out the form
        driver.findElement(By.id("text")).sendKeys("Test User");
        driver.findElement(By.id("smiles")).sendKeys("Selenium");
        driver.findElement(By.id("nature")).sendKeys("Automation");
        driver.findElement(By.id("food")).sendKeys("Pizza");
        driver.findElement(By.id("activities")).sendKeys("Coding");
        driver.findElement(By.id("places")).sendKeys("Home");
        driver.findElement(By.id("objects")).sendKeys("Laptop");
        driver.findElement(By.id("symbols")).sendKeys("❤");
        driver.findElement(By.id("flags")).sendKeys("Flag test");

        // click Apply button
        driver.findElement(By.id("send")).click();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}