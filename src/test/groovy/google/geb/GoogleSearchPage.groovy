package google.geb

import geb.Page

class GoogleSearchPage extends Page {
    static url = "https://google.com"
    static at = { title == "Google" }

    static content = {
        searchField { $("input[name=q]") }
        searchForm { $("form[name=f]").firstElement() }
        searchResult { $("#resultStats") }
    }

    void search(String searchTerm) {
        searchField.value searchTerm
        searchForm.submit()
        waitFor { searchResult.present }
    }
}
