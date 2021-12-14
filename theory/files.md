# Theory: Files

> The data is stored on disks under certain addresses. For a computer, such addresses are numbers. It uses them to find the corresponding information. However, humans are not that good at memorizing sets of numbers. It's much easier for us to name our data, for example, family photo, November report, and so on. Therefore, the concept of a file was invented: in a file, one can store some information under any user-friendly name. Let's take a closer look at what files are.

- 데이터는 디스크에 저장된다.
- 디스크에 저장될 때 저장될 위치를 가리키기 위해 특정한 주소가 붙는데 이는 숫자라서 인간이 기억하기에는 무리가 있다.
- 그래서 파일이 만들어졌는데 파일에는 이름이라는 부가적인 메타 데이터가 붙는다.

***

## What is a file

> A file is associated with a piece of data. As for its name, typically there exist some restrictions in the system. For example, filenames must contain only those characters that are supported by a specific file system. There are different types of contents of the files: text, photo, music, video, etc. The type of information stored in a file defines the file format. In order for the computer to be able to distinguish what format a certain file has, file extensions were invented.

- 파일은 관련있는 데이터 조각의 모음으로 이름을 가지며 특정한 제한조건이 있다.
- 예를 들어서 파일 이름은 문자가 포함되어야 하며, 파일 컨텐츠는 파일의 종류에 따라서 다르다. 그리고 이런 정보의 종류는 파일 포맷에 따라서 다르고 컴퓨터는 이를 구별하기 위해 확장자를 만들었다.

***

## File extensions

> Finding out the format of a file right away is pretty useful. One way to do it involves filename extensions. The end of a filename informs users or programs about the file format. File format designation usually goes after a period, so you get a name ending with ".<extension>". As for more specific examples, here are some of the most common extensions: text files will have the .txt extension, for example, november_report.txt; files with photos may have the .jpg extension, like my_photo.jpg; for videos, the most usual is the .avi extension and for music files, it is .mp3. Operating systems use filename extensions to remember which program to use to open files with a certain extension. Filename extensions aren’t strictly necessary, though: they just eliminate the need to guess the format of a file.
>
> Now you know that a file extension is the service information used by a computer. Let's find out what other information a file has that helps computers understand what properties it has. This information is called file metadata.

- 파일 확장자를 통해 파일의 컨텐츠가 어떠한 형식으로 이뤄졌는지 알 수 있다.
- 그리고 파일 메타데이터를 통해서 파일에 추가적인 정보를 줄 수 있다.

***

## File metadata

> Metadata stands for "data about data". One of the most common pieces of such data is a filename we've discussed above. The others are for example the file size, creation time, the last access time, etc.
> 
> Also, metadata consists of file attributes. Each attribute has two states: set (toggled on) or cleared (toggled off). File attributes tell the file system or operating system if a file should get some special treatment. For example, if a file has a read-only attribute set, its contents can be read, but all attempts to modify them will be prevented by the file system until this attribute gets cleared. If a file has a hidden attribute set, it won’t show up in a graphical user interface unless the user explicitly tells the operating system to show all hidden files. Attributes can be used to restrict file access to specific groups of users.

- 파일은 메타데이터를 가진다. 이 종류로는 파일 사이즈, 파일이 생성된 시점, 파일에 마지막으로 접근한 시점 등이 있다.
- 그리고 메타데이터 중에는 File attribute 가 있는데 이는 여러가지가 있다. 그 중 예로 read-only 설정이 되어있다면 파일을 읽을 수만 있고 변경하는게 불가능하다. hidden 속성이 있다면 GUI 에서는 볼 수 없다.

***

## Absolute and relative paths

> In order to find any file, we need to know the path to it. The path is a character set indicating the location of a file in the system. The file path can be seen in the Explorer. There are two types of paths: an absolute and a relative path.
>
> A path to a file that starts with the root directory is called an absolute path and serves as the file’s unique identifier. If you try to create another file named "my_file" in the same subdirectory, the file system won’t allow you to do that. If both files have the same identifier, how will the system tell them apart? Creating a file named "my_file" in the root directory, however, would be okay: "root_directory/sub_directory/my_file" and "root_directory/my_file" are different identifiers.
>
> There is a catch with absolute paths though. When you write a program that will be installed on different computers, you know your own program’s directory, but you don’t know where other users of this program will install it. Your program’s directory can end up in any parent directory on a user’s computer, so you can't use an absolute path in your program to point to its directory.
>
> This is where relative paths come into play. Each process that runs on a computer is associated with a working directory on this computer; it is tracked and managed by the operating system. This basically means that the operating systems of other users will be focused on your program’s directory when they run it. Your program can address the working directory by using a special character . instead of the directory’s actual name, so you can use a path like "./my_file" without specifying the whole path from a root. You just let the user’s operating system figure it out! You can also use .. to address a parent directory of the working directory.

