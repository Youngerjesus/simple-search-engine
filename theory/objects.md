# Theory: Objects

***

## Everything is an object

> In our life, we are always surrounded by objects: you drive a car, watch TV, read books, pay for bananas with your smartphone. In Kotlin, every time when you work with variables, you work with objects. For example, an integer 5 and a string "love" are objects. It is convenient because programmers are people, and people are used to dealing with objects. In this topic, we will learn about the inner structure of objects, their state and behavior, and their distinctive features.

- 세상 모든 것이 오브젝트로 이뤄져있듯이 코틀린도 모두 Object 로 이뤄져있다.
- Integer 와 String 모두 다 오브젝트다.

***

## State and behavior

> Objects are complex structures that can store some data and do something. How to get an object? Well, an object is a part of memory that stores some sort of information. Variables and values just point to objects. So, you can work with objects with the help of variables. A simple example of an object is a String that stores a message. Let's take a closer look at it.
> 
> First of all, a message has a state: it contains not only a sequence of symbols but also the size of the sequence, that is, the length of the message. In Kotlin, something that allows you to access the state of an object is called a property. Just put a dot and write the name of the property after the object, and you will get what you want! Suppose you have a simple String variable msg: val msg = "Hi". There is a .length property in a string, so msg.length gives us 2.
>
> In Kotlin, some functions are bound to a specific type. This makes using the objects more logical because functions represent the behavior of those objects. These functions are also called member functions. The syntax is similar: just put a dot. For example, we can repeat our message using the member function repeat(): msg.repeat(3) gives us "HiHiHi".
>
> As you can see, even the standard String type has a really complex inner structure.

- Object 는 복잡한 데이터 구조를 가지고 있고 이 데이터는 메모리에 저장된다. 그리고 변수는 오브젝트 (메모리에 저장된) 를 가리킨다.
- 예로 String 타입으로 보면 Object 는 State 를 가지며 (내부에 저장된 데이터를 말한다.) 이에 접근하도록 하는게 Property 이다. String.length 이런 예가 프로퍼티를 말한다.
- 그리고 Object 는 각 오브젝트마다 가지고 있는 function 이 있는데 이를 Object 의 behavior 이라고 부르며 member function 이라고도 부른다. 

***

## Copying by reference

> In programming, copying something is a very common operation. We use = in almost all the cases. Let's take a look at how it works in Kotlin using a simple analogy with a bank account.
>
> You may have several cards connected to one account. If you buy something with one of these cards, you still spend money from that one bank account, even though the cards are different.
>
> In Kotlin, similar rules apply. If you create a variable and assign an object to it, another variable can point to the same object as well. Say you wrote text messages like this:
>
> ````kotlin
> val msg1 = "Hi"
> val msg2 = msg1
> ````
> 
> There will be two values pointing to a single object "Hi":
>
> `val msg1 -> "HI"` AND `val msg2 -> "HI"`
> 
> In other words, the = sign does not copy the object itself, it only copies a reference to it.

- (val 로 했을 때만 = 가 레퍼런스를 복사하는 건가 싶다. 이제 바꾸지 못하니까. ㄴㄴ 아니다. 다 reference 를 복사하는데 )
- var 로 했을 때 하나의 값을 바꾸면 다른 값에 영향을 끼치진 않아서.

***

## Mutability

> What happens if you change an object assigned to multiple variables by changing the value of one of these variables? It depends on the type of object. An object can be either mutable or immutable.
>
> If the object is immutable, you cannot change it, but you can use another object and assign this new object to the same variable. When you reassign the variable, it will point to a new object and other variables will still point to the old object. Standard types such as strings or numbers are immutable, so it's safe to copy them by reference.
>
> The behavior of mutable objects is similar to a bank account and cards. If you modify an object from one variable, the other assigned variables continue to point to that object, so they do not save the previous data. If you buy something, you are spending money from your account and the changes will be reflected on all other cards linked to the same account.

- Objects 들은 크게 Mutability 와 Immutability 의 특성 둘 중 하나를 가지고 있다.
- 이전에 말했듯이 Object 들은 = 연산자를 하면 reference 를 복사한다. 값 자체를 복사하는게 아니라. 그래서 하나의 값을 바꾸면 따라서 레퍼런스를 복사했던 값도 바뀌는데 이런 특성을 Mutable 이라고 한다.
- 근데 String 이나 Integer 같은 오브젝트는 Immutable 하다. 즉 레퍼런스를 복사해도 하나의 값이 바뀌면 기존의 값을 계속해서 가리키는게 아니라 새롭게 바뀐 값을 가리킨다. 즉 영향을 주지 않는다. 

