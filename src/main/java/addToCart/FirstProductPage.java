package addToCart;

import org.openqa.selenium.By;

import static utility.DropDownUtility.selectByVisibleText;
import static utility.JavaScriptUtility.clickJS;
import static utility.JavaScriptUtility.scrollToElementJS;
import static utility.WaitUtility.explicitWaitUntilVisible;

public class FirstProductPage extends ProductsPage {

    private By titleCard = By.xpath("//span[@id=\"productTitle\"]");
    public String getTitle(){
        return find(titleCard).getText();
    }

    private By addToCartButton = By.xpath("//div[@data-a-card-type=\"basic\"]//input[@name=\"submit.addToCart\"]");
    public void clickAddToCartButton(){
        scrollToElementJS(addToCartButton);
        clickJS(addToCartButton);
    }


    private By productRatingText = By.xpath("//div[@id=\"ppd\"]//span[@id=\"acrCustomerReviewText\"]");
    public boolean isProductRatingDisplayed(){
        return find(productRatingText).isDisplayed();
    }

    private By oneStarRating = By.xpath("//span[@class=\"cr-widget-TitleRatingsHistogram\"]//div[text()=\"1 star\"]");
    public void clickOneStarRating(){
        scrollToElementJS(oneStarRating);
        clickJS(oneStarRating);
    }

    private By mostRecentDropdown = By.xpath("//a[@id=\"customer-reviews-content\"]//following::select[@data-action=\"a-dropdown-select\"]");
    public void clickMostRecentInDropdown(String text){
        explicitWaitUntilVisible(mostRecentDropdown,5);
        scrollToElementJS(mostRecentDropdown);
        clickJS(mostRecentDropdown);
//        selectByIndex(mostRecentDropdown,0);
        selectByVisibleText(mostRecentDropdown,text);
    }

    private By imageReview = By.xpath("//h3[text()=\"Reviews with images\"]//following::li[@aria-posinset=\"2\"]//img");
//    private String downloadFilePath="D:/Amazon/resources/screenshots";
//     ChromeOptions options;
//    options.addArguments("download.default_directory="+downloadFilePath);


}
