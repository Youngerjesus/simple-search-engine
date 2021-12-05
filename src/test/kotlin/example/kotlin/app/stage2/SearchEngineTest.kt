package example.kotlin.app.stage2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SearchEngineTest {

    @Test
    fun expandSearch() {
        //given
        val searchEngine = SearchEngine()
        val database = PersonDatabase()
        searchEngine.setDatabase(database)
        insertToSearchEngineWithTestData(searchEngine)
        val query = "ERICK"
        //when
        val personList: List<Person> = searchEngine.search(query)
        //then
        println(personList)
    }

    private fun insertToSearchEngineWithTestData(searchEngine: SearchEngine) {
        searchEngine.insert("Dwight Joseph djo@gmail.com")
        searchEngine.insert("Rene Webb webb@gmail.com")
        searchEngine.insert("Katie Jacobs")
        searchEngine.insert("Erick Harrington harrington@gmail.com")
        searchEngine.insert("Myrtle Medina")
        searchEngine.insert("Erick Burgess")
    }

}
