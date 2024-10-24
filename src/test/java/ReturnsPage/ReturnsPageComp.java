package ReturnsPage;

import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ReturnsPageComp extends ReturnsPageWebElements {

    public void CheckReturnsPageOpened(){
        logger.debug("Check Returns page opened");
        // URL
        String url=driver.getCurrentUrl();
        checkIfEqual(url, "https://tutorialsninja.com/demo/index.php?route=account/return/add");
        //Container
        WebElement ReturnsContainer = GetReturnsContainer();
        checkIfNotNull(ReturnsContainer,"Returns Container");
//        // Title
//        WebElement ReturnsTitle = GetReturnsTitle();
//        CheckIfTextIsDiplayed(ReturnsTitle, "Page Title");
//        String Title = ReturnsTitle.getText();
//        checkIfEqual(Title, "Product Returns");
//        System.out.println("the Title of the page is : " +Title);

    }

    public void ClickBackBtn() {
        logger.debug("Click Back Btn");
        WebElement BackBtn = GetBackBtn();
        checkIfNotNull(BackBtn, "Back Btn");

        // Check if Continue Btn is clickable
        CheckIfButtonIsEnable(BackBtn, "Back Btn");
        BackBtn.click();

        String BackURL = driver.getCurrentUrl();
        checkIfEqual(BackURL, "https://tutorialsninja.com/demo/index.php?route=account/account");
    }

    public void CheckUserEnteredValidData(){
        logger.debug("Check User entered valid data");

        fillField(GetOrderID(), getConfigValue("config", "orderID"));
        fillField(GetOrderDate(), getConfigValue("config", "orderDate"));
        fillField(GetProductName(), getConfigValue("config", "productName"));
        fillField(GetProductCode(), getConfigValue("config", "productCode"));
        fillField(GetFaulty(), getConfigValue("config", "faulty"));

        WebElement yesBtn = GetYesBtn();
        checkIfNotNull(yesBtn, "Yes Button");
        CheckIfButtonIsEnable(yesBtn, "Yes Button");
        yesBtn.click();
        WebElement reasonRadioButton = GetReasonForReturn();
        reasonRadioButton.click();

        WebElement SubmitBtn = GetSubmitBtn();
        checkIfNotNull(SubmitBtn, "Submit Btn");
        CheckIfButtonIsEnable(SubmitBtn, "Submit Btn");
        SubmitBtn.click();
        String SubmitURL = driver.getCurrentUrl();
        checkIfEqual(SubmitURL,"https://tutorialsninja.com/demo/index.php?route=account/return/success");
    }

    public void CheckIfUserEntersInvalidData() {
        logger.debug("Check User entered Invalid data");
        fillField(GetFirstName(), getConfigValue("config", "invalidFirstName"));
        fillField(GetOrderID(), getConfigValue("config", "orderID"));
        fillField(GetOrderDate(), getConfigValue("config", "orderDate"));
        fillField(GetProductName(), getConfigValue("config", "productName"));
        fillField(GetProductCode(), getConfigValue("config", "productCode"));
        fillField(GetFaulty(), getConfigValue("config", "faulty"));

        WebElement yesBtn = GetYesBtn();
        checkIfNotNull(yesBtn, "Yes Button");
        CheckIfButtonIsEnable(yesBtn, "Yes Button");
        yesBtn.click();
        WebElement reasonRadioButton = GetReasonForReturn();
        reasonRadioButton.click();

        WebElement SubmitBtn = GetSubmitBtn();
        checkIfNotNull(SubmitBtn, "Submit Btn");
        CheckIfButtonIsEnable(SubmitBtn, "Submit Btn");
        SubmitBtn.click();
        String SubmitURL = driver.getCurrentUrl();
        checkIfEqual(SubmitURL,"https://tutorialsninja.com/demo/index.php?route=account/return/add");
    }

    public void CheckIfErrorMessageAppears() throws IOException {
        WebElement Errormessage = GetErrorMessageContainer();
        checkIfNotNull(Errormessage,"Error Message Container is Not Found");
        String ErrorMessageText =Errormessage.getText();
        System.out.println(ErrorMessageText);
        checkIfEqual(ErrorMessageText, "Order ID required!");
        String Color=GetErrorMessageContainer().getCssValue("color");
        System.out.println("Color is: "+Color);

    }
    private void fillField(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
        String enteredValue = field.getAttribute("value");
        checkIfEqual(enteredValue, value);
    }

//    // Submit
//    public void ClickSubmitBtn() {
//        logger.debug("Click Submit Btn");
//        WebElement SubmitBtn = GetSubmitBtn();
//        checkIfNotNull(SubmitBtn, "Submit Btn");
//
//        // Check if Submit Btn is clickable
//        CheckIfButtonIsEnable(SubmitBtn, "Submit Btn");
//        SubmitBtn.click();
//
//        String SubmitURL = driver.getCurrentUrl();
//        checkIfEqual(SubmitURL, "https://tutorialsninja.com/demo/index.php?route=account/return/success");
//    }
    }
