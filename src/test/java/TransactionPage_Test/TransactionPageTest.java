package TransactionPage_Test;

import LoginPage.LoginPageComp;
import LoginPage_Test.LoginPageComp_Test;
import TransactionPage.TransactionPageComp;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
public class TransactionPageTest extends TransactionPageComp{
    @BeforeMethod
    public void openTransactionPage(ITestResult result) throws Exception {
        SetupTheDriver(result);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to(getConfigValue("config", "transaction"));
    }

    @Test
    public void testCheckTransactionPageOpened()  {
//        LoginPageComp_Test login = new LoginPageComp_Test();
//        login. CheckIfUserLoggedinWithValidData();
        checkTransactionPageOpened();
    }

    @Test
    public void testCheckTransactionListDisplayed()  {
        testCheckTransactionPageOpened();
        checkTransactionListDisplayed();
    }

    @Test
    public void testCheckTransactionDetailsDisplayed()  {
        // Assuming there are multiple transactions; replace 0 with appropriate index
        testCheckTransactionPageOpened();
        checkTransactionDetailsDisplayed(0);
    }

//
    @Test
    public void testCheckContinueButton()  {
        testCheckTransactionPageOpened();
        checkContinueButton();
    }

    @Test
    public void testCheckNoTransactionMessage()  {
        testCheckTransactionPageOpened();

        checkNoTransactionMessage();
    }
 //   @Test
//    public void testCheckTransactionDateDisplayed() {
//        // Assuming there are multiple transactions; replace 0 with appropriate index
//        checkTransactionDateDisplayed();
//    }
//
//    @Test
//    public void testCheckTransactionDescriptionDisplayed() {
//        // Assuming there are multiple transactions; replace 0 with appropriate index
//        checkTransactionDescriptionDisplayed(0);
//    }
//
//    @Test
//    public void testCheckTransactionAmountDisplayed() {
//        // Assuming there are multiple transactions; replace 0 with appropriate index
//        checkTransactionAmountDisplayed(0);
//    }

    @AfterMethod
    public void close(ITestResult result) throws Exception {
        closeDriver(result);
    }
}
