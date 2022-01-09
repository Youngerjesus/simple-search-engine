package example.kotlin.app.stage5

import example.kotlin.app.stage2.Person

class PersonInvertedIndex {
    var invertedIndex = mutableMapOf<String, MutableSet<Person>>()

    fun add(person: Person) {
        if (person.email.isNotBlank()) {
            putToIndex(person.email, person)
        }

        if (person.lastName.isNotBlank()) {
            putToIndex(person.lastName, person)
        }

        if (person.firstName.isNotBlank()) {
            putToIndex(person.firstName, person)
        }
    }

    private fun putToIndex(query: String, person: Person) {
        var persons = invertedIndex.get(query)
        if (persons == null) {
            persons = mutableSetOf(person)
        }

        persons.add(person)
        invertedIndex.put(query, persons)
    }

    fun get(query: String): List<Person> {
        return invertedIndex.get(query)?.toList() ?: mutableListOf()
    }

    fun getAll(): List<Person> {
        val result = mutableSetOf<Person>()
        val allPersons = invertedIndex.values.toList()
        allPersons.forEach {
            result.addAll(it)
        }
        return result.toList()
    }
}