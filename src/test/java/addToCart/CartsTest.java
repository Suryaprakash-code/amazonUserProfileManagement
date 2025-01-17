package addToCart;

import getTitle.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static utility.SwitchToUtility.switchToNewWindow;

@Test
public class CartsTest extends BaseTest {

    public void CartsTest(){
        var firstProductPage = homePage.clickSearchProduct("laptop").clickFirstProduct();
        switchToNewWindow();
        firstProductPage.clickAddToCartButton();

        var cartsPage = homePage.clickCartCard();
        String totalItems = cartsPage.getSubTotalItems();
        System.out.println(totalItems);
        String totalAmount = cartsPage.getSubTotalAmount();
        System.out.println(totalAmount);

    }
    public void cartsTestAfterDeletion(){
        var cartsPage = homePage.clickCartCard();
        cartsPage.clickDeleteItemInCart();
        cartsPage.isDeletionSuccessMessageDisplayed();
        var cartsPageAfterDeletion = homePage.clickCartCard();
        String totalItemsAfterDeletion = cartsPageAfterDeletion.getSubTotalItems();
        System.out.println(totalItemsAfterDeletion);
        String totalAmountAfterDeletion = cartsPageAfterDeletion.getSubTotalAmount();
        System.out.println(totalAmountAfterDeletion);

        List<WebElement> individualItemsName = cartsPage.getIndividualItemsName();
        for(WebElement element:individualItemsName){
            System.out.println(element.getText());
        }

    }
}
