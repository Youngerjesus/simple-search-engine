# Theory: Class Loader

> A typical enterprise Java application may comprise thousands of source and dependency classes. To handle all of them in a proper way JVM introduces a special mechanism called class loader. It is a part of JRE responsible for dynamic loading classes into memory. Understanding class loading allows to control this process and helps to avoid some types of exceptions.
>
> First of all, let's recall that java code goes through 2 stages: a compilation from source code to byte code (.java -> .class) and a byte code interpretation. The task of a class loader is finding the needed class through .class files from a disc and loading a representing object into the RAM. However, classes are not loaded in bulk mode on the application startup. A class loader loads them on-demand during an interpretation starting with a class containing the main method.  The on-demand approach means that the class will be loaded on its first invocation. It can be a constructor call, e.g. new MyObject() or a static reference to a class, e.g. System.out

- 클래스 로더에 의해서 클래스들이 메모리에 로드된다. (이때 .class 파일을 찾아서 올린다. 예를 들면 classpath)
- 클래스 로더는 클래스를 한번에 대량으로 올리지 않는다.
- 클래스를 메모리에 올리는 방식은 on-demand 방식이다. 즉 필요할 때 메모리에 올린다. 예를 들면 main 함수를 실행하거나, 생성자를 호출하거나, System.out 으로 클래스를 출력하거나.

***

## Internals

> A class loader concept is represented by java.lang.ClassLoader abstract class. There are 3 standard ClassLoader implementation:
> 
> - Bootstrap loads JDK internal classes e.g. java.util package.
> - Extension/Platform loads classes from JDK extensions.
> - Application/System loads classes from application classpath.
>
> One may ask what comes first if classes are loaded by a class loader and the ClassLoader itself is a class. To answer the question let's consider a sequence of these ClassLoaders invocations. 
> 
> First, JRE creates the Bootstrap ClassLoader which loads core classes. Then, Extension ClassLoader is created with Bootstrap as a parent.  It loads classes for extensions if such exist.
> 
> Finally, the Application ClassLoader is created with Extension as a parent. It is responsible for loading application classes from a classpath. Each class loaded in memory is identified by a fully-qualified class name and ClassLoader that loaded this class. Moreover, Class has a method getClassLoader that returns the class loader which loads the given class.
> 
> ````java
> import java.sql.SQLData;
>   import java.util.ArrayList;
>   
>   public class Main {
>       public static void main(String[] args) {
>           ClassLoader listClassLoader = ArrayList.class.getClassLoader();
>           ClassLoader sqlClassLoader = SQLData.class.getClassLoader();
>           ClassLoader mainClassLoader = Main.class.getClassLoader();
>   
>           System.out.println(listClassLoader); // null
>           System.out.println(sqlClassLoader.getName()); // platform
>           System.out.println(mainClassLoader.getName()); // app
>       }
>   }
> ````

- classloader 의 인터페이스는 `java.lang.ClassLoader` 에 정의되어있다. 구현체는 3가지.
- Bootstrap 클래스 로더는 JDK 내부 클래스를을 메모리에 로드하는 역할을 한다. (e.g java.util.package)
- Extension/Platform 클래스로더는 JDK extension 클래스들을 로드한다. 
- Application/System 클래스 로더는 classpath 에 있는 우리의 어플리케이션 클래스들을 로드한다.
- 클래스로더도 클래스고 클래스로더가 클래스를 메모리에 적재하는 역할을 한다면 어떤 과정대로 진행할까? 
- 먼저 Bootstrap 클래스로더가 맨 처음 메모리에 적재되고 그 다음 Bootstrap 클래스로더를 부모로 가지고 있는 Extension ClassLoader 가 적재된다. 마지막으로 Extension ClassLoader 를 부모로 가지는 Application/System ClassLoader 가 적재된다. 
 
 ***
 
## Delegation model
 
