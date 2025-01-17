package getTitle;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class TitleTest extends BaseTest{


    public void titleTest(){
        String actualTitle = homePage.getTitle("aria-label");
        System.out.println(actualTitle);
        String expectedTitle = "Amazon.in";
        Assert.assertEquals(actualTitle,expectedTitle,
                "\nActual & Expected title does not match\n");
    }


}
