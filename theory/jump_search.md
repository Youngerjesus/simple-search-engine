# Theory: Jump search

***

## Introduction

> Jump search (also known as block search) is an algorithm for finding the position of an element in a sorted array. Unlike the linear search, it doesn't compare each element of an array with the target value. Instead, to find the target value, we can represent the array as a sequence of blocks:

- Jump search 는 block search 라고 불리며 정렬된 어레이에서 요소를 찾을 때 사용한다. 
- 여기서는 linear search 의 방식인 각각의 요소를 target Value 와 비교하는 작업은 하지 않는다.
- 대신에 target Value 를 찾기 위해서 어레이를 일련의 블록으로 나타내서 찾는다.
- 시간복잡도는 루트 n 이다. 최악의 케이스의 경우도 루트 n + 루트 n 이라서 루트 n 이다.

***

## Basic Principles

> Consider the basic principles of this algorithm for searching in ascending sorted arrays. Note that it can search in descending sorted arrays as well.
>
> __Principle 1.__ For ascending sorted arrays, any value from a block is less than or equal to any value from the following block.
> 
> __Principle 2.__ If the target element is not present at the beginning of the first block, and its right border exceeds the target element, it is not present in the array at all.
>
> The algorithm jumps over blocks to find the block that may contain the target element. So, the algorithm compares the right borders of blocks to the target element.
  
- Block search 에서 두 가지 원칙만 기억하면 된다.
- 원칙1) Ascending Sorted Array 기준으로 이전 블락의 요소는 다음 블록의 요소보다 작거나 같다. 
- 원칙2) target Value 가 볼록의 마지막 요소보다 크다면 다음 블록으로 가면 된다. 마지막 요소보다 작다면 첫 요소부터 찾아보면 된다. 

***

## Searching

> If the right border of a block is equal to the target element, we have found it. Sometimes we need to search the target with the minimum index.
>
> If the right border of a block is greater than the target element, we have found the block that may contain the target value. When we have found such a block, the algorithm performs a backward linear search within that block. If it has found the target value, it returns its index; otherwise, the array does not contain the target value.
>
> Sometimes blocks don't include the first array element, and then the algorithm works in the same way as described above. The complexity of the algorithm doesn't change.
> 
> Further, we will consider the algorithm with the jump size equal to sqrt(N)
> 
> Please keep in mind the following:
>
> - If sqrt(N) is not an integer value, we take only the integer part, using the floor function;
> - If the index of the following element to jump to is greater than the last element index, we jump to the last element.

- 마찬가지로 Ascending Sorted Array 기준으로 설명하겠다. 
- 블록의 가장 오른쪽 요소와 target Value 와 비교하고 target Value 가 더 크다면 다음 블록으로 점프한다.
- 블록의 요소가 더 크다면 이제 backward 로 linear search 하면된다.
- Jump size 는 sqrt(n) 으로 하는게 가장 이상적이다.

***

## Pseudocode of the jump search function

> ```
> jump_search(array, value)
>     step = floor(sqrt(len(array)))              // step to move to the next block (rounding the value of the 
>                                                 // square root of the length of the array to a smaller integer)
>     curr = 1                                    // index of the current element (the check starts from 1)
>     while curr <= len(array)                    // loop while the index is not bigger than the length of the array
>         if array[curr] == value                 // if the current value is equal to the target value
>             return curr                         // return the index
>         elif array[curr] > value                // else if the current value is greater than the target one
>             ind = curr - 1                      // we start the search inside the block from the end of the block;
>                                                 // the starting index is to the left of the right border of the block (curr)
>             while ind > curr-step and ind >= 1  // while the new index has not gone beyond the left border 
>                                                 // of the block (curr-step) or array (1)
>                 if array[ind] == value          // if the current value is equal to the target value
>                     return ind                  // return the index
>                 ind -= 1                        // reducing the index of the current element
>             return -1                           // the target value is not in the array, so return -1
>         curr += step                            // increasing the index of the current element by a step 
>                                                 // to move to the next block
>     ind = len(array)                            // we start checking the last block (if its length turned out to be less)
>                                                 // the starting index is equal to the last one
>     while ind > curr-step                       // while the new index has not gone beyond the left border of the block (curr-step)
>         if array[ind] == value                  // if the current value is equal to the target value
>             return ind                          // return the index
>         ind -= 1                                // reducing the index of the current element
>     return -1                                   // the target value is not in the array, so return -1
> ```

***

## Harder, faster, stronger

> In this algorithm, once we find the block that may contain the value, we perform a backward linear search. However, what we could also do perform another jump search within the block (backward or forward) and then recursively perform jump search until we have only one element.
  
- 조금이라도 더 빠르게 할려면 블록 사이즈에서 또 루트를 걸어서 찾고 또 거기서 루트를 걸어서 찾는 식의 방법이 있다. 
- 이렇게 해서 모두 더해도 시간복잡도는 sqrt(N) 이다. 

  
  

  

