package example.kotlin.app.stage5

import example.kotlin.app.stage2.Person
import example.kotlin.app.stage4.PersonConverter

class PersonRepository {
    private val persons:PersonInvertedIndex = loadPersons()

    private fun loadPersons(): PersonInvertedIndex {
        val result = PersonInvertedIndex()
        val data = getRawData()
        data.forEach {
            val person = PersonConverter.convert(it)
            result.add(person)
        }

        return result
    }

    private fun getRawData(): List<String> {
        val fileName = "text.txt"
        val data = this::class.java
            .classLoader
            .getResourceAsStream(fileName)
            .bufferedReader()
            .readLines()
        return data
    }

    fun get(query: String): List<Person> {
        return persons.get(query)
    }

    fun getAll(): List<Person> {
        return persons.getAll()
    }
}