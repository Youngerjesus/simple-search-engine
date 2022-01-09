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
}