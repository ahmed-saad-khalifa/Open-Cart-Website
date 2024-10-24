package RegisterPage;

import Utility.FindingElements;
import org.openqa.selenium.WebElement;



public class RegisterPageWebElements extends FindingElements {
    //Get Register Page Container
    public WebElement GetRegisterPageContainer() {return findElementById("account-register");}

    // Get FirstName field
    public WebElement GetFirstName() {return findElementById("input-firstname");}

    // Get LastName field
    public WebElement GetLastName()  {return findElementById("input-lastname");}

    // Get Email field
    public WebElement GetEmail() {return findElementById("input-email");
    }

    // Get Telephone field
    public WebElement GetTelephone()  {return findElementById("input-telephone");}

    // Get Password field
    public WebElement GetPassword()  {return findElementById("input-password");}

    // Get Password Confirm field
    public WebElement GetPasswordConfirm()  {return findElementById("input-confirm");}

    //  Get Continue Button Container
    public WebElement GetContinueButton() {return findElementByXPath("//input[@value='Continue']");}

    //Get My Account Drop Down Arrow
    public WebElement GetMyAccountDropDownList() {return findElementByClassName("caret");}

    //Get Login Page Icon Page From Drop Down List
    public WebElement GetRegisterIcon() {return findElementByXPath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a");}

    //  Get PrivacyPolicy CheckBox Container
    public WebElement GetPrivacyPolicyCheckBox() {return findElementByXPath("//input[@type='checkbox']");}

    //Get Error Message Container
    public WebElement GetGetErrorMessageContainer() {return findElementByClassName("alert-danger");}



}
