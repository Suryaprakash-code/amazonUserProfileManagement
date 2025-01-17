package addToCart;

import getTitle.HomePage;
import org.openqa.selenium.By;

import static utility.JavaScriptUtility.scrollToElementJS;

public class ProductsPage extends HomePage {

    private By firstProduct = By.xpath("//span[@data-component-type=\"s-search-results\"]//div[@data-index=\"3\"]//a[@class=\"a-link-normal s-line-clamp-2 s-link-style a-text-normal\"]");
    public FirstProductPage clickFirstProduct(){
        scrollToElementJS(firstProduct);
        click(firstProduct);
        return new FirstProductPage();
    }

}
