package example.kotlin.app.stage2

object PersonQueryAnalyzer {

    fun analyze(query: String): List<String> {
        if (isNotBlank(query)) {
            return query.trim().lowercase().split(" ")
        }
        throw RuntimeException("failed query analyze")
    }

    private fun isNotBlank(query: String) = query.isNotBlank()
}