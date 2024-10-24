package Footer;

import Utility.FindingElements;
import org.openqa.selenium.WebElement;

public class FooterWebElements extends FindingElements {
    public WebElement GetFooterContainer(){return findElementByClassName("container"); }

    //method to find all the hyperlink web elements:
    public WebElement GetHyperLinkCalled(String HyperLinkTextName){
        WebElement theHyperLink=null;
        switch(HyperLinkTextName) {
            case "OpenCart":
                theHyperLink = findElementByLinkText("OpenCart");
                break;
                //Information Section
            case "About Us":
                theHyperLink = findElementByLinkText("About Us");
                break;
            case "Delivery Information":
                theHyperLink = findElementByLinkText("Delivery Information");
                break;
            case "Privacy Policy":
                theHyperLink = findElementByLinkText("Privacy Policy");
            break;
            case "Terms & Conditions":
                theHyperLink = findElementByLinkText("Terms & Conditions");
            break;
            //Customer Service section
            case "Contact Us":
                theHyperLink = findElementByLinkText("Contact Us");
            break;
            case "Returns":
                theHyperLink = findElementByXPath("/html/body/footer/div/div/div[2]/ul/li[2]/a");
            break;
            case "Site Map":
                theHyperLink = findElementByLinkText("Site Map");
            break;
            //Extras section
            case "Brands":
                theHyperLink = findElementByLinkText("Brands");
            break;
            case "Gift Certificates":
                theHyperLink = findElementByLinkText("Gift Certificates");
            break;
            case "Affiliate":
                theHyperLink = findElementByLinkText("Affiliate");
            break;
            case "Specials":
                theHyperLink = findElementByLinkText("Specials");
            break;
            //My Account section
            case "My Account":
                theHyperLink = findElementByXPath("/html/body/footer/div/div/div[4]/ul/li[1]/a");
            break;
            case "Order History":
                theHyperLink = findElementByXPath("/html/body/footer/div/div/div[4]/ul/li[2]/a");
            break;
            case "Wish List":
                theHyperLink = findElementByXPath("/html/body/footer/div/div/div[4]/ul/li[3]/a");
            break;
            case "Newsletter":
                theHyperLink = findElementByXPath("/html/body/footer/div/div/div[4]/ul/li[4]/a");
            break;

            default:
                theHyperLink = null;
        }
        return theHyperLink;
         }




}
