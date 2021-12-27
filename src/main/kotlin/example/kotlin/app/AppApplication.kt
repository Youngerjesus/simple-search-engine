package example.kotlin.app

import example.kotlin.app.stage4.SearchEngine
import example.kotlin.app.stage3.Menu

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