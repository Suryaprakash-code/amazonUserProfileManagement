package reviewAndRatingSection;

import getTitle.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utility.SwitchToUtility.switchToNewWindow;
@Test
public class ReviewAndRatingTest extends BaseTest {
    private String mostRecent = "Most recent";
    public void reviewAndRatingTest(){
        var firstProductPage = homePage.clickSearchProduct("laptop").clickFirstProduct();
        switchToNewWindow();
        Assert.assertTrue(firstProductPage.isProductRatingDisplayed(),
                "Product rating is not displayed");
        firstProductPage.clickMostRecentInDropdown(mostRecent);
    }
    public void clickOneStarRatingTest(){
        var firstProductPage = homePage.clickSearchProduct("laptop").clickFirstProduct();
        switchToNewWindow();
        firstProductPage.clickOneStarRating();
    }
}
