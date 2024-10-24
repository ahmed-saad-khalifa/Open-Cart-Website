package BrandsPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrandsPageComp extends BrandsPageWebElements {

    // Brands page opened
    public void CheckBrandsPageOpened() {
        logger.debug("Check Brands page opened");
        // URL
        String url=driver.getCurrentUrl();
        checkIfEqual(url, "https://tutorialsninja.com/demo/index.php?route=product/manufacturer");
        //Container
        WebElement BrandsContainer = GetBrandsContainer();
        checkIfNotNull(BrandsContainer,"Brands Container");
    }

    // "Find Your Favorite Brand" displayed
    public void CheckPageTitleIsDisplayed(){
        logger.debug("Check page title is displayed");
        // Title displayed
        WebElement PageTitle = GetTitleName();
        CheckIfTextIsDiplayed(PageTitle, "Page Title");
        String Title = PageTitle.getText();
        checkIfEqual(Title, "Find Your Favorite Brand");
        System.out.println("the Title of the page is : " +Title);
    }

    // "Brands Index" container and isdisplayed
    public void CheckBrandsIndexIsDisplayed(){
        logger.debug("Check Index title is displayed");
        // Index displayed
        WebElement IndexTitle = GetBrandIndexName();
        checkIfNotNull(IndexTitle, "Page Title");
        CheckIfTextIsDiplayed(IndexTitle, "Find Your Favorite Brand");
        // Index container
        WebElement IndexContainer = GetBrandIndexContainer();
        checkIfNotNull(IndexContainer,"Index container");
    }

    // Find all the letters (Brand Index) and click each
    public void CheckBrandAreClickable(){
    List<WebElement> brandLetters = GetBrandLetters();

    // Loop through each letter link in the Brand Index
        for(WebElement letter : brandLetters) {
            letter.click();  // Click each letter

    // Get the brands listed under the letters
        List<WebElement> brandLinks = GetBrandsLinks();

        // For each brand link, click and verify it redirects correctly
        for (WebElement brand : brandLinks) {
            String expectedBrandName = brand.getText();  // Get the brand name

            // Click the brand link
            brand.click();
            // Verify the correct brand page opened by checking the page title or URL
            WebElement brandTitle = driver.findElement(By.xpath("//h2[text()='" + expectedBrandName + "']"));
            CheckIfTextIsDiplayed(brandTitle, "Brand Title");

            // Go back to the Brands page
            driver.navigate().back();
        }
    }
}
    }





