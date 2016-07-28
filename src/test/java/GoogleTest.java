import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

import static org.junit.Assert.*;

public class GoogleTest {
    static WebDriver driver;

    @BeforeClass
    public static void connectDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        GoogleTest.driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.chrome());
    }

    @AfterClass
    public static void close() {
        GoogleTest.driver.quit();
    }

    @Before
    public void getPage() {
        driver.get("https://google.com");
    }

    @Test
    public void titleTest() {
        String title = driver.getTitle();
        assertEquals(title, "Google");
    }

    @Test
    public void searchTest() {
        WebElement q = driver.findElement(By.name("q"));
        q.sendKeys("Google");
        q.submit();

        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(presenceOfElementLocated(By.id("resultStats")));
//

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        assertEquals(title, "Google - Поиск в Google");
    }
}
