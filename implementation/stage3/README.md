# Work on project. Stage 3/6: User menu

## Description

Let's modify the previously written search program an add a user menu for a better user experience.

## Objectives
In this stage, you need to create a menu. The menu should display the following options:

```
1. Search information.
2. Print all data.
0. Exit.
```

The user must select a menu item and then enter data if necessary. Your program must not stop until the corresponding option (exit) is chosen.

Decompose the program into separate methods to make it easy to understand and to further develop or edit.

## Example
In the example below, we use people's names and emails as a dataset example. The lines that start with > represent the user input. Note that these symbols are not part of the input.

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

=== Menu ===
1. Find a person
2. Print all people
0. Exit
> 3

Incorrect option! Try again.

=== Menu ===
1. Find a person
2. Print all people
0. Exit
> 1

Enter a name or email to search all suitable people.
> KATIE
Katie Jacobs

=== Menu ===
1. Find a person
2. Print all people
0. Exit
> 2

=== List of people ===
Dwight Joseph djo@gmail.com
Rene Webb webb@gmail.com
Katie Jacobs
Erick Harrington harrington@gmail.com
Myrtle Medina
Erick Burgess

=== Menu ===
1. Find a person
2. Print all people
0. Exit
> 0

Bye!
```

## TDD 리스트 

- 게임 프로그램을 시작할 App 클래스가 이제 필요하겠다. 
- Menu 클래스가 있고 각 번호바다 특별한 동작이 필요하겠다.
  - 잘못된 번호를 누르면 잘못되었다고 알려줘야함
  - 0 번을 누르면 종료되야함 