package example.kotlin.app.stage2

class PersonDatabase {
    private val database = mutableMapOf<String, MutableMap<String, MutableList<Person>>>()
    private val indexes = mutableListOf("firstName", "lastName", "email")

    init {
        for (index in indexes) {
            database[index] = hashMapOf()
        }
    }

    fun insert(person: Person): Boolean {
        for (index in indexes) {
            if (person[index].isBlank()) {
                continue
            }
            if (database[index]?.contains(person[index]) == false) {
                database[index]?.put(person[index], mutableListOf())
            }
            database[index]?.get(person[index])?.add(person)
        }
        return true
    }

    fun getPerson(query: String): List<Person> {
        val result = mutableSetOf<Person>()

        for (index in indexes) {
            val findPersonList = database[index]?.get(query)
            if (findPersonList != null) {
                result.addAll(findPersonList)
            }
        }

        return result.toList()
    }
}