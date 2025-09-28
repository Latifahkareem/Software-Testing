package Assignment8;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task4 {
    private static final Logger logger = LogManager.getLogger(Task4.class);

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

        Faker faker = new Faker();

        // Add 10 records
        for (int i = 0; i < 10; i++) {
            driver.findElement(By.id("name")).sendKeys(faker.name().firstName());
            driver.findElement(By.id("age")).sendKeys(String.valueOf(faker.number().numberBetween(18, 65)));
            driver.findElement(By.id("country")).sendKeys(faker.country().name());
            driver.findElement(By.id("add")).click();
        }

        // Extract rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table']//tbody//tr"));

        int youngestAge = Integer.MAX_VALUE;
        String youngestName = "";

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String name = cells.get(0).getText();
            int age = Integer.parseInt(cells.get(1).getText());

            if (age < youngestAge) {
                youngestAge = age;
                youngestName = name;
            }
        }

        logger.info("The youngest person is: " + youngestName + " with age " + youngestAge);
        System.out.println("The youngest person is: " + youngestName + " with age " + youngestAge);

        driver.quit();
    }
}
