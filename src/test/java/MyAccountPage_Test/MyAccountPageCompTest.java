package MyAccountPage_Test;

import LoginPage.LoginPageComp;
import MyAccountPage.MyAccountPageComp;
import Utility.ScreenRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyAccountPageCompTest extends MyAccountPageComp {
    @BeforeMethod
    public void OpenMyAccountPage(ITestResult result) throws Exception {
        SetupTheDriver(result);
        LoginPageComp Login=new LoginPageComp();
        Login.CheckLoginPageOpened();
        Login.CheckIfUserLoginWithValidData();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
    }

    @Test(priority = 1)
    public void CheckIfMyAccountPageOpened(){
        CheckMyAccountPageOpened();
    }

    @Test(priority = 2)
    public void ClickEditYourAccountInformationBtn(){
        CheckMyAccountPageOpened();
        ClickEditYourAccountInformationButton();
    }

    @Test(priority = 3)
    public void ClickChangeYourPasswordBtn(){
        CheckMyAccountPageOpened();
        ClickChangeYourPasswordButton();
    }

@AfterMethod(alwaysRun = true)
public void CloseBrowser(ITestResult result) throws Exception {
    closeDriver(result);
    driver.quit();

}}