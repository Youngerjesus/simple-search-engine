# Theory: Linear search

***

## The linear search algorithm

> Linear search (or sequential search) is a simple algorithm for searching an element with a specific value in the array. The algorithm checks each array element until it finds the target value or reaches the array end.
>
> In the worst case, it performs exactly nn comparisons where __n__ is the length of the input array. The time complexity is __O(n)__.

- linear search 의 정의 하나하나 데이터를 발견할 때까지 찾아보는 과정이다.  
- 시간 복잡도는 O(N) 이 걸린다. 

***

## Example

> Suppose, we have an array of 6 elements:
>
> Our goal is to find the index of an element with the value 20. We will start from the first element with index 0 and compare each array element with the target value until we find the target value.
>
> As you may see, the linear search is a simple algorithm with an important advantage: it can search in unsorted arrays.
>
> ```
> found_value(array, value)
>     for index in [1, len(array)]   // looking through the array
>         if array[index] == value   // if the current value is equal to the value we are 
>                                    // searching for,
>             return index           // then we return the index of this element;
>     return -1                      // if the sought value is not in the array, we return -1
> ```
  
***

## Possible modifications

> Possible modifications of the linear search algorithm are:
>
> - check whether the array contains an element, return true or false;
> - search for the first or the last occurrence of an element in the array;
> - count all occurrences of an element in the array;
> - search for all occurrences of an element in the array;
> - search for an element in the subarray of the array with the given indices.
>
> Also, the linear search algorithm can be used as a subroutine in more complex algorithms. For example, to count all occurrences of all array elements in another array.
>
> If we know that our array is sorted (e.g. in ascending order), we could modify the linear search algorithm. If the next checked element is greater than the target value, it means we will not find the value in the rest of the array, and the algorithm should stop. In the next topics, we will examine how to make searching in sorted arrays more effective.
  


  
