package example.kotlin.app.stage2

import example.kotlin.app.stage4.PersonConverter

class SearchEngine {
    private var repository = PersonRepository()

    fun search(query: String): List<Person> {
        return repository.get(query)
    }

    fun insert(query: String){
        val result = PersonConverter.convert(query)
        return this.repository.insert(result)
    }

    fun findAll(): List<Person> {
        return repository.findAll()
    }
}