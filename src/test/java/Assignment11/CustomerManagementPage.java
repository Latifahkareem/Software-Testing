package Assignment11;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerManagementPage {
    WebDriver driver;
    private By addCustomerBtn = By.cssSelector("button[ng-click='addCust()']");
    private By firstNameInput = By.cssSelector("input[ng-model='fName']");
    private By lastNameInput = By.cssSelector("input[ng-model='lName']");
    private By postCodeInput = By.cssSelector("input[ng-model='postCd']");
    private By submitAddCustomer = By.cssSelector("button[type='submit']");

    private By customersTab = By.cssSelector("button[ng-click='showCust()']");
    private By deleteCustomerBtn = By.cssSelector("button[ng-click='deleteCust(cust)']");

    public CustomerManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addCustomer(String fName, String lName, String postCode) {
        driver.findElement(addCustomerBtn).click();
        driver.findElement(firstNameInput).sendKeys(fName);
        driver.findElement(lastNameInput).sendKeys(lName);
        driver.findElement(postCodeInput).sendKeys(postCode);
        driver.findElement(submitAddCustomer).click();
        driver.switchTo().alert().accept(); // التعامل مع alert
    }

    public void deleteAllCustomers() {
        driver.findElement(customersTab).click();
        while(driver.findElements(deleteCustomerBtn).size() > 0) {
            driver.findElement(deleteCustomerBtn).click();
        }
    }
}
