# Theory: Overriding functions

## Override it

> Of course, we need a good example of a class. Let's create the Transport class with its cost property:
>
> ````kotlin
> open class Transport(val cost: Int) {
>     fun getFullInfo(): String {
>         return "$$cost cost"
>     }
> }
> ````
> 
> Pretty typical class ready for extending, right? Keep in mind that it's open. But now we're going to mark our getFullInfo() function as open too and add one more function without the open modifier:
>
> ````kotlin
> open class Transport(val cost: Int) {
>     open fun getFullInfo(): String {
>         return "$$cost cost"
>     }
> 
>     fun getTax(): String {
>         return "$${(cost * 0.25).roundToInt()} tax"
>     }
> }
> ````
> 
> Now we are ready to extend the Transport class with its own getFullInfo() function:
>
> ````kotlin
> open class Ship(cost: Int, val color: String) : Transport(cost) {
>     override fun getFullInfo(): String {
>         return super.getFullInfo() + ", $color color"
>     }
> }
> ````
> 
> By default any overridden function in Kotlin is open. It means that you can override functions in sub-child classes too. Also, if you want to call a parent function, you can use super, as we did it in the example above. Two more things:
>
> 1. If you forget about override keyword, the compiler will warn you because there cannot be two functions getFullInfo() with the same parameters.
> 2. You also cannot override the getTax() function because it's not open.
> 
> In both cases, the source code wouldn't compile at all. Let's check our freshly created classes in the next example:
>
> ````kotlin
> fun main() {
>     val transport = Transport(1000)
>     val ship = Ship(2000, "marine")
>     println(transport.getFullInfo())
>     println(ship.getFullInfo())
> }
> ````
>
> The output should be the following:
>
> ````kotlin
> $1000 cost
> $2000 cost, marine color
> ````

***

## Reuse it

> There is one more useful feature regarding open functions. We will observe it through the following function:
>
> ````kotlin
> fun getTransportInfo(transport: Transport): String {
>     return "transport info: " + transport.getFullInfo()
> }
> ````
> 
> As you can see it handles the Transport class. What is more, it can process easily any child of this class too:
>
> ````kotlin
> fun main() {
>     val transport = Transport(1000)
>     val ship = Ship(2000, "marine")
>     println(getTransportInfo(transport))
>     println(getTransportInfo(ship))
> }
> ````
> 
> And it outputs this:
>
> ```
> transport info: $1000 cost
> transport info: $2000 cost, marine color 
> ```
> 
> Voila! The getTransportInfo() function works well with any open function of the Transport class and its child. Behold the real virtual power of Kotlin inheritance!

