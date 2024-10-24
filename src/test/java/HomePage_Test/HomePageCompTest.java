package HomePage_Test;

import HomePage.HomePageComp;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageCompTest extends HomePageComp {
    @BeforeMethod
    public void OpenHomePage(ITestResult result) throws Exception {
        SetupTheDriver(result);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test(priority = 1)
    public void CheckIfHomePageOpened() {

        CheckHomePageOpened();
    }

    @Test(priority = 2)
    public void CheckProductImageDisplayed() {
        CheckHomePageOpened();
        CheckProductImage();
    }

    @Test(priority = 3)
    public void CheckProductinfoDisplayed() {
        CheckHomePageOpened();
        CheckProductinfo();
    }

    @Test(priority = 4)
    public void CheckProductNameColorDisplayed() {
        CheckHomePageOpened();
        CheckProductNameColor();
    }
    @Test(priority = 5)
    public void ClickAddToCartBtn() {
        CheckHomePageOpened();
        ClickOnAddToCartButton();
    }
    @Test(priority = 6)
    public void CheckAddToCartAlertDisplay() {
        CheckHomePageOpened();
        CheckAlertOnCilickingOnAddTOCartBtn();

    }
    @Test(priority = 7)
    public void CheckAddToCartIconNumberIncrease() throws InterruptedException {
        CheckHomePageOpened();
        CheckCartIconNumberUpdates();
    }

    @Test(priority = 8)
    public void ClickAddToWishListBtn() {
        CheckHomePageOpened();
        ClickOnAddToWishListButton();
    }
    @Test(priority = 9)
    public void CheckAddToWishListAlertDisplay() {
        CheckHomePageOpened();
        CheckAlertOnCilickingOnAddToWishListBtn();

    }
    @Test(priority = 10)
    public void CheckAddToWishListIconNumberIncrease() throws InterruptedException {
        CheckHomePageOpened();
        CheckWishListIconNumberUpdates();
    }


    @Test(priority = 11)
    public void ClickCompareThisProductBtn() {
        CheckHomePageOpened();
        ClickOnCompareThisProductButton();;
    }

    @Test(priority = 12)
    public void CheckCompareThisProductBtnAlertDisplay() {
        CheckHomePageOpened();
        CheckAlertOnCilickingOnCompareThisProductBtn();;
    }

    @Test(priority = 13)
    public void ClickImageSliderNextBtn()  {
        CheckHomePageOpened();
        ClickImageSliderNextButton();
    }

    @Test(priority = 14)
    public void ClickImageSliderPreviousBtn()  {
        CheckHomePageOpened();
        ClickImageSliderPreviousButton();
    }

    @Test(priority = 14)
    public void CheckBottomImageSlider()  {
        CheckHomePageOpened();
        CheckLogoImagesDisplayInBottomSlider();
    }








@AfterMethod
public void Close(ITestResult result) throws Exception {
    closeDriver(result);
}
}