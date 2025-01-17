package getTitle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    public static WebDriver driver;

    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> finds(By locator){
        return driver.findElements(locator);
    }

    public void set(By locator,String text){
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    public void click(By locator){
        find(locator).click();
    }

}
