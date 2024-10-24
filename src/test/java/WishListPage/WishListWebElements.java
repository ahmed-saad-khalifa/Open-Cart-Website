package WishListPage;

import Utility.FindingElements;
import org.openqa.selenium.WebElement;

public class WishListWebElements extends FindingElements {
    public WebElement GetWishlistContainer(){return findElementById("account-wishlist"); }
    public WebElement GetContinueBtn(){return findElementByLinkText("Continue"); }

    public WebElement GetMacBookImage(){return findElementByXPath("//img[@src=\"https://tutorialsninja.com/demo/image/cache/catalog/demo/macbook_1-47x47.jpg\"]");}
    public WebElement GetMacBookHyperLink(){return findElementByXPath("/html/body/div[2]/div/div/div[1]/table/tbody/tr[9]/td[2]/a");}


}
