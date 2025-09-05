package Assignment1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    public static void main(String[] args) {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Create ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Open YouTube homepage
        driver.get("https://www.youtube.com/");

        // Get the page title
        String title = driver.getTitle();

        // Verify if the title contains the word "video"
        if (title.toLowerCase().contains("video")) {
            System.out.println("Title contains 'video': PASS");
        } else {
            System.out.println("Title does not contain 'video': FAIL");
        }

        // Close the browser
        driver.quit();
    }
}
