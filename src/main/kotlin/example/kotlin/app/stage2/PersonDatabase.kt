package example.kotlin.app.stage2

class PersonDatabase {
    private val database = mutableListOf<Person>()

    fun insert(person: Person): Boolean {
        return database.add(person)
    }

}