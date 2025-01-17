package signOut;

import getTitle.HomePage;
import org.openqa.selenium.By;

import static utility.ActionsUtility.moveToElementNotClick;
import static utility.JavaScriptUtility.clickJS;
import static utility.WaitUtility.explicitWaitUntilVisible;

public class AllSettingsPage extends HomePage {
    private By allSettingsCard = By.xpath("//a[@id=\"nav-hamburger-menu\"]//span[text()=\"All\"]");
    private By allSettingsMenu = By.xpath("//div[@id=\"hmenu-canvas\"]");
    private By signInButton = By.xpath("//div[@id=\"hmenu-canvas\"]//a[text()=\"Sign in\"]");
    private By signOutButton = By.xpath("//div[@id=\"hmenu-canvas\"]//a[text()=\"Sign \"]");


    public void moveToAllSettingsCard(){
        moveToElementNotClick(find(allSettingsCard));
    }
    public boolean isAllSettingsMenuDisplayed(){
        explicitWaitUntilVisible(allSettingsMenu,30);
        return find(allSettingsMenu).isDisplayed();
    }
    public void moveToSignIn(){
        explicitWaitUntilVisible(signInButton,30);
        moveToElementNotClick(find(signInButton));

    }
    public void clickSignIn(){
        clickJS(signInButton);
    }

    public void setSignInButton(){
        moveToAllSettingsCard();
        isAllSettingsMenuDisplayed();
        moveToSignIn();
        clickSignIn();
    }
    public void moveToSignOut(){
        explicitWaitUntilVisible(signOutButton,30);
        moveToElementNotClick(find(signOutButton));

    }
    public void clickSignOut(){
        clickJS(signOutButton);
    }

    public void setSignOutButton(){
        moveToAllSettingsCard();
        isAllSettingsMenuDisplayed();
        moveToSignOut();
        clickSignOut();
    }

}
