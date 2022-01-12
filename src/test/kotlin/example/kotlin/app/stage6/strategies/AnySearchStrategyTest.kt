package example.kotlin.app.stage6.strategies

import example.kotlin.app.stage2.PersonQueryAnalyzer
import example.kotlin.app.stage4.PersonConverter
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class AnySearchStrategyTest {

    @Test
    fun ANY_검색_전략으로_조회() {
        //given
        val searchStrategy = SearchStrategyFactory.get("ANY")
        val analyzeQuery = PersonQueryAnalyzer.analyze("Erick Dwight webb@gmail.com")
        val expected = listOf(
            PersonConverter.convert("Erick Harrington harrington@gmail.com"),
            PersonConverter.convert("Erick Burgess"),
            PersonConverter.convert("Dwight Joseph djo@gmail.com"),
            PersonConverter.convert("Rene Webb webb@gmail.com")
        )
        //when
        val actual = searchStrategy?.search(analyzeQuery)
        //then
        assertArrayEquals(arrayOf(expected), arrayOf(actual))
    }
}