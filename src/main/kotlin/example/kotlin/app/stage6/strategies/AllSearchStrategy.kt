package example.kotlin.app.stage6.strategies

import example.kotlin.app.stage2.Person

class AllSearchStrategy : SearchStrategy {

    override fun search(queries: List<String>): List<Person> {
        return queries
            .map { SearchStrategyFactory.repository.get(it) }
            .flatten()
            .filter { isContains(it, queries) }
            .distinct()
            .toList()
    }

    private fun isContains(person: Person, queries: List<String>): Boolean {
        for (query in queries) {
            if (isAllNotMatch(person, query)) {
                return false
            }
        }
        return true
    }

    private fun isAllNotMatch(person: Person, query: String) =
        person.firstName != query && person.lastName != query && person.email != query
}