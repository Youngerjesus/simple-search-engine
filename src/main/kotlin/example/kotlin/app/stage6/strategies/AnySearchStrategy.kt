package example.kotlin.app.stage6.strategies

import example.kotlin.app.stage2.Person

class AnySearchStrategy : SearchStrategy {

    override fun search(queries: List<String>): List<Person> {
        val result = mutableSetOf<Person>()

        for (query in queries) {
            result.addAll(SearchStrategyFactory.repository.get(query))
        }

        return result.toList()
    }
}