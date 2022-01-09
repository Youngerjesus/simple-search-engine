package example.kotlin.app.stage4

import example.kotlin.app.stage2.Person
import example.kotlin.app.stage2.PersonQueryAnalyzer
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

class PersonRepository {
    private var persons = loadPersons()

    private fun loadPersons(): List<Person> {
        val data = getData()
        return data.map { PersonConverter.convert(it) }
    }

    private fun getData(): List<String> {
        val fileName = "text.txt"
        val data = this::class.java
            .classLoader
            .getResourceAsStream(fileName)
            .bufferedReader()
            .readLines()
        return data
    }

    fun get(condition: (Person) -> Boolean): List<Person> {
        return persons.filter( condition )
    }

    fun findAll(): List<Person> {
        return persons
    }
}
