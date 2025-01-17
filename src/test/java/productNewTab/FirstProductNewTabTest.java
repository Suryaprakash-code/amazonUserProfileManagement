package productNewTab;

import getTitle.BaseTest;
import org.testng.annotations.Test;

import static utility.SwitchToUtility.switchToNewWindow;

@Test
public class FirstProductNewTabTest extends BaseTest {

    public void firstProductNewTabTest() {

         var firstProductPage = homePage.clickSearchProduct("laptop").clickFirstProduct();
         switchToNewWindow();
         String firstProductTitle =  firstProductPage.getTitle();
        System.out.println(firstProductTitle);

        firstProductPage.clickAddToCartButton();

    }

}
