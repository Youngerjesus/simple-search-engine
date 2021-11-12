# Theory: Writing code with pleasure

> Let's take a brief look at the useful tools in IDEA that help you code fast and efficiently.
  
***

## Running your program

> To start the program, run it with the
>
> icon on the left gutter or ⌃ R / Shift + F10 shortcut, take a look at the output:
>
> Run your code before checking the task to make sure everything works fine.
  
- control + r 키를 누르면 이전에 실행했던 프로그램을 재실행하는게 가능하다. 이외에도 아이콘을 누르면 실행할 수 있다.

***

## Comments

> Commenting a line. Use ⌘ + / or Ctrl + / shortcut to comment the line your cursor is currently on. You don’t need to move your cursor to the beginning of the line.
>
> Block comments. Use ⌘ ⌥ / (or Ctrl + Shift + /) shortcut to comment selected code fragment with block comment.
>
> Creating Javadoc stubs. Typing /** then pressing Enter above a method signature will create Javadoc stubs for you.
  
- 주석을 만드는 단축키에 대한 설명들
- command + / 키를 누르면 현재줄이 주석이 된다.
- command + option + / 키를 누르면 블럭 주석을 만들 수 있다.
- 이외에 그냥 /** 키를 직접 타이핑 한 후 엔터를 누르면 주석이 만들어진다.
- 그냥 여러가지 키를 쳐보다가 알게된건데 command + '-' 키를 누르니까 선언부만 보이고 본문을 숨길 수 있다.

***

## Navigation and selection

> Navigating through words. Use ⌥ Left Arrow / ⌥ Right Arrow (or Ctrl + Left Arrow / Ctrl + Right Arrow) to navigate through code elements in a line of code.
>
> Navigating through lines. Use ⌘ Left Arrow / ⌘ Right Arrow (or Home / End) to navigate to the beginning/end of the line of code.
>
> Selection. When you need to select some code fragments, handling the selection from the keyboard can be very helpful.
>
> - To manage the selection by word use ⌥ ⇧ Left Arrow / ⌥ ⇧ Right Arrow (or Ctrl + Shift + Left Arrow / Ctrl + Shift + Right Arrow).
> - To shrink or expand the selection by line use ⇧ Up Arrow / ⇧ Down Arrow (or Shift + Up Arrow / Shift + Down Arrow) shortcuts.
> - To move the selection to the line start/end use ⌘ ⇧ Left Arrow / ⌘ ⇧ Right Arrow (or Shift + Home / Shift + End) shortcuts.
>
> Cut a line of code. You can cut a line of code with the ⌘ X / Ctrl + X shortcut, just put a cursor somewhere on the line.
  
- word 순으로 끊어서 탐색하고 싶다면 option + left, right 방향키 를 누르면 된다.
- line 의 시작과 끝을 빠르게 탐색하고 싶다면 command + left, right 방향키를 누르면 된다.
- 코드 블락 중 한 라인을 선택하고 싶다면 command + shift + left, right 방향키를 누르면 된다. 
- 코드 라인 한 줄을 삭제하고 싶다면 command + x 키를 누르면 된다.
- 코트 라인 한 줄을 올리고, 내리고싶다면 option + shift + 위 아래 방향키를 누르면 된다. 

***

## Autocompletion and refactoring

> Smart autocompletion is an essential feature of a professional code editor, which helps you to save time and avoid misprints
> 
> Code autocompletion can help you to find the right variable. Once declared, a variable is added to the autocompletion list. Just start typing or simply press the shortcut to get a list of all the options:
>
> Code snippets, or live templates, can also be a handy tool. They not only speed up your coding but help you learn new language syntax as well. Use ⌘ J / Ctrl + J to see the full list of code snippets available. Start typing to find the one you want to add, and then use Tab to fill in the blanks:
> 
> If you have some experience of learning a foreign language, you might know this feeling when you can't quite put your finger on the right word. Learning a new programming language sometimes feels the same.
> 
> The IDE can help you to remember the right syntaxes. Start typing any parts you remember and the code completion will give you hints even if you only have some parts of the naming right:
>
> Code refactorings can also be handy regardless of how complicated your code is. For example, use ⌘ ⌥ V / Ctrl + Alt + V to extract a variable.
>
> It is often more effective to duplicate a line of code and then edit it than to write a new code line from scratch. ⌘ D / Ctrl + D works great for this, as you don’t need to select the whole line.
  
- 알던거라서 뭐..

***

## Names convention

> Inspired by the best community practices, IntelliJ IDEA checks your code for many types of possible errors and code smells. Naming rules and conventions are among them.
>
> If you try one of the examples above and declare a variable with an invalid name, the IDE will highlight it as an error and suggest a quick fix (within the red bulb or ⌥ Enter / Alt + Enter shortcut):
>
> IntelliJ IDEA can also declare a new variable for you with a quick intention action. Just start with a value, and then invoke the intention action with the shortcut:
>
> You can also tell the IDE to check your variables for naming conventions. Go to File | Settings | Editor | Inspections | Java | Naming conventions and switch on the Local variable naming convention inspection:
>
> Now all the inappropriate names will be highlighted as well:
>
> You can switch on or off all of the inspections, or configure them the way you need, as well as the intention actions.

- 알던거라서 뭐.. 
***

## Reading documentation

> Reading documentation is a must when learning a new programming language. IntelliJ IDEA makes this process as seamless as possible.
>
> Put a cursor on the class, method, variable, or function you want to read about, and then press ⌃ J / Ctrl + Q to open the quick documentation pop-up:
>
> Use the shortcut once more to switch to the tool window mode:
> 
> This lets you read the documentation in parallel with reading your code. Go through the code fragment and read about the code constructions your cursor is on, without any additional shortcuts or mouse clicks. You can also click hyperlinks to find out more details.
  
- control + j 키를 누르면 클래스, 변수, 함수 설명을 읽을 수 있다. 


 
