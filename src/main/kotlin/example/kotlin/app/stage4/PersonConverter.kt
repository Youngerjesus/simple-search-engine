package example.kotlin.app.stage4

import example.kotlin.app.stage2.Person

object PersonConverter {
    fun convert(query: String): Person {
        val split = query.split(" ")

        if (split.size < 2) {
            val (firstName) = query.split(" ")
            return Person(firstName)
        }

        if (split.size < 3) {
            val (firstName, lastName) = query.split(" ")
            return Person(firstName, lastName)
        }

        val (firstName, lastName, email) = query.split(" ")
        return Person(firstName, lastName, email)
    }
}