package example.kotlin.app.stage2

class Person (val firstName: String, val lastName: String) {
    var email: String = ""

    constructor(_firstName: String, _lastName: String, _email: String) : this(_firstName,_lastName) {
        email =  _email
    }
}