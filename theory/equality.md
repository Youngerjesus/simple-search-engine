# Theory: Equality

> You already know that objects are really complex structures and variables only point to objects. This time, you will learn about equality and how to understand that variables point to the same object. In addition, you will finally fully understand the meaning of the val keyword and avoid one of the most common beginner mistakes: assuming that the val keyword guarantees immutability.
  
- 변수는 객체를 가리킨다 라는 의미를 제대로 이해할 수 있을 것.
- val 키워드는 Immutable 을 위한 것.

***

## Comparison

> Imagine a situation: you receive two identical messages from your friend. The messages are "Hi" and "Hi". You see them and understand: the messages are the same. If you want to compare these messages in Kotlin, you can store them as string values:
>
> ```kotlin
> val msg1 = "Hi"
> val msg2 = "Hi"
> ```
> 
> Then you can use the comparison operator ==. For example, print(msg1 == msg2) gives true, and print(msg1 == "Hello") gives false. Variables msg1 and msg2 have the same state, which is called structural equality. Also, you may check for inequality using the operator != . For example, print(msg1 != "Hello") gives true.
>
> Note that some complex data types may not have the operator==. We will discuss this later. Box in the following examples has this operation
>
> Let's look at an example of copying a mutable object. Suppose you have a box that stores balls, and you can add one ball to it. Try to copy this box and change the original:
>
> ````kotlin
>  val blueBox = Box(3)          // box with 3 balls
>  val azureBox = blueBox 
>  println(blueBox == azureBox ) // true, it's a copy
>  blueBox.addBall()             // add a ball to the first box
>  println(blueBox == azureBox ) // true, the second box also contains 4 balls
> ````
> 
> When you change the first box, its copy changes, too. This is because blueBoxand azureBoxpoint to the same object. How do you check this? Let's see how to check the referential equality.

- String 같은 경우는 == 연산으로 비교하는게 가능하지만 일반적인 객체는 그렇지 않다.
- 객체끼리의 == 연산은 참조를 비교하는 것.

***

## Referential equality

> You know that variables can have the same state and can be the same (point to the same object). In both cases, == returns true. However, Kotlin provides a special operator === to check if the variables point to the same object. For example:
>
> ```kotlin
>  val blueBox = Box(3)
>  val azureBox = blueBox 
>  val cyanBox = Box(3)
>  println(blueBox == azureBox)  // true
>  println(blueBox === azureBox) // true, azureBox points to the same object
>  println(blueBox == cyanBox)   // true
>  println(blueBox === cyanBox)  // false, cyanBox points to another object
> ```
> 
> So, blueBox and cyanBox have the same state, but they point to different objects. In this case, if you change the state of blueBox, cyanBox remains the same:
>
> ```kotlin
> blueBox.addBall()
> println(blueBox == cyanBox) // false
> ```
> 
> Also, you may check for referential inequality with the operator !== . For example, print(blueBox !== cyanBox) gives true.
>
> Another interesting thing about the === operator is the equality of immutable objects. Let's look at the following example:
>
> ```kotlin
> var two = 2
> var anotherTwo = 2
> println(two === anotherTwo) // true
> ```
> 
> These variables point to the same object! Don't worry about this: as you remember, you cannot change an immutable object, so if you try to do something with the variable, it will point to a new object and other variables will still point to the old object. Try to change two:
>
> ```kotlin
> two++
> println(two)        // 3
> println(anotherTwo) // 2
> ```
> 
> So, immutable objects are really useful and help you avoid a lot of possible problems with copying.
  
- == 연산을 통해 객체의 상태를 비교하는게 가능하다. (코틀린 내부에서는 equals() 를 호출한다고 한다.)
- === 연산을 통해서 객체의 참조를 비교하는게 가능하다.

***

## The difference between val and var

> Now we can finally understand the meaning of the val keyword. As you know, val denotes an immutable variable. Let's look at a simple analogy.
> 
> Suppose you have a box with five balls:
>
> ```kotlin
> val box = Box(5) // a box with 5 balls
> ```
> 
> If you add one ball to the box, will this box change? No, it won't: it is still the same box, only its contents have changed. So you can write something like the following snippet, where a member function addBall() adds a ball to the box:
>
> ```kotlin
> box.addBall()
> ```
> 
> It looks like we changed the variable with val since now it contains 6 balls instead of 5. However, it is the same box and the same object, so this action is correct. Another example is if you take a book and turn the page, the book remains the same, but you see another state. So, you can change the inner state of val object.
>
> So, what is the main difference between val and var? The val keyword implies an immutable reference to the object. You can change something inside, but you cannot reassign it to another value.
>
> If you took another box with the same number of balls, it would be a different box, so this action would be impossible for a val object:
>
> ````kotlin
> val newBox = Box(6)
> newBox = Box(6) // reassignment of value is impossible
> ````
> 
> With var variables, you can do this. The var keyword implies a mutable reference to a variable, so you can reassign it.
>
> ````kotlin
> var anotherBox = Box(6)
> anotherBox = Box(2)
> ````
> 
> To sum up, you can change the contents of val with member functions, but you cannot assign another value to it. Remember that Int, Double, String, and other standard types are immutable, so you cannot change their inner state. In this case, val keyword implies immutability because the only way to change a standard type is by reassignment, and val doesn't allow this operation.
  
- val 키워드의 진정한 의미는 Immutable Reference 를 말한다.
- 그러므로 assign 을 두 번 이상 못한다는 거지 하나의 창조를 가진 객체에서 행동을 통해 내부의 상태를 변경시키는 건 가능하다.



