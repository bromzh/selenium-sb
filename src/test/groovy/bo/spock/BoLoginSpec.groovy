package bo.spock

import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import spock.lang.Shared
import spock.lang.Specification

class BoLoginSpec extends Specification {
    @Shared WebDriver driver
    @Shared BoLoginPage page

    def username = "Flotiliya"
    def password = "test"

    def setupSpec() {
        System.setProperty "webdriver.chrome.driver", "/usr/bin/chromedriver"
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome())
        page = new BoLoginPage(driver)
    }

    def cleanupSpec() {
        driver.quit()
    }

    def cleanup() {
        driver.manage().deleteAllCookies()
    }

    def "Must redirect to login page"() {
        when:
            driver.get("http://localhost:3000")
            def oldUrl = driver.currentUrl
            def wait = new WebDriverWait(driver, 10)
            wait.until ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl))
        then:
            driver.currentUrl == "http://localhost:3000/login"
    }

    def "Must redirect to home after log in"() {
        when:
            driver.get("http://localhost:3000/login")
            page.login username, password
            page.waitForResult()
        then:
            driver.currentUrl.contains "/home"
    }
}