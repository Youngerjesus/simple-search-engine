package example.kotlin.app.stage2

interface Database <T>{

    fun insert(data: T)

    fun findAll() : List<T>
}