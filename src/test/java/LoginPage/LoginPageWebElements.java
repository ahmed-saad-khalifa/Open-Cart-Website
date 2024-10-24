package LoginPage;


import org.openqa.selenium.WebElement;
import Utility.FindingElements;

public class LoginPageWebElements extends FindingElements {
    //Get Login Page Container
    public WebElement LoginPageContainer() {return findElementById("account-login");}

    // Get Email field
    public WebElement GetEmailField() {return findElementById("input-email");}

    // Get Password field
    public WebElement GetPasswordField() {return findElementById("input-password");}

    //  Get Login Button Container
    public WebElement GetLoginButton() {return findElementByXPath("//input[@value='Login']");}

    //  Get CONTINUE Container
    public WebElement GetContinueButton() {return findElementByXPath("//*[@id=\"content\"]/div/div[1]/div/a]");}

    //Get My Account Drop Down Arrow
    public WebElement GetMyAccountDropDownList() {return findElementByClassName("caret");}

    //Get Login Page Icon Page From Drop Down List
    public WebElement GetLoginIcon() {return findElementByXPath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");}

    //Get Error Message Container
    public WebElement GetGetErrorMessageContainer() {return findElementByClassName("alert-danger");}



}


