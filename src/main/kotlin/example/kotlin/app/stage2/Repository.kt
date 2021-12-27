package example.kotlin.app.stage2

interface Repository <T>{

    fun insert(data: T)

    fun get(query: String): List<T>

    fun findAll() : List<T>
}