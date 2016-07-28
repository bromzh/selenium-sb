package bo.spock

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class BoLoginPage {
    WebDriver driver

    @FindBy(tagName = "form")
    WebElement loginForm

    @FindBy(name = "username")
    WebElement usernameInput

    @FindBy(name = "password")
    WebElement passwordInput

    BoLoginPage(WebDriver driver) {
        this.driver = driver
        PageFactory.initElements driver, this
    }

    def login(String username, String password) {
        usernameInput.sendKeys(username)
        passwordInput.sendKeys(password)
        loginForm.submit()
    }

    def waitForResult(long timeout=10) {
        def wait = new WebDriverWait(driver, timeout)
        def oldUrl = driver.currentUrl
        wait.until ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl))
    }
}
