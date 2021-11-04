# Theory: What is an exception

> Like in many other languages, some unexpected situations may occur in Kotlin. Imagine, you've written your program and now you are trying to run it. Suddenly, the Kotlin compiler says that code isn't correct and marks errors in the code. However, no compiler is almighty, so the Kotlin one can't prevent all the possible errors. Therefore, an error can happen while a program is running, even though it's syntactically correct and has been compiled without any problem. Such situations are called Exceptions in Kotlin and we are going to explore this concept.
  
***

## Causing an exception

> First of all, let's describe an exception. Obviously, it's an unexpected and non-standard event, which occurs in different situations and may be annoying for any programmer. Let's look at the example below:
>
> ````kotlin
>  fun readNextInt(): Int {
>      return readLine()!!.toInt()
>  }
>  
>  fun runIncrementer() {
>      val increment = 1 + readNextInt()
>      println(increment)
>  }
>  
>  fun main() {
>      runIncrementer()
>  }
> ````
> 
> We've just created a function to read from the standard input. It's quite a simple example: we just read a line, convert it to a number and return the result. Any possible problems? Well, here they are: we can't be sure that a user won't type something like this:
>
> ```
> > Hi :)
> ```
> 
> Oops! If you run the program and enter this line, an exception will happen and the program will just output this:
>
> ```
> Exception in thread "main" java.lang.NumberFormatException: For input string: "> Hi :)"
>      at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
>      at java.lang.Integer.parseInt(Integer.java:580)
>      at java.lang.Integer.parseInt(Integer.java:615)
>      at TmpKt.readNextInt(tmp.kt:2)
>      at TmpKt.runIncrementer(tmp.kt:6)
>      at TmpKt.main(tmp.kt:11)
>      at TmpKt.main(tmp.kt)
> ```

- 예외가 발생하는 상황을 가정한 것인듯

***

## Reading an exception text

> This text is a way to notify a user about an error. If the user passes this text to the application's programmers, they will have a chance to understand how to help the user and how to fix the problem. We will discuss variants of avoiding exceptions in the next topics, but here you are going to learn what the text is about and how to read it. Let's read it together!
>
> First of all, the exception text contains java because we've run the program as Kotlin/JVM. In other environments such as the Kotlin/Native, the text will be different.
>
> The Exception in thread "main" phrase notifies that an exception happened and says the thread name. If you don't know what a thread is, it's totally okay for now. There will be special topics about threads.
>
> The java.lang.NumberFormatException: For input string: "> Hi :)" text demonstrates the exception name (java.lang.NumberFormatException) and the message (For input string: "> Hi :)").
>
> The name describes the kind of the exception and the message clarifies it.
>
> Finally, there are the lines starting with "at":
> 
> ```
>      at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
>      at java.lang.Integer.parseInt(Integer.java:580)
>      at java.lang.Integer.parseInt(Integer.java:615)
>      at TmpKt.readNextInt(tmp.kt:2)
>      at TmpKt.runIncrementer(tmp.kt:6)
>      at TmpKt.main(tmp.kt:11)
>      at TmpKt.main(tmp.kt)
> ```
>
> They are called a stack trace and they show where the exception happened. It's a trace because using it you are able to track places of function's calls. Each line is called a stack trace element. As you see, a line contains the function name (forInputString, readNextInt, main), the file name (NumberFormatException.java, Integer.java, tmp.kt), and often even the line number in the file (65, 615, 2, 6).
>
> Also, a stack trace element contains something that is called a canonical name of a class (java.lang.NumberFormatException, java.lang.Integer, TmpKt). This name allows you to locate the place of the exception, too. It's less precise than the line number in the file but it's more human-readable.
>
> We aren't covering classes and their canonical names now, there will be topics for this. Now you can use files and line numbers to determine the place.

- Exception 이 발생하면 그것들을 읽어보자. 왜 일어나는지 이해하는데 도움을 줄 것 이다.
- Exception 은 Thread Name 과 Exception Name 그리고 Exception Message 마지막으로 Stack Trace 로 이뤄져있따.
- Exception Name 은 일어날 수 있는 Exception 유형을 결정해주고 Exception Message 는 예외가 발생한 것에 대한 메시지를 전달해준다.
- Stack Trace 는 Exception 이 어디서 발생했는지르 알려준다. Exception 이 발생한 곳이 가장 위에있고 각 단계마다 호출한 메소드 이름과 해당 클래스 위치가 적혀있다. 

***

## Ordering of stack trace elements

> It's important to mention that the order of stack trace elements is vital. A trace begins with the nearest place to the event and goes down to the first place of the functions call.
>
> For example, seeing the trace, you can say that the runIncrementer function calls the readNextInt function in the sixth line of the tmp.kt file and it somehow calls the parseInt function in the second line. Finally, the first line of a stack trace says pretty clearly where the event has happened.
>
> However, the first line often isn't enough to understand the problem because it can be an internal function that you don't even know about.
>
> In our example, the fourth stack trace element shows the problematic place in our function. And the third line demonstrates that an internal function that you can't modify is called. Which place to fix? It's a good question. You can't answer to it just by saying the first or the last stack trace element of your own code. Answering this question is more about common sense. We will discuss ways to fix the code later, but we can say now that actually it's better to fix the tmp.kt:6 line in this situation. Why? You will learn soon.
  
- Stack Trace 가 어떻게 구성되어 있는지 아는게 중요하다.
- Exception 이 발생한 Event 로 부터 Exception 이 발생한 처음 함수를 호출한 곳으로 연결되어있다.
- Exception 이 발생한 Event 위주로만 보면 충분한 정보를 제공해주지 못하는 경우가 있다. Internal Function 이기 때문에. (우리가 변경할 수 있는 부분이 아님. 즉 우리가 작성한 부분이 아님.)
- 그러므로 함수 호출이 어떻게 진행되는지 보는게 중요하다. 우리가 작성한 코드에서 에러가 발생할 것이기 때문.



