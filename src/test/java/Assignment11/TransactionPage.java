package Assignment11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.cssSelector;

public class TransactionPage {
    WebDriver driver;
    private final By depositTab = cssSelector("button[ng-click='deposit()']");
    private final By withdrawTab = cssSelector("button[ng-click='withdrawl()']");
    private final By amountInput = cssSelector("input[ng-model='amount']");
    private final By submitBtn = cssSelector("button[type='submit']");
    private final By balanceText = cssSelector("strong.ng-binding");

    public TransactionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void deposit(int amount) {
        driver.findElement(depositTab).click();
        driver.findElement(amountInput).sendKeys(String.valueOf(amount));
        driver.findElement(submitBtn).click();
    }

    public void withdraw(int amount) {
        driver.findElement(withdrawTab).click();
        driver.findElement(amountInput).sendKeys(String.valueOf(amount));
        driver.findElement(submitBtn).click();
    }

    public int getBalance() {
        return Integer.parseInt(driver.findElement(balanceText).getText());
    }
}
