package RegisterPage;

import org.openqa.selenium.WebElement;

import java.io.IOException;

public class RegisterPageComp extends RegisterPageWebElements{
    public void CheckRegisterPageOpened() {
        logger.debug("check Register page opened");
        WebElement MyAccountDropDownList = GetMyAccountDropDownList();
        MyAccountDropDownList.click();
        WebElement LoginIcon = GetRegisterIcon();
        LoginIcon.click();

        //check URL
        String url=driver.getCurrentUrl();
        checkIfEqual(url, "https://tutorialsninja.com/demo/index.php?route=account/register");

        //CHECK TITLE
        String TITLE = driver.getTitle();
        checkIfEqual(TITLE, "Register Account");
        System.out.println("the Title of the Website is : " +TITLE);

        //CHECK CONTAINER
        WebElement Contianer = GetRegisterPageContainer();
        checkIfNotNull(Contianer,"Container is not found " );
    }


    public void CheckIfUserRegisteredWithValidData()  {
        logger.debug("Check If User Registered With Valid Data");
        //ENTER VALID First Name
        WebElement FirstNameField = GetFirstName();
        checkIfNotNull( FirstNameField,"FirstName Field is not found");
        FirstNameField.sendKeys("ahmed");

        //ENTER VALID Last Name
        WebElement LastNameField = GetLastName();
        checkIfNotNull( LastNameField,"LastName Field is not found");
        LastNameField.sendKeys("hossam");

        //ENTER VALID E-MAIL
        WebElement EmailField = GetEmail();
        checkIfNotNull( EmailField,"Email Field is not found");
        EmailField.sendKeys("ahmedAli12@gmail.com");

        //ENTER VALID Telephone
        WebElement TelephoneField = GetTelephone();
        checkIfNotNull( TelephoneField,"Telephone Field is not found");
        TelephoneField.sendKeys("01212962848");

        //ENTER VALID PASSWORD
        WebElement PasswordField = GetPassword();
        checkIfNotNull(PasswordField,"Password Field is not found");
        String password ="ahmed1234";
        PasswordField.sendKeys(password);

        //ENTER VALID PASSWORD
        WebElement ConfirmPasswordField = GetPasswordConfirm();
        checkIfNotNull(ConfirmPasswordField,"Password Confirm Field is not found");
        ConfirmPasswordField.sendKeys(password);

        //Click on Privacy Policy Check Box
        WebElement CheckBox =GetPrivacyPolicyCheckBox();
        CheckBox.click();

        // CLICK ON Register BUTTON
        WebElement RegisterButton = GetContinueButton();
        RegisterButton.click();

        //CHECK IF USER LOGGED IN Successfully
        checkIfEqual(driver.getCurrentUrl(),"https://tutorialsninja.com/demo/index.php?route=account/success");

    }




    public void CheckIfUserRegisteredWithSameEmailBefore()  {
        logger.debug("Check If User Registered With Same Email Before");

        //ENTER VALID First Name
        WebElement FirstNameField = GetFirstName();
        checkIfNotNull( FirstNameField,"FirstName Field is not found");
        FirstNameField.sendKeys("ahmed");

        //ENTER VALID Last Name
        WebElement LastNameField = GetLastName();
        checkIfNotNull( LastNameField,"LastName Field is not found");
        LastNameField.sendKeys("hossam");

        //ENTER VALID E-MAIL
        WebElement EmailField = GetEmail();
        checkIfNotNull( EmailField,"Email Field is not found");
        EmailField.sendKeys("ahmedhossam3@gmail.com");

        //ENTER VALID Telephone
        WebElement TelephoneField = GetTelephone();
        checkIfNotNull( TelephoneField,"Telephone Field is not found");
        TelephoneField.sendKeys("01212962848");

        //ENTER VALID PASSWORD
        WebElement PasswordField = GetPassword();
        checkIfNotNull(PasswordField,"Password Field is not found");
        String password ="ahmed1234";
        PasswordField.sendKeys(password);

        //ENTER VALID PASSWORD
        WebElement ConfirmPasswordField = GetPasswordConfirm();
        checkIfNotNull(ConfirmPasswordField,"Password Confirm Field is not found");
        ConfirmPasswordField.sendKeys(password);

        //Click on Privacy Policy Check Box
        WebElement CheckBox =GetPrivacyPolicyCheckBox();
        CheckBox.click();

        // CLICK ON Register BUTTON
        WebElement RegisterButton = GetContinueButton();
        RegisterButton.click();


    }
    public void CheckIfRegisterErrorMessageAppears() {
        WebElement Errormessage = GetGetErrorMessageContainer();
        checkIfNotNull(Errormessage,"Error Message Container is Not Found");
        String ErrorMessageText =Errormessage.getText();
        System.out.println(ErrorMessageText);
        String Color=GetGetErrorMessageContainer().getCssValue("color");
        System.out.println("Color is: "+Color);
    }

    public void CheckContinueButton () {
        logger.debug(" Check If Continue Btn is Enable");
        //Check Continue Button
        WebElement ContinueButton = GetContinueButton();
        CheckIfButtonIsEnable (ContinueButton,"ContinueBtn");
        checkIfEqual(driver.getCurrentUrl(),"https://tutorialsninja.com/demo/index.php?route=account/register");
    }

    public void CheckPrivacyPolicyCheckBox() {
        logger.debug(" Check If PrivacyPolicy CheckBox is Enable");
        //Check PrivacyPolicy CheckBox
        WebElement PrivacyPolicy = GetPrivacyPolicyCheckBox();
        CheckIfButtonIsEnable(PrivacyPolicy, "CheckBox");
    }








}
