package Assignment5;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task2 {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/guru99home/");
    }

    @Test
    void testFrames() {
        // count number of frames
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        System.out.println("Number of frames: " + frames.size());

        // switch to third iframe (index 2)
        driver.switchTo().frame(2);

        // click on the link inside iframe
        WebElement jmeterLink = driver.findElement(By.xpath("//a[contains(text(),'JMeter Made Easy')]"));
        jmeterLink.click();

        // back to main page
        driver.switchTo().defaultContent();

        Assertions.assertTrue(driver.getTitle().contains("Guru99"), "Not on Guru99 main page!");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
