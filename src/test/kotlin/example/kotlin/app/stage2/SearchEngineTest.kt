package example.kotlin.app.stage2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SearchEngineTest {

    @Test
    fun 검색엔진에_저장되어_있는_모든_사람들_조회() {
        assertFindAll(
            SearchEngine(),
            "Dwight Joseph djo@gmail.com",
            "Rene Webb webb@gmail.com",
            "Katie Jacobs"
        )

        assertFindAll(
            SearchEngine(),
            "Erick Harrington harrington@gmail.com",
            "Myrtle Medina",
            "Erick Burgess"
        )
    }

    private fun assertFindAll(searchEngine: SearchEngine, vararg persons: String) {
        persons.forEach { person -> searchEngine.insert(person) }
        //when
        val allPeople = searchEngine.findAll()
                                    .map { person -> person.toString()}
        //then
        persons.forEach{ person -> assertTrue(allPeople.contains(person)) }
    }
}
