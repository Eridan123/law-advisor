package law.advisor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sprint2 {
    static String baseURL = "http://localhost:8080/";

    /*Ask Question Test*/
    public static boolean ask(WebDriver driver){
        driver.findElement(By.xpath("/html/body/section/div/section/header/h2/a")).click();
        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[1]/input")).sendKeys("Hello world");
        driver.findElement(By.xpath("//*[@id=\"category.id\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"category.id\"]/option[2]")).click();
        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[3]/textarea")).sendKeys("It's my question");
        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/button")).click();
        if(driver.getTitle().contentEquals("Question View")){
            System.out.println(1);
            return true;
        } else{
            System.out.println("failed ask");
            return false;
        }
    }

    /*Open Lawyers Test*/
    public static boolean openLawyers(WebDriver driver){
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[2]/a")).click();
        if(!driver.getTitle().contentEquals("Lawyers")){
            System.out.println("title failed");
        }
        if(driver.getCurrentUrl().contentEquals("http://localhost:8080/lawyer/list")){
            System.out.println(1);
            return true;
        } else {
            System.out.println("failed lawyer");
            return false;
        }
    }


}
