# Theory: Searching problem

> If you want something from a group of objects, you need to perform a search. It applies to all aspects of life. For example, if you want to get your algorithm book from a pile of books, you have to search. If you want to buy a pair of shoes that fits you, you have to search among different sizes. In programming, we always deal with data structures that are collections of data. Likewise, to get the desired data, we have to search for it. This searching problem is so common in programming that intelligent solutions are indispensable to make our program more efficient and reliable.
  

## What do we search for?

> In programming, we usually search for information about:
>
> 1. __Value__: We want to know whether a list or an array of data contains our desired value, and we need to access it.
> 2. __Location__: We might need to find out the site that holds our data. It can be the index number of an array or the memory address of the storage that contains the data.
>

***

## How do computers search?

> Computers have instant access to all of their memory addresses, i.e., if you tell a computer an index number, it will tell you the value contained there right away. But when it comes to searching, a question of efficiency arises. Searching is a tedious job for a computer since it cannot see an array like a human and jump directly to a particular value.
>
> Let's elaborate on the concept of searching using the previous example. Suppose we have given our computer an array of six numbers. To the computer, it looks like this:
>
> Now, to find the value 11, the computer starts exploring the indexes one by one. First, it checks the index 0:
>
> It contains the value 9, not 11. Next, it checks the index 1:
>
> Still, the computer is out of luck as index 1 contains the value 2, whereas it needs 11. Then it moves to the following index:
>
> Hurray! It has found the value 11. In this case, it stops here and won't explore the following indexes.
>
> In this particular example, the computer has performed three steps in total to find the value 11. The worst-case scenario could have happened if only the last index contained the value 11. Then, the computer would've had to perform six operations to find the desired value.
>
> Now, imagine our array contained thousands of numbers. Then the computer would have to perform thousands of operations to find a certain value. At this point, you may have guessed why intelligent searching algorithms are necessary to help computers find the desired number with the fewest possible operations.
>
> There are several searching algorithms available. We can classify all of them into two categories, namely sequential search and interval search. Now let's learn about them briefly.
  
- 일반적인 Searching 은 Brute-force 방식이다. (이는 너무 많은 연산을 해야한다.)
- 그래서 Searching Algorithm 이 필요하다. 
- Searching Algorithm 은 크게 Sequential search 와 Interval search 로 구분할 수 있다.

***

## Sequential search

> The steps that our computer followed in the previous example in order to find the number 11 is sequential search, also known as linear search. Here, the computer is clueless about its next move, so it starts exploring indexes sequentially from the very beginning until it gets the desired value. We need this method when we don't know any pattern in our data; that is, our data is a collection of some random, unsorted values. In that case, we have no other option than to analyze them from the beginning one by one.
>
> For example, we have to find an algorithm book in a pile of random books. We have to start looking for the book sequentially. If we are lucky enough, we might find the book very soon. But what if our algorithm book is the last one? Now you see that sequential search is luck-dependent: there is no elegance here.
  
- Sequential search 는 linear search 라고도 불린다.  
- 데이터에 대해서 어떠한 패턴을 알 지 못할 때 이런 방식을 쓸 수 밖에 없다. (좋은 방법은 아니다.) 
- 패턴을 알게되면 패턴에 맞춰서 다음 탐색지점으로 가서 찾아보는 것인듯. 

***

## Interval search

> In interval search, we try to be innovative and guess our next move based on the data. This cleverness is only possible when we discover a pattern in our data or our data is sorted.
>
> Let's think about the problem of finding a pair of shoes that fits you. Shoes are already categorized based on size, style, purpose, etc. Drawing on these choices, we can quickly narrow down our searching area. Do you want a pair of shoes for hiking? You can move forward and search only where hiking shoes are displayed.
>
> Now, suppose you have found a pair of shoes of your choice. But when you put them on, they feel tight. After this, you will only look for a bigger size than the one you chose first. You won't have to search for a smaller size.
>
> Interval search algorithms work quite the same way. They narrow down the searching area based on some criteria or a pattern. For this reason, interval search is always faster and more efficient than sequential search.
>
> Now let's illustrate the searching algorithm by playing a game. You may be familiar with the guessing game where one person guesses a number and the other person says whether the number they've thought of is lower or higher than the guessed one. Suppose the correct number is 63, but you don't know that. We ask you to guess a number between 1 and 100. You will probably say that the number is 50. Now we tell you that the actual number is higher. At this point, you can immediately forget about the first 50 numbers and guess a number between 51 and 100. This time, suppose you say the number is 75. We tell you that the actual number is lower, and you discard numbers from 75 to 100. After that, luckily, you guess the correct number and say the number is 63.
>
> After guessing just 3 numbers you have figured out the correct answer. This is a lot faster than guessing numbers sequentially from 1 to 63.
  
- Interval search 는 데이터가 특정한 패턴을 가지거나 특정한 카테고리가 있다면 이를 이용해서 찾아야 하는 데이터의 영역을 줄일 수 있는 것이다.
 



 



     


