package spock.geb

import geb.spock.GebSpec


class GoogleSearchGebSpec extends GebSpec {
    def "Go to index"() {
        when:
            go "/"
        then:
            title == "Google"
    }

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