package example.kotlin.app.stage6.strategies

import example.kotlin.app.stage2.Person

class NoneSearchStrategy : SearchStrategy {
    override fun search(queries: List<String>): List<Person> {
        return SearchStrategyFactory.repository
            .getAll()
            .filter { isNotContain(it, queries) }
    }

    private fun isNotContain(person: Person, queries: List<String>): Boolean {
        for (query in queries) {
            if (isAnyMatch(person, query)) {
                return false
            }
        }
        return true
    }

    private fun isAnyMatch(person: Person, query: String) =
        person.firstName == query || person.lastName == query || person.email == query
}