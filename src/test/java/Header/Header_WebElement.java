package Header;
import Utility.FindingElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.time.Duration;

public class Header_WebElement extends FindingElements{
    // Homepage button (Logo)
    public WebElement gethomepagebutton(){return findElementByXPath("//a[@href='https://tutorialsninja.com/demo/index.php?route=common/home']");};

    // Currency Switcher
    public WebElement getCurrencySwitcher() {return findElementByXPath("//form[@id='form-currency']//button");}

    // Currency dropdown options
    public WebElement getCurrencyEuro() {return findElementByXPath("//button[@name='EUR']");}

    public WebElement getCurrencyPound() {return findElementByXPath("//button[@name='GBP']");}

    public WebElement getCurrencyDollar() {return findElementByXPath("//button[@name='USD']");}

    // Contact Us button
    public WebElement getContactUsButton() {return findElementByXPath("//a[contains(@href,'contact')]");}

    // My Account Switcher
    public WebElement getMyAccountSwitcher() {return findElementByXPath("//a[@title='My Account']");}

    // Login button under My Account
    public WebElement getLoginButton() {return findElementByXPath("//a[text()='Login']");}

    // Register button under My Account
    public WebElement getRegisterButton() {return findElementByXPath("//a[text()='Register']");}

    // Wishlist button
    public WebElement getWishlistButton() {return findElementById("wishlist-total");}

    // Shopping Cart button
    public WebElement getShoppingCartButton() {return findElementByXPath("//a[@title='Shopping Cart']");}

    // Checkout button
    public WebElement getCheckoutButton() {return findElementByXPath("//a[@title='Checkout']");}

    // Cart dropdown
    public WebElement getCartDropdownButton() {return findElementByXPath("//*[@id=\"cart\"]");}

    // Cart Items inside the dropdown
    public WebElement getCartItems() {return findElementByXPath("//ul[@class='dropdown-menu pull-right']//li");}

    // Navbar categories
    public WebElement getNavbarCategories() {return findElementByXPath("//ul[@class='nav navbar-nav']");}

    // Search Bar input field
    public WebElement getSearchBar() {return findElementByXPath("//input[@name='search']");}

    // Search Button
    public WebElement getSearchButton() {return findElementByXPath("//button[@class='btn btn-default btn-lg']");}

    // Search Results Section (for validation)
    public WebElement getSearchResults() {return findElementByXPath("//div[@id='content']");}

    // No product message for invalid search
    public WebElement getNoProductMessage() {return findElementByXPath("//p[contains(text(),'There is no product that matches the search criteria.')]");}

    // Switchers
    public WebElement getDesktopsSwitcher() {return findElementByXPath("//a[contains(text(),'Desktops')]");}
    public WebElement getLaptopsSwitcher() {return findElementByXPath("//a[contains(text(),'Laptops & Notebooks')]");}
    public WebElement getComponentsSwitcher() {return findElementByXPath("//a[contains(text(),'Components')]");}
    public WebElement getMP3PlayersSwitcher() {return findElementByXPath("//a[contains(text(),'MP3 Players')]");}

    // Buttons
    public WebElement getTabletsButton() {return findElementByXPath("//a[contains(text(),'Tablets')]");}
    public WebElement getSoftwareButton() {return findElementByXPath("//a[contains(text(),'Software')]");}
    public WebElement getPhonesButton() {return findElementByXPath("//a[contains(text(),'Phones & PDAs')]");}
    public WebElement getCamerasButton() {return findElementByXPath("//a[contains(text(),'Cameras')]");}

    // Get category options (for dropdowns)
    public List<WebElement> getCategoryOptions(String category) {return findElementsByXpath("//a[contains(text(),'" + category + "')]/following-sibling::ul//a");}



}
