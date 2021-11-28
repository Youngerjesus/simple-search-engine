package example.kotlin.app.stage2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PersonDatabaseTest {
    private val database = PersonDatabase()

    @Test fun 데이터베이스에_사람_추가() {
        val isSuccess: Boolean = database.insert(Person("first", "last", ""))
        assertEquals(true, isSuccess)
    }
}