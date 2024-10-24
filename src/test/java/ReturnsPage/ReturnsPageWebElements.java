package ReturnsPage;

import Utility.FindingElements;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ReturnsPageWebElements extends FindingElements {

    public WebElement GetReturnsContainer(){return findElementById("account-return");}
    public WebElement GetReturnsTitle(){return findElementByTagName("h1");}
    public WebElement GetSubmitBtn(){return findElementByXPath("//input[@value='Submit']");}
    public WebElement GetBackBtn(){return findElementByXPath("//a[contains(text(),'Back')]");}
    public WebElement GetOrderID(){return findElementById("input-order-id");}
    public WebElement GetOrderDate(){return findElementById("input-date-ordered");}
    public WebElement GetProductName(){return findElementById("input-product");}
    public WebElement GetProductCode(){return findElementById("input-model");}
    public WebElement GetFaulty(){return findElementById("input-comment");}
    public WebElement GetYesBtn(){return findElementByXPath("//input[@value='1']");}
    public WebElement GetReasonForReturn(){return findElementByXPath("//input[@value='4']");}
    public WebElement GetErrorMessageContainer(){return findElementByClassName("text-danger");}
    public WebElement GetFirstName(){return findElementById("input-firstname");}


   }
