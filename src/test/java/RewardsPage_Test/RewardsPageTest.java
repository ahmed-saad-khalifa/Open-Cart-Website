package RewardsPage_Test;

import LoginPage_Test.LoginPageComp_Test;
import RewardsPage.RewardsPageComp;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RewardsPageTest extends RewardsPageComp {
    @BeforeMethod(alwaysRun = true)
    public void openBrowser(ITestResult result) throws Exception {
        SetupTheDriver(result);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        LoginPageComp_Test loginPageCompTest = new LoginPageComp_Test();
        loginPageCompTest.CheckIfUserLoggedinWithValidData();
        driver.navigate().to(getConfigValue("config","rewardUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(ITestResult result) throws Exception {
        closeDriver(result);
    }

    @Test(priority = 1)
    public void checkOpenedRewardPage() {
        checkIfRewardPageOpened();
    }

    @Test(priority = 2)
    public void checkRewardTableDisplayed() {
        checkRewardTable();
    }

    @Test(priority = 3)
    public void checkTotalRewardPoints() {
        checkTotalPoints();
    }

}
