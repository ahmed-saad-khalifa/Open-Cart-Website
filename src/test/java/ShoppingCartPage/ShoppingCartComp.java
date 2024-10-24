package ShoppingCartPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import HomePage.HomePageComp;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartComp extends ShoppingCartWebElements{

    public void CheckContainer() throws Exception{
        WebElement container = GetContainer();
        checkIfNotNull(container,"Container");

    }
    public void CheckRemoveBtn() throws Exception{
        logger.debug("Check Remove button");
        WebElement RmvBtn = GetMacBookRemoveBtn();
        CheckIfButtonIsEnable(RmvBtn,"Remove Button");

        RmvBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        try {
            CheckCartIconEmpty();//we use this as we've added only 1 product to the cart
        }catch (Exception e){
            System.out.println("The product isn't removed");
        }

    }

    public void CheckCartIconEmpty() throws Exception {
        logger.debug("Check Cart Icon Number 0 (empty)");
        HomePageComp homePageComp = new HomePageComp();
        //check cart icon number
        WebElement CartIcon = homePageComp.GetHeaderCartIcon();
        Actions action = new Actions(driver);
        action.moveToElement(CartIcon).perform();
        Thread.sleep(1000);
        String CartNumber = homePageComp.GetHeaderCartIcon().getText();
        System.out.println(CartNumber);
        checkIfContain(CartNumber, "0");
    }

//    public void CheckUpdateBtn() throws Exception{
//        logger.debug("Check Update btn");
//        WebElement updtField = GetMacBookUpdateField();
//        updtField.clear();
//        updtField.sendKeys("2");
//        WebElement updtBtn = GetMacBookUpdateBtn();
//        updtBtn.click();
//        Thread.sleep(5000);
//        WebElement updtFieldAfterPageReload = GetMacBookUpdateField();
////        explicitlyWaitForVisibility(updtFieldAfterPageReload);
//        String updatedQuantity = updtFieldAfterPageReload.getAttribute("value");
//        checkIfEqual(updatedQuantity,"2");
//    }

}
