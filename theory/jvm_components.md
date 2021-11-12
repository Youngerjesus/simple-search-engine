# Theory: JVM components

***

## What is Java Virtual Machine?

> The Java Virtual Machine (JVM) is a virtual simulation of a physical computer that executes compiled Java programs (bytecode). JVM runs as an application on top of an operating system and provides an environment for Java programs
>
> Because they use virtual machines, Java programs are platform-independent and can be executed on different hardware and operating systems according to the WORA (Write Once Run Anywhere) principle.
>
> There are a lot of different JVM implementations. HotSpot is the primary reference Java VM implementation. It's used by Oracle Java and OpenJDK.
>
> Many JVMs (including HotSpot) are implemented according to the Java Virtual Machine Specification. You do not need to read it now, just remember that this specification exists.
  
***

## The JVM internals overview

> After the compilation of a Java program, there is a file with the .class extension. It contains the Java bytecode. In order to execute the code, you need to load it into JVM. When JVM executes a program, it translates the bytecode into the platform native code.
>  
> JVM mainly performs the following activities:
> 
> - loads bytecode;
> - verifies bytecode;
> - executes bytecode;
> - provides the runtime environment.
>
> The following image illustrates the common JVM architecture:
  
- jvm 이 하는 활동은 다음과 같다.
- bytecode 를 로드하고 (Class Loader)
- bytecode 를 검증하고 (Class Loader)
- bytecode 를 실행한다. (Execution Engine)
- 그러면서 이제 런타임 환경을 제공해준다. (Runtime Data Areas) 

***

## The class loader subsystem

> This subsystem loads the Java bytecode for execution, verifies it and then allocates memory for the bytecode. 
>
> We cover the subsystem in another topic. To verify bytecode there is a module called bytecode verifier
>
> It checks that the instructions don’t require any dangerous actions like accessing private fields and methods of classes and objects.

- class loader 에 의해서 bytecode 를 메모리에 로드하고
- bytecode verifier 에 의해서 bytecode 를 검증하는 역할을 한다. (다 클래스로더에 있는 것들.)
- 주로 검증은 어떠한 위험한 행동을 하지 않는가? 에 대한 검사이다. (private field 나 메소드에 접근하고 있는지 등.)

***

## The runtime data areas

> This subsystem represents JVM memory. The areas are used for different purposes during the program execution.
> 
> - PC register holds the address of the currently executing instruction;
> - stack area is a memory place where methods' calls and local variables are stored;
> - native method stack stores native method information;
> - heap stores all created objects (instances of classes);
> - method area stores all the class level information like class name, immediate parent class name, method information and all static variables.
> 
> Every thread has its own PC register, stack, and native method stack, but all threads share the same heap and method area.

- JVM 의 서브 시스템에서 메모리 역할을 해주는게 Runtime Data Area 이다. (프로그램 실행 환경을 제공해주는 것.) 
- 여기에는 다음과 같은 것들이 있다.
- PC Register: 현재 실행될 명령의 주소를 저장하고 있다. 
- stack area: call stack 으로 불리는 곳. 메소드 호출 정보를 담고 있는 Stack frame 들이 저장되는 곳. 
- native method stack: native method 정보가 저장되는 곳
- heap: 만들어진 모든 객체가 저장되는 곳.
- method area: 클래스 수준의 정보를 저장하는 곳. 클래스 이름이나, 메소드 정보 등에 관한 것.
- 모든 스레드들은 자신만의 pc register 과 stack 그리고 native method stack 을 가지고 있다. 
- 공유하는 자원은 heap 과 method area 이다. 

***

## Execution engine

> It is responsible for executing the program (bytecode). It interacts with various data areas of JVM when executing a bytecode.
> 
> The execution engine has the following parts:
> 
> - bytecode interpreter interprets the bytecode line by line and executes it
> - just-in-time compiler (JIT compiler) translates bytecode into native machine language while executing the program (it executes the program faster than the interpreter);
> - garbage collector cleans unused objects from the heap.
> 
> Different JVM implementations can contain both a bytecode interpreter and a just-in-time compiler, or only one of them. Do not confuse them with the javac (source code to bytecode compiler); it's not included in JVM.

- JVM 서브 시스템 중에 바이트 코드를 실행하는 책임을 가진 것이 Execution Engine
- Bytecode Interpreter: 바이트 코드를 해석해서 바로 실행하는 것.
- JIT Compiler: 바이트 코드를 번역해 머신 언어로 바꿔서 더 실행이 빠르게 하는 것
- GC: 힙에서 사용되지 않는 오브젝트를 제거하는 것.  

***

## Interfaces and libraries

> Other important parts of JVM for execution:
>
> native method interface provides an interface between Java code and the native method libraries;
> native method library consists of (C/C++) files that are required for the execution of native code.
> 
> Thus, JVM has a lot of parts. We won't cover all of them because it's enough to understand the JVM in general. The class loader working principles and garbage collection algorithms will be discussed in separate topics.


