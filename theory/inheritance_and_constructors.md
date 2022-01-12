# Theory: Inheritance and constructors

> Inheritance is a powerful tool for reusing an existing class. With inheritance, Kotlin ensures that both the base and the derived classes are correctly initialized. A derived class may take advantage of the base class's multiple constructors in order to create its own multiple constructor scheme.

***

## Inheritance and primary constructor

> The most simple case occurs when the base class doesn't have any constructor parameters. In the following example, the Fiction class inherits from the Book class, which has no parameters. Note that the parentheses for Book are required in order to initialize it.
>
> ```kotlin
> open class Book
> 
> class Fiction : Book()
> ```
> 
> When the base class has constructor parameters, the derived class should take care of them. Kotlin will not allow a program to compile if the base class isn't properly initiated. The following examples show some cases of the base class initiation though the primary constructor. Here, we have the open class Book, from which we inherit the ExtBook, NoInfoBook, and FictionBook classes.
>
> ````kotlin
> open class Book(val title: String, val author: String = "Unknown",
>                 val genre: String = "Unknown", val isbn: Long = 0)
> 
> class ExtBook(val publisher: String = "Unknown", title: String,
>               genre: String = "Unknown", author: String = "Unknown",
>               isbn: Long = 0) : Book(title, author, genre, isbn)
> 
> class NoInfoBook(title: String, author: String = "Unknown") : Book(title, author)
> 
> class FictionBook(title: String, author: String = "Unknown",
>                   isbn: Long = 0) : Book(title, author, genre = "fiction", isbn)
> ````
>
> The ExtBook class has a new property called publisher, which has to be declared with var or val. All other parameters are not new properties, and they are used to initialize the respective properties of the base class Book.
>
> The NoInfoBook class has only 2 parameters, which are used to initialize the base class. All other base class parameters take their default values.
>
> Finally, the FictionBook class has only 3 parameters, which are used to initialize 3 parameters of the base class. The fourth parameter, named genre, is explicitly set within the Book parentheses.

***

## Inheritance and secondary constructor

> A base class may have multiple constructors, which may include a primary constructor and many secondary ones. The derived class might use one or more of those in order to initiate the base class by implementing multiple constructors itself. In the following example, the Derived class, which inherits the Base class, has multiple constructors.
>
> ````kotlin
> open class Base(val beta: Int, val gamma: Int = 0, var message: String = "") {
>     constructor(beta: Int, message: String = "") : this(beta, 0, message)
> }
> 
> class Derived(val alpha: Int, beta: Int, gamma: Int = 0, message: String = "") : Base(beta, gamma, message) {
>     constructor(alpha: Int, beta: Int, message: String = "") : this(alpha, beta, 0, message)
> }
> ````
> 
> In the above example, the Base class can be initiated in 4 different ways. For example:
>
> ```kotlin
> Base(10)                    // beta is set
> Base(10, 20)                // beta and gamma are set
> Base(10, 20, "My message")  // beta, gamma, and a message are set
> Base(10, "My message")      // beta and a message are set
> ```
> 
> The Base class secondary constructor is using delegation to the primary constructor by means of the keyword this.
>
> The Derived class declares the same parameter list as the Base class, a similar secondary constructor, and also a new property called alpha. Thus, the class can be initiated in similar ways as the Base class. For example:
>
> ````kotlin
> Derived(0, 10)
> Derived(0, 10, 20)
> Derived(0, 10, 20, "My message")
> Derived(0, 10, "My message")
> ````
>  
> Of course, if we want to restrict the ways in which our Derived class can be initiated, then we should make further use of the secondary constructors. In the following example, we explicitly define each possible constructor for the Derived class by using secondary constructors. The Derived class adds a new property called alpha, like in the previous example.
>
> ````kotlin
> open class Base(val beta: Int, val gamma: Int = 0, var message: String = "")
> 
> class Derived : Base {
>     val alpha: Int
> 
>     constructor(alphaConstr: Int, beta: Int) : super(beta) {
>         alpha = alphaConstr
>     }
> 
>     constructor(alphaConstr: Int, beta: Int, gamma: Int) : super(beta, gamma) {
>         alpha = alphaConstr
>     }
> 
>     constructor(alphaConstr: Int, beta: Int, gamma: Int, message: String) : super(beta, gamma, message) {
>         alpha = alphaConstr
>     }
> 
>     constructor(alphaConstr: Int, beta: Int, message: String) : super(alphaConstr, beta, message) {
>         alpha = alphaConstr
>     }
> }
> ````
> 
> Each secondary constructor calls upon a Base class constructor by using the keyword super. Here, we can't have a primary constructor. Also, note the absence of parentheses after the class names.
>
> The new property alpha is defined within the class brackets, and it is not given any value. This is possible because its value is set in every secondary constructor. Thus, it is assured that alpha is going to be initialized.
>
> Here we defined 4 constructors to match the different constructors of the Base class, but we could limit them to only those needed.

***

## Inheritance and init

> In case a class has a primary constructor, some init blocks, and some secondary constructors, then the order of execution is the following:
>
> - The primary constructor, even if a secondary one is called. The primary one is called first through the this keyword;
> - All init blocks, sequentially in the order they appear;
> - The second constructor block, in case this constructor was called.
> 
> In case of inheritance, the base class is initiated first: either by calling its primary or a secondary constructor, through the derived class. So, the sequence order is the following:
>
> - Base class primary constructor, even if a base class secondary one is called through the derived class;
> - Base class init blocks, sequentially in the order they appear;
> - Base class secondary constructor block, in case this constructor was called;
> - Derived class primary constructor, even if a derived class secondary one is called;
> - Derived class init blocks, sequentially in the order they appear;
> - Derived class secondary constructor block, in case this constructor was called.
>
> The following code is an example of the above. There are a Base and a Derived classes, both with primary constructors, init blocks, and secondary constructors. The Derived class is initiated through a secondary constructor.
>
> ````kotlin
> open class Base(val message: String, val email: String) {
>     init { println("Base class init") }
>     constructor(email: String) : this("No message", email) { println("Base class secondary") }
> }
> 
> class Derived(email: String) : Base(email) {
>     init { println("Derived class init") }
>     constructor() : this("example.com") { println("Derived class secondary") }
> }
> 
> fun main() {
>     val myDerived = Derived()
> }
> ````
>
> When the Derived class is initiated through a secondary constructor, then the blocks are executed in the following order:
>
> - Base class init block;
> - Base class secondary block;
> - Derived class init block;
> - Derived class secondary block.
>
> This can be verified with the above code output:
>
> ```
> Base class init
> Base class secondary
> Derived class init
> Derived class secondary
> ```