package Assignment11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountManagementPage {
    WebDriver driver;

    public AccountManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openAccount(String customerName, String currency) {
        driver.findElement(By.cssSelector("button[ng-click='addAccount()']")).click();
        driver.findElement(By.id("userSelect")).sendKeys(customerName);
        driver.findElement(By.id("currency")).sendKeys(currency);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.switchTo().alert().accept();
    }
}
