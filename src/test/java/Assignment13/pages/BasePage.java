package Assignment13.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage<T extends BasePage<T>> {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public T open(String url) {
        driver.get(url);
        //noinspection unchecked
        return (T) this;
    }
}
