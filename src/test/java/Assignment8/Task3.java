package Assignment8;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Task3 {
    private static final Logger logger = LogManager.getLogger(Task3.class);

    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://claruswaysda.github.io/webTable.html");

        // Locate Table 1
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Create Excel workbook
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Table1");

        // Write table data into Excel
        for (int i = 0; i < rows.size(); i++) {
            Row excelRow = sheet.createRow(i);
            List<WebElement> cols = rows.get(i).findElements(By.tagName("th"));
            if (cols.isEmpty()) {
                cols = rows.get(i).findElements(By.tagName("td"));
            }
            for (int j = 0; j < cols.size(); j++) {
                excelRow.createCell(j).setCellValue(cols.get(j).getText());
            }
        }

        // Save to file
        FileOutputStream fos = new FileOutputStream("Table1.xlsx");
        workbook.write(fos);
        fos.close();
        workbook.close();

        logger.info("Table 1 exported to Table1.xlsx successfully!");
        driver.quit();
    }
}
