///* By Zhamiila*/
//package law.advisor;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class SeleniumTests {
//    static String baseURL = "http://localhost:8080/";
//
//    //############Sprint1############
//    /*Open site Test*/
//    public static boolean open(WebDriver driver) {
//        driver.get(baseURL);
//        if (!driver.getTitle().contentEquals("ОНЛАЙН ЮРИДИЧЕСКИЙ КОНСУЛЬТАНТ")) {
//            System.out.println("open failed");
//            return false;
//        }
//        return true;
//    }
//
//    /*Open Login page Test*/
//    public static boolean openLogin(WebDriver driver) {
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id='userbox']/div/a[1]")).click();
//
//        String expectedURL = "http://localhost:8080/login";
//        String actualURL = "";
//        actualURL = driver.getCurrentUrl();
//        if (actualURL.contentEquals(expectedURL)) {
//            return true;
//        } else {
//            System.out.println("openLogin failed");
//            return false;
//        }
//    }
//
//    /*Open Registration page Test*/
//    public static boolean openReg(WebDriver driver) {
//        String expectedURL = "http://localhost:8080/user/0/save";
//        String actualURL = "";
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id='userbox']/div/a[2]")).click();
//
//        actualURL = driver.getCurrentUrl();
//        if (actualURL.contentEquals(expectedURL)) {
//            return true;
//        } else {
//            System.out.println("openReg failed");
//            return false;
//        }
//    }
//
//    /* Return to home page by clicking logo Test*/
//    public static boolean homeLogo(WebDriver driver) {
//        String expectedURL = "http://localhost:8080/";
//        String actualURL = "";
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id='userbox']/div/a[1]")).click();
//        driver.findElement(By.xpath("/html/body/section/div/a/img")).click();
//        actualURL = driver.getCurrentUrl();
//        if (actualURL.contentEquals(expectedURL)) {
//            return true;
//        } else {
//            System.out.println("homeLogo failed");
//            return false;
//        }
//    }
//
//    /* Registration Test*/
//    public static boolean register(WebDriver driver) {
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id='userbox']/div/a[2]")).click();
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[1]/input")).sendKeys("selenium");
//        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("password");
//        driver.findElement(By.xpath("//*[@id=\"confirm\"]")).sendKeys("password");
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[4]/input")).sendKeys("zhamiila.kartanbaeva@iaau.edu.kg");
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[5]/input")).sendKeys("Selenium");
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[6]/input")).sendKeys("Test");
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[7]/input")).sendKeys("0700123456");
//        driver.findElement(By.xpath("//*[@id=\"optionsRadios2\"]")).click();
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/button")).click();
//        if (driver.getPageSource().contains("Selenium")){
//            return true;
//        } else {
//            System.out.println("failed register");
//            return false;
//        }
//    }
//
//    /*Login Test*/
//    public static boolean login(WebDriver driver) {
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id='userbox']/div/a[1]")).click();
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div/input")).sendKeys("user");
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[2]/div[2]/input")).sendKeys("123");
//        driver.findElement(By.xpath("//*[@id=\"RememberMe\"]")).click();
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[3]/div[2]/button[1]")).click();
//        if (driver.getCurrentUrl().contentEquals(baseURL)) {
//            return true;
//        } else {
//            System.out.println("failed login");
//            return false;
//        }
//    }
//
//    /*Login Lawyer Test*/
//    public static boolean loginLaw(WebDriver driver) {
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id='userbox']/div/a[1]")).click();
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div/input")).sendKeys("lawyer");
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[2]/div[2]/input")).sendKeys("123");
//        driver.findElement(By.xpath("//*[@id=\"RememberMe\"]")).click();
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[3]/div[2]/button[1]")).click();
//        if (driver.getCurrentUrl().contentEquals(baseURL)) {
//            return true;
//        } else {
//            System.out.println("failed loginLaw");
//            return false;
//        }
//    }
//
//    /*Login Admin Test*/
//    public static boolean loginAdm(WebDriver driver) {
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id='userbox']/div/a[1]")).click();
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div/input")).sendKeys("admin");
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[2]/div[2]/input")).sendKeys("123");
//        driver.findElement(By.xpath("//*[@id=\"RememberMe\"]")).click();
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[3]/div[2]/button[1]")).click();
//        if (driver.getCurrentUrl().contentEquals(baseURL)) {
//            return true;
//        } else {
//            System.out.println("failed loginAdm");
//            return false;
//        }
//    }
//
//    /*Login Test*/
//    public static boolean login3(WebDriver driver) {
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id='userbox']/div/a[1]")).click();
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div/input")).sendKeys("selenium");
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[2]/div[2]/input")).sendKeys("password");
//        driver.findElement(By.xpath("//*[@id=\"RememberMe\"]")).click();
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[3]/div[2]/button[1]")).click();
//        if (driver.getCurrentUrl().contentEquals(baseURL)) {
//            return true;
//        } else {
//            System.out.println("failed login");
//            return false;
//        }
//    }
//
//    /*Login Test*/
//    public static boolean login2(WebDriver driver) {
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id='userbox']/div/a[1]")).click();
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div/input")).sendKeys("jama");
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[2]/div[2]/input")).sendKeys("12345");
//        driver.findElement(By.xpath("//*[@id=\"RememberMe\"]")).click();
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[3]/div[2]/button[1]")).click();
//        if (driver.getCurrentUrl().contentEquals(baseURL)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    /*Open About Us page Test*/
//    public static boolean aboutUs(WebDriver driver) {
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[6]/a")).click();
//        if (driver.getCurrentUrl().contentEquals("http://localhost:8080/aboutus")) {
//            return true;
//        } else {
//            System.out.println("failed about us");
//            return false;
//        }
//    }
//
//    /*Open News page Test*/
//    public static boolean news(WebDriver driver) {
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[3]/a")).click();
//        if (driver.getCurrentUrl().contentEquals("http://localhost:8080/news")) {
//            return true;
//        } else {
//            System.out.println("failed news");
//            return false;
//        }
//    }
//
//    /*Open Reviews page Test*/
//    public static boolean reviews(WebDriver driver) {
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[7]/a")).click();
//        if (driver.getCurrentUrl().contentEquals("http://localhost:8080/reviews")) {
//            return true;
//        } else {
//            System.out.println("failed review");
//            return false;
//        }
//    }
//
//    /*Copyright Test*/
//    public static boolean copyright(WebDriver driver, String url) {
//        driver.get(url);
//        String expectedCopy = ":copyright: Copyright 2019 - All Rights Reserved";
//        String actualCopy = driver.findElement(By.xpath("/html/body/footer/div")).getText();
//        if (actualCopy.contentEquals(expectedCopy)) {
//            System.out.println(1);
//            return true;
//        } else {
//            System.out.println("failed copyright");
//            return false;
//        }
//    }
//
//    /*Delete Account Test*/
//    public static boolean deleteAcc(WebDriver driver) {
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id=\"userbox\"]/div")).click();
//        driver.findElement(By.xpath("//*[@id=\"userbox\"]/div/div/ul/li[2]/a")).click();
//        driver.findElement(By.xpath("/html/body/section/div/section/div[1]/div/div/div[2]/section/form/div/button")).click();
//        if (driver.getCurrentUrl().contentEquals(baseURL)) {
//            return true;
//        } else {
//            System.out.println("failed delete");
//            return false;
//        }
//    }
//
//    /*Reset password Test*/
//    public static boolean resetPassword(WebDriver driver) {
//        login(driver);
//        driver.findElement(By.xpath("//*[@id=\"userbox\"]/div")).click();
//        driver.findElement(By.xpath("//*[@id=\"userbox\"]/div/div/ul/li[2]/a")).click();
//        String expectedURL = driver.getCurrentUrl();
//        driver.findElement(By.xpath("/html/body/section/div/section/div[1]/div/div/div[1]/section/form/div/button")).click();
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div/input")).sendKeys("12345");
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[2]/div[2]/input")).sendKeys("password");
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[3]/div[2]/input")).sendKeys("password");
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[4]/div/button[1]")).click();
//        if (driver.getCurrentUrl().contentEquals(expectedURL)) {
//            return true;
//        } else {
//            System.out.println("change password failed");
//            return false;
//        }
//    }
//
//    /*Logout Test*/
//    public static boolean logout(WebDriver driver) {
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id=\"userbox\"]/div")).click();
//        driver.findElement(By.xpath("//*[@id=\"userbox\"]/div/div/ul/li[3]/a")).click();
//        if (driver.getCurrentUrl().contentEquals(baseURL)) {
//            return true;
//        } else {
//            System.out.println("failed logout");
//            return false;
//        }
//    }
//    //############End of Sprint1############
//
//    //############Sprint2############
//    /*Ask Question Test*/
//    public static boolean ask(WebDriver driver) {
//        driver.get(baseURL);
//        driver.findElement(By.xpath("/html/body/section/div/section/header/h2/a")).click();
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[1]/input")).sendKeys("Hello world");
//        driver.findElement(By.xpath("//*[@id=\"category.id\"]")).click();
//        driver.findElement(By.xpath("//*[@id=\"category.id\"]/option[2]")).click();
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[3]/textarea")).sendKeys("It's my question");
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/button")).click();
//        if (driver.getPageSource().contains("Вопрос")){
//            return true;
//        } else {
//            System.out.println("failed ask");
//            return false;
//        }
//    }
//
//    /*Open Lawyers Test*/
//    public static boolean openLawyers(WebDriver driver) {
//        driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[2]/a")).click();
//        if (driver.getCurrentUrl().contentEquals("http://localhost:8080/lawyer/list")) {
//            return true;
//        } else {
//            System.out.println("failed lawyer");
//            return false;
//        }
//    }
//
//    /*Use search bar Test*/
//    public static boolean search(WebDriver driver) {
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id=\"q\"]")).sendKeys("Hello");
//        driver.findElement(By.xpath("/html/body/section/header/div[2]/form/div/span/button")).click();
//        return driver.getCurrentUrl().contentEquals("http://localhost:8080/pages-search-results.html?q=Hello");
//    }
//
//
//    /*See Top 10 Lawyers Test*/
//    public static boolean top(WebDriver driver) {
//        driver.findElement(By.xpath("//*[@id=\"content\"]/section/header/div/div[2]/div/a[2]")).click();
//        if(driver.findElement(By.xpath("//*[@id=\"content\"]/section/header/div/div[1]/h2")).getText().contentEquals("Top Lawyers")){
//            return true;
//        } else{
//            System.out.println("top failed");
//            return false;
//        }
//    }
//
//    /*Add lawyer Test*/
//    public static boolean addLaw(WebDriver driver) {
//        openLawyers(driver);
//        driver.findElement(By.xpath("/html/body/section/div/section/header/h2/a")).click();
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[1]/input")).sendKeys("lawyer3");
//        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("123");
//        driver.findElement(By.xpath("//*[@id=\"confirm\"]")).sendKeys("123");
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[5]/input")).sendKeys("Alina");
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[6]/input")).sendKeys("Lawyer");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,500)");
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/button")).click();
//        openLawyers(driver);
//        if(driver.getPageSource().contains("Alina")) {
//            return true;
//        }else {
//            System.out.println("addLaw failed");
//            return false;
//        }
//    }
//
//    /*Delete lawyer Test*/
//    public static boolean deleteLaw(WebDriver driver) {
//        openLawyers(driver);
//        driver.findElement(By.xpath("//*[@id=\"content\"]/section/div/div/table/tbody/tr[2]/td[5]/a[2]/form/button")).click();
//        if(driver.getPageSource().contains("Whitelabel Error Page")) {
//            System.out.println("delete lawyer failed");
//            return false;
//        }else {
//            return true;
//        }
//    }
//    //############End of Sprint2############
//
//
//    //############Sprint3############
//    /*Answer Test*/
//    public static boolean answer(WebDriver driver) {
//        loginLaw(driver);
//        driver.get(baseURL);
//        driver.findElement(By.cssSelector("#content > ul > li > div > div:nth-child(1) > section > header > a > h2")).click();
//        driver.findElement(By.xpath("/html/body/section/div[2]/section/div[2]/div/section/header/a")).click();
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div/textarea")).sendKeys("It is answer");
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/button")).click();
//        if(driver.getPageSource().contains("Whitelabel Error Page")) {
//            System.out.println("mistake failed");
//            return false;
//        }else {
//            return true;
//        }
//    }
//
//    /*Leave review Test*/
//    public static boolean review(WebDriver driver) {
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[7]/a")).click();
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div[2]/form/section/div/div[1]/div[1]/input")).sendKeys("Alina");
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div[2]/form/section/div/div[1]/div[3]/input")).sendKeys("Zhakypova");
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div[2]/form/section/div/div[1]/div[5]/input")).sendKeys("alina@mail.ru");
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div[2]/form/section/div/div[2]/div/textarea")).sendKeys("My review");
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div[2]/form/section/footer/button")).click();
//        if(driver.getPageSource().contains("Whitelabel Error Page")) {
//            System.out.println("review failed");
//            return false;
//        }else {
//            return true;
//        }
//    }
//
//
//    /*Inform about mistake Test*/
//    public static boolean mistake(WebDriver driver) {
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[8]/a")).click();
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div[2]/form/section/div/div/div/textarea")).sendKeys("I have a mistake");
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div[2]/form/section/footer/button")).click();
//        if(driver.getPageSource().contains("Whitelabel Error Page")) {
//            System.out.println("mistake failed");
//            return false;
//        }else {
//            return true;
//        }
//    }
//
//    /*Status of questions Test*/
//    public static boolean status(WebDriver driver) {
//        driver.get(baseURL);
//        if (driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li/div/div[1]/section/div/div/div/div/div[3]/label")).getText().contentEquals("1")) {
//            return true;
//        } else {
//            System.out.println("status failed");
//            return false;
//        }
//    }
//
//    /*See date of question Test*/
//    public static boolean dateQuestion(WebDriver driver) {
//        driver.get(baseURL);
//        if (driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li/div/div[1]/section/div/div/div/div/div[5]/label")).getText().contentEquals("16-05-2019")) {
//            return true;
//        } else {
//            System.out.println("dateQuestion failed");
//            return false;
//        }
//
//    }
//
//    /*Put like to question Test*/
//    public static boolean putLike(WebDriver driver) {
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li/div/div[1]/section/div/div/div/div/div[1]/button")).click();
//        if(driver.findElement(By.xpath("//*[@id=\"totalLike\"]")).getText().contentEquals("0")){
//            return true;
//        }else {
//            System.out.println("putLike failed");
//            return false;
//        }    }
//    //############End of Sprint3############
//
//    //############Sprint4############
//
//    /*Give feedback Test*/
//    public static boolean feedback(WebDriver driver){
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[8]/a")).click();
//        driver.findElement(By.xpath("/html/body/section/div/section/div[2]/div[2]/form/section/div/div/div/textarea")).sendKeys("5");
//        driver.findElement(By.xpath("/html/body/section/div/section/div[2]/div[2]/form/section/footer/button")).click();
//        if(driver.getPageSource().contains("Whitelabel Error Page")) {
//            System.out.println("feedback failed");
//            return false;
//        }else {
//            return true;
//        }
//    }
//
//    /*See rate of answer for Lawyer Test*/
//    public static boolean helpful(WebDriver driver){
//        driver.get("http://localhost:8080/question/147/view");
//        if(driver.findElements(By.xpath("//*[@id=\"likea=149\"]")).size()!=0){
//            return true;
//        } else {
//            System.out.println("helpful failed");
//            return false;
//        }
//    }
//
//    /*Switch language Test*/
//    public static boolean languageEn(WebDriver driver){
//        driver.get(baseURL);
//        driver.findElement(By.linkText("АНГЛ")).click();
//        if(driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[1]/a/span")).getText().contentEquals("HOME")){
//            return true;
//        } else {
//            System.out.println("language failed");
//            return false;
//        }
//    }
//
//    /*Switch language Test*/
//    public static boolean languageKg(WebDriver driver){
//        driver.get(baseURL);
//        driver.findElement(By.linkText("КЫРГ")).click();
//        if(driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[1]/a/span")).getText().contentEquals("БАШКЫ БЕТ")){
//            return true;
//        } else {
//            System.out.println("language failed");
//            return false;
//        }
//    }
//
//    /*Switch language Test*/
//    public static boolean languageRu(WebDriver driver){
//        driver.get(baseURL);
//        driver.findElement(By.linkText("RU")).click();
//        if(driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[1]/a/span")).getText().contentEquals("ГЛАВНАЯ")){
//            return true;
//        } else {
//            System.out.println("languageRU failed");
//            return false;
//        }
//    }
//    //############End of Sprint4############
//
//    public static boolean registerlaw(WebDriver driver) {
//        driver.get(baseURL);
//        driver.findElement(By.linkText("Sign up!")).click();
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[1]/input")).sendKeys("begemotkyz");
//        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("123");
//        driver.findElement(By.xpath("//*[@id=\"confirm\"]")).sendKeys("123");
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[4]/input")).sendKeys("alina@mail.ru");
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[5]/input")).sendKeys("Alina");
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/div[6]/input")).sendKeys("Zhakypova");
//        driver.findElement(By.xpath("<input name=\"phone_number\" type=\"text\" class=\"form-control\" placeholder=\"Phone number\" value=\"\">")).sendKeys("0703673027");
//        driver.findElement(By.xpath("//*[@id=\"optionsRadios1\"]")).click();
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/button")).click();
//        if (!driver.getCurrentUrl().contentEquals(baseURL)) {
//            return true;
//
//        } else {
//            return false;
//        }
//    }
//    public static boolean menuhover (WebDriver driver){
//        driver.get(baseURL);
//        driver.findElement(By.xpath("/html/body/section/div/aside/div[1]/div[2]/i")).click();
//        if(driver.getCurrentUrl().contentEquals(baseURL)){
//            return true;
//        }else{
//            return false;
//        }
//    }
//    public static boolean editUser(WebDriver driver){
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id='userbox']/div/a[1]")).click();
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div/input")).sendKeys("user");
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[2]/div[2]/input")).sendKeys("123");
//        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[3]/div[2]/button[1]")).click();
//        driver.findElement(By.xpath("/html/body/section/header/div[2]/div/div")).click();
//        driver.findElement(By.xpath("/html/body/section/header/div[2]/div/div/div/ul/li[2]")).click();
//        driver.findElement(By.xpath("/html/body/section/div/section/div[1]/section[1]/div/div/div[2]/div[4]/a")).click();
//        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("1234");
//        driver.findElement(By.xpath("//*[@id=\"confirm\"]")).sendKeys("1234");
//        driver.findElement(By.xpath("/html/body/section/div/section/div/div/section/div/form/div/div/button")).click();
//        if(driver.getCurrentUrl().contentEquals("http://localhost:8080/user/12/view")){
//            return true;
//        }else {
//            return false;
//        }
//    }
//    public static void main(String[] args) {
//        System. setProperty("webdriver.chrome.driver", "D:\\AIU\\CS-306\\chromedriver_win32\\chromedriver.exe");
//        WebDriver dr = new ChromeDriver();
//        dr.manage().window().maximize();
//        try{open(dr);} catch (Exception e){ System.out.println("open ignored"); }
//        try{openReg(dr);} catch (Exception e){ System.out.println("openReg ignored"); }
//        try{openLogin(dr);} catch (Exception e){ System.out.println("openLogin ignored"); }
//        try{homeLogo(dr);} catch (Exception e){ System.out.println("homeLogo ignored"); }
//        try{login(dr);} catch (Exception e){ System.out.println("login ignored"); }
//        try{openLawyers(dr);} catch (Exception e){ System.out.println("openLawyer ignored"); }
//        try{top(dr);} catch (Exception e){ System.out.println("top ignored"); }
//        try{aboutUs(dr);} catch (Exception e){ System.out.println("aboutUs ignored"); }
//        try{news(dr);} catch (Exception e){ System.out.println("news ignored"); }
//        try{dateQuestion(dr);} catch (Exception e){ System.out.println("date ignored"); }
//        try{mistake(dr);} catch (Exception e){ System.out.println("mistake ignored"); }
//        try{reviews(dr);} catch (Exception e){ System.out.println("reviews ignored"); }
//        try{languageKg(dr);} catch (Exception e){ System.out.println("languageKG ignored"); }
//        try{languageEn(dr);} catch (Exception e){ System.out.println("laguageEn ignored"); }
//        try{languageRu(dr);} catch (Exception e){ System.out.println("laguageRu ignored"); }
//        try{logout(dr);} catch (Exception e){ System.out.println("logout ignored"); }
//        try{loginAdm(dr);} catch (Exception e){ System.out.println("loginAdm ignored"); }
//        try{addLaw(dr);} catch (Exception e){ System.out.println("addLaw ignored"); }
//        try{deleteLaw(dr);} catch (Exception e){ System.out.println("delLaw ignored"); }
//        try{logout(dr);} catch (Exception e){ System.out.println("logout ignored"); }
//        try{login2(dr);} catch (Exception e){ System.out.println("login ignored"); }
//        try{feedback(dr);} catch (Exception e){ System.out.println("feedback ignored"); }
//        try{review(dr);} catch (Exception e){ System.out.println("review ignored"); }
//        try{ask(dr);} catch (Exception e){ System.out.println("ask ignored"); }
//        try{logout(dr);} catch (Exception e){ System.out.println("logout ignored"); }
//        try{answer(dr);} catch (Exception e){ System.out.println("answer ignored"); }
//        try{logout(dr);} catch (Exception e){ System.out.println("logout ignored"); }
//        try{register(dr);} catch (Exception e){ System.out.println("register ignored"); }
//
//        try{login3(dr);} catch (Exception e){ System.out.println("login ignored"); }
//        try{editUser(dr);} catch (Exception e){ System.out.println("edit ignored"); }
//        try{menuhover(dr);} catch (Exception e){ System.out.println("menu ignored"); }
//        try{search(dr);} catch (Exception e){ System.out.println("search ignored"); }
//        try{copyright(dr, baseURL);} catch (Exception e){ System.out.println("copy ignored"); }
//        try{deleteAcc(dr);} catch (Exception e){ System.out.println("deleteAcc ignored"); }
//
//        dr.close();
//
//    }
//}
