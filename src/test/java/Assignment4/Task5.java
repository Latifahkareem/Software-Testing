package Assignment4;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Task5 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void dynamicListManagementTest() {
        Faker faker = new Faker();

        // إزالة أي مهام موجودة مسبقًا
        List<WebElement> existingTasks = driver.findElements(By.xpath("//li"));
        for (WebElement task : existingTasks) {
            WebElement deleteButton = task.findElement(By.xpath(".//i[@class='fa fa-trash']"));
            deleteButton.click();
            wait.until(ExpectedConditions.stalenessOf(task));
        }

        // إضافة 5 مهام عشوائية
        for (int i = 0; i < 5; i++) {
            String taskName = faker.lorem().word();
            System.out.println("Generated Task: " + taskName);
            WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
            inputBox.sendKeys(taskName, Keys.ENTER);
        }

        // تعليم كل مهمة ثانية كمكتملة (strikethrough)
        List<WebElement> tasks = driver.findElements(By.xpath("//ul/li"));
        for (int i = 1; i < tasks.size(); i += 2) {
            tasks.get(i).click();
        }

        // حذف المهام المكتملة
        List<WebElement> completedTasks = driver.findElements(By.xpath("//li[@class='completed']"));
        for (WebElement task : completedTasks) {
            WebElement deleteButton = task.findElement(By.xpath(".//i[@class='fa fa-trash']"));
            deleteButton.click();
            wait.until(ExpectedConditions.stalenessOf(task));
        }

        // التحقق من بقاء المهام غير المكتملة فقط
        int remainingTasks = driver.findElements(By.xpath("//li[not(@class='completed')]")).size();
        System.out.println("Remaining Incomplete Tasks: " + remainingTasks);

        // بعد حذف كل مهمة ثانية، يجب أن تبقى 3 مهام غير مكتملة
        Assertions.assertEquals(3, remainingTasks);
    }
}
