package MyAccountPage;

public class MyAccountPageComp extends MyAccountPageWebElements{

    public void CheckMyAccountPageOpened(){
        logger.debug("Check If My Account Page opened");
        //URL
        String url=driver.getCurrentUrl();
        checkIfEqual(url,"https://tutorialsninja.com/demo/index.php?route=account/account");

        //Title
        String MyAccountTitle=GetMyAccountTitle().getText();
        checkIfEqual(MyAccountTitle,"My Account");
    }

    public void ClickEditYourAccountInformationButton(){
        logger.debug("Click Edit Your Account Information Button");
        GetEditYourAccountInformationBtn().click();
        //Check My Account Information Page Opened
        checkIfEqual(driver.getCurrentUrl(),"https://tutorialsninja.com/demo/index.php?route=account/edit");
    }

    public void ClickChangeYourPasswordButton(){
        logger.debug("Click Change Your Password Button");
        GetChangeYourPasswordBtn().click();
        //Check Change Password Page Opened
        checkIfEqual(driver.getCurrentUrl(),"https://tutorialsninja.com/demo/index.php?route=account/password");
    }



}


