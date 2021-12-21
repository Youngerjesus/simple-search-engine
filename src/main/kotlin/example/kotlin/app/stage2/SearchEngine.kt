package example.kotlin.app.stage2

class SearchEngine {
    private var database = PersonDatabase()
    private var queryAnalyzer: QueryAnalyzer<Person> = PersonQueryAnalyzer()

    fun search(query: String): List<Person> {
        return database.getPerson(query)
    }

    fun insert(query: String){
        val result = this.queryAnalyzer.analyze(query)
        return this.database.insert(result as Person)
    }

    fun findAll(): List<Person> {
        return database.findAll()
    }
}