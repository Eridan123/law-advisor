/* By Zhamiila*/
package law.advisor;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sprint1 {
    static String baseURL = "http://localhost:8080/";
    WebDriver driver=new ChromeDriver();
    /*Open Login page Test*/
    public static boolean openLogin(WebDriver driver){
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id='userbox']/div/a[1]")).click();
        String expectedURL = "http://localhost:8080/login";
        String actualURL = "";
        actualURL = driver.getCurrentUrl();
        if (actualURL.contentEquals(expectedURL)){
            System.out.println(1);
            return true;
        } else {
            System.out.println("Failed :"+driver.getCurrentUrl());
            System.out.println(0);
            return false;
        }
    }

    /*Open Registration page Test*/
    public static boolean openReg(WebDriver driver){
        String expectedURL = "http://localhost:8080/user/0/save";
        String actualURL = "";
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id='userbox']/div/a[2]")).click();
        actualURL = driver.getCurrentUrl();
        if (actualURL.contentEquals(expectedURL)){
            System.out.println(1);
            return true;
        } else {
            System.out.println("Failed :"+driver.getCurrentUrl());
            return false;
        }
    }

    /* Return to home page by clicking logo Test*/
    public static boolean homeLogo(WebDriver driver){
        String expectedURL = "http://localhost:8080/";
        String actualURL = "";
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id='userbox']/div/a[1]")).click();
        driver.findElement(By.xpath("/html/body/section/div/a/img")).click();
        actualURL = driver.getCurrentUrl();
        if(actualURL.contentEquals(expectedURL)){
            System.out.println(1);
            return true;
        } else {
            System.out.println("Failed :"+driver.getCurrentUrl());
            return false;
        }
    }

    /* Registration Test*/
    public static boolean register(WebDriver driver){
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id='userbox']/div/a[2]")).click();
        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[1]/input")).sendKeys("selenium");
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("password");
        driver.findElement(By.xpath("//*[@id=\"confirm\"]")).sendKeys("password");
        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[4]/input")).sendKeys("jama.98.kjk@gmail.com");
        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[5]/input")).sendKeys("Selenium");
        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[6]/input")).sendKeys("Test");
        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[7]/input")).sendKeys("0700123456");
        driver.findElement(By.xpath("//*[@id=\"optionsRadios2\"]")).click();
        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/button")).click();
        if(driver.getCurrentUrl().contentEquals(baseURL)){
            System.out.println(1);
            return true;
        }else{
            System.out.println("Failed :"+driver.getCurrentUrl());
            return false;
        }
    }

    /*Open register page from login page Test*/
    public static boolean openReg2(WebDriver driver){
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id=\"userbox\"]/div/a[1]")).click();
        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/p/a")).click();
        if(driver.getCurrentUrl().contentEquals("http://localhost:8080/user/0/save")) {
            System.out.println(1);
            return true;
        } else {
            System.out.println("Failed :"+driver.getCurrentUrl());
            return false;
        }

    }

    /*Login Test*/
    public static boolean login(WebDriver driver){
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id='userbox']/div/a[1]")).click();
        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div/input")).sendKeys("selenium");
        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[2]/div[2]/input")).sendKeys("password");
        driver.findElement(By.xpath("//*[@id=\"RememberMe\"]")).click();
        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[3]/div[2]/button[1]")).click();
        if(driver.getCurrentUrl().contentEquals(baseURL)){
            System.out.println(1);
            return true;
        }else {
            System.out.println(0);
            return false;
        }
    }

    /*Login with Facebook Test*/
    public static boolean loginFacebook(WebDriver driver){
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id='userbox']/div/a[1]")).click();
        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[4]/a[1]")).click();
        System.out.println(0);
        return false;
    }

    /*Login with Tweeter Test*/
    public static boolean loginTweeter(WebDriver driver){
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id='userbox']/div/a[1]")).click();
        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[4]/a[2]")).click();
        System.out.println(0);
        return false;
    }

    /*Open About Us page Test*/
    public static boolean aboutUs(WebDriver driver){
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[5]/a")).click();
        if(driver.getCurrentUrl().contentEquals("http://localhost:8080/aboutus")){
            System.out.println(1);
            return true;
        }else {
            System.out.println(0);
            return false;
        }
    }

    /*Open News page Test*/
    public static boolean news(WebDriver driver){
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[2]/a")).click();
        if(driver.getCurrentUrl().contentEquals("http://localhost:8080/news")){
            System.out.println(1);
            return true;
        }else {
            System.out.println(0);
            return false;
        }
    }
    
    /*Copyright Test*/
    public static boolean copyright(WebDriver driver, String url){
        driver.get(url);
        String expectedCopy = ":copyright: Copyright 2019 - All Rights Reserved";
        String actualCopy = driver.findElement(By.xpath("/html/body/footer/div")).getText();
        if(actualCopy.contentEquals(expectedCopy)){
            System.out.println(1);
            return true;
        } else {
            System.out.println(0);
            return false;
        }
    }
    
    /*Delete Account Test*/
    public static boolean deleteAcc(WebDriver driver){
        login(driver);
        driver.findElement(By.xpath("//*[@id=\"userbox\"]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"userbox\"]/div/div/ul/li[2]/a")).click();
        driver.findElement(By.xpath("/html/body/section/div/section/div[1]/div/div/div/section/form/div/button")).click();
        if(driver.getCurrentUrl().contentEquals(baseURL)){
            System.out.println(1);
            return true;
        } else {
            System.out.println(0);
            return false;
        }
    }
    
    /*Reset password Test*/
    public static boolean resetPassword(WebDriver driver){
        driver.findElement(By.xpath("//*[@id=\"userbox\"]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"userbox\"]/div/div/ul/li[2]/a")).click();
        driver.findElement(By.xpath("/html/body/section/div/section/div[1]/section[1]/div/div/div[2]/div[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("newpassword");
        driver.findElement(By.xpath("//*[@id=\"confirm\"]")).sendKeys("newpassword");
        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/button")).click();
        if(driver.getCurrentUrl().contentEquals("http://localhost:8080/user/31/view")){
            System.out.println(1);
            return true;
        } else {
            System.out.println(0);
            return false;
        }
    }
}
