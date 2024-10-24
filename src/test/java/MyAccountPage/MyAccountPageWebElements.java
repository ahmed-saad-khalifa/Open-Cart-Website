package MyAccountPage;

import Utility.FindingElements;
import org.openqa.selenium.WebElement;

public class MyAccountPageWebElements extends FindingElements {

    public WebElement GetMyAccountTitle(){return findElementByXPath("//h2[text()='My Account']");}
    public WebElement GetEditYourAccountInformationBtn(){return findElementByLinkText("Edit your account information");}
    public WebElement GetChangeYourPasswordBtn(){return findElementByLinkText("Change your password");}


}






