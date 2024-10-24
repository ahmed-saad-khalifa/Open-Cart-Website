package ProductPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPageComp extends ProductPageWebElement{
    public void checkIfProductPageOpened() {
        logger.debug("Verify if the product page is displayed.");

        String url = driver.getCurrentUrl();
        checkIfEqual(url, getConfigValue("config","product"));

        // Check product title
        WebElement productTitle = getProductTitle();
        System.out.println(productTitle.getText());
        checkIfNotNull(productTitle, "Product title");
        CheckIfTextIsDiplayed(productTitle, productTitle.getText());
    }

    public void checkProductDetails() {
        logger.debug("Verify the product details displayed on the product page.");

        // Locate the list containing product details
        List<WebElement> productDetails = getProductDetails();

        // Check the Brand
        WebElement brandElement = productDetails.get(0);
        String brandText = brandElement.getText();
        System.out.println(brandText);
        checkIfContain(brandText, "Brand");

        // Check the Product Code
        WebElement productCodeElement = productDetails.get(1);
        String productCodeText = productCodeElement.getText();
        System.out.println(productCodeText);
        checkIfContain(productCodeText, "Product Code");

        // Check the Reward Points
        WebElement rewardPointsElement = productDetails.get(2);
        String rewardPointsText = rewardPointsElement.getText();
        System.out.println(rewardPointsText);
        checkIfContain(rewardPointsText, "Reward Points");

        // Check Availability
        WebElement availabilityElement = productDetails.get(3);
        String availabilityText = availabilityElement.getText();
        System.out.println(availabilityText);
        checkIfContain(availabilityText, "Availability");
    }

    public void checkProductPrice() {
        logger.debug("Verify if the product price is displayed correctly.");

        WebElement priceElement = getPriceElement();
        checkIfNotNull(priceElement, "Price element");
        String price = priceElement.getText();
        System.out.println(price);
        checkIfContain(price, "$");
    }

    public void checkProductRewardPoints() {
        logger.debug("Verify if the product Reward Points is displayed correctly.");

        WebElement rewardElement = getRewardElement();
        checkIfNotNull(rewardElement, "Price element");
        String reward = rewardElement.getText();
        System.out.println(reward);
        checkIfContain(reward, "reward");

    }

    public void selectProductQuantity(int quantity) {
        logger.debug("Select product quantity.");

        WebElement quantityField = getQuantityField();
        checkIfNotNull(quantityField, "Quantity Field");
        quantityField.clear();
        quantityField.sendKeys(String.valueOf(quantity));
    }

    public void addToCart() {
        logger.debug("Clicking on the 'Add to Cart' button.");

        WebElement addToCartBtn = getAddToCartBtn();
        checkIfNotNull(addToCartBtn, "Add to Cart button");
        addToCartBtn.click();

        // Wait for success message
        WebElement successMessage = getSuccessMessage();
        explicitlyWaitForVisibility(successMessage);
        CheckIfTextIsDiplayed(successMessage, "Success: You have added MacBook to; your shopping cart!");
    }




}
