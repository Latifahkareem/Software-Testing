package Assignment11;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerLoginPage {
    WebDriver driver;

    private By customerLoginBtn = By.cssSelector("button[ng-click='customer()']");
    private By customerSelect = By.id("userSelect");
    private By loginBtn = By.cssSelector("button[type='submit']");

    public CustomerLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String customerName) {
        driver.findElement(customerLoginBtn).click();
        driver.findElement(customerSelect).sendKeys(customerName);
        driver.findElement(loginBtn).click();
    }
}
