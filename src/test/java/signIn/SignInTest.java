package signIn;

import getTitle.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import javax.swing.*;

import static utility.WaitUtility.explicitWaitUntilVisible;

public class SignInTest extends BaseTest {
    private By logo = By.xpath("//div[@id=\"nav-logo\"]//following::a[@id=\"nav-logo-sprites\"]");
    private String countryCode= "+91";
    private String phoneNumber ="your_number";
    @Test
    public void signINTests(){
        var signInPage = homePage.clickAccountsAndListsCard();
        signInPage.setPhoneNumber(countryCode+" "+phoneNumber);
        signInPage.clickContinue();
        signInPage.clickGetOtp();
        JOptionPane.showMessageDialog(null,"perform and ok to continue");
        explicitWaitUntilVisible(logo,30);
        signInPage.getTitle("aria-label");
    }
}
