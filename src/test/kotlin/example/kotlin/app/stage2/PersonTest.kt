package example.kotlin.app.stage2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PersonTest {

    @Test fun person_객체_생성_테스트() {
        val person = Person("first", "last", "email")

        assertEquals("first", person.firstName)
        assertEquals("last", person.lastName)
        assertEquals("email", person.email)
    }
}