# Theory: First steps to coroutines

> You already know about the different ways to process multiple tasks simultaneously in Kotlin. One of them is internal concurrency, which involves working with the coroutines library. In this topic, you will learn about the official Kotlin coroutines library, understand why it is not built into the language, and see how to set it up.

***

## What is `kotlinx.coroutines`

> Coroutines are a Kotlin library developed by JetBrains. It is multiplatform and available for all major Kotlin targets: JVM, JS, Native, and Android.
> 
> The library provides many methods of dealing with simultaneous tasks in Kotlin. You are probably curious about the specifics, but let's take it slow: before we can discuss the most useful methods in detail, we need to understand a few general things about coroutines.
> 
> The important fact about the library is that it is open-sourced, just like Kotlin itself. You can find the code in the GitHub repository, where anyone can see the process of development as well as report issues and suggest changes.
>
> Another resource worth checking out is the official documentation web page where you can find a variety of guides and examples. Reading through the documentation can help you understand coroutines better.

- coroutine 은 오픈소스로 개발되고 있고 여기서 보면 된다.
  - https://github.com/Kotlin/kotlinx.coroutines
- 그리고 coroutines 을 자세하게 보고 싶다면 레퍼런스를 참고하자.
  - https://kotlinlang.org/docs/coroutines-overview.html

***

## `kotlinx.coroutines` as a library

> It's important to understand that coroutines are not bundled with the Kotlin standard library — they are a dependency. If you haven't worked with external libraries before, don't worry: it's not a big deal. There are several reasons why coroutines are separated. Here are two major reasons:
> - Not every program needs internal concurrency. If coroutines were built-in, all Kotlin programs would take up more memory space because they contain redundant code.
> - Some developers don't want to use the official implementation of internal concurrency. When coroutines are a plugable module, you can easily plug not the official one but the one that best suits your particular situation.
>
> In other words, making coroutines an external library gives the users more freedom. This way, no-one is forced to use this particular implementation or even use internal concurrency at all!

- kotlinx.coroutines 가 왜 Standard library 가 아니라 plugin 형식인지에 대한 설명
- 이유 1) 모든 kotlin 어플리케이션이 coroutine 이 필요한건 아님. 이걸 standard 형식으로 해놓으면 메모리 낭비가 생길 것.
- 그리고 일부 개발자들은 Standard 형식의 coroutines 를 좋아하지 않기도 한다. 자신들만의 어플리케이션에 맞는 코루틴을 좋아해서.

***

## Maven dependency

> One of the most convenient ways to add the kotlinx.coroutines library to the project is using a Maven dependency. Here, we will show how to do this in Gradle, but other systems will most likely have their own ways to add Maven dependencies. Feel free to check out the description on GitHub for the up-to-date information about different build systems and platforms.
>
> The instructions are very easy. Just add the following lines to the build.gradle(.kts) file:
> 
> ```
> repository {
>     jcenter()
> }
> 
> dependencies {
> implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8")
> } 
> ```
>
> As you see, you should define a repository that Gradle will search for the library. Instead of jcenter(), you can use mavenCentral(): the library is available in both.
>
> Also, you should specify the dependency itself. When we were writing this topic, the up-to-date version was 1.3.8; you can find the number of the latest version on GitHub.

***

## Validation

> You need to make sure that kotlinx.coroutines is installed properly. You can test this file:
>
> ````kotlin
> import kotlinx.coroutines.delay
> 
> fun main() {
>     println(::delay.name)
> }
> ````
>
> If you did everything correctly, the program will compile and output the delay message.


