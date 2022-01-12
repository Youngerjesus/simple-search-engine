package example.kotlin.app.stage6

import example.kotlin.app.stage2.Person
import example.kotlin.app.stage2.PersonQueryAnalyzer
import example.kotlin.app.stage5.PersonRepository
import example.kotlin.app.stage6.strategies.SearchStrategy
import example.kotlin.app.stage6.strategies.SearchStrategyFactory

class SearchEngine (var searchStrategy: SearchStrategy = SearchStrategyFactory.ANY.searchStrategy) {
    private var queryAnalyzer = PersonQueryAnalyzer
    private val respository = PersonRepository()

    fun search(query: String): List<Person> {
        val query = queryAnalyzer.analyze(query)
        return searchStrategy.search(query)
    }

    fun findAll(): List<Person> {
        return respository.getAll()
    }

    fun setStrategy(searchStrategy: SearchStrategy) {
        this.searchStrategy = searchStrategy
    }
}