# Theory: Writing files

> You can do a lot of interesting things with files: for example, you can read content from them or write something new. In this topic you will learn how to write files. There are different ways to write a file in Kotlin. We won't consider all of them here: let's start with the selected basics.

***

## Writing files with writeText()

> You may already know that the main class for working with files is java.io.File, and Kotlin library adds some features through the extension functions. An object of File type just provides a reference with the path to a file. First, you need to import this library:
> 
> ````kotlin
> import java.io.File
> ````
> 
> Suppose we want to create a text file called MyFile with the following text:
>
> ````kotlin
> "It is awfully hard work doing nothing!"
> ````
> 
> To do that, we need to use the aforementioned library, create a `File(pathName: String)` object, and use the `writeText(text: String)` function which sets the text content of a file:
> 
> ````kotlin
> val myFile = File("MyFile.txt") //file name must be indicated in parentheses 
> myFile.writeText("It is awfully hard work doing nothing!")
> ````
> 
> Mission accomplished: the text is in the file! You can see it in the current project directory where it was saved by default. Notice, if you just create a File object, you will not create a file, it's just an object.
>
> Suppose we didn't write the file in the current directory but elsewhere. In that case, simply indicate the path to it like this:
>
> ````kotlin
> val myFile = File("D://Users/myFile.txt")
> myFile.writeText("It is awfully hard work doing nothing!")
> ````
> 
> If you run the code, you can see that our file with the specified text was created on the corresponding disk following this path.
>
> If the file has access restrictions or has already been opened in another process, AccessDeniedException is thrown.
>
> Last but not least, let’s talk about code style: the file name should be put into a separate string variable. You can also put the text into a variable. Take a look:
>
> ````kotlin
> val fileName = "myFile.txt"
> val textToFile = "If we learn to process our code carefully, we’ll grow as programmers."
> File(fileName).writeText(textToFile)
> ````
> 
> This is considered good style, so it would be great if you make it a rule for yourself.

- File 을 만들고 쓰는 내용에 대해서 
- 가장 근간인 메인 라이브러리는 자바에서 제공해주는 `java.io.file` 이 있다.
- 파일을 생성하고 쓰려면 File(pathname) 을 통해 파일 객체를 만들고 writeText() 메소드에 파일에 넣을 텍스트를 넣으면 된다.
- 파일을 생성할 경로에 접근할 수 있다면 그 경로에 파일이 만들어지고 
- 파일 경로에 접근할 수 없다면 `AccessDeniedException` 이 발생할 것이다.
- 파일을 쓸 때 컨벤션으로 파일이름과 파일에 쓸 텍스트는 변수로 저장해놓고 한번에 저장하자.

***

## Formatting and processing

> Sometimes we need to apply formatting to improve the layout of the text. For example, we may need to move the text to a new line. In this case, the \n comes in handy:
>
> ````kotlin
> val fileName = "myFile.txt"
> File(fileName).writeText("Just \nlook\n at\n that!")
> ````
> 
> If you need to make an indented paragraph, use `\t:`
> 
> ````kotlin
> val fileName = "myFile.txt"
> File(fileName).writeText("\tThere’s a tab")
> ````
> 
> Feel free to experiment with this: the use of such tools is very easy yet effective. Even if the string with your text does not look very good, the text in the final file will look fabulous!

- `\n` 이나 `\t` 같은 개행문자를 넣어서 파일에 있는 문자열의 레이아웃에 변화를 줄 수 있다.

***

## Overwriting and appending

> You know how to create files with text content, but what if you need to overwrite an existing file? For this, you can use the same feature writeText() for File(), which specifies the path to the document we want to overwrite. Let's rewrite our text and use a different quote:
>
> ```kotlin
> File(fileName).writeText("Beware of bugs in the above code; I have only proved it correct, not tried it")
> ```
> 
> You can open the file and make sure it worked!
>
> Logically, if the specified file did not exist on this path, it will be created.
>
> Okay, and what if you wanted to save the current content of the file and add something else to it? Then we’ll need the appendText(text: String) function:
>
> ```kotlin
> val fileName = "myFile.txt"
> File(fileName).appendText(", Donald E. Knuth said.")
> ```
> 
> You can see that the text in our file now looks like this:
>
> ```kotlin
> Beware of bugs in the above code; I have only proved it correct, not tried it, Donald E. Knuth said.
> ```

- 이미 만들어진 파일에 내용을 덧붙이고 싶다면 File.appendText() 메소드를 이용하자.
- File.writeText() 같은 경우애는 overwrite 한다.

***

## Writing byte arrays

> Sometimes you need to write Bytes, not Strings. Let's briefly consider two other options for file writing.
>
> writeBytes(array: ByteArray) – with this function, we can write an array of bytes to this file.
>
> ```kotlin
> val arrayOfBytes = byteArrayOf(1, 2, 3) // create an array
> // another way:
> // val arrayOfBytes = mutableListOf<Byte>(1, 2, 3).toByteArray()
> 
> File(fileName).writeBytes(arrayOfBytes)
> ```
>
> appendBytes(array: ByteArray) – this function is analogous to the appendText() method, only applied to an array of bytes:
>
> ```kotlin
> val arrayOfBytes = byteArrayOf(0, 1, 2)
> File(fileName).appendBytes(arrayOfBytes)
> ```
> 
> Note, these functions work with ByteArray. The Array structure is similar to the MutableList, you cannot resize it, but you can modify elements. You can easily convert MutableList to ByteArray and vice versa with toByteArray() and toMutableList() functions.

- 파일에 저장하는 컨텐츠가 String 이 아니라 Bytes 인 경우에는 File.writeBytes() 와 File.appendBytes() 를 이용하면 된다.
- 파라미터로는 ByteArray 를 던지면 되는데 이는 MutableList 를 통해서도 쉽게 변환이 가능하다. toByteArray() 이런 메소드를 호출해서 




