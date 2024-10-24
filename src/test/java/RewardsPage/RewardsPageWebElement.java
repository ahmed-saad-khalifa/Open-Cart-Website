package RewardsPage;

import Utility.FindingElements;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RewardsPageWebElement extends FindingElements {
    public WebElement getRewardPageTitle() {return findElementByXPath("//*[@id=\"content\"]/h1");}
    public WebElement getRewardTable() {return findElementByClassName("table-responsive");}
    public List<WebElement> getRewardRows() {return findElementsByCssSelector(".table-responsive table tbody tr");}
    public WebElement getTotalPoints() {return findElementByXPath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td");}

}
