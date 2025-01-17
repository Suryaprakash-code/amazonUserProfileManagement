package productFilteringSorting;

import getTitle.BaseTest;
import org.testng.annotations.Test;

@Test
public class productFilterSortTest extends BaseTest {

    private String enterSortType = "Price: Low to High";
    private String sizeGB ="128 GB";
    private int x = 0;
    private int y=5;
//    private String hardDiskType="HDD";
    public void applySortAndFiltersTest(){
        var productLaptopPage = homePage.goToProductLaptop();
        productLaptopPage.clickSort(enterSortType);
        productLaptopPage.clickMemorySizeButton(sizeGB);
        productLaptopPage.setLaptopPrice(x,y);
        String sliderValue = productLaptopPage.getSliderValue();
        System.out.println("Price: "+sliderValue);
//        productLaptopPage.clickHardDiskType(hardDiskType);
    }
}
