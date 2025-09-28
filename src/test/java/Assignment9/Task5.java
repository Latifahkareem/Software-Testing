package Assignment9;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task5 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Initialize ChromeDriver and open the login page
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://claruswaysda.github.io/signIn.html");
    }

    @Test
    public void negativeLoginTest() {
        SoftAssert softAssert = new SoftAssert();

        // Enter incorrect credentials
        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("wrongpass");
        driver.findElement(By.id("loginButton")).click();

        try {
            // Switch to JavaScript alert
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();

            // Soft Assertion: Verify alert message text
            softAssert.assertEquals(alertText, "Incorrect username or password",
                    "ERROR: Alert message text is incorrect!");

            // Accept the alert
            alert.accept();

        } catch (NoAlertPresentException e) {
            // Fail the test if alert did not appear
            softAssert.fail("ERROR: Alert did not appear after failed login");
        }

        // Execute all soft assertions
        softAssert.assertAll();
    }

    @AfterMethod
    public void teardown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
