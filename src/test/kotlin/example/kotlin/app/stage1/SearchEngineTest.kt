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

    private fun assertNotFound(stringList: List<String>, word: String) {
        val index: Int = searchEngine.search(stringList, word)
        assertEquals(index, -1)
    }
}