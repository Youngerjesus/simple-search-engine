package example.kotlin.app.stage6.strategies

import example.kotlin.app.stage2.PersonQueryAnalyzer
import example.kotlin.app.stage4.PersonConverter
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class AllSearchStrategyTest {

    @Test
    fun ALL_검색_전략으로_조회() {
        //given
        val searchStrategy = SearchStrategyFactory.get("ALL")
        val expected = listOf(
            PersonConverter.convert("Erick Harrington harrington@gmail.com")
        )
        val analyzeQuery = PersonQueryAnalyzer.analyze("Harrington Erick")
        //when
        val actual = searchStrategy?.search(analyzeQuery)
        //then
        assertArrayEquals(arrayOf(expected), arrayOf(actual))
    }
}