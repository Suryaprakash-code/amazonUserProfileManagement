package createAccount;

import getTitle.HomePage;
import org.openqa.selenium.By;

import static utility.ActionsUtility.sendKeys;
import static utility.JavaScriptUtility.clickJS;
import static utility.WaitUtility.explicitWaitUntilVisible;

public class AccountsAndListsPage extends HomePage {

    private By createNewAccount = By.xpath("//a[@id=\"createAccountSubmit\"]");
    public CreateAccountPage clickCreateNewAccount(){
        clickJS(createNewAccount);
        return new CreateAccountPage();
    }


    private By phoneNumberField = By.xpath("//input[@id=\"ap_email\"]");
    public void setPhoneNumber(String phoneNumber){
        sendKeys(find(phoneNumberField),phoneNumber);
    }

    private By continueButton = By.xpath("//input[@id=\"continue\"]");
    public void clickContinue(){
        click(continueButton);
    }

    private By getOtp = By.xpath("//input[@id=\"continue\"]");
    public void clickGetOtp(){
        explicitWaitUntilVisible(getOtp,5);
        click(getOtp);
    }

}