> When the class loader receives a request for loading a class, it follows certain steps in order to resolve the class. Default behavior defined by JVM specification:
>
> 1. Check if the class has already been loaded
> 2. If not, delegate the request to a parent
> 3. If the parent class returns nothing, it attempts to find the class in its own classpath
>
> Default logic can be overridden in custom class loaders. So web container class loaders will look for classes in the local classpath and only in case the class is not found will delegate resolving to a parent.
  
- 클래스 로더의 클래스 적재 과정은 Delegation Model 구조로 이뤄져있다.
- 클래스 로더는 클래스가 필요한 시점에 클래스를 적재하려고 한다. 그리고 클래스 로더는 부모 계층 구조로 이뤄져있다. 
- 요청이 들어오면 클래스 로더는 이미 해당 클래스가 적재되었는지 확인하고 부모에게 요청한다. 
- 부모를 타고가서 클래스가 로드되었는지 찾고 없다면 최상위 부모인 Bootstrap 클래스 로더부터 이제 해당 클래스를 찾아서 로드하려는 시도를 하려고 한다.
- Bootstrap 의 classpath 는 `jdk/jre/lib` 이고 여기서 클래스를 찾아보고 결과를 전달해준다.
- 결과가 없다면 다음 부모인 Extension 의 classpath 인 `jdk/jre/lib/ext` 에서 찾아보고 결과를 전달해준다.
- 여기고 결과가 없다면 Application 의 classpath 에서 해당 클래스를 찾아서 메모리에 적재한다. 
- 물론 중간 부모에 이미 클래스가 로드되어있다고 판단되면 찾는 작업은 하지않는다.
- 이렇게 부모 계층 구조로 이뤄진 경우에는 특정 영역으로 관심사를 나누는 구조에선 이렇게 하는듯.
- 물론 커스텀 클래스로더에서는 이렇게 클래스를 적재하는 방식을 오버라이딩해서 구현하는게 가능하다.

## Example

> Let's consider an application that consists of 2 classes. Although it does nothing, it is a good example of a class loader explanation.
>
> ```java
> public class A {
>      public static void main(String[] args) {
>          B b = new B();
>      }
>  }
> ```
> 
> ```java
> public class B {
> }
> ```
> 
> Launch the program by command:
> 
> ```
> java A
> ```
> 
> Let's go through key points of class loading during code execution:
> 
> 1. Bootstrap ClassLoader is invoked by JRE on the start java process. It loads java internal packages.
> 
> 2. Extension ClassLoader is invoked but loads nothing.
> 
> 3. Application ClassLoader is invoked and loads class A.
> 
> 4. When the constructor of class B is invoked ClassLoader of class A (Application ClassLoader) is invoked to load class B and delegates loading to Extension ClassLoader.
>
> 5. Extension ClassLoader is invoked and delegates loading to Bootstrap ClassLoader.
> 
> 6. Bootstrap ClassLoader is invoked and tries to resolve the class, but finds nothing and returns control to Extension ClassLoader.
>
> 7. Extension ClassLoader finds nothing as well and returns control to Application ClassLoader.
> 
> 8. Application ClassLoader resolves the class and loads it into memory.

- 클래스 로더가 찾는 과정 예제다. 
- Bootstrap 클래스 로더가 적재될 땐 java internal package 가 함께 적재되지만 Extension Loader 부터는 그러지 않는다. 필요할 때 로드한다. 

## When something goes wrong

> Let's have a quick glance at problems related to class loaders. The common root cause comes because runtime dependencies may differ from compile-time ones. For instance, a project may be compiled successfully, but some classes were not added to the classpath. In that case, a class loader cannot find a class. That leads to ClassNotFoundException or NoClassDefFoundError. Another kind of exception happens because a project was compiled with one version of a class, but the classpath includes a different one. In that case NoSuchMethodError or NoSuchFieldError are thrown.

- classpath 에 해당 클래스가 없다면 ClassNotFoundException 또는 NoClassDefFoundError 가 발생한다. 
- 그리고 해당 클래스가 컴파일 되었지만 클래스패스에 다른 버전의 클래스가 있다면 NoSuchMethodError 또는 NoSuchFieldError 가 발생한다.





 