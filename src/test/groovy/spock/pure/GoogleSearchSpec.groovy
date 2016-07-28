package spock.pure

import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import spock.lang.Unroll

//import org.openqa.selenium.support.
import spock.lang.Shared
import spock.lang.Specification


class GoogleSearchSpec extends Specification {
    @Shared WebDriver driver

    @Shared GoogleSearchPage page

    def setupSpec() {
        System.setProperty "webdriver.chrome.driver", "/usr/bin/chromedriver"
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome())
        page = new GoogleSearchPage(driver)
    }

    def cleanupSpec() {
        driver.quit()
    }

    def "Title must be 'Google'"() {
        when:
            driver.get "https://google.com"
        then:
            driver.title == "Google"
    }

    @Unroll
    def "Searching #query"(String query) {
        setup:
            driver.get "https://google.com"
            page.searchFor query
            page.waitForResult()
        expect:
            driver.title == "${query} - Поиск в Google" as String
        where:
            query << ["Google", "Yandex", "Selenium"]
    }
}