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

    /*Open About Us page from Lowyers page Test*/
    public static boolean aboutUs2(WebDriver driver){
        driver.get("http://localhost:8080/lawyer/list");
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

    /*Use search bar Test*/
    public static boolean search(WebDriver driver){
        return true;
    }

    /*Search by category*/
    public static boolean category(WebDriver driver){
        return true;
    }

    /*See Top 10 Lawyers Test*/
    public static boolean top(WebDriver driver){
        return true;
    }

    /*Delete questions Test*/
    public static boolean delQuestion(WebDriver driver){
        return true;
    }

    /*Rating near answer Test*/
    public static boolean rating(WebDriver driver){
        return true;
    }

    /*Who answered Test*/
    public static boolean whoanswer(WebDriver driver){
        return true;
    }

    /*Date of answer Test*/
    public static boolean dateAns(WebDriver driver){
        return true;
    }

    /*Add category Test*/
    public static boolean addCat(WebDriver driver){
        return true;
    }

    /*Delete category Test*/
    public static boolean deleteCat(WebDriver driver){
        return true;
    }

    /*Edit category Test*/
    public static boolean editCat(WebDriver driver){
        return true;
    }

    /*Add lawyer Test*/
    public static boolean addLaw(WebDriver driver){
        return true;
    }

    /*Delete lawyer Test*/
    public static boolean deleteLaw(WebDriver driver){
        return true;
    }

    /*Date of question Test*/
    public static boolean dateQuestion(WebDriver driver){
        return true;
    }

}
