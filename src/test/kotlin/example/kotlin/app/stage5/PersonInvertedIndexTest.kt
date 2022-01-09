package example.kotlin.app.stage5

import example.kotlin.app.stage2.Person
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PersonInvertedIndexTest {

    @Test
    fun inverted_index_를_통한_검색_기능_테스트() {
        //given
        assertSearchFromInvertedIndex(
            Person("first", "last", "email@gmai.com"),
            "first"
        )

        assertSearchFromInvertedIndex(
            Person("first", "last", "email@gmai.com"),
            "last"
        )

        assertSearchFromInvertedIndex(
            Person("first", "last", "email@gmai.com"),
            "email@gmai.com"
        )
    }

    private fun assertSearchFromInvertedIndex(person: Person, query: String) {
        val personInvertedIndex = PersonInvertedIndex()
        personInvertedIndex.add(person)
        //when
        val findPersons: List<Person> = personInvertedIndex.get(query)
        //then
        assertFalse(findPersons.isEmpty())
        assertTrue(findPersons.contains(person))
    }
}

