package example.kotlin.app.stage3

import example.kotlin.app.stage5.SearchEngine

object Menu {
    fun display() {
        println("=== Menu ===")
        println("1. Find a person")
        println("2. Print all people")
        println("0. Exit")
    }

    fun receiveUserInput(): UserInput {
        while (true) {
            val result: UserInput? = readLine()?.toInt()?.let { UserInput(it) }
            if (result?.isCorrectInput() == true) {
                return result
            }
            println("\nIncorrect option! Try again.")
        }
    }

    fun printAllPeople(searchEngine: SearchEngine) {
        println("=== List of people ===")
        searchEngine.findAll()
            .forEach{ person -> println(person.toString())}

        println("=== End ===")
    }

    fun printFoundPeople(searchEngine: SearchEngine) {
        println("Enter a name or email to search all suitable people.")
        val findPersons = searchEngine.search(readLine()!!)
        findPersons.forEach { person -> println(person.toString())}
    }

    class UserInput (private val value: Int) {
        fun isCorrectInput(): Boolean {
            return value == 1 || value == 2 || value == 0
        }

        fun choiceExit(): Boolean {
            return value == 0
        }

        fun get(): Int{
            return value
        }

        fun choiceFindPerson(): Boolean {
            return value == 1
        }

        fun choicePrintAllPeople(): Boolean {
            return value == 2
        }
    }
}