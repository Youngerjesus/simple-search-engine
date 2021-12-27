package example.kotlin.app.stage4

import example.kotlin.app.stage2.Person
import example.kotlin.app.stage2.PersonQueryAnalyzer

class SearchEngine {
    private var repository = PersonRepository()
    private var queryAnalyzer = PersonQueryAnalyzer

    fun search(query: String): List<Person> {
        val condition = queryAnalyzer.analyze(query)
        return repository.get(condition)
    }

    fun findAll(): List<Person> {
        return repository.findAll()
    }
}