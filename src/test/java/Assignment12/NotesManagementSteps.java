package Assignment12;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

public class NotesManagementSteps {

    private WebDriver driver;

    @Given("I am on the Notes application page")
    public void i_am_on_the_notes_application_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");
    }

    @When("I add the following notes:")
    public void i_add_the_following_notes(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> notes = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> note : notes) {
            driver.findElement(By.id("note-title-input")).clear();
            driver.findElement(By.id("note-title-input")).sendKeys(note.get("Title"));

            driver.findElement(By.id("note-details-input")).clear();
            driver.findElement(By.id("note-details-input")).sendKeys(note.get("Note"));

            driver.findElement(By.id("add-note")).click();
        }
    }

    @Then("I should see all {int} notes displayed on the page")
    public void i_should_see_all_notes_displayed_on_the_page(Integer expectedCount) {
        List<WebElement> notes = driver.findElements(By.cssSelector(".note"));
        Assertions.assertEquals(expectedCount, notes.size(),
                "Expected " + expectedCount + " notes, but found " + notes.size());

        // Optional: Print titles for debugging
        notes.forEach(note -> System.out.println("Note: " + note.getText()));

        driver.quit();
    }
}
