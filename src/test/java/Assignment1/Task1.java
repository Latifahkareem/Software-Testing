package Assignment1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    public static void main(String[] args) {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Create ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Open Google homepage
        driver.get("https://www.google.com");

        // Print the page title
        System.out.println("Page Title: " + driver.getTitle());

        // Print the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Close the browser
        driver.quit();
    }
}
