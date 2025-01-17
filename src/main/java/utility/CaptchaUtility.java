package utility;

import java.util.Scanner;

public class CaptchaUtility extends Utility{
    public static void waitForCaptchaResolution(){
        System.out.println("CAPTCHA detected. Solve it manually, then press Enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("resuming");
        driver.quit();
    }

    public static void waitForAccountProtection(){
        try{
            System.out.println("Solve Puzzle detected. Solve it manually, then press enter to continue...");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }

    }
}
