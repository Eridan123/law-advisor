/*package com.example.opentravel.test;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import java.io.IOException;
public class Sprint1 {
    public static String uName = "Examp@mail.ru";
    public static String uName2 = "Exam2@mail.ru";
    public static String exUName="example@mail.ru";
    public static String pWord = "zzz123";
    public static String exname = "Example user";
    public static String exage = "21";
    public static String exabout = "Hello";
    public static String exlang = "RU KG TR UZ";
    public static String exexp = "0";
    public static String excount = "KG";
    public static String exBlogName = "KG";
    public static String exPlaceName = "kg1";
    public static String exBlogText = "te  Socialist Republics (USSRfd) as  15 constituent  Republic (SSR). The  under Soviet rule, and  became independent from the USSR in 1991. In 1993 the republic ratified its first post-Soviet constitution.";
    public static String exAdress="KG BISH";
    public static String baseUrl = "http://127.0.0.1:8080/";
    public static boolean checkTitle(WebDriver driver, String expTitle) {
        String title=driver.getTitle();
        if(!title.equals(expTitle)) {
            System.out.println("Fault: "+title+"-> " +expTitle);
            return false;
        }
        return true;
    }
    public static boolean regGID(WebDriver driver, Sprint1 sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Registration";
        driver.get(sp.baseUrl);
        driver.findElement(By.linkText("REGISTER")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }
        driver.findElement(By.linkText("GID")).click();
        driver.findElement(By.id("name")).sendKeys(sp.exname);
        driver.findElement(By.id("languages")).sendKeys(sp.exlang);
        driver.findElement(By.id("age")).sendKeys(sp.exage);
        driver.findElement(By.id("experience")).sendKeys(sp.exexp);
        driver.findElement(By.id("aboutMe")).sendKeys(sp.exabout);
        driver.findElement(By.id("email")).sendKeys(sp.uName);
        driver.findElement(By.id("password")).sendKeys(sp.pWord);
        driver.findElement(By.className(("login100-form-btn"))).click();
        Thread.sleep(10000);
        title = driver.getTitle();
        System.out.println(title);
        if (title.equals("Login")) {
            System.out.println("GID registration successful!!!");
            return true;
        }
        System.out.println("Failed in registration GID");
        return false;
    }
    public static boolean regTourist(WebDriver driver, Sprint1 sp) {
        String title = "";
        String expectedTitle = "Registration";
        driver.get(sp.baseUrl);
        driver.findElement(By.linkText("REGISTER")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }
        driver.findElement(By.linkText("Tourist")).click();
        driver.findElement(By.id("name")).sendKeys(sp.exname);
        driver.findElement(By.id("languages")).sendKeys(sp.exlang);
        driver.findElement(By.id("age")).sendKeys(sp.exage);
        driver.findElement(By.id("country")).sendKeys(sp.excount);
        driver.findElement(By.id("aboutMe")).sendKeys(sp.exabout);
        driver.findElement(By.id("email")).sendKeys(sp.uName2);
        driver.findElement(By.id("password")).sendKeys(sp.pWord);
        driver.findElement(By.className(("login100-form-btn"))).click();
        title = driver.getTitle();
        if (title.equals("Login")) {
            System.out.println("Tourist registration successful!!!");
            return true;
        }
        System.out.println("Failed in registration Tourist");
        return false;
    }
    public static boolean logIn(WebDriver driver, Sprint1 sp) {
        String title = "";
        String expectedTitle = "Login";
        driver.get(sp.baseUrl);
        driver.findElement(By.linkText("LOGIN")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }
        driver.findElement(By.id("email")).sendKeys(sp.exUName);
        driver.findElement(By.id("password")).sendKeys(sp.pWord);
        driver.findElement(By.className(("container-login100-form-btn"))).click();
        title = driver.getTitle();
        if (title.equals("Opentravel")) {
            System.out.println("Logged In!!!");
            return true;
        }
        System.out.println("Failed in Logging In");
        return false;
    }
    public static boolean USE2(WebDriver driver, Sprint1 sp) {
        String title = "";
        String expectedTitle = "Profile";
        driver.get(sp.baseUrl);
        driver.findElement(By.partialLinkText("@")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }
        System.out.println("User's Profile Done!!!");
        return true;
    }
    public static boolean BLO4(WebDriver driver, Sprint1 sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Profile";
        driver.get(sp.baseUrl);
        driver.findElement(By.partialLinkText("@")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }
        driver.findElement(By.cssSelector("a[href*='newBlog']")).click();
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.id("title")).sendKeys(sp.exBlogName);
        driver.findElement(By.id("text")).sendKeys(sp.exBlogText);
        Select categSel = new Select(driver.findElement(By.id("category")));
        categSel.selectByVisibleText("Nature");
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("input[value*='ADD BLOG']")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }
        System.out.println("Blog Created!!!");
        return true;
    }
    public static boolean BLO5(WebDriver driver, Sprint1 sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Profile";
        driver.get(sp.baseUrl);
        driver.findElement(By.partialLinkText("@")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }
        driver.findElement(By.linkText(sp.exBlogName)).click();
        title = driver.getTitle();
        if (!title.equals("Single Blog")) {
            System.out.println("Failed:" + title);
            return false;
        }
        Thread.sleep(3000);
        driver.findElement(By.className("btn-danger")).click();
        driver.findElement(By.partialLinkText("Delete")).click();
        title = driver.getTitle();
        if (!title.equals("Blogs")) {
            System.out.println("Failed:" + title);
            return false;
        }
        System.out.println("Blog Deleted!!!");
        return true;
    }
    public static boolean LUP6(WebDriver driver, Sprint1 sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Profile";
        driver.get(sp.baseUrl);
        driver.findElement(By.partialLinkText("@")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }
        driver.findElement(By.cssSelector("a[href*='newPlace']")).click();
        driver.findElement(By.id("title")).sendKeys(sp.exPlaceName);
        driver.findElement(By.id("address")).sendKeys(sp.exAdress);
        driver.findElement(By.id("text")).sendKeys(sp.exBlogText);
        Select categSel = new Select(driver.findElement(By.id("category")));
        categSel.selectByVisibleText("Nature");
        Thread.sleep(4000);
        driver.findElement(By.className("login100-form-btn")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }
        System.out.println("Place Created!!!");
        return true;
    }
    public static boolean LUP7(WebDriver driver, Sprint1 sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Profile";
        driver.get(sp.baseUrl);
        driver.findElement(By.partialLinkText("@")).click();
        driver.findElement(By.linkText(sp.exPlaceName)).click();
        title = driver.getTitle();
        if (!title.equals("Places")) {
            System.out.println("Failed:" + title);
            return false;
        }
        Thread.sleep(3000);
        driver.findElement(By.className("btn-danger")).click();
        driver.findElement(By.partialLinkText("Delete")).click();
        title = driver.getTitle();
        if (!title.equals("All Places")) {
            System.out.println("Failed:" + title);
            return false;
        }
        System.out.println("Place Deleted!!!");
        return true;
    }
    public static boolean LUP12(WebDriver driver, Sprint1 sp) {
        String expectedTitle = "Places";
        LUP1(driver, sp);
        driver.get("http://127.0.0.1:8080/placeInfo?id=52");
        if(checkTitle(driver,expectedTitle)==false){
            System.out.println("Fault in USE6");
            return false;
        }
        return true;
    }
    public static boolean BLO2(WebDriver driver, Sprint1 sp) {
        String expectedTitle = "Single Blog ";
        BLO1(driver, sp);
        driver.get("http://127.0.0.1:8080/blogInfo?id=53");
        if(checkTitle(driver,expectedTitle)==false){
            System.out.println("Fault in USE6");
            return false;
        }
        return true;
    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/home/student/Videos/geckodriver");
        WebDriver driver = new FirefoxDriver();
        Sprint1 sp = new Sprint1();
        boolean progress;
        /*progress = regGID(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }*/
      /*  progress = regTourist(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }/*
        progress = logIn(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }
        progress = USE2(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }
        progress = BLO4(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }
        progress = BLO5(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }
        progress = LUP6(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }
        progress = LUP7(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }*/
      /*  System.out.println("No fails found in Sprint 1");
        try {
            System.out.println("Please press Enter to continue...");
            System.in.read();
        } catch (IOException e) {}
        driver.close();
        System.exit(0);
    }
}*/
      /*package com.example.opentravel.test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;
public class Sprint2 {
    public static boolean REG5(WebDriver driver, Sprint1 sp) {
        String title = "";
        String expectedTitle = "About Us";
        Sprint1.BAU(driver,sp);
        driver.findElement(By.linkText("ABOUT US")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }
        return true;
    }
    public static boolean LUP4(WebDriver driver, Sprint1 sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Toktogul city";
        Sprint1.BAU(driver,sp);
        Sprint1.LUP1(driver, sp);
        driver.findElement(By.id("Layer_1")).click();
        driver.findElement(By.className("search_content_input")).sendKeys("Toktogul city");
        driver.findElement(By.className("search_content_input")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        title=driver.getTitle();
        System.out.println("Searching found");
        return true;
    }
    public static boolean LUP11(WebDriver driver, Sprint1 sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Opentravel";
        Sprint1.LUP6(driver, sp);
        Sprint1.BAU(driver, sp);
        driver.findElement(By.partialLinkText("@")).click();
        title = driver.getTitle();
        if (!title.equals("Profile")) {
            System.out.println("Failed:" + title);
            return false;
        }
        driver.findElement(By.linkText(sp.exPlaceName)).click();
        driver.findElement(By.linkText("UPDATE THE PLACE")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }
        driver.findElement(By.id("title")).sendKeys(sp.exPlaceName);
        driver.findElement(By.id("address")).sendKeys(sp.exAdress+"updated");
        driver.findElement(By.id("text")).sendKeys(sp.exBlogText+"updated");
        Select categSel = new Select(driver.findElement(By.id("category")));
        categSel.selectByVisibleText("Parks");
        driver.findElement(By.className("login100-form-btn"));
        title = driver.getTitle();
        if (!title.equals("Opentravel")) {
            System.out.println("Failed:" + title);
            return false;
        }
        System.out.println("Place Updated!!!");
        Sprint1.LUP7(driver, sp);
        return true;
    }
    public static boolean BLO3(WebDriver driver, Sprint1 sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Toktogul city";
        Sprint1.BAU(driver,sp);
        Sprint1.BLO1(driver, sp);
        driver.findElement(By.id("Layer_1")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("search_content_input")).sendKeys(expectedTitle+"\n");
        title=driver.getTitle();
        System.out.println("Searching found");
        return true;
    }
    public static boolean USE11(WebDriver driver, Sprint1 sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Nadyr Sultanov";
        Sprint1.BAU(driver,sp);
        Sprint1.USE1(driver, sp);
        driver.findElement(By.id("Layer_1")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("search_content_input")).sendKeys(expectedTitle+"\n");
        title=driver.getTitle();
        System.out.println("hehehe");
        WebElement el=driver.findElement(By.linkText("Nadyr Sultanov"));
        if(el==null) {
            System.out.println("Searching not found:"+title);
        }
        System.out.println("Searching found");
        return true;
    }
    public static boolean BLO6(WebDriver driver, Sprint1 sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Opentravel";
        Sprint1.BLO4(driver, sp);
        Sprint1.BAU(driver, sp);
        driver.findElement(By.partialLinkText("@")).click();
        title = driver.getTitle();
        if (!title.equals("Profile")) {
            System.out.println("Failed:" + title);
            return false;
        }
        driver.findElement(By.linkText(sp.exBlogName)).click();
        driver.findElement(By.linkText("UPDATE THE BLOG")).click();
        title = driver.getTitle();
        driver.findElement(By.id("text")).sendKeys(sp.exBlogText+"updated");
        Select categSel = new Select(driver.findElement(By.id("category")));
        categSel.selectByVisibleText("Parks");
        driver.findElement(By.cssSelector("input[value*='UPDATE']")).click();
        Sprint1.BLO5(driver, sp);
        title = driver.getTitle();
        if (!title.equals("Opentravel")) {
            System.out.println("Failed:" + title);
            return false;
        }
        System.out.println("Blog Updated!!!");
        return true;
    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\tanya\\Downloads\\programs\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        Sprint1 sp = new Sprint1();
        Sprint1.logIn(driver,sp);
        boolean progress;
        /*progress = LUP4(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }
        progress = LUP11(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }
        progress = REG5(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }
        progress = BLO3(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }
        progress = USE11(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }*/
        /*progress = LUP11(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }
        progress = BLO6(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }
        driver.close();
        System.exit(0);
    }
}*/
        /*package com.example.opentravel.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import weka.core.pmml.jaxbbindings.False;
import java.io.IOException;
public class Sprint3 {
    public static boolean USE6(WebDriver driver,Sprint1 sp) {
        String expectedTitle = "Profile";
        Sprint1.USE2(driver, sp);
        driver.findElement(By.linkText("UPDATE USER")).click();
        if(Sprint1.checkTitle(driver,"Update profile")==false){
            System.out.println("Fault in USE6");
            return false;
        }
        driver.findElement(By.id("name")).sendKeys(sp.exname+"updated");
        driver.findElement(By.id("languages")).sendKeys(sp.exlang+"updated");
        driver.findElement(By.id("age")).sendKeys(sp.exage);
        driver.findElement(By.id("experience")).sendKeys(sp.exexp);
        driver.findElement(By.id("aboutMe")).sendKeys(sp.exabout+"updated");
        driver.findElement(By.className("login100-form-btn")).click();
        if(Sprint1.checkTitle(driver,expectedTitle)==false){
            System.out.println("Fault in USE6");
            return false;
        }
        return true;
    }
    public static boolean USE7(WebDriver driver,Sprint1 sp) {
        String expectedTitle = "Opentravel";
        Sprint1.USE2(driver, sp);
        driver.findElement(By.className("btn-danger")).click();
        driver.findElement(By.linkText("Delete")).click();
        if(Sprint1.checkTitle(driver,"Login")==false){
            System.out.println("Fault in USE7");
            return false;
        }
        return true;
    }
    public static boolean NEW(WebDriver driver,Sprint1 sp) {
        String expectedTitle = "Opentravel";
        driver.findElement(By.linkText("HELP")).click();
        if(Sprint1.checkTitle(driver,"Opentravel")==false){
            System.out.println("Fault in USE7");
            return false;
        }
        return true;
    }
    public static boolean LUP5(WebDriver driver,Sprint1 sp) {
        String expectedTitle = "Places";
        Sprint1.LUP12(driver, sp);
        driver.findElement(By.id("comments")).sendKeys("Nice Place");
        driver.findElement(By.className("submit-btn")).click();
        if(Sprint1.checkTitle(driver,expectedTitle)==false){
            System.out.println("Fault in USE6");
            return false;
        }
        return true;
    }
    public static boolean BLO8(WebDriver driver,Sprint1 sp) {
        String expectedTitle = "Single Blog";
        Sprint1.BLO2(driver, sp);
        driver.findElement(By.id("comments")).sendKeys("Nice Blog");
        driver.findElement(By.className("submit-btn")).click();
        if(Sprint1.checkTitle(driver,expectedTitle)==false){
            System.out.println("Fault in USE6");
            return false;
        }
        return true;
    }
    public static boolean USE14(WebDriver driver,Sprint1 sp) {
        String expectedTitle = "Profile";
        Sprint1.USE2(driver, sp);
        driver.findElement(By.id("comments")).sendKeys("Nice Blog");
        driver.findElement(By.className("submit-btn")).click();
        if(Sprint1.checkTitle(driver,expectedTitle)==false){
            System.out.println("Fault in USE6");
            return false;
        }
        return true;
    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\tanya\\Downloads\\programs\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        Sprint1 sp = new Sprint1();
        boolean progress;
        Sprint1.BAU(driver,sp);
        Sprint1.logIn(driver,sp);
        progress = USE6(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
        }
        progress = USE6(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
        }
        progress = NEW(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
        }
        progress = LUP5(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
        }
        progress = BLO8(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
        }
        progress = USE14(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
        }
        /*progress = USE6(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
        }*/
