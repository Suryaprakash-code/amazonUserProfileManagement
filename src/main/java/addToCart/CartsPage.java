package addToCart;

import getTitle.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utility.JavaScriptUtility.clickJS;
import static utility.JavaScriptUtility.scrollToElementJS;
import static utility.WaitUtility.explicitWaitUntilVisible;

public class CartsPage extends HomePage {


    private By subTotalItems = By.xpath("//form[@id=\"activeCartViewForm\"]//span[@id=\"sc-subtotal-label-activecart\"]");
    public String getSubTotalItems(){
        return find(subTotalItems).getText();
    }

    private By subTotalAmount = By.xpath("//form[@id=\"activeCartViewForm\"]//span[@id=\"sc-subtotal-amount-activecart\"]");
    public String getSubTotalAmount(){
        return find(subTotalAmount).getText();
    }

    private By individualItemsPrice = By.xpath("//span[@class=\"a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold\"]");
    public List<WebElement> getIndividualItemsPrice (){
        return finds(individualItemsPrice);
    }

    private By individualItemsName = By.xpath("//div[@id=\"sc-active-cart\"]//li[@class=\"a-spacing-mini sc-item-product-title-cont\"]");
    public List<WebElement> getIndividualItemsName(){

        return finds(individualItemsName);
    }

    private By deleteItemInCard = By.xpath("//div[@data-item-index=\"2\"]//span[@data-a-selector=\"decrement-icon\"]");
    public void clickDeleteItemInCart(){
        scrollToElementJS(deleteItemInCard);
        clickJS(deleteItemInCard);
    }


    private By deletionSuccessMessage = By.xpath("//div[@data-item-index=\"2\"]//div[@data-feature-id=\"delete-success-message\"]");
    public boolean isDeletionSuccessMessageDisplayed(){
         explicitWaitUntilVisible(deletionSuccessMessage,5);
         return find(deletionSuccessMessage).isDisplayed();
    }
}
