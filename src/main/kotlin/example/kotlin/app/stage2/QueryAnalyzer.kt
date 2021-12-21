package example.kotlin.app.stage2

interface QueryAnalyzer <T>{
    fun analyze(query: String): T
}