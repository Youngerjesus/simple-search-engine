# Theory: Reading files

> There are many different ways to read files in Kotlin, but let's focus on just a few of them for now. The core class for file processing is File from the java.io package. Kotlin provides additional functionality over Java implementation through Extension Functions. This means that by just importing java.io.File into your project, you can use functionality from both Java and Kotlin File implementations. Let's take a closer look at these extension functions.

- Kotlin 에서 file 을 다루는 방식은 여러개가 있지만 그 중 가장 근본적인 것은 java.io 패키지에 있는 파일을 처리하는 기능을 확장해놓은 것이다. 이를 살펴보겠다.

***

## readText

> First, there is readText() which helps you read the whole file in just one String variable.
>
> Say we create a text file reading.txt with the following text:
>
> ```
> Kotlin or Java,
> Java or C++.
> ```
> 
> We put it in src folder, and now we can read it with our readText() method:
>
> ```kotlin
> val fileName = "src/reading.txt"
> val lines = File(fileName).readText()
> print(lines)
> ```
> 
> As, you may have already guessed, the output is this:
>
> ```kotlin
> Kotlin or Java,
> Java or C++.
> ```
> 
> As you see, we made a mistake and tried to read a different file – new.txt. If there is no such file in the filesystem, then NoSuchFileException is thrown. You can catch and process it as a usual Kotlin's exception, it's totally up to you. Now we can fix our example and continue:
>
> ```kotlin
> val fileName = "src/reading.txt"
> val file = File(fileName)
> if (file.exists()) { // checks if file exists
>   val lines = file.readText()
>   print(lines)
> } 
> else print("No such file")
> ```
> 
> Actually, our file variable didn't open the file, it just provided a reference with the path to it. What's more, readText() automatically opened and closed the file!
>
> We can also provide specific charset for reading the file:
>
> ```kotlin
> val line = File(fileName).readText(Charsets.US_ASCII)
> ```
> 
> Just keep it in mind that by default readText() has UTF-8 charset encoding, but you can change it whenever you want. Also, Kotlin doesn't recommend using this function with files larger than 2 Gb, because this may cause OutOfMemoryError.
>
> We can also check the existence of a file with exists() method, which will return false in case of a missing file and true if Kotlin found it. Actually, you can use any method from File, for example, length() or delete().

- File.readText() 메소드를 통해서 파일의 전체를 String 형식으로 읽어올 수 있다.
- readText() 를 호출한 시점에 파일이 열리고 읽어오고 닫힌다.
- 파일이 없다면 NoSuchFileException 이 발생한다. 그러므로 파일이 있는지 없는지 체크하고 싶다면 file.exists() 메소드를 통해서 확인하자. 이 메소드는 파일을 열지 않는다.
- readText() 를 사용할 땐 너무 큰 파일 (2GB 정도) 를 한번에 읽어올려고 하지말자. OutofMemoryError 가 발생할 수 있다.
- readText() 에서 인자로 읽어올 구체적인 Character set 을 넘길 수 있다. 기본은 UTF-8 이다.

***

## readLines

> Function readLines() provides the functionality of reading files for each line and store it in List:
>
> ```kotlin
> val fileName = "src/reading.txt"
> val lines = File(fileName).readLines()
> for (line in lines){
>   println(line)
> }
> ```
> 
> The output will be the following:
>
> ```kotlin
> Kotlin or Java,
> Java or C++.
> ```
> 
> This method has the same size limitations and charset specification as readText().

- readLines() 메소드를 통해서 각각의 파일을 라인별로 구별해서 읽어오는 것도 가능하다. 
- 이 메소드는 readText() 와 사이즈와 charset 이 동일하다.

***

## readBytes

> Function readBytes() may be helpful if you need to store file contents as an array of bytes:
>
> ```kotlin
> val lines = File(fileName).readBytes()
> ```
> 
> Note, this function returns the ByteArray. The Array structure is similar to the MutableList, you cannot resize it, but you can modify elements. You can easily convert MutableList to ByteArray and vice versa with toByteArray() and toMutableList() functions.
>
> It's still not recommended using this option with large files (2 Gb or more). This method is used as an implementation of readText() function with conversion to String in Kotlin source files.

- readBytes() 메소드를 통해서 바이트의 어레이 형식으로 가져올 수 있다.
- 어레이 구조는 MutableList() 와 비슷하고 resize 가 안된다. 물론 안의 요소는 변경하는게 가능하다.
- 이 메소드도 readText() 와 유사하기 때문에 너무 큰 파일에는 추천하지 않는다.

***

## forEachLine

> forEachLine() is the recommended way of reading large files:
>
> ```kotlin
> val fileName = "src/reading.txt"
> File(fileName).forEachLine { println(it) }
> ```
> 
> This lambda reading approach provides an action (println() in our case) for each line.
>
> It's always a possibility that the file you're going to read has already been opened in another process, or it might have access restrictions. In such cases, AccessDeniedException is thrown.

- forEachLine() 메소드를 통해서 큰 파일을 읽어올 수 있다.
- 이 함수를 사용할 때 각 라인을 읽어오고 어떻게 처리할 건지를 람다식에 전달해주면 된다.
- 이 함수의 경우 다른 프로세스에 파일이 열려있는 경우에도 접근해서 읽어올 수 있다. 이 경우 권한이 없다면 AccessDeniedException 이 발생한다.


