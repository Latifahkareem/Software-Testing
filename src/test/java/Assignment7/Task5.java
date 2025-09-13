package assignment7;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5 {
    WebDriver driver;
    Faker faker = new Faker(new Locale("en-GB"));

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    void dynamicListTest() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

        for (int i = 0; i < 5; i++) {
            String task = faker.job().title();
            driver.findElement(By.cssSelector("input[type='text']")).sendKeys(task + Keys.ENTER);
        }

        List<WebElement> todos = driver.findElements(By.cssSelector("ul li"));
        for (int i = 0; i < todos.size(); i++) {
            if (i % 2 == 0) todos.get(i).click(); // mark as completed
        }

        List<WebElement> deleteButtons = driver.findElements(By.cssSelector(".completed span"));
        for (WebElement deleteBtn : deleteButtons) {
            deleteBtn.click();
        }

        List<WebElement> remaining = driver.findElements(By.cssSelector("ul li"));
        for (WebElement task : remaining) {
            assertTrue(!task.getAttribute("class").contains("completed"));
        }

        System.out.println("Completed tasks deleted, only incomplete remain ✅");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
