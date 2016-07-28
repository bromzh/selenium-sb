package bo.geb

import geb.Page

class BoRootPage extends Page {
    static at = { pageUrl == "/" }

//    waitForRedirect() {
//        def oldUrl = pageUrl
//        waitFor {  }
//    }
}

class BoLoginPage extends Page {
    static at = { pageUrl == "/login" }
}
