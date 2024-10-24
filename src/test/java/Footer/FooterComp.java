package Footer;

import org.openqa.selenium.WebElement;

public class FooterComp extends FooterWebElements{
    //check container
    public void CheckFooterContainer() throws Exception{
        logger.debug("Check that the container of Footer is not null");
        WebElement container = GetFooterContainer();
        checkIfNotNull(container, "Footer Container");
    }

    //check hyper-links in "information" section direct the user to the right link
    public void CheckInformationSectionHyperLinks() throws Exception{
        logger.debug("Check hyper-links in \"information\" section direct the user to the right link");
        String[] Information = {"About Us","Delivery Information", "Privacy Policy", "Terms & Conditions"};
        String[] InformationLinks = {"https://tutorialsninja.com/demo/index.php?route=information/information&information_id=4"
                ,"https://tutorialsninja.com/demo/index.php?route=information/information&information_id=6"
                , "https://tutorialsninja.com/demo/index.php?route=information/information&information_id=3"
                , "https://tutorialsninja.com/demo/index.php?route=information/information&information_id=5"};

        for(int i=0;i<4;i++){
            WebElement Info_HL = GetHyperLinkCalled(Information[i]);//access each element of "Information" array each loop.
            Info_HL.click();//click on the current hyper link
            checkIfEqual(driver.getCurrentUrl(),InformationLinks[i]);
        }
            }

    //check hyper-links in "Customer Service" section direct the user to the right link
    public void CheckCustomerServiceSectionHyperLinks() throws Exception{
        logger.debug("Check hyper-links in \"Customer Service\" section direct the user to the right link");
        String[] Customer = {"Contact Us" ,"Returns" ,"Site Map"};
        String[] CustomerLinks = {"https://tutorialsninja.com/demo/index.php?route=information/contact"
                , "https://tutorialsninja.com/demo/index.php?route=account/return/add"
                , "https://tutorialsninja.com/demo/index.php?route=information/sitemap"};

        for(int i=0;i<3;i++){
            WebElement Custom_HL = GetHyperLinkCalled(Customer[i]);//access each element of "Information" array each loop.
            Custom_HL.click();//click on the current hyper link
            checkIfEqual(driver.getCurrentUrl(),CustomerLinks[i]);
        }
    }

    //check hyper-links in "Extras" section direct the user to the right link
    public void CheckExtrasSectionHyperLinks() throws Exception{
        logger.debug("Check hyper-links in \"Extras\" section direct the user to the right link");
        String[] Extras = {"Brands","Gift Certificates", "Affiliate", "Specials"};
        String[] ExtrasLinks = {"https://tutorialsninja.com/demo/index.php?route=product/manufacturer"
                , "https://tutorialsninja.com/demo/index.php?route=account/voucher"
                , "https://tutorialsninja.com/demo/index.php?route=affiliate/login"
                , "https://tutorialsninja.com/demo/index.php?route=product/special"};

        for(int i=0;i<4;i++){
            WebElement Extra_HL = GetHyperLinkCalled(Extras[i]);//access each element of "Information" array each loop.
            Extra_HL.click();//click on the current hyper link
            checkIfEqual(driver.getCurrentUrl(),ExtrasLinks[i]);
        }
    }

    //check "affiliate" hyper-link in "Extras" section direct the user to the right link
    public void CheckAffiliateHyperLinkWhileLogin() throws Exception{
        logger.debug("Check \"affiliate\" hyper-link in \"Extras\" section direct the user to the right link");
        String Affiliate = "Affiliate";
        String AffiliateLink = "https://tutorialsninja.com/demo/index.php?route=account/affiliate/edit";

            WebElement Aff_HL = GetHyperLinkCalled(Affiliate);//access each element of "Information" array each loop.
            Aff_HL.click();//click on the current hyper link
            checkIfEqual(driver.getCurrentUrl(),AffiliateLink);

    }

    //check hyper-links in "My Account" section direct the user to the right link
    public void CheckMyAccountSectionHyperLinksWhileNoLogin() throws Exception{
        logger.debug("Check hyper-links in \"My Account\" section direct the user to the right link");
        String[] Account = {"My Account", "Order History", "Wish List", "Newsletter"};
        String AccountLinks = "https://tutorialsninja.com/demo/index.php?route=account/login";

        for(int i=0;i<4;i++){
            WebElement Acc_HL = GetHyperLinkCalled(Account[i]);//access each element of "Information" array each loop.
            CheckIfTextIsDiplayed(Acc_HL, Account[i]);
            Acc_HL.click();//click on the current hyper link
            checkIfEqual(driver.getCurrentUrl(),AccountLinks);
            //System.out.println("loop " + i + "has been finished");
        }
    }
    public void CheckMyAccountSectionHyperLinksWhileLogin() throws Exception{
        logger.debug("Check hyper-links in \"My Account\" section direct the user to the right link");
        String[] Account = {"My Account", "Order History", "Wish List", "Newsletter"};
        String[] AccountLinks = {"https://tutorialsninja.com/demo/index.php?route=account/account"
                , "https://tutorialsninja.com/demo/index.php?route=account/order"
                , "https://tutorialsninja.com/demo/index.php?route=account/wishlist"
                , "https://tutorialsninja.com/demo/index.php?route=account/newsletter"};

        for(int i=0;i<4;i++){
            WebElement Acc_HL = GetHyperLinkCalled(Account[i]);//access each element of "Information" array each loop.
            CheckIfTextIsDiplayed(Acc_HL, Account[i]);
            Acc_HL.click();//click on the current hyper link
            checkIfEqual(driver.getCurrentUrl(),AccountLinks[i]);
            System.out.println("loop " + i + "has been finished");
        }
    }

    //check "OpenCart" directs the user to the main website
    public void CheckWhenClickOnOpenCartDirectedToMainWebsite() throws Exception{
        logger.debug("Check \"OpenCart\" directs the user to the main website");
        WebElement OpenCartHyperLink = GetHyperLinkCalled("OpenCart");
        OpenCartHyperLink.click();
        checkIfEqual(driver.getCurrentUrl(), getConfigValue("config", "MAIN_WEBSITE"));
    }


}
