package example.kotlin.app.stage2

class SearchEngine {
    private var repository = PersonRepository()
    private var queryAnalyzer = PersonQueryAnalyzer

    fun search(query: String): List<Person> {
        return repository.get(query)
    }

    fun insert(query: String){
        val result = this.queryAnalyzer.convert(query)
        return this.repository.insert(result)
    }

    fun findAll(): List<Person> {
        return repository.findAll()
    }
}