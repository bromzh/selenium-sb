import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

System.setProperty "webdriver.chrome.driver", "/usr/bin/chromedriver"
def remoteDriverUrl = new URL("http://localhost:4444/wd/hub")

waiting {
    timeout = 10
}

driver = { new RemoteWebDriver(remoteDriverUrl, DesiredCapabilities.chrome()) }
baseUrl = "https://google.com"
atCheckWaiting = true

//environments {
//
//    // run via “./gradlew chromeTest”
//    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
//    chrome {
//        driver = { new RemoteWebDriver(remoteDriverUrl, DesiredCapabilities.chrome()) }
//    }
//
//    // run via “./gradlew firefoxTest”
//    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
//    firefox {
//        driver = { new RemoteWebDriver(remoteDriverUrl, DesiredCapabilities.firefox()) }
//    }
//}

// To run the tests with all browsers just run “./gradlew test”

