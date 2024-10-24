package Header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Header_Comp extends Header_WebElement {
    public void Homebuttonisworking(){
        logger.debug("Check Home page button working");
        WebElement Homepagebutton = gethomepagebutton();
        gethomepagebutton().click();
        String url = driver.getCurrentUrl();
        checkIfEqual(url, "https://tutorialsninja.com/demo/");
    }
    // Test if the Currency Switcher is working
    public void CurrencySwitch() {
        logger.debug(" Check Currency Switcher is working");
        WebElement CurrencySwitcher = getCurrencySwitcher();
        CurrencySwitcher.click();

        // Switch to Euro
        WebElement EuroOption = getCurrencyEuro();
        EuroOption.click();

        // Verify the currency switch
        String currencySymbol = driver.findElement(By.xpath("//strong[text()='€']")).getText();
        checkIfEqual(currencySymbol, "€");

        // Similarly, you can add tests for Pound and Dollar if needed
    }

    public void ContactUsPageIsWorking() {
        logger.debug(" Check Contact Us Page Is Working");
        WebElement contactUsButton = getContactUsButton();
        contactUsButton.click();

        // Verify the URL
        String currentUrl = driver.getCurrentUrl();
        checkIfEqual(currentUrl, "https://tutorialsninja.com/demo/index.php?route=information/contact");
    }

    // Test if the Wishlist button redirects correctly
    public void WishlistButtonIsWorking() {
        logger.debug(" Check Wishlist button redirects correctly");
        WebElement wishlistButton = getWishlistButton();
        wishlistButton.click();

        String currentUrl = driver.getCurrentUrl();
        checkIfEqual(currentUrl, "https://tutorialsninja.com/demo/index.php?route=account/wishlist");
    }

    // Test if the Shopping Cart button redirects correctly
    public void ShoppingCartButtonIsWorking() {
        logger.debug(" Check Shopping Cart button redirects correctly");
        WebElement shoppingCartButton = getShoppingCartButton();
        shoppingCartButton.click();

        String currentUrl = driver.getCurrentUrl();
        checkIfEqual(currentUrl, "https://tutorialsninja.com/demo/index.php?route=checkout/cart");
    }

    // Test if the Checkout button redirects correctly
    public void CheckoutButtonIsWorking() {
        logger.debug(" Check Checkout button redirects correctly");
        WebElement checkoutButton = getCheckoutButton();
        checkoutButton.click();

        String currentUrl = driver.getCurrentUrl();
        checkIfEqual(currentUrl, "https://tutorialsninja.com/demo/index.php?route=checkout/checkout");
    }

    // Test if the My Account switcher is working and redirects to Login
    public void LoginButtonIsWorking() throws InterruptedException {
        logger.debug(" Check My Account switcher is working and redirects to Login");
        WebElement myAccountSwitcher = getMyAccountSwitcher();
        myAccountSwitcher.click();
        Thread.sleep(1000);
        WebElement loginButton = getLoginButton();
        loginButton.click();

        String currentUrl = driver.getCurrentUrl();
        checkIfEqual(currentUrl, "https://tutorialsninja.com/demo/index.php?route=account/login");
    }

    // Test if the Register button is working
    public void RegisterButtonIsWorking() throws InterruptedException {
        logger.debug(" Check Register button is working");
        WebElement myAccountSwitcher = getMyAccountSwitcher();
        myAccountSwitcher.click();
        Thread.sleep(1000);
        WebElement registerButton = getRegisterButton();
        registerButton.click();

        String currentUrl = driver.getCurrentUrl();
        checkIfEqual(currentUrl, "https://tutorialsninja.com/demo/index.php?route=account/register");
    }

    // Test if the Cart Dropdown is working and showing items
    public void CartDropdownIsWorking() {
        logger.debug(" Check Cart Dropdown is working and showing items");
        WebElement cartDropdownButton = getCartDropdownButton();
        cartDropdownButton.click();

        // Get the list of items in the cart
        List<WebElement> cartItems = getCartItems().findElements(By.tagName("li"));

        // Check if the cart has items
        if (cartItems.size() > 0) {
            System.out.println("Cart items are displayed: " + cartItems.size());
        } else {
            System.out.println("No items in the cart.");
        }
    }

    // Test a valid search (e.g., "mac")
    public void SearchBarValidSearch() {
        logger.debug(" Check valid search");
        WebElement searchBar = getSearchBar();
        searchBar.sendKeys("mac");

        WebElement searchButton = getSearchButton();
        searchButton.click();

        String currentUrl = driver.getCurrentUrl();
        checkIfEqual(currentUrl, "https://tutorialsninja.com/demo/index.php?route=product/search&search=mac");

        // Validate if search results contain "mac"
        WebElement searchResults = getSearchResults();
        String resultsText = searchResults.getText();
        Assert.assertTrue(resultsText.toLowerCase().contains("mac"));
    }

    // Test an invalid search (e.g., "&*^%R25")
    public void SearchBarInvalidSearch() {
        logger.debug(" Check invalid search");
        WebElement searchBar = getSearchBar();
        searchBar.sendKeys("&*^%R25");

        WebElement searchButton = getSearchButton();
        searchButton.click();


        // Validate the error message for no products found
        WebElement noProductMessage = getNoProductMessage();
        String messageText = noProductMessage.getText();
        checkIfEqual(messageText, "There is no product that matches the search criteria.");
    }

    // Function to test category switchers and their options
    public void TestCategorySwitchers() {
        logger.debug(" Check test category switchers and their options");
        String[] categories = {"Desktops", "Laptops & Notebooks", "Components", "MP3 Players"};
        WebElement[] switchers = {getDesktopsSwitcher(), getLaptopsSwitcher(), getComponentsSwitcher(), getMP3PlayersSwitcher()};

        for (int i = 0; i < switchers.length; i++) {
            WebElement switcher = switchers[i];
            switcher.click();

            // Get the list of options for the current category
            List<WebElement> options = getCategoryOptions(categories[i]);
            for (WebElement option : options) {
                option.click();

                // Validate URL redirection
                String expectedUrl = option.getAttribute("href");
                String actualUrl = driver.getCurrentUrl();
                checkIfEqual(actualUrl, expectedUrl);

                // Navigate back after each test
                driver.navigate().back();
                switcher.click();  // Reopen the switcher after navigating back
            }
        }
    }

    // Function to test category buttons
    public void TestCategoryButtons() {
        logger.debug(" Check test category buttons");
        WebElement[] buttons = {getTabletsButton(), getSoftwareButton(), getPhonesButton(), getCamerasButton()};

        for (WebElement button : buttons) {
            button.click();

            // Validate URL redirection
            String expectedUrl = button.getAttribute("href");
            String actualUrl = driver.getCurrentUrl();
            checkIfEqual(actualUrl, expectedUrl);

            // Navigate back after each test
            driver.navigate().back();
        }
    }

    // Function to test category switchers and their options
    public void TestDesktopsSwitcher() {
        logger.debug(" Check test category switchers and their options");
        WebElement desktopsSwitcher = getDesktopsSwitcher();
        desktopsSwitcher.click();  // Click on the Desktops switcher

        // Get the list of options for "Desktops" (PC, Mac, Show All Desktops)
        List<WebElement> options = getCategoryOptions("Desktops");
        for (WebElement option : options) {
            String optionText = option.getText();
            option.click();  // Click on each option

            // Validate URL redirection
            String expectedUrl = option.getAttribute("href");
            String actualUrl = driver.getCurrentUrl();
            checkIfEqual(actualUrl, expectedUrl);

            // Navigate back after each option is clicked and validated
            driver.navigate().back();
            desktopsSwitcher.click();  // Reopen the switcher after navigation back
        }
    }

    public void TestHeaderContainers() {
        logger.debug(" Check Header Containers Is Displayed");
        // Define all header components
        WebElement[] headerComponents = {
                getCurrencySwitcher(),
                getContactUsButton(),
                getMyAccountSwitcher(),
                getWishlistButton(),
                getShoppingCartButton(),
                getCheckoutButton(),
                gethomepagebutton(),
                getSearchBar(),
                getCartDropdownButton(),
                getNavbarCategories()
        };

        // Check if each component is displayed
        for (WebElement component : headerComponents) {
            if (component.isDisplayed()) {
                System.out.println(component.getAttribute("outerHTML") + " is displayed.");
            } else {
                System.out.println(component.getAttribute("outerHTML") + " is NOT displayed.");
            }
        }
    }


}
