package Assignment11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountManagementPage {
    WebDriver driver;
    private By openAccountBtn = By.cssSelector("button[ng-click='openAccount()']");
    private By customerSelect = By.id("userSelect");
    private By currencySelect = By.id("currency");
    private By processBtn = By.cssSelector("button[type='submit']");

    public AccountManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openAccount(String customerName, String currency) {
        driver.findElement(openAccountBtn).click();
        driver.findElement(customerSelect).sendKeys(customerName);
        driver.findElement(currencySelect).sendKeys(currency);
        driver.findElement(processBtn).click();
        driver.switchTo().alert().accept();
    }
}
