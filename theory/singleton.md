# Theory: Singleton

> Creational patterns consist of some solutions to common design problems. One of these problems is the need to maintain a single instance of some object. The most common solution to this problem is the singleton pattern.
 
***

## What is a singleton?

> Singleton is a creational design pattern that allows you to keep only one instance of an object and provide global access to it. What does it mean and why you might have to use it? Well, it solves two problems:
>
> - Keeping only one instance of an object is useful when you want to control access to some shared resources. When you create one object of a class, if you use singleton pattern, you will always have that same object. In case you'll try to create another one, the code will return the first initiated object each time.
> - Providing global access point to allow all clients to use the initiated instances. When you address this problem, you also should squeeze all the code regarding the first problem in one class, to avoid it being scattered all over your code.
>
> Usually, to implement this pattern, we create a Singleton class that is connected to other parts of our application. It consists of Object constructor and getInstance() method. Through our constructor, we create instances when application first needs it. Then we check the presence of this instance with our method getInstance() and pass it to our application. This helps us to avoid creating other instances.

- Singleton 패턴은 하나의 객체만 생성하고 이 객체만 사용할 수 있도록 해주는 것. 
- 주로 공유할만한 리소스를 객체로 사용하고 싶을 때 사용한다.
- 싱글톤을 글로벌하게 엑세스할 수 있다. (이런 경우에는 변경이 안되도록 읽기 전용으로 될만한 객체가 좋다.)
- 싱글톤 패턴을 사용할 땐 getInstance() 메소드를 통해서 접근하도록 하고, 이 메소드를 호출할 시점에 객체가 있다면 그 객체를 반환하도록 하고, 객체가 없다면 객체 생성후에 반환하도록 하는식으로 구현을하면 된다.

## Singleton implementation example

> Here's a simple implementation example of this pattern, depicted in pseudocode:
>  
> ```
> global instance
>   
> class Object is
>     constructor of Object...
>   
>     method getInstance() is
>         if (instance == null) then
>           instance = new Object()
>         return instance
>  
> ```
> 
> As you can see, we have global instance and Object class which consist of Object() constructor which creates our object instance and method getInstance(). This method is the most common way to apply singleton. We have a simple condition if which checks the presence of an object instance. If there is no instance of an object, the method will create a new one. If there is an object instance, the method will simply stick to it.
> 
> Let's try to use this class in our application:
> 
> ```
> foo = Object.getInstance()
> bar = Object.getInstance()
> foo is bar //true
> ```
> 
> Here we have a class application, which, through the main() method, tries to create objects foo and bar. The objects are checked through our getInstance() method. When we initialize our instance for the first time with foo, our code will stick to it even when we try to initialize it with our bar object. So our bar object will always be the same as the foo object.
> 
> Instead of trying to maintain one instance of a class, you can maintain few instances. All it takes is a bit of change to getInstance() method and keeping more than one instance. But by doing this, you'll now work with different design pattern called multiton.
  
***

## Usage of singleton

> Obviously, singleton should be used in situations when you need to keep only one instance of a class that is available to all clients. For example, the most common example is the LogManager class that allows keeping logs of your application runtime. It doesn't need to have more than one instance and should be accessible to all application classes. Another time when this pattern should be implemented is when you need to isolate your instance and have only singleton class control over it.
>
> But singleton has a few problems that make you do some bad workarounds in your code. For example:
> 
> - Singleton violates SPR (Single Responsibility Principle) by solving two problems at once. This could have a negative impact on your code because the solution for one problem can interfere with the solution for another.
> - Components of a program can have a bit too much information about each other.
> - It has a negative impact on a unit-testing and makes it harder.
> 
> Those are the most common problems that can occur when implementing singleton.
  
- 싱글톤의 예) LogManager
- 싱글톤의 문제점
  - SRP 를 위반함 (이 부분은 잘 모르겠음.)
    - https://stackoverflow.com/questions/137975/what-are-drawbacks-or-disadvantages-of-singleton-pattern
  - 결합도가 높음.
  - Unit Testing 할 때 어려움. 
  
