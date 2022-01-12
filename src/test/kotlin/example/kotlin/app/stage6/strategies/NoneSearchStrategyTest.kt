package example.kotlin.app.stage6.strategies

import example.kotlin.app.stage2.PersonQueryAnalyzer
import example.kotlin.app.stage4.PersonConverter
import org.assertj.core.api.Assertions.assertThat

import org.junit.jupiter.api.Test

internal class NoneSearchStrategyTest {

    @Test
    fun NONE_전략으로_검색조회() {
        //given
        val analyzeQuery = PersonQueryAnalyzer.analyze("djo@gmail.com ERICK")
        //when
        val actual = SearchStrategyFactory.NONE.search(analyzeQuery)
        //then
        assertThat(actual).contains(
            PersonConverter.convert("Katie Jacobs"),
            PersonConverter.convert("Myrtle Medina"),
            PersonConverter.convert("Rene Webb webb@gmail.com")
        )
    }
}