package Assignment1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4 {
    public static void main(String[] args) throws InterruptedException {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Open Amazon homepage
        driver.get("https://www.amazon.com/");

        // Print the current window position and size
        System.out.println("Current Position: " + driver.manage().window().getPosition());
        System.out.println("Current Size: " + driver.manage().window().getSize());

        // Adjust the window position and size
        Point newPosition = new Point(300, 200); // example position
        Dimension newSize = new Dimension(1200, 700); // example size
        driver.manage().window().setPosition(newPosition);
        driver.manage().window().setSize(newSize);

        // Wait 2 seconds to apply changes
        Thread.sleep(2000);

        // Print the new window position and size
        Point currentPos = driver.manage().window().getPosition();
        Dimension currentSize = driver.manage().window().getSize();
        System.out.println("New Position: " + currentPos);
        System.out.println("New Size: " + currentSize);

        // Verify that the window is in the desired position and size
        if (currentPos.equals(newPosition) && currentSize.equals(newSize)) {
            System.out.println("The window is in the desired position and size.");
        } else {
            System.out.println("The window is NOT in the desired position and size.");
        }

        // Close the browser
        driver.quit();
    }
}
