# Theory: Pseudocode

> Different people use different programming languages, and that often becomes a problem. If you implement an algorithm you've written in one particular language, developers who don't know that language would hardly be able to understand it. To solve this problem, you can use a pseudocode, a special artificial language that stands somewhere in between "human" language and code. Let's find out what it is and why we need it at all.
  
- 프로그래밍 언어로 알고리즘을 짜면 그 언어를 모르는 다른 개발자는 이해하지 못한다.
- 그래서 수도코드를 이용한다. (모든 인간이 이해할만한 코드를 말하는 듯.)

***

## What is pseudocode?

> Despite the variety of programming languages, they all share some common features. These include variables, loops, if-else blocks, and so on. In fact, if we remove all language-specific features from a program, we are left with its "logical core", which is the essence of any algorithm. By isolating this core, we are inevitably forced to resort to high-level constructs like "Do A until B happens", where both A and B can be quite complex operations. So, this essence of an algorithm may be called a pseudocode.
>
> If we decide to use pseudocode, we lose the opportunity to "explain" our instructions to a computer, which requires a significantly lower-level input. On the other hand, we gain a lot in the brevity of our solution and its comprehensibility to people, which is exactly what we strive for when we create pseudocode.
  
- 모든 프로그래밍 언어에서 가지고 있는 공통적인 특성이 있다. (변수, 루프, if-else 등)
- 이러한 특성과 함께 수도 코드에서는 알고리즘의 논리적인 핵심들을 넣어둠으로써 설명을 한다. 
- 이렇게 하면 물론 컴퓨터는 이해하기 힘들겠지만, 좀 더 추상화된 핵심들 기반으로 인간에게 설명하는게 가능하다. 

***

## Why do we need pseudocode?

> But why should we use an abstract language, not an existing one? Of course, we can use a popular and simple language like Python, and many programmers can understand this code. The main problem here is that in real code you need to work with memory, include libraries, solve some problems with visibility, variable types, and so on. Why do we need to think about this stuff if we want to understand the algorithm? An abstract language better describes the idea of an algorithm without complications.
>
> Another obvious solution to the problem of universal description of an algorithm is to simply describe it in human language. Alas, this is also a bad idea. In this case, you have to read a lot of text and take some time to figure out what the code will look like. With pseudocode, you don't need to clarify the description and it's easy to see the structure of the code.
  
- 대중적인 프로그래밍 언어를 쓴다고 해도 그렇게 명확하지 않을 수 있다. (클린코드가 아니라면)
- 그리고 오로지 텍스트로만 설명하는 것도 그렇게 좋지 않다. 많은 양을 읽어야 할 수 있고 코드로 어떻게 구성되는지의 작업도 분명 생각해봐야한다. 
- 수도 코드를 사용하면 코드 구조로 설명이 가능하고 오로지 알고리즘 로직에만 집중 할 수 있어서 좋다. (데이터 인풋 처리나 변수 선언같은 것들을 모두 제거하는게 가능하다.) 

***

## Pseudocode example

> Let's solve a standard task and find the maximum value in an array of positive numbers. The array is just an ordered bunch of numbers if you're not already familiar with the term.
>
> First, let's look at a pseudocode function:
> 
> ```
> max(array)                    // you receive an array somehow
>     if len(array) == 0        // compare the size of array with 0
>         return -1             // empty array, no maximum
> 
>     max = 0                   // assume that maximum is the 0
>     
>     for i in [1, len(array)]  // iterate over the array, array indices start at 1
>         if array[i] > max     // if we find something greater, we change the maximum
>             max = array[i]
>     
>     return max                // our result
> ```
>
> It looks pretty straightforward and gives a sense of the algorithm's internal logic.
>
> Now let's look at the Python code that does basically the same:
>
> ````python
> n = int(input())                # the size of array 
> array = []                      # empty array
> for i in range(n):              # do something n times
>     array.append(int(input()))  # add element to the array
> 
> if n == 0:                      # empty array
>     print(-1)
> 
> else:
>     max = 0                     # current maximum
> 
>     for i in array:             # iterate over the array
>         if i > max:         
>             max = i             # update the maximum
> 
>     print(max)
> ````
>
> As you can see, we can omit reading and storing values. With pseudocode, we can describe only the algorithm's logic.
>
> The pseudocode has a lot of variations and dialects. In this course, we will use a specific version of pseudocode. We will talk more about our dialect in the following topics. For now, it's important that you know how to read and understand pseudocode, not how to write it correctly.
  


