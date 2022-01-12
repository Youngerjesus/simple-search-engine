package example.kotlin.app

import example.kotlin.app.stage3.Menu
import example.kotlin.app.stage6.SearchEngine
import example.kotlin.app.stage6.strategies.AnySearchStrategy

fun main() {
	displayMenu()
}

private fun displayMenu() {
	val menu = Menu

	while (true) {
		menu.display()
		val userInput: Menu.UserInput = menu.receiveUserInput()

		if (userInput.choiceExit()) {
			return
		}

		if (userInput.choiceFindPerson()) {
			menu.printFoundPeople()
		}

		if (userInput.choicePrintAllPeople()) {
			menu.printAllPeople()
		}
	}
}