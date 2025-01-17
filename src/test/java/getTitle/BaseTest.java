package getTitle;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

import static utility.Utility.setUtilityDriver;
import static utility.WaitUtility.explicitWaitUntilVisible;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    private By logo = By.xpath("//div[@id=\"nav-logo\"]//following::a[@id=\"nav-logo-sprites\"]");

    private String URL = "https://www.amazon.in/";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @BeforeMethod
    public void load() {
        driver.get(URL);

        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtilityDriver();
        homePage = new HomePage();

        captchaTest();

    }


    @AfterMethod
    public void takeFailedResultScreenshot(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshots/(" +
                    java.time.LocalDate.now() +
                    testResult.getName() + ".png");
            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Screenshot located at:" + destination);
        }
    }

    @AfterClass
    public void tearUp(){
        if(driver!=null) {
            driver.quit();
        }
    }
    private By captcha = By.xpath("//div[@class=\"a-box\"]//img");
    private boolean isCaptchaDisplayed(){
        return driver.findElement(captcha).isDisplayed();
    }
    public void captchaTest(){
        try{
            if(isCaptchaDisplayed()) {
                JOptionPane.showMessageDialog(null, "perform and ok to continue");
                explicitWaitUntilVisible(logo,30);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}