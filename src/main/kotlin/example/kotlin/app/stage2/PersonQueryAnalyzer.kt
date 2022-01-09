package example.kotlin.app.stage2

object PersonQueryAnalyzer {

    fun analyze(query: String): String {
        if (isValid(query)) {
            return query.trim().lowercase()
        }
        throw RuntimeException("failed query analyze")
    }

    private fun isValid(query: String): Boolean {
        return isOneLine(query) && isNotBlank(query)
    }

    private fun isOneLine(query: String) = query.split(" ").size == 1

    private fun isNotBlank(query: String) = query.isNotBlank()
}