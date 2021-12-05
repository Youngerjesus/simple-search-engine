package example.kotlin.app.stage2

class SearchEngine {
    private var database = PersonDatabase()

    fun setDatabase(database: PersonDatabase) {
        this.database = database
    }

    fun search(query: String): List<Person> {
        return database.getPerson(query)
    }

    fun insert(query: String){
        val split = query.split(" ")

        if (split.size < 2) {
            val (firstName) = query.split(" ")
            return this.database.insert(Person(firstName))
        }

        if (split.size < 3) {
            val (firstName, lastName) = query.split(" ")
            return this.database.insert(Person(firstName, lastName))
        }

        val (firstName, lastName, email) = query.split(" ")
        return this.database.insert(Person(firstName, lastName, email))
    }
}