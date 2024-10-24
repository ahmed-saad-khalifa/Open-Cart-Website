package ShoppingCartPage_Test;

import Header.Header_Comp;
import HomePage.HomePageComp;
import LoginPage.LoginPageComp;
import ShoppingCartPage.ShoppingCartComp;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class ShoppingCartCompTest extends ShoppingCartComp {
    @BeforeMethod
    public void OpenShoppingCartPage(ITestResult result) throws Exception {
        SetupTheDriver(result);
        //login
        LoginPageComp loginPageComp = new LoginPageComp();
        loginPageComp.CheckLoginPageOpened();
        loginPageComp.CheckIfUserLoginWithValidData();
        //go to home page
        driver.navigate().to(getConfigValue("config", "url"));
        //add MacBook to ShoppingCart
        HomePageComp homePageComp = new HomePageComp();
        homePageComp.ClickOnAddToCartButton();
        //go to ShoppingCart page
        Header_Comp headerComp = new Header_Comp();
        headerComp.ShoppingCartButtonIsWorking();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void checkContainer() throws Exception{
        CheckContainer();
    }

    @Test
    public void checkRemoveBtn() throws Exception{
        CheckRemoveBtn();
    }


    @AfterMethod
    public void Close(ITestResult result) throws Exception {
        closeDriver(result);
    }
}
