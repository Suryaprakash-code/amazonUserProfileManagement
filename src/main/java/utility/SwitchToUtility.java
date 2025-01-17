package utility;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class SwitchToUtility extends Utility{

    private static WebDriver.TargetLocator switchTo(){
        return driver.switchTo();
    }
    public static void switchToWindow(String handle){
        switchTo().window(handle);
    }

    public static void switchToNewWindow(){
        String currentHandle = driver.getWindowHandle();
        System.out.println("Main Window Id: "+ currentHandle + "\n" );

        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("# of open windows: "+allHandles.size());

        for(String handle:allHandles){
            if(currentHandle.equals(handle)){
                System.out.println("1st window id: "+ handle);
            }else{
                switchToWindow(handle);
                System.out.println("2nd window handle: "+handle);
            }
        }
    }

}
