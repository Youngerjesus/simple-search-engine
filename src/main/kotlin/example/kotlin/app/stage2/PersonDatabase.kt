package example.kotlin.app.stage2

class PersonDatabase {
    private val database = mutableMapOf<String, MutableMap<String, MutableList<Person>>>()
    private val indexes = mutableListOf("firstName", "lastName", "email")

    init {
        for (index in indexes) {
            database[index] = hashMapOf()
        }
    }

    fun insert(person: Person) {
        for (index in indexes) {
            val key = person[index].lowercase()
            if (person[index].isBlank()) {
                continue
            }
            if (database[index]?.contains(key) == false) {
                database[index]?.put(key, mutableListOf())
            }
            database[index]?.get(key)?.add(person)
        }
    }

    fun getPerson(query: String): List<Person> {
        val result = mutableSetOf<Person>()

        for (index in indexes) {
            val findPersonList = database[index]?.get(query.lowercase())
            if (findPersonList != null) {
                result.addAll(findPersonList)
            }
        }

        return result.toList()
    }
}

