package example.kotlin.app.stage5

import example.kotlin.app.stage2.Person
import example.kotlin.app.stage2.PersonQueryAnalyzer

class SearchEngine {
    private var repository = PersonRepository()
    private var queryAnalyzer = PersonQueryAnalyzer

    fun search(query: String): List<Person> {
        val query = queryAnalyzer.analyze(query)
        return repository.get(query)
    }

    fun findAll(): List<Person> {
        return repository.getAll()
    }
}