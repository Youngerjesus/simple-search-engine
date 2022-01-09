# Work on project. Stage 4/6: X-files

## Description

Now, let's further modify the program and teach it to read the input data from a file.

## Objectives
In this stage, your program should read data from a text file instead of the standard input. The file structure will depend on your text data type (personal information, address information, book information, and so on). See an example below:

```
Dwight Joseph djo@gmail.com
Rene Webb webb@gmail.com
Katie Jacobs
Erick Harrington harrington@gmail.com
Myrtle Medina
Erick Burgess
```

The program must process the command line argument `--data` followed by the name of the file with the data, for example, `--data text.txt.`

Note that the file should not include the total number of lines. All lines must be read only once, at the start of your program.

## Example
Here is an example of an output line, which contains three items: the first name, the last name, and an email address.

The lines that start with > represent the user input. Note that these symbols are not part of the input.

```
=== Menu ===
1. Find a person
2. Print all people
0. Exit
> 1

Enter a name or email to search all matching people.
> WEBB@gmail.com
Rene Webb webb@gmail.com

=== Menu ===
1. Find a person
2. Print all people
0. Exit
> 0

Bye!
```

## TDD 리스트

- 파일에다가 데이터를 저장할 수 있어야한다. 
  - 파일에다가 사람에 대한 초기화 데이터를 저장하는 것
- 파일에 있는 내용을 가져와서 검색이 가능해야한다.
- FileDatabase 와 PersonDatabase 의 상속문제를 해결해야함. (코드 짜고 설계하는 연습은 계속해야곘디.)