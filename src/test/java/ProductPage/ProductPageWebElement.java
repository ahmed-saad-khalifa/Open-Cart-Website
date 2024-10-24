package ProductPage;

import Utility.FindingElements;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPageWebElement extends FindingElements {

    public WebElement getProductTitle(){return findElementByXPath("//*[@id=\"content\"]/div/div[2]/h1");}
    public WebElement getPriceElement(){return findElementByXPath("//*[@id=\"content\"]/div/div[2]/ul[2]/li[1]");}
    public WebElement getRewardElement(){return findElementByXPath("//*[@id=\"content\"]/div/div[2]/ul[2]/li[3]");}

    public WebElement getQuantityField(){return findElementById("input-quantity");}
    public WebElement getAddToCartBtn(){return findElementById("button-cart");}

    public WebElement getSuccessMessage(){return findElementByClassName("alert-success");}


    public List<WebElement> getProductDetails(){return findElementsByXpath("//*[@id='content']/div/div[2]/ul[1]/li");}
}
