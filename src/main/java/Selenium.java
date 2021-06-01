import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium {
    public static final String SEARCH_BUTTON_BY_XPATH = "//*[@id=\"sb_form_go\"]";
    public static WebDriver browser; //susikureme globalu kintamaji

    public static void main(String[] args) { //eiluciu masyvas args - issitraukti is vartotojo parametrus; main
        System.out.println("Selenium + maven + junit");
//        setUp();
        //logIn();
//        search("Baranauskas");
        //getResults();
//        close();
    }

    public static void setUp() {
        //sujungiamas kodas su narsykle driveriu pagalba
        System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver91.exe");

        browser = new ChromeDriver();
        browser.get("https://www.linkedin.com/login/");
        browser.manage().window().maximize();
        browser.manage().deleteAllCookies();
    }

    public static void signUp() {
        WebElement username = browser.findElement(By.id("username"));
        WebElement password = browser.findElement(By.id("password"));
        WebElement signUp = browser.findElement(By.xpath("//button[text()='Sign in']"));
        username.sendKeys("email@email.com");
        password.sendKeys("exampleAboutSelenium123");
        JavascriptExecutor executor = (JavascriptExecutor) browser;
        executor.executeScript("arguments[0].click();", signUp); // elementas kuri norime kad paspaustu





    }


    public static void search(String keyword) {
        //siuo atveju unikalus web elemento identifikatorius surandamas pagal ID, bet galima naudoti ir kitus budus = By.name, By.className, By.xpath
        WebElement searchField = browser.findElement(By.id("sb_form_q"));
        //suradus elementa puslapyje, i ji irasomas paieskos raktinis zodis (pvz: Baranauskas)
        searchField.sendKeys(keyword);
        //irasius paieskos raktini zodi paspaudziamas enter mygtukas
        //searchField.sendKeys(Keys.ENTER);
//
        WebElement ele = browser.findElement(By.xpath(SEARCH_BUTTON_BY_XPATH));
        JavascriptExecutor executor = (JavascriptExecutor) browser;
        executor.executeScript("arguments[0].click();", ele); //ele yra tas lelemntas kuri norime kad paspaustu


//        WebDriverWait wait2 = new WebDriverWait(browser, 10);
//        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SEARCH_BUTTON_BY_XPATH)));
//        browser.findElement(By.xpath(SEARCH_bUTTON_BY_XPATH)).click();

//        WebDriverWait wait1 = new WebDriverWait(browser, 10);
//        WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(SEARCH_BUTTON_BY_PATH)));
//        element1.click();

    }

    public static int getResults(){
        //naudojamas reliatyvus kelias iki elemento
        WebElement result2 = browser.findElement(By.xpath("//*[@id=\"b_tween\"]/span"));

        String resultStr = result2.getText()
                .replaceAll("[a-zA-Z]", "")
                .replaceAll("[ ,]", "");
        //konvertuojame is string i int, nes mum sreikes palyginti rezultatus(i string telpa viskas, tiek skaiciai, tiek simboliai)
        int resultInt = Integer.parseInt(resultStr);
        return resultInt;
    }

    public static void close(){
        browser.close();
    }
}

