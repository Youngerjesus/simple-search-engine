package example.kotlin.app.stage3

import example.kotlin.app.stage2.SearchEngine

fun main() {
    val (searchEngine, menu) = initialization()

    while (true) {
        menu.display()
        val userInput:Menu.UserInput = menu.receiveUserInput()

        if (userInput.choiceExit()) {
            return
        }

        if (userInput.choiceFindPerson()) {
            println("Enter a name or email to search all suitable people.")
            menu.printFoundPeople(searchEngine)
        }

        if (userInput.choicePrintAllPeople()) {
            menu.printAllPeople(searchEngine)
        }
    }
}

fun initialization() : Pair<SearchEngine, Menu>{
    println("Enter the number of people:")
    val peopleCount = readLine()!!.toInt()

    println("Enter all people:")
    val searchEngine = SearchEngine()
    for (i in 1..peopleCount) {
        searchEngine.insert(readLine()!!)
    }

    return Pair(searchEngine, Menu())
}

