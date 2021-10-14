# Theory: Introduction to Kotlin


## What is Kotlin?

> Kotlin is a highly effective modern programming language developed by JetBrains. It has a very clear and concise syntax, which makes your code easy to read.
>
> Knowledge of Kotlin allows developers to write mobile, server-side, and desktop applications, as well as useful frameworks and libraries. As a general-purpose language, it can be used in many spheres, such as financial services, telecommunications, embedded systems, medicine, development tools (like IntelliJ IDEA), and so on.

- 코틀린 언어의 특징을 말해준다. (easy to read, 람다로 표현 가능해서 그런듯.)
- 많은 플랫폼을 지원핟다. (server-side, mobile, desktop 등)
 
***

## A multiplatform language
> Kotlin is a multiplatform language.
  
> JVM: Kotlin is fully interoperable with Java, which means Kotlin works great with all existing Java code and libraries. It also allows companies to make a gradual migration from Java to Kotlin because Java code can access Kotlin code, too. At the same time, developers can use Kotlin as the only language for their projects without Java at all.
>
> Android: using Kotlin, you can create mobile applications for the most used operating system in the world.
>
> JS: Kotlin is also compatible with JavaScript, which enables you to develop client-side web applications and run them in a browser.
>
> Native: Kotlin code can be converted into a file that can be run on any OS such as Windows, Linux, iOS, and macOS.

- 여러가지 플랫폼위에서 코틀린을 사용하는게 가능하다. 특히 자바를 사용하는 곳에서 코틀린을 사용하는게 가능ㅎㄷ고 자바 코드도 코틀린 코드에 엑세스 하는게 가능하다. __(이게 정확하게 어떤 의미지? 자바 파일안에 코틀린 코드를 넣는게 가능하단 뜻인가?)__

***

## Features

> Kotlin is designed as a pragmatic language, which means that its main purpose is solving real-world problems rather than completing research purposes.
>
> It is also important that Kotlin supports multiple programming paradigms, such as imperative programming, object-oriented programming, generic programming, functional programming, and more. You will learn about these paradigms throughout the course.
>
> Last but not least, Kotlin is a tool-friendly language, which means all popular development tools, such as IntelliJ IDEA, Eclipse, and Android Studio, are compatible with it.

- 코틀린의 가장 큰 특징은 실용적인 언어다. __(어떻게 실용적인지 파악을 해야겠네. 큰 특징이 멀티 플랫폼을 지원한다와 실용적이고 코드를 이해하기 쉽다가 주 특징이라고 한다.)__
- 코틀린을 이용하면 여러가지 프로그래밍 기법들을 사용하는게 가능하다고 한다. Object Oriented Programming, Functional Programming, Imperative Programming 등
- 그 다음 많은 툴에서 코틀린을 지원한다가 있다.

***

## A brief history

> In July 2011, JetBrains unveiled the Kotlin Project, a new language for the Java Platform, which had been in development for a year. The name comes from Kotlin Island near St. Petersburg, Russia. The primary goal of this project was to provide a safer and more concise alternative to Java in all the contexts where Java is currently used.
>
> In 2016, the first official stable version was released (Kotlin v1.0). The developer community was already interested in using this language, especially on Android.
>
> At the Google I/O 2017 conference, Google announced first-class support for Kotlin on Android. Chet Haase, the chief advocate for Android, said: "We understand that not everybody is on Kotlin right now, but we believe that you should get there".
>
> At this moment, Kotlin is considered as a general-purpose language for many platforms, not only for Android. The language has several releases a year. The latest version can be found on the official site.

- 코틀린 프로젝트는 자바를 대체하기 위해, 자바를 좀 더 안전하게 사용하기 위해 나왔다.

***

## A sample Kotlin program

```kotlin
fun main() {
    println("Hello Kotlin")
}
```

