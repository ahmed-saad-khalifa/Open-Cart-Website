package NewsletterPage;

import Utility.FindingElements;
import org.openqa.selenium.WebElement;

public class NewsletterPageWebElements extends FindingElements {

      public WebElement GetNewsletterContainer(){return findElementById("account-newsletter");}
      public WebElement GetContinueBtn(){return findElementByXPath("//input[@value='Continue']");}
      public WebElement GetBackBtn() {return findElementByXPath("//a[text()='Back']");}
      public WebElement GetTitle(){return findElementByTagName("h1");}
      public WebElement GetYesBtn(){return findElementByXPath("//input[@value='1']");}
      public WebElement GetNoBtn(){return findElementByXPath("//input[@value='0']");}
}
