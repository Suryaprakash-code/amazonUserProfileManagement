package serachBar;

import getTitle.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;


@Test
public class SearchTabTest extends BaseTest {

    public void enterProduct(){
        homePage.enterProductInSearchTab("laptop");
    }

    public void getAllSearchTabDropDownOptions(){
        List<String> options = homePage.getDropDownInSearchTab();
        for(String option: options){
            System.out.println(option);
        }
    }

    public void selectedOptionInSearchTabDropDown(){
        homePage.selectOptionInDropDown("Computers & Accessories");
    }

    public void areSearchProductsRelated(){
        List<WebElement> suggestions= homePage.idDisplayedSearchProductRelated("laptop");
        for(WebElement suggestion:suggestions){
            System.out.println(suggestion.getText());
        }
    }
}
