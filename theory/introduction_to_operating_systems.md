# Theory: Introduction to operating systems

> How can it be that there are thousands of different computer models but they all can run the same programs? Have you ever thought about how the programs interact with the hardware? These and other features are made possible by operating systems.

- 수 많은 컴퓨터가 어떻게 동일한 프로그램을 실행할 수 있는지, 프로그램이 어떻게 하드웨어와 상호작용 할 수 있는지에 대해 알아보는 시간을 가지겠다.

***

## Operating system

> An operating system (OS) is a set of software that manages communication between all other applications and hardware. It turns a computer into something more than just a bunch of metal parts, namely, a complex system that can effectively perform different tasks.
> 
> Nowadays, there exist a lot of operating systems for you to choose from. For personal computers, the most popular ones are Microsoft Windows, macOS, and Linux distributions. The two top mobile operating systems are Android and iOS. If you've ever heard of smart kettles and smart fridges, even they have their own OS.
> 
> Of course, the operating systems for such a range of devices differ greatly from one another. What they have in common are the means they provide to the programs and those who use them.
>
> On the one hand, it's only an illusion that your favorite browser is the same on Windows as it is on macOS. On the other hand, you can run the same application on different computers with the same OS.

- OS 는 어플리케이션과 하드웨어가 커뮤니케이션 할 수 있게 관리해주고, 여러가지 복잡한 일을 효율적으로 수행할 수 있도록 해준다.
- 현대에는 다양한 OS 가 있다.

***

## Functions of the OS

> An operating system controls the communication between all the computer software and hardware. An OS can give programs restricted access to processor units, memory, hard drives, network, peripherals, and other resources.
>
> You can run a browser, a media player, and ten other applications, and your OS is the one giving them all the resources they need to run properly. At the same time, this OS acts as a fair referee prohibiting any application to take up more resources than it actually needs
> 
> As a mediator between the applications and hardware, the operating system allows us to communicate with the device without going into details about its specifics or mechanics.
> 
> Any operating system has several essential functions. Here is a list of some of them:
>
> - data protection and secure access;
> - resource management;
> - interaction between hardware and peripherals;
> - file management;
> - running other programs.
> 
> It is possible to distinguish more functions of modern operating systems, but those listed above are enough for starters.

- OS 가 주는 기능은 다음과 같다.
- 데이터 접근에 대해서 보호해준다.
- 리소스 관리를 도와준다. (어플리케이션에게 필요한 만큼만 리소스를 할당해줄 수 있도록)
- 파일을 관리해준다.
- 다른 여러 프로그램을 실행할 수 있도록 해준다.

***

## Operating systems' components

> A mandatory part of all operating systems, its core, is the kernel. Usually, it's one of the first programs that loads when you turn on your computer. It provides all the necessary means to run the programs you want.
> 
> Typically, when you start your OS, you see the Graphical User Interface (GUI). It is the type of interface that allows users to interact with the device using graphical icons and audio indicators. Another way to interact with the OS is to use commands in a text-based terminal known as a Command Line Interface (CLI).
>
> There are two types of kernels, known as monolithic and microkernels. A monolithic kernel is a large program that performs most of the OS functions. At the same time, a microkernel performs only a small subset of the operating system functions, but we can extend it with additional modules known as drivers.
>
> There are other important parts of the operating system besides the kernel and the graphical user interface. We will review them in the next topic. For now, use the following image to brush up everything we've covered so far:

- 컴퓨터가 켜지면 가장 먼저 실행하는 프로그램이 있는데 이를 커널이라고 부른다. 커널은 가장 핵심적인 운영체제의 프로그램으로서 시스템 전체를 통제한다.
- 커널은 마이크로커널과 모놀리식 커널이 있다. 마이크로커널은 좀 더 가볍고 필요하면 모듈을 설치해서 확장해나가는 타입이라면 모놀리식 커널은 필요한 모든 기능이 다 있는 커널이다.


