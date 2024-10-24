package BrandsPage_Test;

import BrandsPage.BrandsPageComp;
import LoginPage_Test.LoginPageComp_Test;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BrandsPageCompTest extends BrandsPageComp {

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(ITestResult result) throws Exception {
        SetupTheDriver(result);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        LoginPageComp_Test loginPageCompTest = new LoginPageComp_Test();
        loginPageCompTest.CheckIfUserLoggedinWithValidData();

        driver.navigate().to(getConfigValue("config","brandsUrl"));
    }

    @Test
    public void TestIfBrandsPageOpened() {
        CheckBrandsPageOpened();
    }

    @Test
    public void TestPageTitleIsDisplayed(){
        CheckBrandsPageOpened();
        CheckPageTitleIsDisplayed();
    }

    @Test
    public void TestBrandsIndexIsDisplayed(){
        CheckBrandsPageOpened();
        CheckBrandsIndexIsDisplayed();
    }

    @Test
    public void TestBrandAreClickable(){
        CheckBrandsPageOpened();
        CheckBrandAreClickable();
    }

    @AfterMethod
    public void Close(ITestResult result) throws Exception {
        closeDriver(result);
    }
}
