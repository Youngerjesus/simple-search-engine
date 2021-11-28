package example.kotlin.app.stage1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SearchEngineTest {
    private val searchEngine = SearchEngine()

    @Test fun 주어진_문자열_리스트에서_찾고자하는_단어가_없는_경우() {
        assertNotFound(
            listOf("cat", "dog", "and", "mouse"),
            "elephant"
        )

        assertNotFound(
            listOf("one", "two", "three", "abcde", "abc"),
            "abcd"
        )
    }

    @Test fun 주어진_문자열_리스트에서_단어를_찾은_경우() {
       assertFound(
           listOf("first", "second", "third", "fourth"),
           "third",
           3
       )

        assertFound(
            listOf("first", "second", "third", "fourth"),
            "fourth",
            4
        )
    }

    fun solution() {
        val stringList = readLine()!!.split(" ").toList() // "first", "second", "third", "fourth"
        val searchWord = readLine()!!                                // "third"

        when (val index = searchEngine.search(stringList, searchWord)) {
            -1 -> println("Not found")
            else -> println(index)
        }
    }

    private fun assertFound(stringList: List<String>, word: String, actualResult: Int){
        val index = searchEngine.search(stringList, word)
        assertEquals(actualResult, index)
    }

    private fun assertNotFound(stringList: List<String>, word: String) {
        val index: Int = searchEngine.search(stringList, word)
        assertEquals(-1, index)
    }
}