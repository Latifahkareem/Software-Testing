package Assignment13.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DashboardPage extends BasePage<DashboardPage> {

    @FindBy(id = "addContactBtn")
    private WebElement addContactButton;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public AddContactPage clickAddContact() {
        addContactButton.click();
        return new AddContactPage(driver);
    }
}
