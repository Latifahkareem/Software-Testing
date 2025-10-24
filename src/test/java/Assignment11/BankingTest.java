package Assignment11;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BankingTest {
    WebDriver driver;
    List<String> customers = new ArrayList<>();

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @Test
    public void bankingOperations() {
        // 1. Manager login
        Assignment11.ManagerLoginPage managerPage = new Assignment11.ManagerLoginPage(driver);
        managerPage.loginAsManager();

        CustomerManagementPage customerMgmt = new CustomerManagementPage(driver);
        Assignment11.AccountManagementPage accountMgmt = new AccountManagementPage(driver);

        // 2. Add 5 customers & open accounts
        for(int i = 1; i <= 5; i++) {
            String name = "Customer" + i;
            String lastName = "Test";
            String postCode = "12345";
            customers.add(name);

            customerMgmt.addCustomer(name, lastName, postCode);
            accountMgmt.openAccount(name, "Dollar");
        }

        // 3. Customer deposit
        for(String cust : customers) {
            CustomerLoginPage custLogin = new CustomerLoginPage(driver);
            custLogin.login(cust);

            TransactionPage txnPage = new Assignment11.TransactionPage(driver);
            txnPage.deposit(100);
            Assert.assertEquals(txnPage.getBalance(), 100);

            // Logout
            driver.findElement(By.cssSelector("button[ng-click='byebye()']")).click();
        }

        // 4. Withdraw 100 from first customer
        CustomerLoginPage custLogin = new CustomerLoginPage(driver);
        custLogin.login(customers.getFirst());
        TransactionPage txnPage = new TransactionPage(driver);
        txnPage.withdraw(100);
        Assert.assertEquals(txnPage.getBalance(), 0);

        // 5. Delete all customers
        Assignment11.ManagerLoginPage managerPage2 = new Assignment11.ManagerLoginPage(driver);
        managerPage2.loginAsManager();
        customerMgmt.deleteAllCustomers();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
