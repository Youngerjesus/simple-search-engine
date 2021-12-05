package example.kotlin.app.stage2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PersonDatabaseTest {

    @Test fun 데이터베이스에_사람_추가() {
        //given
        val database = PersonDatabase()
        //when
        val isSuccess: Boolean = database.insert(Person("first", "last", ""))
        //then
        assertEquals(true, isSuccess)
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

    private fun insertToDatabase(database: PersonDatabase, input: String): Person {
        val person = createPerson(input)
        database.insert(person)
        return person
    }

    private fun createPerson(input: String): Person {
        val firstName = input.split(" ")[0]
        val lastName = input.split(" ")[1]
        val email = input.split(" ")[2]
        val person = Person(firstName, lastName, email)
        return person
    }

}