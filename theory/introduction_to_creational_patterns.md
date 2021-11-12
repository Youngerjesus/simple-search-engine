# Theory: Introduction to creational patterns

> There are quite a few design patterns in programming. Most of them are aimed at the simplification of your code and at making faster ways to implement complex ideas and concepts. One group of such design patterns is called creational design patterns. The goal of these patterns is to make you write more flexible and reusable code using simple and fast solutions for common problems.

- design pattern 은 직면한 문제에 대해서 빠르게 솔루션을 제공할 수 있을 뿐 아니라 reusable code, flexible code 를 제공해줄 수 있다는 점. 

***

## What is a creational pattern?

> Creational design patterns are design patterns that focus on making objects through a mechanism for a required application. 
>
> The result of using a mechanism could be the simplification of your code with a quick solution to the most common problems. 
>
> This pattern separates your system's main functions from a process of object creation. The concept of creational design patterns allows us to develop more flexible systems in terms of object creation.
  
- Creational Pattern 은 오브젝트를 만드는 것과 관련된 패턴. 
- Creational Pattern 은 주요 시스템 로직과 분리되서 객체를 생성할 수 있다는 장점이 있다. 

***

## Using creational patterns

> Creational patterns are one of the ways to get rid of hard-coding. It allows us to make a system that is independent of how its object are created. Here's a few situations when you should apply creational patterns:
> 
> - Designing a set of related objects that are to be used together.
> - Hiding the implementation of a class library, revealing only its interfaces.
> - Constructing different representation of independent complex objects.
> - A class delegates its subclass to implement the object it creates.
> - There must be a single instance and client can access this instance at all times.
>
> There is also some criticism towards all design patterns including creational ones. Mainly it is their unjustified usage and their occasional inefficiency. So you should keep in mind the situations described above to get the most benefits out of creational design patterns.
> 
> But these design patterns could also limit your creativity and make you think that they are multi-tools which can solve any problem. So you shouldn't always solely rely on them.
  
- Creational Pattern 을 사용하면 좋은 상황들은 다음과 같다. 
  - 함께 사용되는 객체들을 만들 때  
  - 클래스의 라이브러의 구현을 숨기고 인터페이스만 표시하고 시픙ㄹ 때 
  - 독립적인 복잡한 객체를 다르게 표현하고 싶을 때
  - 하위 클래스에 위임해서 객체의 생성 구현을 만들 때
  - 하나의 인스턴스만을 사용할 때
- 디자인패턴은 불필요한 경우도 있을 수 있으므로, 디자인 패턴이 푸는 문제에 대해서 정확하게 인식하고 사용하는 걸 추천한다. 

***

## Types of creational patterns

> Each of the creational pattern types has its own concept, advantages, and disadvantage. There are five most common types of creational patterns.
>
> - **Factory method** is a pattern that creates an interface or abstract class for object creation that also allows for a modification of object creation in subclasses. You could use this pattern when you don't know beforehand the exact types and dependencies of the objects your code should work with.
> - **Singleton** is a pattern that creates only one instance of an object while providing a point of global access to this instance. This pattern should be implemented when the class in your program should have just a single instance available to all clients.
> - **Prototype** is a pattern based on the concept of copying an existing class for the creation of a new one. Use this to reduce the number of subclasses that only differ in the way they initialize their objects.
> - **Builder** is a pattern that lets you design complex objects using simple objects while using step by step approach. This allows you to create different modified variations of the same object
> - **Abstract factory** is a pattern that works with a method that creates other factories. Its factories could further be used for a factory method.

- 디자인 패턴은 자신만의 강점과 약점이 확실히 있다. 이를 인지하는게 중요하다.
- Factory method 패턴은 객체를 생성할 때 인터페이스나 추상 클래스 타입으로 객체를 리턴해주기 때문에 구체적인 클래스타입을 몰라도 된다라는 점이 있다.
- Singleton 패턴은 오로지 하나의 객체만 생성하고 이에 엑세스할 수 있다는 점이 있다.
- Prototype 패턴은 객체를 복사할 때 일일히 하나씩 필드를 복사하도록 하는게 아니라 쉽게 복사해서 생성할 수 있도록 해주는 것
- Builder 패턴은 복잡한 객체를 생성할 때 한 스텝씩 나아가면서 객체를 안전하게 생성할 수 있다는 점.
- Abstract Factory 패턴은 관련있는 객체의 경우 통째로 묶어서 생성하는 패턴 


 