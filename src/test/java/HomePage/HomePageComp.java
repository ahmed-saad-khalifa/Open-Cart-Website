package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;



public class HomePageComp extends HomePageWebElements {

    public void CheckHomePageOpened() {
        logger.debug("check Home page opened");
        //check URL
        String url = driver.getCurrentUrl();
        checkIfEqual(url, "https://tutorialsninja.com/demo/");
    }


    public void CheckProductImage() {
        logger.debug("Check Product image");
        boolean ProductImage = GetProductImage().isDisplayed();
        System.out.println("product image " + ProductImage);
    }

    public void CheckProductNameColor() {
        logger.debug("Check Product name color");
        String Color = GetProductName().getCssValue("Color");
        System.out.println("Color is: " + Color);
    }

    public void CheckProductinfo() {
        logger.debug("Check product info");
        String ProductInfo = GetProductContentContainer().getText();
        System.out.println(ProductInfo);
    }

    public void ClickOnAddToCartButton() {
        logger.debug("Click Add to cart button");
        WebElement AddToCart = GetAddToCartButton();
        explicitlyWaitForVisibility(AddToCart);
        //move to add to cart btn
        Actions action = new Actions(driver);
        action.moveToElement(AddToCart).perform();
        //check if add to cart btn is enabled
        CheckIfButtonIsEnable(AddToCart, "Add To Cart Button");
        AddToCart.click();
    }

    public void CheckAlertOnCilickingOnAddTOCartBtn() {
        logger.debug("Check Add to cart button Alert");
        WebElement AddToCart = GetAddToCartButton();
        explicitlyWaitForVisibility(AddToCart);
        //Click on add to cart btn
        Actions action = new Actions(driver);
        action.moveToElement(AddToCart).perform();
        AddToCart.click();
        //check alert is appeared

        String alertText = GetAlert().getText();
//        Alert alert = driver.switchTo().alert();
//        explicitlyWaitForVisibility((WebElement) alert);
//        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
        explicitlyWaitForVisibility(GetAlert());
        checkIfEqual(alertText,"Success");
    }

    public void CheckCartIconNumberUpdates() throws InterruptedException {
        logger.debug("Check Cart Icon Number Updates");
        WebElement AddToCart = GetAddToCartButton();
        explicitlyWaitForVisibility(AddToCart);
        //Click on add to cart btn
        Actions action = new Actions(driver);
        action.moveToElement(AddToCart).perform();
        AddToCart.click();
        //check cart icon number
        WebElement CartIcon = GetHeaderCartIcon();
        action.moveToElement(CartIcon).perform();
        Thread.sleep(1000);
        String CartNumber = GetHeaderCartIcon().getText();
        System.out.println(CartNumber);
        checkIfContain(CartNumber, "1");

    }

    public void ClickOnAddToWishListButton() {
        logger.debug("Click Add to Wish list button");
        WebElement AddToWishList = GetAddToWishListButton();
        explicitlyWaitForVisibility(AddToWishList);
        //move to add to wish list btn
        Actions action = new Actions(driver);
        action.moveToElement(AddToWishList).perform();
        //check if he btn is enabled
        CheckIfButtonIsEnable(AddToWishList, "Add To Wish List Button");
        AddToWishList.click();
    }

    public void CheckAlertOnCilickingOnAddToWishListBtn() {
        logger.debug("Check Wish list button Alert");

        WebElement AddToWishList = GetAddToWishListButton();
        explicitlyWaitForVisibility(AddToWishList);
        //Click on add to wish list btn
        Actions action = new Actions(driver);
        action.moveToElement(AddToWishList).perform();
        AddToWishList.click();
        //check alert appeared
        String alertText = GetAlert().getText();
//        Alert alert = driver.switchTo().alert();
//        explicitlyWaitForVisibility((WebElement) alert);
//        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
    }

    public void CheckWishListIconNumberUpdates() throws InterruptedException {
        logger.debug("Check Wish List Icon Number Updates");

        WebElement AddToWishList = GetAddToWishListButton();
        explicitlyWaitForVisibility(AddToWishList);
        // Click on add to wish list btn
        Actions action = new Actions(driver);
        action.moveToElement(AddToWishList).perform();
        CheckIfButtonIsEnable(AddToWishList, "Add To Wish List Button");
        AddToWishList.click();
        //check wish list icon number
        WebElement WishListIcon = GetHeaderWishListIcon();
        Thread.sleep(1000);
        String WishListNumber = GetHeaderWishListIcon().getText();
        System.out.println(WishListNumber);
        checkIfContain(WishListNumber, "1");

    }

