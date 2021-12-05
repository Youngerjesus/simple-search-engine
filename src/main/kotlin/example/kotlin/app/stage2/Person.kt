package example.kotlin.app.stage2

import java.lang.UnsupportedOperationException

class Person (val firstName: String, val lastName: String) {
    fun hasEmail(): Boolean {
        return email != ""
    }

    var email: String = ""

    constructor(_firstName: String, _lastName: String, _email: String) : this(_firstName,_lastName) {
        email =  _email
    }

    operator fun get(property: String): String {
        return when(property) {
            "firstName" -> this.firstName
            "lastName" -> this.lastName
            "email" -> this.email
            else -> throw UnsupportedOperationException()
        }
    }
}