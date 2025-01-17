package signOut;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import signIn.SignInTest;

public class SignOutTest extends SignInTest {
    private By logo = By.xpath("//div[@id=\"nav-logo\"]//following::a[@id=\"nav-logo-sprites\"]");

    @Test
    public void signOutTest(){
        var allSettingsPage = homePage.clickAllSettingsCard();
        allSettingsPage.setSignOutButton();
    }

}
