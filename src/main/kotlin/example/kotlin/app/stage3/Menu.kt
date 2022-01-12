package example.kotlin.app.stage3

import example.kotlin.app.stage6.SearchEngine
import example.kotlin.app.stage6.strategies.SearchStrategyFactory

object Menu {
    val searchEngine = SearchEngine()

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

    fun printAllPeople() {
        println("=== List of people ===")
        searchEngine.findAll()
            .forEach{ person -> println(person.toString())}

        println("=== End ===")
    }

    fun printFoundPeople() {
        printSearchStrategy()
        println("Enter a name or email to search all suitable people.")
        val findPersons = searchEngine.search(readLine()!!)
        findPersons.forEach { person -> println(person.toString())}
    }

    private fun printSearchStrategy() {
        while (true) {
            println("Select a matching strategy: ALL, ANY, NONE")
            val searchStrategy = SearchStrategyFactory.get(readLine())?.searchStrategy
            if (searchStrategy != null) {
                searchEngine.setStrategy(searchStrategy)
                return
            }
        }
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