package getTitle;

import addToCart.CartsPage;
import addToCart.ProductsPage;
import createAccount.AccountsAndListsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import productFilteringSorting.ProductLaptopPage;
import signOut.AllSettingsPage;

import java.util.List;

import static utility.ActionsUtility.moveToElementNotClick;
import static utility.ActionsUtility.pageScrollUp;
import static utility.DropDownUtility.getDropDownOptions;
import static utility.DropDownUtility.selectByVisibleText;
import static utility.GetUtility.getAttribute;
import static utility.JavaScriptUtility.clickJS;
import static utility.WaitUtility.explicitWaitUntilVisible;

public class HomePage extends BasePage {
    private By logo = By.xpath("//div[@id=\"nav-logo\"]//following::a[@id=\"nav-logo-sprites\"]");
    public String getTitle(String attribute){
        return getAttribute(logo,attribute);
    }


    private By searchTab = By.id("twotabsearchtextbox");
    public void enterProductInSearchTab(String product){
        set(searchTab,product);
    }


    private By searchTabDropDown = By.xpath("//select[@aria-describedby=\"searchDropdownDescription\"]");
    public List<String> getDropDownInSearchTab(){
        return getDropDownOptions(searchTabDropDown);
    }

    public void selectOptionInDropDown(String text){
        selectByVisibleText(searchTabDropDown,text);
    }

    private By searchProductSuggestions = By.xpath("//div[@id=\"nav-flyout-searchAjax\"]//following::div[@class=\"s-suggestion-container\"]");
    public List<WebElement> idDisplayedSearchProductRelated(String product){
        enterProductInSearchTab(product);
        explicitWaitUntilVisible(searchProductSuggestions,5);
        return finds(searchProductSuggestions);
    }

    private By searchButton = By.id("nav-search-submit-button");
    public ProductsPage clickSearchProduct(String product){
        enterProductInSearchTab(product);
        click(searchButton);
        return new ProductsPage();
    }


    private By cartsCard = By.id("nav-cart-count");
    public CartsPage clickCartCard(){
        click(cartsCard);
        return new CartsPage();
    }


    public ProductLaptopPage goToProductLaptop(){
        enterProductInSearchTab("laptop");
        click(searchButton);
        return new ProductLaptopPage();
    }

    private By todayDealsCard = By.xpath("//div[@id=\"nav-xshop\"]//a[text()=\"Today's Deals\"]");
    public void clickTodayDeals(){
        click(todayDealsCard);
        pageScrollUp();
    }


    private By primeCard = By.xpath("//div[@id=\"nav-xshop\"]//span[text()=\"Prime\"]");
    public void clickPrimeCard(){
        click(primeCard);
    }


//    private By accountsAndListsCard = By.xpath("//div[@id=\"nav-tools\"]//span[text()=\"Account & Lists\"]");
private By accountsAndListsCard = By.xpath("//div[@id=\"nav-tools\"]//a[@id=\"nav-link-accountList\"]//span[@class=\"nav-icon nav-arrow\"]");

    public AccountsAndListsPage clickAccountsAndListsCard(){
        clickJS(accountsAndListsCard);
        return new AccountsAndListsPage();
    }

    private By allSettingsCard = By.xpath("//a[@id=\"nav-hamburger-menu\"]//span[text()=\"All\"]");
    public AllSettingsPage clickAllSettingsCard(){
        clickJS(allSettingsCard);
        return new AllSettingsPage();
    }

    public void notClickAllSettingsCard(){
        moveToElementNotClick(find(accountsAndListsCard));
    }
    private By signOutButton = By.xpath("//span[text()=\"Sign Out\"]");
    public void clickSignOut(){
        explicitWaitUntilVisible(signOutButton,5);
        clickJS(signOutButton);
    }






}
