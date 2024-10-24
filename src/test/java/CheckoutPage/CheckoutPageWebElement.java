package CheckoutPage;

import Utility.FindingElements;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutPageWebElement extends FindingElements {

    public WebElement getcheckoutPageTitle() {return findElementById("content");}
    public WebElement getContinueBtn1(){return findElementById("button-account");}
    public WebElement getContinueBtn2(){return findElementById("button-guest");}
    public WebElement getContinueBtn3(){return findElementById("button-guest-shipping");}
    public WebElement getContinueBtn4(){return findElementById("button-shipping-method");}
    public WebElement getContinueBtn5(){return findElementById("button-payment-method");}
    public WebElement getConfirmOrderBtn(){return findElementById("button-confirm");}
    public WebElement getBillingDetailsForm(){return findElementById("accordion");}
    public WebElement getFirstNameField(){return findElementById("input-payment-firstname");}
    public WebElement getLastNameField(){return findElementById("input-payment-lastname");}
    public WebElement getEmailField(){return findElementById("input-payment-email");}
    public WebElement getTelephoneField(){return findElementById("input-payment-telephone");}
    public WebElement getAddress1Field(){return findElementById("input-payment-address-1");}
    public WebElement getCityField(){return findElementById("input-payment-city");}
    public WebElement getPostcodeField(){return findElementById("input-payment-postcode");}
    public WebElement getCountryField(){return findElementById("input-payment-country");}
    public WebElement getZoneField(){return findElementById("input-payment-zone");}
    public WebElement getFirstNameDeliveryField(){return findElementById("input-shipping-firstname");}
    public WebElement getLastNameDeliveryField(){return findElementById("input-shipping-lastname");}
    public WebElement getAddressDeliveryField(){return findElementById("input-shipping-address-1");}
    public WebElement getCityDeliveryField(){return findElementById("input-shipping-city");}
    public WebElement getCountryDropdownInDelviryOptions(){return findElementById("input-shipping-country");}
    public WebElement getZoneDropdownInDelviryOptions(){return findElementById("input-shipping-zone");}

    public WebElement getCheckBox(){return findElementByXPath("//input[@type='checkbox']");}
    public WebElement getCheckPoint(){return findElementByXPath("//input[@type='radio' and @name='shipping_method' and @value='flat.flat' and @checked]");}
    public WebElement getCommentField(){return findElementByXPath("//textarea[@name='comment']");}
    public WebElement getPaymentMethodElement(){return findElementByXPath("//*[@id=\"collapse-payment-method\"]/div/div[1]/label/input");}
    public WebElement getCommentTwoField(){return findElementByXPath("//*[@id=\"collapse-payment-method\"]/div/p[3]/textarea");}
    public WebElement getAgreeCheckBox(){return findElementByXPath("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]");}


    public WebElement getDisplayedQuantityElement(){return findElementByXPath("//div[@class='table-responsive']//tbody/tr/td[3]");}
    public WebElement getPriceElement(){return findElementByXPath("//div[@class='table-responsive']//tbody/tr/td[4]");}
    public WebElement getDisplayedTotalPriceElement(){return findElementByXPath("//div[@class='table-responsive']//tbody/tr/td[5]");}

    public WebElement getSubTotalElement(){return findElementByXPath("//tfoot/tr[1]/td[2]");}
    public WebElement getShippingRateElement(){return findElementByXPath("//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table/tfoot/tr[2]/td[2]");}
    public WebElement getTotalAmountElement(){return findElementByXPath("//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table/tfoot/tr[3]/td[2]");}
    public WebElement getRegisterCheckoutOption(){return findElementByXPath("//input[@value='register']");}
    public WebElement getGuestCheckoutOption(){return findElementByXPath("//input[@value='guest']");}


    public List<WebElement> getPanels() {return findElementsByClassName("panel-default");}

}
