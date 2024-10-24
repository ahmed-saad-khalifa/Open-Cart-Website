package ShoppingCartPage;

import Utility.FindingElements;
import org.openqa.selenium.WebElement;

public class ShoppingCartWebElements extends FindingElements {
    public WebElement GetContainer(){return findElementById("checkout-cart");}

    public WebElement GetMacBookRemoveBtn(){return findElementByXPath("/html/body/div[2]/div[2]/div/form/div/table/tbody/tr[1]/td[4]/div/span/button[2]");}
    public WebElement GetMacBookUpdateField(){return findElementByXPath("/html/body/div[2]/div[2]/div/form/div/table/tbody/tr/td[4]/div/input");}

    public WebElement GetMacBookUpdateBtn(){return findElementByXPath("//button[@data-original-title=\"Update\"]");}

}
