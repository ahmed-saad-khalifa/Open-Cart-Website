package NewsletterPage;

import org.openqa.selenium.WebElement;

public class NewsletterPageComp extends NewsletterPageWebElements {

    // Page opened
    public void CheckNewsletterPageOpened() {
        logger.debug("Check Newsletter page opened");
        // URL
        String url=driver.getCurrentUrl();
        checkIfEqual(url, "https://tutorialsninja.com/demo/index.php?route=account/newsletter");
        //Container
        WebElement BrandsContainer = GetNewsletterContainer();
        checkIfNotNull(BrandsContainer,"Newsletter Container");
    }
    // Title displayed
    public void CheckNewsletterSubscriptionTitleIsDisplayed(){
        logger.debug("Check page title is displayed");
        // Title displayed
        WebElement NewsletterTitle = GetTitle();
        CheckIfTextIsDiplayed(NewsletterTitle, "Page Title");
        String Title = NewsletterTitle.getText();
        checkIfEqual(Title, "Newsletter Subscription");
        System.out.println("the Title of the page is : " +Title);
    }

    // Subscribe buttons Yes/No
    public void CheckSubscriptionYesNoBtns() {
        logger.debug("Check Subscriptions Yes/No Button");
        WebElement yesBtn = GetYesBtn();
        WebElement noBtn = GetNoBtn();

        // Check if Yes button is displayed and clickable
        checkIfNotNull(yesBtn, "Yes Button");
        CheckIfButtonIsEnable(yesBtn, "Yes Button");
        yesBtn.click();

        // Check if No button is displayed and clickable
        checkIfNotNull(noBtn, "No Button");
        CheckIfButtonIsEnable(noBtn, "No Button");
        noBtn.click();
    }
    // Back button
    public void ClickBackBtn() {
        logger.debug("Click Back Btn");
        WebElement BackBtn = GetBackBtn();
        checkIfNotNull(BackBtn, "Continue Btn");

        // Check if Continue Btn is clickable
        CheckIfButtonIsEnable(BackBtn, "Continue Btn");
        BackBtn.click();

        String BackURL = driver.getCurrentUrl();
        checkIfEqual(BackURL, "https://tutorialsninja.com/demo/index.php?route=account/account");
    }
    // Continue
    public void ClickContinueBtn() {
        logger.debug("Click Continue Btn");
        WebElement ContinueBtn = GetContinueBtn();
        checkIfNotNull(ContinueBtn, "Continue Btn");

        // Check if Continue Btn is clickable
        CheckIfButtonIsEnable(ContinueBtn, "Continue Btn");
        ContinueBtn.click();

        String ContinueURL = driver.getCurrentUrl();
        checkIfEqual(ContinueURL, "https://tutorialsninja.com/demo/index.php?route=account/account");
    }

}
