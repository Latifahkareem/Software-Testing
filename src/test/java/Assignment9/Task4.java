package Assignment9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task4 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://claruswaysda.github.io/signIn.html");
    }

    @Test
    public void positiveLoginTest() {

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("loginButton")).click();

        String expectedUrl = "https://claruswaysda.github.io/signIn.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "ERROR: after login URL not true!");

        // Hard Assertion 2: تحقق من وجود نص "Employee Table"
        WebElement body = driver.findElement(By.tagName("body"));
        Assert.assertTrue(body.getText().contains("Employee Table"),
                "ERROR: this page not contain 'Employee Table'");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

