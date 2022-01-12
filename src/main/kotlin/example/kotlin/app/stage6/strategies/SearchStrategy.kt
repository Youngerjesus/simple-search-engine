package example.kotlin.app.stage6.strategies

import example.kotlin.app.stage2.Person

interface SearchStrategy {
    fun search(queries: List<String>): List<Person>
}