package LoginPage_Test;

import LoginPage.LoginPageComp;
import Utility.ScreenRecord;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class LoginPageComp_Test extends LoginPageComp {

    @BeforeMethod
    public void OpenHomePage(ITestResult result) throws Exception {
        SetupTheDriver(result);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
    }

    @Test(priority = 1)
    public void CheckIfLoginPageOpened() {
        CheckLoginPageOpened();
    }

    @Test(priority = 2)
    public void CheckIfUserLoggedinWithValidData () throws IOException {
        CheckLoginPageOpened();
        CheckIfUserLoginWithValidData();
    }

    @Test(priority = 3)
    public void CheckIfUserLoggedinWithINValidData () throws IOException {
        CheckLoginPageOpened();
        CheckIfUserLoginWithINValidData();
    }

    @Test(priority = 4)
    public void TestLoginWithFakeData() throws IOException {
        CheckLoginPageOpened();
        CheckLoginWithJavaFaker();
        CheckIfErrorMessageAppears();

    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws Exception {
        closeDriver(result);
        ScreenRecord.stopRecording();
        Thread.sleep(2000);
        driver.quit();

    }
}
