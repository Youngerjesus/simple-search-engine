# Theory: Introduction to software architecture

> At the beginning of a development cycle for a complex application that combines multiple components, you may notice that you need to have a proper structure that represents all interactions happening within. Software architecture is the term that defines said structure. It helps understand the relationships between each major system component and simultaneously provides the necessary documentation for developers and clients.
>
> Every project that combines multiple different components has to have a clear software architecture to define technical and structural requirements for the system. It allows reducing any possible risks when creating a project. If you need to complete your project and establish communications within a team in a short amount of time, you need to master software architecture.

- software architecture 는 소프트웨어를 구성하는 컴포넌트끼리의 관계 구조다.

***

## What is software architecture?

> For example, you want to develop a brand new application, that potentially could do whatever you want. What will be the first thing that you’ll do? Your answer should be, "Divide my application into several components, write documentation and draw a scheme of all the connections within it".
>
> Basically, software architecture or SA is a pattern, which describes all inner components of the system and interactions between them. It has spheres of influence which you can classify as Direct and Indirect. By direct influence, you can make any changes to the project itself. Like improvements of security and quality attributes, optimizing project structure, and any influence on used technologies.
>
> Indirect influence means changes to the environment of a project. On a picture down below you can see how the classification goes. SA directly influences Project Structure, IT environment, and Quality Attributes. While indirect influence encompasses Human Dynamics and Business Strategy.

- 어플리케이션을 개발할 땐 어플리케이션의 구성 요소를 쪼개고 그것들의 관계를 정의하는 것.
- 소프트웨어 아키텍처에 영향을 주는 요소는 직접적인 요소와 간접적인 요소가 있다.
- 직접적인 요소는 프로젝트 그 자체를 바꾸는 데 관여하는 요소로 Quality, Security, Tech Stack, Optimizing project structure 이 있다.
- 간접적인 요소는 프로젝트의 환경을 바꾸는 요소로 인간과 비즈니스가 관련이 있다.

***

## Why would you need software architecture?

> When working on a complex project, developers need to understand what they are doing, what they will do next, and what they are supposed to get in the end. An architectural pattern that describes every connection within a system can help developers understand their project and adjust the workflow.
>
> Here's a list of advantages of the software architecture:
>
> - It describes the system in a simple way without implementation details.
> - It displays all working scenarios.
> - It distinguishes functional and quality requirements.
> - It improves the working and business environment.
> 
> If you properly distribute functions between the elements of SA, you could potentially save time for the developers working on implementing new features. Also, it would be easier for the new team members to adjust to the workflow.
>
> Then again, although creating a software architecture can make a real difference, it’s not always treated properly. Thus we experience a shortage of methods to represent SA and a lack of prioritization in making one.

- 시스템 내의 모든 구성요소의 관계를 알아야 프로젝트를 더욱 잘 이해하고 워크 플로우를 조정하는게 가능하다.
- (workflow: A Workflow is a sequence of tasks that processes a set of data.)

***

## Types of software architecture

> You won't always need to create an absolutely unique software architecture, because there are lots of different pattern types created as optimal solutions to commonly occurring problems. There are few types of patterns like Layered, Primary-Secondary, Peer-to-Peer, and etc. You will learn more about them in future topics. To represent any pattern you could use schemes, models, diagrams, and even documents that collect every architectural decision (like Architecture Decision Record (ADR)). Also, you can visualize SA through Unified Modeling Language or UML. UML is a visual language that combines different types of diagrams specified for individual purposes.
>
> For a better understanding, here's a list of a few basic types of software architecture:
>
> - Application architecture – description of patterns required to build an application. This type of architecture provides a team with a roadmap to build a well-structured app.
> - Information architecture – description of an organization, structuring, and labeling content in a way that allows users to conveniently access the information they need.
> - Database architecture – a concept that focuses on the design, development, implementation, and maintenance of a database management system (DBMS). Simply put, it's an architecture that describes all the steps needed to realize and support a database and gives proper access to its functions for users and admins.
> - Network architecture – description of a network system's physical and logical design. Basically, it depicts relations between network components and their logical functions.

- 일반적으로 발생하는 문제에 대한 최적의 해결책으로 생성된 여러 가지 패턴 유형이 있기 때문에 완전히 고유한 소프트웨어 아키텍처를 항상 만들 필요는 없다.
- Layered, Primary-Secondary, Peer-to-Peer 등의 여러가지 패턴이 있다.
