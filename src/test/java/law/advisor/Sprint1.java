/* By Zhamiila*/
package law.advisor;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sprint1 {
    static String baseURL = "http://localhost:8080/";
    /*Open site Test*/
    public static boolean open(WebDriver driver){
        driver.get(baseURL);
        if(!driver.getTitle().contentEquals("Online Law Consultant")){
            System.out.println("open failed");
            return false;
        }
        return true;
    }

    /*Open Login page Test*/
    public static boolean openLogin(WebDriver driver){
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id='userbox']/div/a[1]")).click();
        if(!driver.getTitle().contentEquals("Login")){
            System.out.println("title failed");
        }
        String expectedURL = "http://localhost:8080/login";
        String actualURL = "";
        actualURL = driver.getCurrentUrl();
        if (actualURL.contentEquals(expectedURL)){
            System.out.println(1);
            return true;
        } else {
            System.out.println("Failed open login :"+driver.getCurrentUrl());
            return false;
        }
    }

    /*Open Registration page Test*/
    public static boolean openReg(WebDriver driver){
        String expectedURL = "http://localhost:8080/user/0/save";
        String actualURL = "";
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id='userbox']/div/a[2]")).click();
        if(!driver.getTitle().contentEquals("Registration")){
            System.out.println("title failed");
        }
        actualURL = driver.getCurrentUrl();
        if (actualURL.contentEquals(expectedURL)){
            System.out.println(1);
            return true;
        } else {
            System.out.println("Failed open register:"+driver.getCurrentUrl());
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
            System.out.println("Failed home logo :"+driver.getCurrentUrl());
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
        if(!driver.getCurrentUrl().contentEquals(baseURL)){
            System.out.println(1);
            return true;
        }else{
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
        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div/input")).sendKeys("zhamiila.kartanbaeva");
        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[2]/div[2]/input")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@id=\"RememberMe\"]")).click();
        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[3]/div[2]/button[1]")).click();
        if(driver.getCurrentUrl().contentEquals(baseURL)){
            System.out.println(1);
            return true;
        }else {
            System.out.println( "failed login");
            return false;
        }
    }

    /*Login Test*/
    public static boolean login2(WebDriver driver){
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id='userbox']/div/a[1]")).click();
        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div/input")).sendKeys("alina");
        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[2]/div[2]/input")).sendKeys("12345");
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
        driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[6]/a")).click();
        if(!driver.getTitle().contentEquals("About Us")){
            System.out.println("title failed");
        }
        if(driver.getCurrentUrl().contentEquals("http://localhost:8080/aboutus")){
            System.out.println(1);
            return true;
        }else {
            System.out.println("failed about us");
            return false;
        }
    }

    /*Open News page Test*/
    public static boolean news(WebDriver driver){
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[3]/a")).click();
        if(!driver.getTitle().contentEquals("News")){
            System.out.println("title failed");
        }
        if(driver.getCurrentUrl().contentEquals("http://localhost:8080/news")){
            System.out.println(1);
            return true;
        }else {
            System.out.println("failed news");
            return false;
        }
    }

    /*Open News page Test*/
    public static boolean reviews(WebDriver driver){
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[7]/a")).click();
        if(!driver.getTitle().contentEquals("Reviews")){
            System.out.println("title failed");
        }
        if(driver.getCurrentUrl().contentEquals("http://localhost:8080/reviews")){
            System.out.println(1);
            return true;
        }else {
            System.out.println("failed review");
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
            System.out.println("failed copyright");
            return false;
        }
    }
    
    /*Delete Account Test*/
    public static boolean deleteAcc(WebDriver driver){
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id=\"userbox\"]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"userbox\"]/div/div/ul/li[2]/a")).click();
        driver.findElement(By.xpath("/html/body/section/div/section/div[1]/div/div/div[2]/section/form/div/button")).click();
        if(driver.getCurrentUrl().contentEquals(baseURL)){
            System.out.println(1);
            return true;
        } else {
            System.out.println("failed delete");
            return false;
        }
    }
    
    /*Reset password Test*/
    public static boolean resetPassword(WebDriver driver){
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id=\"userbox\"]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"userbox\"]/div/div/ul/li[2]/a")).click();
        driver.findElement(By.xpath("/html/body/section/div/section/div[1]/div/div/div[1]/section/form/div/button")).click();
        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div/input")).sendKeys("12345");
        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[2]/div[2]/input")).sendKeys("password");
        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[3]/div[2]/input")).sendKeys("password");
        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[4]/div/button[1]")).click();
        if(driver.getCurrentUrl().contentEquals("http://localhost:8080/user/57/view")){
            System.out.println(1);
            return true;
        } else {
            System.out.println(0);
            return false;
        }
    }
    
    /*Logout Test*/
    public static boolean logout(WebDriver driver){
        driver.findElement(By.xpath("//*[@id=\"userbox\"]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"userbox\"]/div/div/ul/li[3]/a")).click();
        if(driver.getCurrentUrl().contentEquals(baseURL)){
            System.out.println(1);
            return true;
        } else {
            System.out.println("failed logout");
            return false;
        }
    }



}
