package spock.pure

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

public class GoogleSearchPage {
    WebDriver driver

    @FindBy(name = "q")
    WebElement q

    GoogleSearchPage(WebDriver driver) {
        this.driver = driver
        PageFactory.initElements driver, this
    }

    void searchFor(String text) {
        q.sendKeys(text);
        q.submit();
    }

    void waitForResult(long timeout = 10) {
        def waiter = new WebDriverWait(driver, timeout);
        waiter.until ExpectedConditions.presenceOfElementLocated(By.id("resultStats"))
    }
}
