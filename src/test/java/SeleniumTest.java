import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {
    @BeforeTest
    public void setUp() {
        Selenium.setUp();
    }

    @Test(priority = 1)
    public void signUp(){
        Selenium.signUp();
        Assert.assertEquals("https://www.linkedin.com/Feed/", Selenium.browser.getCurrentUrl());
    }

    @Test(priority=2)
    public void searchByKeywordTest() {
        Selenium.search("");
    }

    @Test(priority=3)
    public void getResults(){
        Selenium.search("Baranauskas");
        Assert.assertEquals(Selenium.getResults(), 193000);
        Selenium.getResults();
    }

    @AfterTest
    public void close(){
        Selenium.close();
    }
}

