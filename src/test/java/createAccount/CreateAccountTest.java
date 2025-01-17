package createAccount;

import getTitle.BaseTest;
import org.testng.annotations.Test;

@Test
public class CreateAccountTest extends BaseTest {
    private String name = "your_name";
    private String phoneNumber = "phone_number";
    private String password = "password";

    public void setInformationInCreateAccount(){
        var createAccountPage = homePage.clickAccountsAndListsCard().clickCreateNewAccount();
        createAccountPage.setNameField(name);
        createAccountPage.setPhoneNumber(phoneNumber);
        createAccountPage.setPassword(password);
        createAccountPage.clickVerifyButton();
    }
}
