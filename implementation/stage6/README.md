# Work on project. Stage 6/6: Search strategies

## Description

Now let's Improve your search engine to make it support complex queries containing word sequences and use several strategies that determine how to match data.

## Objectives

In this stage, your program should be able to use such searching strategies as ALL, ANY, and NONE.

Take, for example, these six sample lines:

````kotlin
Dwight Joseph djo@gmail.com
Rene Webb webb@gmail.com
Katie Jacobs
Erick Harrington harrington@gmail.com
Myrtle Medina
Erick Burgess
````

If the strategy is ALL, the program should print the lines containing all the words from the query.

Query:

```
Harrington Erick
```

Result:

```
Erick Harrington harrington@gmail.com
```

If the strategy is ANY, the program should print the lines containing at least one word from the query.

Query:

```
Erick Dwight webb@gmail.com
```

Result:

```
Erick Harrington harrington@gmail.com
Erick Burgess
Dwight Joseph djo@gmail.com
Rene Webb webb@gmail.com
```

If the strategy is NONE, the program should print the lines that do not contain any words from the query at all.

Query:

```
djo@gmail.com ERICK
```

Result:

```
Katie Jacobs
Myrtle Medina
Rene Webb webb@gmail.com
```

All the listed operations should be implemented with an inverted index, and the results should not contain any duplicates.

Do not forget to use methods to decompose your program.

## Example

The lines that start with > represent the user input. Note that these symbols are not part of the input.

```
=== Menu ===
1. Find a person
2. Print all persons
0. Exit
> 1

Select a matching strategy: ALL, ANY, NONE
> ANY

Enter a name or email to search all matching people.
> Katie Erick QQQ

3 persons found:
Katie Jacobs
Erick Harrington harrington@gmail.com
Erick Burgess
```

## TDD 리스트

- 검색 전략이 있어야 한다.
  - ALL: 쿼리에 모두 매칭될 때 찾는 경우
  - ANY: 하나의 쿼리에만 매칭될 때 찾는 경우
  - NONE: 쿼리에 모두 매칭안될 때 찾는 경우
- 각 전략에 따라서 찾는 방식이 달라야 한다.
- SearchEngine 을 만들 때 전략을 넣는 식으로. 