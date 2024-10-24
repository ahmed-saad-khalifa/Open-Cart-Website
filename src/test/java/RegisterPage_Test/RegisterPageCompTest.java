package RegisterPage_Test;

import RegisterPage.RegisterPageComp;
import Utility.ScreenRecord;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class RegisterPageCompTest extends RegisterPageComp {

    @BeforeMethod
    public void OpenHomePage(ITestResult result) throws Exception {
        SetupTheDriver(result);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
    }

    @Test(priority = 1)
    public void CheckIfRegisterPageOpened() {
        CheckRegisterPageOpened();
    }
    @Test(priority = 2)
    public void CheckUserRegisteredWithValidData () {
        CheckRegisterPageOpened();
        CheckIfUserRegisteredWithValidData();
    }
    @Test(priority = 2)
    public void CheckUserRegisteredWithSameEmailBefore () {
        CheckRegisterPageOpened();
        CheckIfUserRegisteredWithSameEmailBefore();
        CheckIfRegisterErrorMessageAppears();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws Exception {
        closeDriver(result);
        ScreenRecord.stopRecording();
        Thread.sleep(2000);
        driver.quit();

    }
}
