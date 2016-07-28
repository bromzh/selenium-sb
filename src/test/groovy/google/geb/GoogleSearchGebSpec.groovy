package google.geb

import geb.spock.GebSpec

class GoogleSearchGebSpec extends GebSpec {
    def "Search #query"(String query) {
        setup:
            to GoogleSearchPage
            search query
        expect:
            title == "${query} - Поиск в Google" as String
        where:
            query << ["Google", "Selenium"]
    }
}