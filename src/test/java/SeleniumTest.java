import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class SeleniumTest {
    @Before
    public void setUp() {
        Selenium.setUp();
    }

    @Test
    @Order(1)
    public void searchByKeywordTest() {
        Selenium.search("Baranauskas");
    }

    @Test
    @Order(2)
    public void getResults(){
        Selenium.search("Baranauskas");
        Assert.assertEquals(192000, Selenium.getResults());
        Selenium.getResults();
    }

    @After
    public void close(){
        Selenium.close();
    }
}

