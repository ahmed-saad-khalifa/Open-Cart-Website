package TransactionPage;
import LoginPage.LoginPageComp;
import MyAccountPage.MyAccountPageComp;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class TransactionPageComp extends TransactionPageWebElement{

    public void checkTransactionPageOpened() {
        LoginPageComp login = new LoginPageComp();
        login.CheckLoginPageOpened();
        login.CheckIfUserLoginWithValidData();
        MyAccountPageComp account = new MyAccountPageComp();
        account.CheckMyAccountPageOpened();
        logger.debug("Check Transaction Page opened");




        // Redirect to the transaction page
        String transactionUrl = getConfigValue("config", "transaction");
        driver.get(transactionUrl); // Navigate to the transaction page

        // URL verification
        String currentUrl = driver.getCurrentUrl();
        checkIfEqual(currentUrl, transactionUrl);

        // Check if the transaction table is displayed
        boolean isDisplayed = getTransactionTable().isDisplayed();
        System.out.println("Transaction table is displayed: " + isDisplayed);
    }

    public void checkTransactionListDisplayed() {
        logger.debug("Check if the transaction list is displayed");
        boolean isDisplayed = getTransactionTable().isDisplayed();
        System.out.println("Transaction list is displayed: " + isDisplayed);
    }



    public void checkTransactionDetailsDisplayed(int rowIndex) {
        logger.debug("Check if transaction details are displayed for row " + rowIndex);
        WebElement transactionDetails = getTransactionDetails(rowIndex);
        boolean isDisplayed = transactionDetails.isDisplayed();
        System.out.println("Transaction details for row " + rowIndex + " are displayed: " + isDisplayed);

        // If not displayed, try to retrieve and log the error message
        if (!isDisplayed) {
            String errorMessage = String.valueOf(getNoTransactionMessage("You do not have any transactions!")); // Implement this method to retrieve the error message
            System.out.println("Error message for row " + rowIndex + ": " + errorMessage);
            logger.error("Transaction details for row " + rowIndex + " are not displayed. Error: " + errorMessage);
        }
    }

//

    public void checkContinueButton() {
        logger.debug("Check if Continue button is present and clickable");
        WebElement continueButton = getContinueButton();
        explicitlyWaitForVisibility(continueButton);
        boolean isEnabled = continueButton.isEnabled();
        System.out.println("Continue button is enabled: " + isEnabled);
        continueButton.click();
    }

    public void checkNoTransactionMessage() {
        logger.debug("Check if No Transaction message is displayed");
        WebElement noTransactionMessage = getNoTransactionMessage("You do not have any transactions!");
        boolean isDisplayed = noTransactionMessage.isDisplayed();
        System.out.println("No Transaction message is displayed: " + isDisplayed);
    }

//    public void checkTransactionDateDisplayed(int rowIndex) {
//        logger.debug("Check if transaction date is displayed for row " + rowIndex);
//        WebElement transactionDate = getTransactionDate(rowIndex);
//        boolean isDisplayed = transactionDate.isDisplayed();
//        System.out.println("Transaction date for row " + rowIndex + " is displayed: " + isDisplayed);
//    }
//
//    public void checkTransactionDescriptionDisplayed(int rowIndex) {
//        logger.debug("Check if transaction description is displayed for row " + rowIndex);
//        WebElement transactionDescription = getTransactionDescription(rowIndex);
//        boolean isDisplayed = transactionDescription.isDisplayed();
//        System.out.println("Transaction description for row " + rowIndex + " is displayed: " + isDisplayed);
//    }
//
//    public void checkTransactionAmountDisplayed(int rowIndex) {
//        logger.debug("Check if transaction amount is displayed for row " + rowIndex);
//        WebElement transactionAmount = getTransactionAmount(rowIndex);
//        boolean isDisplayed = transactionAmount.isDisplayed();
//        System.out.println("Transaction amount for row " + rowIndex + " is displayed: " + isDisplayed);
//    }
}
