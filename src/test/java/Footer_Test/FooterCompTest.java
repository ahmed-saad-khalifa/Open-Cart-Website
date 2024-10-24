package Footer_Test;

import Footer.FooterComp;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import LoginPage.LoginPageComp;

public class FooterCompTest extends FooterComp {
    @BeforeMethod
    public void OpenHomePage(ITestResult result) throws Exception {
        SetupTheDriver(result);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void checkFooterContainer() throws Exception{
       CheckFooterContainer();
    }

    @Test
    public void checkInformationSectionHyperLinks() throws Exception{
        CheckInformationSectionHyperLinks();
    }

    @Test
    public void checkCustomerServiceSectionHyperLinks() throws Exception{
        CheckCustomerServiceSectionHyperLinks();
    }
    @Test
    public void checkExtrasSectionHyperLinks() throws Exception{
        CheckExtrasSectionHyperLinks();
    }

    @Test
    public void checkAffiliateHyperLinkWhileLogin() throws Exception{
        LoginPageComp loginPageComp = new LoginPageComp();
        loginPageComp.CheckLoginPageOpened();
        loginPageComp.CheckIfUserLoginWithValidData();
        CheckAffiliateHyperLinkWhileLogin();
    }

    @Test
    public void checkMyAccountSectionHyperLinksWhileNoLogin() throws Exception {
        CheckMyAccountSectionHyperLinksWhileNoLogin();
    }

    @Test
    public void checkMyAccountSectionHyperLinksWhileLogin() throws Exception {
        LoginPageComp loginPageComp = new LoginPageComp();
        loginPageComp.CheckLoginPageOpened();
        loginPageComp.CheckIfUserLoginWithValidData();
        CheckMyAccountSectionHyperLinksWhileLogin();
    }

    @Test
    public void checkWhenClickOnOpenCartDirectedToMainWebsite() throws Exception{
        CheckWhenClickOnOpenCartDirectedToMainWebsite();
    }

    @AfterMethod
    public void Close(ITestResult result) throws Exception {
        closeDriver(result);
    }
}
