package BrandsPage;

import Utility.FindingElements;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrandsPageWebElements extends FindingElements {

    public WebElement GetBrandsContainer(){return findElementById("content");}
    public WebElement GetTitleName(){return findElementByTagName("h1");}
    public WebElement GetBrandIndexName(){return findElementByTagName("strong");}
    public WebElement GetBrandIndexContainer(){return findElementByTagName("p");}
    public List<WebElement> GetBrandLetters(){return findElementsByXpath("//div[@class='list-group']//a");}
    public List<WebElement> GetBrandsLinks(){return findElementsByXpath("//div[@class='row']//div[@class='col-sm-4']/a");}
}
