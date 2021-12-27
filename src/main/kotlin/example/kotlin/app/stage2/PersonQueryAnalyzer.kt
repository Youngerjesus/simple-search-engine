package example.kotlin.app.stage2

object PersonQueryAnalyzer {

    fun analyze(query: String): (Person) -> Boolean {
        if (isOneLineString(query)) {
            return { it:Person ->
                it.firstName == query ||
                it.lastName == query ||
                it.email == query
            }
        }
        throw RuntimeException("failed query analyze")
    }

    private fun isOneLineString(query: String): Boolean {
        return query.split(" ").size == 1
    }

    fun convert(query: String): Person {
        val split = query.split(" ")

        if (split.size < 2) {
            val (firstName) = query.split(" ")
            return Person(firstName)
        }

        if (split.size < 3) {
            val (firstName, lastName) = query.split(" ")
            return Person(firstName, lastName)
        }

        val (firstName, lastName, email) = query.split(" ")
        return Person(firstName, lastName, email)
    }
}