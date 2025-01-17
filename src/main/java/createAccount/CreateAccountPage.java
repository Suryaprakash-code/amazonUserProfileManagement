package createAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static utility.ActionsUtility.sendKeys;
import static utility.JavaScriptUtility.scrollToElementJS;

public class CreateAccountPage extends AccountsAndListsPage{
    private By nameField = By.xpath("//input[@id=\"ap_customer_name\"]");
    public void setNameField(String name){
        sendKeys(find(nameField), name);
    }

    private By phoneNumberField = By.xpath("//input[@id=\"ap_phone_number\"]");
    public void setPhoneNumber(String phoneNumber){
        sendKeys(find(phoneNumberField),Keys.chord(phoneNumber));
    }


    public void setPassword(String password){
        setPhoneNumber(Keys.chord(Keys.TAB,password));
    }


    private By verifyButton = By.xpath("//input[@id=\"continue\"]");
    public void clickVerifyButton(){
        scrollToElementJS(verifyButton);
        click(verifyButton);
    }

    private By solvePuzzleHeading = By.xpath("//span[starts-with(text(),\"Solve this puzzle\")]");
    public boolean isSolvePuzzleDisplayed(){
        return find(solvePuzzleHeading).isDisplayed();
    }
}
