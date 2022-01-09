package example.kotlin.app

import example.kotlin.app.stage3.Menu
import example.kotlin.app.stage5.SearchEngine

fun main() {
	displayMenu()
}

private fun displayMenu() {
	val menu = Menu
	val searchEngine = SearchEngine()

	while (true) {
		menu.display()
		val userInput: Menu.UserInput = menu.receiveUserInput()

		if (userInput.choiceExit()) {
			return
		}

		if (userInput.choiceFindPerson()) {
			menu.printFoundPeople(searchEngine)
		}

		if (userInput.choicePrintAllPeople()) {
			menu.printAllPeople(searchEngine)
		}
	}
}