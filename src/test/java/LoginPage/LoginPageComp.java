package LoginPage;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LoginPageComp extends LoginPageWebElements {

    public void CheckLoginPageOpened() {
        logger.debug("check Login page opened");
        WebElement MyAccountDropDownList = GetMyAccountDropDownList();
        MyAccountDropDownList.click();
        WebElement LoginIcon = GetLoginIcon();
        LoginIcon.click();

        //check URL
        String url=driver.getCurrentUrl();
        checkIfEqual(url, "https://tutorialsninja.com/demo/index.php?route=account/login");

        //CHECK TITLE
        String TITLE = driver.getTitle();
        checkIfEqual(TITLE, "Account Login");
        System.out.println("the Title of the Website is : " +TITLE);

        //CHECK CONTAINER
        WebElement Contianer = LoginPageContainer();
        checkIfNotNull(Contianer,"Container is not found " );
    }


    public void CheckLoginButton () {
        logger.debug(" Check If Login Btn is Enable");
        //Check Login Button
        WebElement LoginButton = GetLoginButton();
        CheckIfButtonIsEnable (LoginButton,"LoginBtn");
    }

    public void CheckContinueButton () {
        logger.debug(" Check If Continue Btn is Enable");
        //Check Continue Button
        WebElement ContinueButton = GetContinueButton();
        CheckIfButtonIsEnable (ContinueButton,"ContinueBtn");
        checkIfEqual(driver.getCurrentUrl(),"https://tutorialsninja.com/demo/index.php?route=account/register");
    }

    public void CheckIfUserLoginWithValidData()  {
        logger.debug("Check If User Entered With Valid Data");
        //ENTER VALID E-MAIL
        WebElement EmailField = GetEmailField();
        checkIfNotNull( EmailField,"Email Field is not found");
        EmailField.sendKeys("ahmedhossam3@gmail.com");

        //ENTER VALID PASSWORD
        WebElement PasswordField = GetPasswordField();
        checkIfNotNull(PasswordField,"Password Field is not found");
        PasswordField.sendKeys("ahmed1234");

        // CLICK ON LOGIN BUTTON
        WebElement LoginButton = GetLoginButton();
        LoginButton.click();

        //CHECK IF USER LOGGED IN Successfully
        checkIfEqual(driver.getCurrentUrl(),"https://tutorialsninja.com/demo/index.php?route=account/account");

    }


    public void CheckIfUserLoginWithINValidData()  {
        logger.debug("Check If User Entered With INValid Data");
        //ENTER INVALID E-MAIL
        WebElement EmailField = GetEmailField();
        checkIfNotNull( EmailField,"Email Field is not found");
        EmailField.sendKeys("ahmed@gmail.com");

        //ENTER INVALID PASSWORD
        WebElement PasswordField = GetPasswordField();
        checkIfNotNull(PasswordField,"Password Field is not found");
        PasswordField.sendKeys("8888888");

        // CLICK ON LOGIN BUTTON
        WebElement LoginButton = GetLoginButton();
        LoginButton.click();

        //CHECK IF USER LOGGED IN Successfully
        checkIfEqual(driver.getCurrentUrl(),"https://tutorialsninja.com/demo/index.php?route=account/account");


    }
    public void CheckLoginWithJavaFaker()  {
        logger.debug("Checking Login With Java Faker");

        Faker faker = new Faker();

        String randomEmail = faker.internet().emailAddress();
        String randomPassword = faker.internet().password();
        //SEND FAKE EMAIL
        WebElement EmailField = GetEmailField();
        checkIfNotNull( EmailField,"Email Field is not found");
        EmailField.sendKeys(randomEmail);
        logger.info("Email: " + randomEmail);

        //SEND FAKE PASSWORD
        WebElement PasswordField = GetPasswordField();
        checkIfNotNull(PasswordField,"Password Field is not found");
        PasswordField.sendKeys(randomPassword);
        logger.info("Password: " + randomPassword);

        // CLICK ON LOGIN BUTTON
        WebElement LoginButton = GetLoginButton();
        explicitlyWaitForClickability(LoginButton);
        LoginButton.click();


    }
    public void CheckIfErrorMessageAppears() throws IOException {
        WebElement Errormessage = GetGetErrorMessageContainer();
        checkIfNotNull(Errormessage,"Error Message Container is Not Found");
        String ErrorMessageText =Errormessage.getText();
        System.out.println(ErrorMessageText);
        checkIfEqual(ErrorMessageText, "Warning: No match for E-Mail Address and/or Password.");
        checkIfContain(ErrorMessageText,"E-Mail");
        checkIfContain(ErrorMessageText,"Password");
        String Color=GetGetErrorMessageContainer().getCssValue("color");
        System.out.println("Color is: "+Color);

    }
}
