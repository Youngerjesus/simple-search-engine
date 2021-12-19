# Theory: The main() function

> I guess you’ve been asking yourself the question of why we have to write exactly fun main() {} in every program. Now we’re going to get to the bottom of this!

***

## The main() function

> So, take a closer look at the main() function. In fact, it’s a very common thing: you can do exactly what you do with any other function. The only difference is that it is the entry point of the program. This means that the running of the program begins by calling this function.
> 
> Let’s take a closer look at what the main() consists of:
>
> ````kotlin
> fun main() {}
> ````
> 
> - fun is a keyword that shows that main() is a function. Just a regular function;
> - main is the function name. It is important to know that we cannot change it: if we change it, for example, to Main(), the program will compile but not start;
> - and finally, the body of the function, as you well know, will be placed in curly braces.
> 
> In fact, there may still be input parameters — args — in the main() syntax; it’s a non-binding part of the declaration of the main(), and we'll talk more about it later.
>
> So, anything you can do with a usual function, instead of renaming, can be done with main().
>
> Its main feature is that its existence is mandatory: without it, the program will not start. But the main() can also be called on purpose. For example, it can be called by itself:
>
> ````kotlin
> var decrease = 3
> 
> fun main() {
>     if(decrease == 0)
>         return
>     decrease = decrease - 1
>     println(decrease)
>     main()
> }
> ````
>
> In this program, each call to main() decreases the value of the global variable decrease by 1 and prints the current value, until it is equal to 0. The word "global" means that this variable is accessible from anywhere in the program, inter alia in main() function.
>
> The output of this code looks like this:
>
> ````kotlin
> 2
> 1
> 0
> ````

***

## Arguments of the main function

> Actually, the main() function may have input parameters. They should be called args and stored in an array of strings. And the syntax of the main() will look like this:
>
> ````kotlin
> fun main(args: Array<String>) {}
> ````
> 
> Work with args is carried out in the same way as with other arrays: for example, args.size will return the number of arguments, and args[1] will return the second argument to the program.
>
> Yes, but what's it for?
>
> In simple words, the arguments of the main() function are the arguments of the program. You’ve probably used the opportunity of setting it many times in your life, for example, when you’ve opened a file with the "Open with...": in this case the file location is passed using the program arguments.
>
> So, using the main() arguments, we transmit some additional external data to the program itself.

***

## Working with the command line

> In fact, we can pass arguments to the program using the tools of the IDE or the command line. You already know how it can be done with the IDE. The other way is a little more complicated.
>
> Consider it in more detail: it is a one-size-fits-all approach, and command line skills will be needed many times in your programmer's path anyway. For example, in simple cases, it may obviate the need to create a graphical interface to interact with the user. Don’t be afraid if this approach seems too complicated now: this is just an example of how to set the program’s arguments exactly with the command line.
>
> To send command line arguments to your application, you need a pre-compiled program.
> 
> So, consider how you can pass arguments through the console: firstly, you need a compiled program. When you have one, you call the command line. After that, you run the application with the following command:
>
> `$ java -jar filename.jar args`
> 
> However, in this command, after you specify a file filename with .jar extension, you can pass exactly program arguments args separated by a space. Now let’s look at how all of this works in a very simple example.

***

## A practical example

> Let's look at the following code:
>
> ````kotlin
> fun main(args: Array<String>) {
>     println(args[0])
>     println(args[1])
> }
> ````
> 
> ```
> $ java -jar print_args.jar Hello, Kotlin!
> ```
> 
> Then the result will be as follows:

***

## With or without arguments?

> As we mentioned above, the main() function can exist with or without arguments. By way of illustration, let's run the same code that doesn’t use the program’s arguments in two ways:
>
> ````kotlin
> fun main(args: Array<String>) {
>     val firstName = "Luke"
>     val lastName = "Skywalker"
>     println(firstName + " " + lastName) // Luke Skywalker
> }
> ````
>
> ````kotlin
> fun main() {
>     val firstName = "Luke"
>     val lastName = "Skywalker"
>     println(firstName + " " + lastName) // Luke Skywalker
> }
> ````
>
> So everything works!
>
> Moreover, there will be no error when your file will contain both versions of the main() – with and without arguments. The program will just begin by executing main(args: Array <String>) {}:
>
> What about the other type, the other number and another name of arguments? Of course, you may have a main() function with completely different input parameters in one file, for example, it can be main(arg: Int) or main(a: Double, b: String), but then it will no longer be an entry point. It’ll be just a common function. In order for the program to start, the program file must contain exactly a function with the signature main() or main(args: Array<String>).
> 
> To sum up, you can use args when you need to work with program arguments. But if your program does not require command-line arguments the command-line arguments could be omitted. Before Kotlin 1.3, you had to write main(args: Array<String>), but now you don't need to.






