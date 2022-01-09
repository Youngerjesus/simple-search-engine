# Work on project. Stage 2/6: Expand the search

## Description

Now, let's make our search a little more complex. Let's write a program that performs multiple searches in multiple text lines.

## Objectives

Write a program that reads text lines from the standard input and processes single-word queries. The program must output all lines that contain the string from the query.

You may choose what kind of text you will input in your project. For example, each line may describe:

- a person represented by the first name, the last name, and optionally an email;

- an address of a building represented by the country, city, state, street, and zip code;

- a book represented by its ISBN, title, author/authors, publisher, and so on.

You can use any of these options or come up with your own, but it is important to stick to the same type of data in your dataset throughout all stages of the project. As item delimiters, you can use spaces, commas (see CSV), or any other characters.

Here is an example of an input line. It contains three items: the first name, the last name, and an email address.

```
Elsa Sanders elsa@gmail.com
```

In this example, all items are separated by spaces.

The search should be case insensitive and ignore all extra spaces.

First, the user should input a number N, which is the number of data lines they are going to enter next. Then the user enters N lines with data. After that, the user enters a number M, which is the number of search queries. After each query, the program should print the information it managed to find among the data. You can see this searching process in the example below.

## Example

In the following example, we use several names and e-mails as a dataset. The lines that start with > represent the user input. Note that these symbols are not part of the input.

```
Enter the number of people:
> 6
Enter all people:
> Dwight Joseph djo@gmail.com
> Rene Webb webb@gmail.com
> Katie Jacobs
> Erick Harrington harrington@gmail.com
> Myrtle Medina
> Erick Burgess

Enter the number of search queries:
> 3

Enter data to search people:
> ERICK

People found:
Erick Harrington harrington@gmail.com
Erick Burgess

Enter data to search people:
> unknown
No matching people found.

Enter data to search people:
> WEBB@gmail.com

People found:
Rene Webb webb@gmail.com
```


## TDD 리스트 

- ~~Input 을 DB 에 저장할 수 있어야 한다.~~
  - ~~Input 에서 Person 모델을 가지고 저장하면 된다.~~  
  - ~~데이터를 가지고 올 수 있어야한다. (firstName, lastName, email 모두)~~
- 쿼리를 가지고 사람들을 찾을 수 있어야 한다.
  - 한 명을 찾을 수도 있고, 여러명을 찾을 수 있다. 
- 쿼리를 가지고 사람들을 못찾으면 "No matching people found." 을 print 해야한다.
- 문제 해결 방법으 어떤게 있을까? 
  - 모든 칼럼마다 (firstName, lastName, email) 인덱싱을 걸어서 데이터를 조회하는 방법
    - 데이터 중복이 발생한다. 대신에 결과르 조회하는 속도는 더 빠르다.
   
   

