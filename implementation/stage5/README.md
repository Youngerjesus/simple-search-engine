# Work on project. Stage 5/6: Inverted Index search


## Description
Now your program can successfully search for all matching lines, and the search is case- and space-insensitive. There is one problem though: you need to check each line to find out whether it contains the query string.

To optimize your program, you can use a data structure called an Inverted Index. It maps each word to all positions/lines/documents in which the word occurs. As a result, when we receive a query, we can immediately find the answer without any comparisons.

## Objectives

In this stage, build an inverted index at the start of the program and then use the index for searching operations. You can implement it using the Map class. It connects an item with a list (or set) of indexes belonging to the lines that contain the item.

Suppose you have the following list of lines:

```
0: Katie Jacobs
1: Erick Harrington harrington@gmail.com
2: Myrtle Medina
3: Erick Burgess
```

For these lines, the inverted index will look like this:

```
Katie -> [0]
Jacobs -> [0]
Erick -> [1, 3]
Harrington -> [1]
harrington@gmail.com -> [1]
Myrtle -> [2]
Medina -> [2]
Burgess -> [3]
```

The order of pairs is not important. If you are searching for Erick, you can immediately get the target fields using this mapping.

Note that the Inverted Index is not intended to search for parts of a word, it is only used to search for full words.

## Example

The lines that start with `>` represent the user input. Note that these symbols are not part of the input.

```
=== Menu ===
1. Find a person
2. Print all people
0. Exit
> 1

Enter a name or email to search all matching people.
> ERICK
2 persons found:
Erick Harrington harrington@gmail.com
Erick Burgess

=== Menu ===
1. Find a person
2. Print all people
0. Exit
> 1

Enter a name or email to search all matching people.
> ROY@gmail.com
1 person found:
Richard    Roy    roy@gmail.com

=== Menu ===
1. Find a person
2. Print all people
0. Exit
> 1

Enter a name or email to search all matching people.
> john
No matching people found.

=== Menu ===
1. Find a person
2. Print all people
0. Exit
> 0

Bye!
```

## TDD 리스트 

- InvertedIndex 자료구조를 만들어야 함.
  - term -> document 사이가 매핑이 되야한다.
- File 에서 데이터를 읽어올 때 Inverted Index 를 만들어야 함.
- 쿼리릉 보고 Inverted Index 를 통해서 서치가 가능해야함. 
