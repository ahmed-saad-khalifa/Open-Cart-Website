package WishListPage_Test;

import WishListPage.WishListComp;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import LoginPage.LoginPageComp;
import HomePage.HomePageComp;
import Header.Header_Comp;

public class WishListCompTest extends WishListComp {
    @BeforeMethod
    public void OpenWishlistPage(ITestResult result) throws Exception {
        SetupTheDriver(result);
        //login
        LoginPageComp loginPageComp = new LoginPageComp();
        loginPageComp.CheckLoginPageOpened();
        loginPageComp.CheckIfUserLoginWithValidData();
        //go to home page
        driver.navigate().to(getConfigValue("config", "url"));
        //add MacBook to wishlist
        HomePageComp homePageComp = new HomePageComp();
        homePageComp.ClickOnAddToWishListButton();
        //go to wish list page
        Header_Comp headerComp = new Header_Comp();
        headerComp.WishlistButtonIsWorking();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(priority = 1)
    public void checkContainer() throws Exception{
        CheckContainer();
    }

    @Test(priority = 2)
    public void checkContinueButtonDirectsToMyAccountPage() throws Exception{
        CheckContinueButtonDirectsToMyAccountPage();
    }

    @Test(priority = 3)
    public void checkTheClickOnProductImageDirectsToItsPage() throws Exception{

        CheckTheClickOnProductImageDirectsToItsPage();
    }

    @Test(priority = 3)
    public void checkTheClickOnProductHyperLinkDirectsToItsPage() throws Exception{
        CheckTheClickOnProductHyperLinkDirectsToItsPage();
    }

    @AfterMethod
    public void Close(ITestResult result) throws Exception {
        closeDriver(result);
    }

}
