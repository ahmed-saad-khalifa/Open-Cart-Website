package CheckoutPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckoutPageComp extends CheckoutPageWebElement{

    public void checkIfCheckoutPageOpened(){
        logger.debug("Verify if the checkout complete page is displayed.");

        String url = driver.getCurrentUrl();
        checkIfEqual(url, getConfigValue("config", "checkoutPageUrl"));

        // chcek page title
        WebElement checkoutPageTitle = getcheckoutPageTitle();
        checkIfNotNull(checkoutPageTitle, "Checkout page");
        CheckIfTextIsDiplayed(checkoutPageTitle, "Checkout");
    }

    public void checkIfCheckoutOptions(String option){
        logger.debug("Verify if the checkout options is displayed and can select guest user and continue.");

        List<WebElement> panels = getPanels();
        WebElement firstPanel = panels.get(0);
        WebElement secondPanel = panels.get(1);

        CheckIfTextIsDiplayed(firstPanel, "Step 1: Checkout Options");
        WebElement panelTitle = firstPanel.findElement(By.className("panel-title"));
        String titleText = panelTitle.getText();
        System.out.println(titleText);

        checkIfEqual(titleText, "Step 1: Checkout Options");

        if(option.toLowerCase().equals("register")){
            WebElement registerCheckoutOption = getRegisterCheckoutOption();
            registerCheckoutOption.click();

            // check the title of the header in step 2 if I select register
            panelTitle = secondPanel.findElement(By.className("panel-title"));
            titleText = panelTitle.getText();

            checkIfEqual(titleText, "Step 2: Account & Billing Details");
        }
        else if(option.toLowerCase().equals("guest")){
            WebElement guestCheckoutOption = getGuestCheckoutOption();
            guestCheckoutOption.click();

            // check the title of the header in step 2 if I select guest
            panelTitle = secondPanel.findElement(By.className("panel-title"));
            titleText = panelTitle.getText();

            checkIfEqual(titleText, "Step 2: Billing Details");
        }
        else {
            System.out.println("Invalid option: " + option);
        }

        WebElement continueBtn = getContinueBtn1();
        continueBtn.click();

    }

    public void validateBillingDetails() {
        logger.debug("check that we can fill the inputs sections in the step 2 in checkout page");

        WebElement billingDetailsForm = getBillingDetailsForm();
        explicitlyWaitForVisibility(billingDetailsForm);
        checkIfNotNull(billingDetailsForm, "Billing details form");

        fillAndVerifyField(getFirstNameField(), getConfigValue("config", "firstName"));
        fillAndVerifyField(getLastNameField(), getConfigValue("config", "lastName"));
        fillAndVerifyField(getEmailField(), getConfigValue("config", "email"));
        fillAndVerifyField(getTelephoneField(), getConfigValue("config", "telephone"));
        fillAndVerifyField(getAddress1Field(), getConfigValue("config", "address"));
        fillAndVerifyField(getCityField(), getConfigValue("config", "city"));
        fillAndVerifyField(getPostcodeField(), getConfigValue("config", "postalCode"));

        selectAndVerifyField(getCountryField(), getConfigValue("config", "country"));
        selectAndVerifyField(getZoneField(), getConfigValue("config", "zone"));

        WebElement stepTwoContinueBtn = getContinueBtn2();
        stepTwoContinueBtn.click();
    }

    public void checkIfDeleviryDetailsFilled(){
        logger.debug("check if step 3 delviry details is filled or not if filled compare data if not fill it.");

        WebElement shippingAddressCheckBox = getCheckBox();
        boolean isChecked = shippingAddressCheckBox.isSelected();

        if(isChecked){

            checkIfEqual(getFieldValue(getFirstNameDeliveryField()), getConfigValue("config", "firstName"));
            checkIfEqual(getFieldValue(getLastNameDeliveryField()), getConfigValue("config", "lastName"));
            checkIfEqual(getFieldValue(getAddressDeliveryField()), getConfigValue("config", "address"));
            checkIfEqual(getFieldValue(getCityDeliveryField()), getConfigValue("config", "city"));

        }
        else{
            fillAndVerifyField(getFirstNameDeliveryField(), getConfigValue("config", "firstName"));
            fillAndVerifyField(getLastNameDeliveryField(), getConfigValue("config", "lastName"));
            fillAndVerifyField(getAddressDeliveryField(), getConfigValue("config", "address"));
            fillAndVerifyField(getCityDeliveryField(), getConfigValue("config", "city"));

            selectAndVerifyField(getCountryDropdownInDelviryOptions(), getConfigValue("config", "country"));
            selectAndVerifyField(getZoneDropdownInDelviryOptions(), getConfigValue("config", "zone"));

            WebElement stepThreeContinueBtn = getContinueBtn3();
            stepThreeContinueBtn.click();

        }
    }


    public void checkDeliveryMethod(){
        logger.debug("check if step 4 delviry method is selecting correctly and add comment.");

        WebElement checkpoint = getCheckPoint();

        if (!checkpoint.isSelected()) {
            checkpoint.click();
        }

        boolean isSelected = checkpoint.isSelected();

        WebElement commentField = getCommentField();

        String comment = "This is my order comment.";
        commentField.clear();
        commentField.sendKeys(comment);

        WebElement stepFourContinueBtn = getContinueBtn4();
        stepFourContinueBtn.click();
    }

    public void checkIfSelectingPaymentMethod() {
        logger.debug("check if step 5 payment method is selecting correctly and add comment and agree to terms and conditions.");

        WebElement paymentMethod = getPaymentMethodElement();
        if (!paymentMethod.isSelected()) {
            paymentMethod.click();
        }

        WebElement commentField = getCommentTwoField();

        String comment = "This is my payment comment.";
        commentField.clear();
        commentField.sendKeys(comment);

        // agree terms&conditions
        WebElement agreeCheckBox = getAgreeCheckBox();

        if (!agreeCheckBox.isSelected()) {
            agreeCheckBox.click();
        }

        WebElement continueBtn = getContinueBtn5();
        continueBtn.click();
    }

    public void checkConfirmOrder(){
        logger.debug("check if step 6 confirm order and revise the calculation.");

        // Locate the displayed quantity element
        WebElement displayedQuantityElement = getDisplayedQuantityElement();
        explicitlyWaitForVisibility(displayedQuantityElement);
        String displayedQuantityText = displayedQuantityElement.getText().trim();
        int displayedQuantity = Integer.parseInt(displayedQuantityText);

        // Locate the price element and extract its value
        WebElement priceElement = getPriceElement();
        String priceText = priceElement.getText();
        double price = Double.parseDouble(priceText.replace("$", ""));

        // Calculate the expected total price for the product (price * quantity)
        double expectedTotalPrice = price * displayedQuantity;

        // Locate the displayed total price element
        WebElement displayedTotalPriceElement = getDisplayedTotalPriceElement();
        String displayedTotalPriceText = displayedTotalPriceElement.getText();
        double displayedTotalPrice = Double.parseDouble(displayedTotalPriceText.replace("$", ""));

        // Verify the displayed total price matches the expected total price
        checkIfEqual(displayedTotalPrice, expectedTotalPrice);

        // Print the results for debugging
        System.out.println("Displayed Quantity: " + displayedQuantity);
        System.out.println("Price per Item: $" + price);
        System.out.println("Displayed Total Price: $" + displayedTotalPrice);
        System.out.println("Expected Total Price: $" + expectedTotalPrice);

        // Check the Sub-Total
        WebElement subTotalElement = getSubTotalElement();
        explicitlyWaitForVisibility(subTotalElement);
        String subTotalText = subTotalElement.getText();
        double subTotal = Double.parseDouble(subTotalText.replace("$", ""));

        // Check the Flat Shipping Rate
        WebElement shippingRateElement = getShippingRateElement();
        String shippingRateText = shippingRateElement.getText();
        double shippingRate = Double.parseDouble(shippingRateText.replace("$", ""));

        // Check the Total Amount
        WebElement totalAmountElement = getTotalAmountElement();
        String totalAmountText = totalAmountElement.getText();
        double totalAmount = Double.parseDouble(totalAmountText.replace("$", ""));

        // Calculate the expected total amount (sub-total + shipping rate)
        double expectedTotalAmount = subTotal + shippingRate;

        // Verify the displayed total amount matches the expected total amount
        checkIfEqual(totalAmount, expectedTotalAmount);

        // Print the sub-total, shipping rate, and total amount for debugging
        System.out.println("Sub-Total: $" + subTotal);
        System.out.println("Shipping Rate: $" + shippingRate);
        System.out.println("Displayed Total Amount: $" + totalAmount);
        System.out.println("Expected Total Amount: $" + expectedTotalAmount);

        // Continue to Confirmation
        WebElement confirmOrderBtn = getConfirmOrderBtn();
        confirmOrderBtn.click();

    }


    public void helpFunc(){
        WebElement addToCartBtn = findElementById("button-cart");
        addToCartBtn.click();

        WebElement checkoutBtn = findElementByXPath("//*[@id=\"top-links\"]/ul/li[5]/a/span");
        checkoutBtn.click();
    }

    private void fillAndVerifyField(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
        String enteredValue = field.getAttribute("value");
        checkIfEqual(enteredValue, value);
    }

    private void selectAndVerifyField(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
        WebElement selectedOption = select.getFirstSelectedOption();
        String selectedValue = selectedOption.getText();
        checkIfEqual(selectedValue, value);
    }

    private String getFieldValue(WebElement field) {
        return field.getAttribute("value");
    }



    private void checkIfEqual(double actual, double expected) {
        if (actual != expected) {
            throw new AssertionError("Expected " + expected + " but found " + actual);
        }
    }


}