    public void ClickOnCompareThisProductButton() {
        //Check Compare this product button is clicked
        logger.debug("Click Compare this product button");
        WebElement CompareThisProduct = GetCompareThisProductButton();
        //move to add to Compare this product btn
        Actions action = new Actions(driver);
        action.moveToElement(CompareThisProduct).perform();
        //Check if Compare this product btn is enabled
        CheckIfButtonIsEnable(CompareThisProduct, "Compare This Product Button");
        CompareThisProduct.click();

    }

    public void CheckAlertOnCilickingOnCompareThisProductBtn() {
        logger.debug("Check Compare this product button Alert");

        WebElement CompareThisProduct = GetCompareThisProductButton();
        //move to add to Compare this product btn
        Actions action = new Actions(driver);
        action.moveToElement(CompareThisProduct).perform();
        //Click on Compare this product btn is enabled
        CompareThisProduct.click();
        //check alert appeared
        String alertText = GetAlert().getText();
//        Alert alert = driver.switchTo().alert();
//        explicitlyWaitForVisibility((WebElement) alert);
//        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
    }

    public void ClickImageSliderNextButton() {
        logger.debug("Click Image Slider Next button");
        //get slider container
        WebElement SliderContainer = GetSliderContainer();
        List<WebElement> slides = SliderContainer.findElements(By.cssSelector(".swiper-slide"));
        //get current image Name
        WebElement CurrentImage = slides.get(0).findElement(By.className("img-responsive"));
        String CurrentImageName = CurrentImage.getAttribute("alt");
        System.out.println(CurrentImageName);
        //move to slider button and click on it
        WebElement SliderButton = GetSliderNextButton();
        Actions action = new Actions(driver);
        action.moveToElement(SliderButton).perform();
        CheckIfButtonIsEnable(SliderButton, "Slider Button");
        SliderButton.click();
        //get next image Name
        WebElement NextImage = slides.get(1).findElement(By.className("img-responsive"));
        String NextImageName = NextImage.getAttribute("alt");
        System.out.println(NextImageName);
        CheckIfNotequals(CurrentImageName, NextImageName);
    }


    public void ClickImageSliderPreviousButton() {
        logger.debug("Click Image Slider Previous button");
        //get slider container
        WebElement SliderContainer = GetSliderContainer();
        List<WebElement> slides = SliderContainer.findElements(By.cssSelector(".swiper-slide"));
        //get current image Name
        WebElement CurrentImage = slides.get(0).findElement(By.className("img-responsive"));
        String CurrentImageName = CurrentImage.getAttribute("alt");
        System.out.println(CurrentImageName);
        //move to slider button and click on it
        WebElement SliderButton = GetSliderPreviousButton();
        Actions action = new Actions(driver);
        action.moveToElement(SliderButton).perform();
        CheckIfButtonIsEnable(SliderButton, "Slider Button");
        SliderButton.click();
        //get next image Name
        WebElement NextImage = slides.get(1).findElement(By.className("img-responsive"));
        String NextImageName = NextImage.getAttribute("alt");
        System.out.println(NextImageName);
        CheckIfNotequals(CurrentImageName, NextImageName);

    }

public void CheckLogoImagesDisplayInBottomSlider(){

    logger.debug("Check Logo Images Display In Bottom Slider");
    //get slider container
    WebElement BottomSliderContainer = GetBottomSliderContainer();
    List<WebElement> slides = BottomSliderContainer.findElements(By.cssSelector(".swiper-slide"));
    //get current image Name
    int i=0;
    for(WebElement CurrentImage:slides){

        WebElement Image = slides.get(i).findElement(By.className("img-responsive"));
        String CurrentImageName = Image.getAttribute("alt");
        System.out.println(CurrentImageName);
        //move to slider button and click on it
        WebElement SliderButton = GetSliderPreviousButton();
        Actions action = new Actions(driver);
        action.moveToElement(SliderButton).perform();
        CheckIfButtonIsEnable(SliderButton, "Slider Button");
        SliderButton.click();
        i++;

    }



}



}
