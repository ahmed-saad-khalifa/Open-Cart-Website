package CategoryPage_Test;

import CategoryPage.CategoryPageComp;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CategoryPageTest extends CategoryPageComp {
    @BeforeMethod
    public void OpenCategoryPage(ITestResult result) throws Exception {
        SetupTheDriver(result);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testCheckCategoryPageOpened() {
        driver.navigate().to(getConfigValue("config", "category"));
        CheckCategoryPageOpened();
    }

    @Test
    public void testCheckProductListDisplayed() {
//        CheckCategoryPageOpened();
        testCheckCategoryPageOpened();
        CheckProductListDisplayed();
    }

    @Test
    public void testClickAddToCartButton() {
        testCheckCategoryPageOpened();
        ClickOnAddToCartButton();
    }

    @Test
    public void testCheckAddToCartAlertDisplay() {
        testCheckCategoryPageOpened();
        CheckAlertOnClickingAddToCart();
    }

    @Test
    public void testClickAddToWishListButton() {
        testCheckCategoryPageOpened();
        CheckAddToWishListButton();
    }

    @Test
    public void testCheckAddToWishListAlertDisplay() {
        testCheckCategoryPageOpened();
        CheckAlertOnClickingAddToWishList();
    }

    @Test
    public void testClickCompareProductButton() {
        testCheckCategoryPageOpened();
        ClickCompareProductButton();
    }

    @Test
    public void testCheckCompareProductAlertDisplay() {
        testCheckCategoryPageOpened();
        CheckAlertOnClickingCompareProduct();
    }

    @Test
    public void testCheckPaginationDisplayed() {
        testCheckCategoryPageOpened();
        CheckPaginationDisplayed();
    }

    @Test
    public void testCheckCategoryTitle() {
        testCheckCategoryPageOpened();
        CheckCategoryTitle("Desktops");
    }

    @Test
    public void testClickProductThumbnail() {
        testCheckCategoryPageOpened();
        ClickProductThumbnail();
    }

    @Test
    public void testCheckProductPriceDisplayed() {
        testCheckCategoryPageOpened();
        CheckProductPriceDisplayed();
    }

    @AfterMethod
    public void Close(ITestResult result) throws Exception {
        closeDriver(result);
    }
}
