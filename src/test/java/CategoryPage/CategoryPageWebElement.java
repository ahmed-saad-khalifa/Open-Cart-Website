package CategoryPage;

import Utility.FindingElements;
import org.openqa.selenium.WebElement;

public class CategoryPageWebElement extends FindingElements {
    public WebElement GetCategoryPageContainer() {
        return findElementById("product-category");
    }
    public WebElement GetCategoryContentContainer() {return findElementById("content");}

    public WebElement GetProductList() {
        return findElementByClassName("product-layout");
    }

    public WebElement GetProductThumbnail() {
        return findElementByClassName("image");
    }

    public WebElement GetProductsTitle() {
        return findElementByTagName("h4");
    }
    public WebElement GetProductTitle() {
        return findElementByTagName("h2");
    }
    public WebElement GetProductPrice() {
        return findElementByClassName("price");
    }

    public WebElement GetAddToCartButton() {
        return findElementByXPath("//button[contains(@onclick, 'cart.add')]");
    }

    public WebElement GetAddToWishListButton() {
        return findElementByXPath("//button[contains(@onclick, 'wishlist.add')]");
    }

    public WebElement GetCompareProductButton() {
        return findElementByXPath("//button[contains(@onclick, 'compare.add')]");
    }

    public WebElement GetSortDropdown() {
        return findElementById("input-sort");
    }

    public WebElement GetShowLimitDropdown() {
        return findElementById("input-limit");
    }

    public WebElement GetPagination() {
        return findElementByClassName("text-right");
    }

    public WebElement GetBreadcrumbs() {
        return findElementByClassName("breadcrumb");
    }

    public WebElement GetCategoryTitle() {
        return findElementByTagName("h2");
    }

    public WebElement GetAlertMessage() {
        return findElementByClassName("alert");
    }
}
