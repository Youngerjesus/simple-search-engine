# Work on project. Stage 1/6: String theory

## Description

Let's implement the simplest search engine possible ever. It should search for a specific word in a multi-word input line.

The input line contains several words separated by a space. The words are numbered according to their order, with the first word having index 1. Consider that all the words in the line are unique, so there can be no repetition.

## Objectives

Write a simple program that reads two lines: a line of words and a line containing the search word. The program must search in the first line for a word specified in the second one. The program should output the index of the specified word. If there is no such word in the first line, the program should print Not Found. Please remember that indexes start from 1!

You should output exactly one line.

## Examples

The lines that start with > represent the user input. Note that these symbols are not part of the input.

### Example 1:

```
> first second third fourth
> third
3
```

### Example 2:

```
> cat dog and mouse
> elephant
Not found
```

## TDD 리스트 

- String List 사이에서 주어진 단어를 못찾는 경우
- String List 사이에서 주어진 단어를 찾고 인덱스를 반환하는 경우 

