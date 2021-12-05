package example.kotlin.app.stage2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class PersonDatabaseTest {

    @Test fun 데이터베이스에_사람_추가() {
        //given
        val database = PersonDatabase()
        //when
        database.insert(Person("first", "last", ""))
        //then
    }

    @Test fun fistName_으로_데이터베이스에서_조회하기() {
        //given
        val database = PersonDatabase()
        val person = insertToDatabase(database, "Dwight Joseph djo@gmail.com")
        //when
        val findPersons: List<Person> = database.getPerson(person.firstName)
        //then
        assertEquals(person, findPersons[0])
    }

    @Test fun firstName_으로_데이터베이스에서_여러값들_조회하기() {
        //given
        val database = PersonDatabase()
        val personList = mutableListOf<Person>()
        personList.add(
            insertToDatabase(database, "Erick Harrington harrington@gmail.com")
        )
        personList.add(
            insertToDatabase(database, "Erick Burgess")
        )
        //when
        val findPerson: List<Person> = database.getPerson("Erick")
        //then
        assertEquals(personList, findPerson)
    }

    @Test fun lastName_으로_데이터베이스에서_조회하기() {
        //given
        val database = PersonDatabase()
        val person = insertToDatabase(database, "Dwight Joseph djo@gmail.com")
        //when
        val findPersons: List<Person> = database.getPerson(person.lastName)
        //then
        assertEquals(person, findPersons[0])
    }

    @Test fun email_으로_데이터베이스에서_조회하기() {
        //given
        val database = PersonDatabase()
        val person = insertToDatabase(database, "Dwight Joseph djo@gmail.com")
        //when
        val findPersons: List<Person> = database.getPerson(person.email)
        //then
        assertEquals(person, findPersons[0])
    }

    @Test fun 조회결과가_없는_경우() {
        //given
        val database = PersonDatabase()
        insertToDatabase(database, "Erick Harrington harrington@gmail.com")
        //when
        val findPerson = database.getPerson("WEBB@gmail.com")
        //then
        assertTrue(findPerson.isEmpty())
    }

    private fun insertToDatabase(database: PersonDatabase, input: String): Person {
        val person = createPerson(input)
        database.insert(person)
        return person
    }

    private fun createPerson(input: String): Person {
        val split = input.split(" ")
        if (split.size < 3) {
            val (firstName, lastName) = input.split(" ")
            return Person(firstName, lastName)
        }
        val (firstName, lastName, email) = input.split(" ")
        return Person(firstName, lastName, email)
    }

}