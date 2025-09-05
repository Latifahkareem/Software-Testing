package Assignment1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Open Google homepage
        driver.get("https://www.google.com/");

        // Maximize the window
        driver.manage().window().maximize();

        // Print the window's current position and size
        System.out.println("Position: " + driver.manage().window().getPosition());
        System.out.println("Size: " + driver.manage().window().getSize());

        // Minimize the window
        driver.manage().window().minimize();

        // Wait 5 seconds in minimized state
        Thread.sleep(5000);

        // Maximize the window again
        driver.manage().window().maximize();

        // Print the window's position and size after maximizing
        System.out.println("Maximized Position: " + driver.manage().window().getPosition());
        System.out.println("Maximized Size: " + driver.manage().window().getSize());

        // Set the window to fullscreen
        driver.manage().window().fullscreen();

        // Close the browser
        driver.quit();
    }
}
