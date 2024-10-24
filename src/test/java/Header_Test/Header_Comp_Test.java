package Header_Test;

import Header.Header_Comp;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Header_Comp_Test extends Header_Comp {
    @BeforeMethod
    public void OpenHomePage(ITestResult result) throws Exception {
        SetupTheDriver(result);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test(priority = 1)
    public void CheckIfHomePageOpened() {

        gethomepagebutton();
    }

    @Test(priority = 2)
    public void CheckIfCurrencySwitcherWorks() {
        CurrencySwitch();
    }

    @Test(priority = 3)
    public void CheckIfContactUsPageWorks() {
        ContactUsPageIsWorking();
    }

    @Test(priority = 4)
    public void CheckIfWishlistButtonWorks() {
        WishlistButtonIsWorking();
    }

    @Test(priority = 5)
    public void CheckIfShoppingCartButtonWorks() {
        ShoppingCartButtonIsWorking();
    }

    @Test(priority = 6)
    public void CheckIfCheckoutButtonWorks() {
        CheckoutButtonIsWorking();
    }

    @Test(priority = 7)
    public void CheckIfLoginButtonWorks() throws InterruptedException {
        LoginButtonIsWorking();
    }

    @Test(priority = 8)
    public void CheckIfRegisterButtonWorks() throws InterruptedException {
        RegisterButtonIsWorking();
    }

    @Test(priority = 9)
    public void CheckIfCartDropdownWorks() {
        CartDropdownIsWorking();
    }

    @Test(priority = 10)
    public void CheckValidSearch() {
        SearchBarValidSearch();
    }

    @Test(priority = 11)
    public void CheckInvalidSearch() {
        SearchBarInvalidSearch();
    }

    @Test(priority = 12)
    public void CheckCategorySwitchers() {
        TestCategorySwitchers();
    }

    @Test(priority = 13)
    public void CheckCategoryButtons() {
        TestCategoryButtons();
    }

    @Test(priority = 14)
    public void CheckDesktopsSwitcher() {
        TestDesktopsSwitcher();
    }

    @Test(priority = 15)
    public void CheckHeaderContainers() {
        TestHeaderContainers();
    }

    @AfterMethod
    public void Close(ITestResult result) throws Exception {
        closeDriver(result);
    }
}
