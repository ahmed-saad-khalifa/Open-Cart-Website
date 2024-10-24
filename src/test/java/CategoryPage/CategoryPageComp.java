package CategoryPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CategoryPageComp extends CategoryPageWebElement{

    public void CheckCategoryPageOpened() {
        logger.debug("Check Category Page opened");
        //URL
        String url=driver.getCurrentUrl();
        checkIfEqual(url,getConfigValue("config", "category"));

        //Title
        String TitleProduct=GetProductTitle().getText();
        checkIfEqual(TitleProduct,"Desktops");
    }

    public void CheckProductListDisplayed() {
        logger.debug("Check Product List displayed");
        boolean isDisplayed = GetProductList().isDisplayed();
        System.out.println("Product list is displayed: " + isDisplayed);
    }

    public void ClickOnAddToCartButton() {
        logger.debug("Click Add to Cart button for a product");
        WebElement addToCartButton = GetAddToCartButton();
        explicitlyWaitForVisibility(addToCartButton);
        Actions action = new Actions(driver);
        action.moveToElement(addToCartButton).perform();
        CheckIfButtonIsEnable(addToCartButton, "Add To Cart Button");
        addToCartButton.click();
    }

    public void CheckAlertOnClickingAddToCart() {
        logger.debug("Check alert message after clicking Add to Cart");
        ClickOnAddToCartButton();
        String alertText = GetAlertMessage().getText();
        System.out.println("Alert text: " + alertText);
    }

    public void CheckAddToWishListButton() {
        logger.debug("Click Add to Wish List button");
        WebElement addToWishListButton = GetAddToWishListButton();
        explicitlyWaitForVisibility(addToWishListButton);
        Actions action = new Actions(driver);
        action.moveToElement(addToWishListButton).perform();
        CheckIfButtonIsEnable(addToWishListButton, "Add To Wish List Button");
        addToWishListButton.click();
    }

    public void CheckAlertOnClickingAddToWishList() {
        logger.debug("Check alert message after clicking Add to Wish List");
        CheckAddToWishListButton();
        String alertText = GetAlertMessage().getText();
        System.out.println("Alert text: " + alertText);
    }

    public void ClickCompareProductButton() {
        logger.debug("Click Compare Product button");
        WebElement compareButton = GetCompareProductButton();
        Actions action = new Actions(driver);
        action.moveToElement(compareButton).perform();
        CheckIfButtonIsEnable(compareButton, "Compare Product Button");
        compareButton.click();
    }

    public void CheckAlertOnClickingCompareProduct() {
        logger.debug("Check alert message after clicking Compare Product");
        ClickCompareProductButton();
        String alertText = GetAlertMessage().getText();
        System.out.println("Alert text: " + alertText);
    }

    public void CheckPaginationDisplayed() {
        logger.debug("Check Pagination is displayed");
        boolean isDisplayed = GetPagination().isDisplayed();
        System.out.println("Pagination is displayed: " + isDisplayed);
    }

//    public void SelectSortOption(String optionText) {
//        logger.debug("Select sorting option: " + optionText);
//        WebElement sortDropdown = GetSortDropdown();
//        sortDropdown.click();
//        sortDropdown.findElement(By.xpath("//option[text()='" + optionText + "']")).click();
//    }
//
//    public void SelectShowLimitOption(String limit) {
//        logger.debug("Select Show Limit option: " + limit);
//        WebElement showLimitDropdown = GetShowLimitDropdown();
//        showLimitDropdown.click();
//        showLimitDropdown.findElement(By.xpath("//option[text()='" + limit + "']")).click();
//    }

    public void CheckCategoryTitle(String expectedTitle) {
        logger.debug("Check category title");
        String actualTitle = GetCategoryTitle().getText();
        checkIfEqual(actualTitle, expectedTitle);
    }

    public void ClickProductThumbnail() {
        logger.debug("Click on Product Thumbnail");
        WebElement productThumbnail = GetProductThumbnail();
        productThumbnail.click();
    }

    public void CheckProductPriceDisplayed() {
        logger.debug("Check Product Price displayed.");
        boolean isDisplayed = GetProductPrice().isDisplayed();
        System.out.println("Product price is displayed: " + isDisplayed);
    }
}
