package CheckoutPage_Test;

import CheckoutPage.CheckoutPageComp;
import HomePage_Test.HomePageCompTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CheckoutPageTest extends CheckoutPageComp {

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(ITestResult result) throws Exception {
        SetupTheDriver(result);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(ITestResult result) throws Exception {
        closeDriver(result);
    }

    @Test(priority = 1)
    public void checkCheckoutPageOpened() throws InterruptedException {

        driver.navigate().to(getConfigValue("config", "product"));
        helpFunc();
        checkIfCheckoutPageOpened();
    }

    @Test(priority = 2)
    public void checkStepOne() throws InterruptedException {
        checkCheckoutPageOpened();
        checkIfCheckoutOptions(getConfigValue("config", "checkoutOption"));
    }

    @Test(priority = 3)
    public void checkStepTwo() throws InterruptedException {
        checkStepOne();
        validateBillingDetails();
    }

    @Test(priority = 3)
    public void checkStepThree() throws InterruptedException {
        checkStepTwo();
        checkIfDeleviryDetailsFilled();
    }

    @Test(priority = 3)
    public void checkStepFour() throws InterruptedException {
        checkStepThree();
        checkDeliveryMethod();

    }

    @Test(priority = 4)
    public void checkStepFive() throws InterruptedException {
        checkStepFour();
        checkIfSelectingPaymentMethod();

    }

    @Test(priority = 5)
    public void checkStepSix() throws InterruptedException {
        checkStepFive();
        checkConfirmOrder();
    }

}
