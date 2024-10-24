package ProductPage_Test;

import ProductPage.ProductPageComp;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductPageTest extends ProductPageComp {

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(ITestResult result) throws Exception {
        SetupTheDriver(result);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to(getConfigValue("config","product"));
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(ITestResult result) throws Exception {
        closeDriver(result);
    }

    @Test(priority = 1)
    public void testProductPageOpened() {
        checkIfProductPageOpened();
    }

    @Test(priority = 2, dependsOnMethods = "testProductPageOpened")
    public void testProductDetails() {
        checkProductDetails();
    }

    @Test(priority = 3, dependsOnMethods = "testProductPageOpened")
    public void testProductPrice() {
        checkProductPrice();
    }

    @Test(priority = 4, dependsOnMethods = "testProductPageOpened")
    public void testProductRewardPoints() {
        checkProductRewardPoints();
    }

    @Test(priority = 5, dependsOnMethods = "testProductPageOpened")
    public void testSelectProductQuantity() {
        selectProductQuantity(2);
    }

    @Test(priority = 6, dependsOnMethods = {"testSelectProductQuantity", "testProductPageOpened"})
    public void testAddToCart() {
        addToCart();
    }
}
