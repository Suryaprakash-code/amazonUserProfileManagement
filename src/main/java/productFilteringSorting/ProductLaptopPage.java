package productFilteringSorting;

import addToCart.ProductsPage;
import org.openqa.selenium.By;

import static utility.ActionsUtility.dragAndDropBy;
import static utility.DropDownUtility.selectByVisibleText;
import static utility.GetUtility.getAttribute;
import static utility.JavaScriptUtility.clickJS;
import static utility.JavaScriptUtility.scrollToElementJS;
import static utility.WaitUtility.explicitWaitUntilVisible;

public class ProductLaptopPage extends ProductsPage {

    private By sortDropDownCard = By.xpath("//span[@data-component-type=\"s-result-info-bar\"]//select");
    public void clickSort(String text){
        clickJS(sortDropDownCard);
        selectByVisibleText(sortDropDownCard,text);
    }


    public void clickMemorySizeButton(String sizeGB){
         By memorySizeButton = By.xpath("//div[@id=\"s-refinements\"]//span[text()=\"Notebook Computer RAM Memory Size\"]//following::span[text()=\""+sizeGB+"\"]");
        explicitWaitUntilVisible(memorySizeButton,5);
        if(!find(memorySizeButton).isSelected()){
            scrollToElementJS(memorySizeButton);
            clickJS(memorySizeButton);
        }
    }


    private By laptopPriceSlider = By.xpath("//input[@id=\"p_36/range-slider_slider-item_upper-bound-slider\"]");
    private By goButton = By.xpath("//div[@id=\"priceRefinements\"]//div[@class=\"a-section sf-submit-range-button\"]");
    public void setLaptopPrice(int x,int y){
        explicitWaitUntilVisible(laptopPriceSlider,10);
        dragAndDropBy(find(laptopPriceSlider),x,y);
        clickJS(goButton);
    }
    public String getSliderValue(){
        explicitWaitUntilVisible(laptopPriceSlider,10);
        return getAttribute(laptopPriceSlider,"aria-valuetext");
    }

    public void clickHardDiskType(String hardDisk){
        By hardDiskType = By.xpath("//span[text()=\"Hard Disk Description\"]//following::span[text()=\""+hardDisk+"\"]");
        scrollToElementJS(hardDiskType);
        explicitWaitUntilVisible(hardDiskType,5);
        if(!find(hardDiskType).isSelected()){
            clickJS(hardDiskType);
        }
    }
}
