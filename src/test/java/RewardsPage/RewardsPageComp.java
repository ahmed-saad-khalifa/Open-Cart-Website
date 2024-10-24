package RewardsPage;

import RewardsPage.RewardsPageWebElement;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RewardsPageComp extends RewardsPageWebElement {
    public void checkIfRewardPageOpened() {
        logger.debug("Verify if the reward page is displayed.");

        String url = driver.getCurrentUrl();
        checkIfEqual(url, "https://tutorialsninja.com/demo/index.php?route=account/reward");

        // Check page title
        WebElement pageTitle = getRewardPageTitle();
        checkIfNotNull(pageTitle, "Reward Page Title");
        CheckIfTextIsDiplayed(pageTitle, "Your Reward Points"); // Assuming the title is "Your Reward Points"
    }

    public void checkRewardTable() {
        logger.debug("Verify if the reward points table is displayed correctly.");

        WebElement table = getRewardTable();
        checkIfNotNull(table, "Reward Points Table");

        // Check if table rows are displayed
        List<WebElement> rows = getRewardRows();
        checkIfTrue(rows.size() > 0, "Reward table contains at least one row");
    }

    public void checkTotalPoints() {
        logger.debug("Verify the total reward points displayed.");

        WebElement totalPoints = getTotalPoints();
        checkIfNotNull(totalPoints, "Total Points Element");
        checkIfContain(totalPoints.getText(), "Points"); // Verifying that it contains "Points" text
    }
}
