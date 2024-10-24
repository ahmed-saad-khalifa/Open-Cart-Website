package TransactionPage;

import Utility.FindingElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TransactionPageWebElement extends FindingElements {
    public WebElement getTransactionPage(){
        return driver.findElement(By.id("content"));
    }
    public WebElement getRightList(){
        return driver.findElement(By.id("column-right"));
    }
    public WebElement getTransactionTable() {
        return findElementByClassName("table-responsive"); // Update with the actual locator for the transaction table
    }

    public WebElement getBackButton() {
        return driver.findElement(By.xpath("//a[text()='Back']")); // Locator for the Back button
    }

    public WebElement getTransactionDetails(int rowIndex) {
        return driver.findElement(By.className("text-center")); // Locator for transaction details row-wise
    }
    // Get the 'Continue' button if available on the page
    public WebElement getContinueButton() {return driver.findElement(By.xpath("//a[text()='Continue']")); // Locator for the Continue button
    }

    // Get the transaction date for a specific row
    public WebElement getTransactionDate(int rowIndex) {
        return driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[" + rowIndex + "]/td[1]"));
    }

    // Get the transaction description for a specific row
    public WebElement getTransactionDescription(int rowIndex) {
        return driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[" + rowIndex + "]/td[2]"));
    }

    // Get the transaction amount for a specific row
    public WebElement getTransactionAmount(int rowIndex) {
        return driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[" + rowIndex + "]/td[3]"));
    }

    // Get the text indicating a lack of transactions (e.g., "No transactions found")
    public WebElement getNoTransactionMessage(String s) {
        return driver.findElement(By.className("text-center")); // Adjust locator if needed
    }
}
