package WishListPage;

import org.openqa.selenium.WebElement;


public class WishListComp extends WishListWebElements{
    public void CheckContainer() throws Exception{
        WebElement container = GetWishlistContainer();
        checkIfNotNull(container, "Wish List page container");
    }
    public void CheckContinueButtonDirectsToMyAccountPage() throws Exception{
        WebElement ContinueBtn = GetContinueBtn();
        CheckIfButtonIsEnable(ContinueBtn, "Continue Button");
        ContinueBtn.click();
        checkIfEqual(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=account/account");
    }

    public void CheckTheClickOnProductImageDirectsToItsPage() throws Exception{
        WebElement productImg = GetMacBookImage();
        CheckIfTextIsDiplayed(productImg,"MacBook image");

        productImg.click();
        checkIfEqual(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=product/product&product_id=43");
    }

    public void CheckTheClickOnProductHyperLinkDirectsToItsPage() throws Exception{
        WebElement productHL = GetMacBookHyperLink();
        CheckIfTextIsDiplayed(productHL,"MacBook HyperLink");


        productHL.click();
        checkIfEqual(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=product/product&product_id=43");
    }


}
