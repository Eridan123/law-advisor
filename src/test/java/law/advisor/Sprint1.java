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
            return true;
        } else {
            System.out.println("Failed :"+driver.getCurrentUrl());
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
            return true;
        }else{
            System.out.println("Failed :"+driver.getCurrentUrl());
            return false;
        }

    }
}
