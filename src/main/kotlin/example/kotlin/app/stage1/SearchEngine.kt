package example.kotlin.app.stage1

class SearchEngine {
    fun search(strings: List<String>, word: String): Int {
        if (word in strings) {
            return strings.indexOf(word) + 1
        }
        return -1
    }
}