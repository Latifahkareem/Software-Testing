package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagerLoginPage {
    WebDriver driver;
    private By managerLoginBtn = By.cssSelector("button[ng-click='manager()']");

    public ManagerLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginAsManager() {
        driver.findElement(managerLoginBtn).click();
    }
}
