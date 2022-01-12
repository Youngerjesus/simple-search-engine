package example.kotlin.app.stage6.strategies

import example.kotlin.app.stage2.Person
import example.kotlin.app.stage5.PersonRepository

enum class SearchStrategyFactory (val type: String, val searchStrategy: SearchStrategy): SearchStrategy {
    ALL ("ALL", AllSearchStrategy()) {
        override fun search(queries: List<String>): List<Person> {
            return searchStrategy.search(queries)
        }
    },
    ANY ("ANY", AnySearchStrategy()) {
        override fun search(queries: List<String>): List<Person> {
            return searchStrategy.search(queries)
        }
    },
    NONE ("NONE", NoneSearchStrategy()) {
        override fun search(queries: List<String>): List<Person> {
            return searchStrategy.search(queries)
        }
    };

    companion object {
        fun get(type: String?): SearchStrategyFactory? {
            if (type == null) return null

            for (enum in values())  {
                if (enum.type == type) {
                    return enum
                }
            }
            return null
        }

        val repository = PersonRepository()
    }
}