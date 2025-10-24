package Assignment13.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddContactPage extends BasePage<AddContactPage> {

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(id = "saveButton")
    private WebElement saveButton;

    public AddContactPage(WebDriver driver) {
        super(driver);
    }

    public AddContactPage enterName(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    public AddContactPage enterEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public AddContactPage enterPhone(String phone) {
        phoneInput.sendKeys(phone);
        return this;
    }

    public void clickSave() {
        saveButton.click();
        new DashboardPage(driver);
    }

}
