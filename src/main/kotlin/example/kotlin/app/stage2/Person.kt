package example.kotlin.app.stage2

import java.lang.UnsupportedOperationException

class Person (val firstName: String) {
    var lastName: String = ""
    var email: String = ""

    constructor(_firstName: String, _lastName: String) : this(_firstName) {
        this.lastName = _lastName
    }

    constructor(_firstName: String, _lastName: String, _email: String) : this(_firstName) {
        this.lastName = _lastName
        this.email =  _email
    }

    operator fun get(property: String): String {
        return when(property) {
            "firstName" -> this.firstName
            "lastName" -> this.lastName
            "email" -> this.email
            else -> throw UnsupportedOperationException()
        }
    }

    override fun toString(): String {
        if (this.email.isBlank()) {
            return "${this.firstName} ${this.lastName}"
        }
        return "${this.firstName} ${this.lastName} ${this.email}"
    }

    override fun equals(other: Any?): Boolean {
        val person = other as Person
        return this.firstName == person.firstName &&
                this.lastName == person.lastName &&
                this.email == person.email
    }
}