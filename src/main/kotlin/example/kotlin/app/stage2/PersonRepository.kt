package example.kotlin.app.stage2

class PersonRepository : Repository<Person> {
    private val database = mutableMapOf<String, MutableMap<String, MutableList<Person>>>()
    private val indexes = mutableListOf("firstName", "lastName", "email")

    init {
        for (index in indexes) {
            database[index] = hashMapOf()
        }
    }

    override fun insert(person: Person) {
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

    override fun get(query: String): List<Person> {
        val result = mutableSetOf<Person>()

        for (index in indexes) {
            val findPersonList = database[index]?.get(query.lowercase())
            if (findPersonList != null) {
                result.addAll(findPersonList)
            }
        }

        return result.toList()
    }

    override fun findAll(): List<Person> {
        val result = mutableSetOf<Person>()

        for (index in indexes) {
            val keys = database[index]?.keys ?: emptySet()
            keys.forEach{ key ->
                result += database[index]?.get(key) ?: emptyList()
            }
        }
        return result.toList()
    }
}

