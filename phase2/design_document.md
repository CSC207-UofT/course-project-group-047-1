**Specification:**

Our project domain is a grocery order reservation app. We are designing a program for grocery stores like Walmart or 
T&T. In phase 0, the program allows users to register and login. 

As of phase 1, users can view and order groceries
from the store. Users can see the id, name, price, and quantity in stock of each item. Each user has their
own shopping cart, and they can add items to their shopping cart, or remove items. At any time, users can view the 
items in their shopping cart. When they are satisfied, they can check out. On the checkout page, users will be asked
to confirm if they picked up their items. 

As of phase 2, users can change their username and pin through the
program. Each user will be rewarded with credit when they purchase items and confirm their orders. At any time, users
can top up their balance through the program. And their balance will be deducted after they purchase items. 
Users can also choose three types of color settings, default, inverted, and all black. Now, users are able to view 
their account information, such as username, pin, balance, credit, and color setting. They can also view their order 
history.


**Changes in phase 2:**

1. The first thing we did is to fix the clean architecture violation by controllers using dependency inversion.
2. We extracted String output parts in controllers into presenters.
3. Implemented iterator patterns in presenters with while loop.
4. Added more functionalities like check order history, change username and pin, color setting(accessibility), 
payment and balance
system.
5. Added more tolerance for errors, for example if the user put a string into where they suppose to put an integer
then the program won't crash but a warning will be sent to user.
6. Fixed some bugs in phase 1 like if a user put the wrong item id then he/she will enter a infinite loop.
7. Added more business policies such as username cannot be empty, cannot add negative balance, cannot shop with 
negative balance.
8. Make the UI more interactive, for example user can go back from shopping menu to main menu, in phase 1 they can
only exit.

**Design Decisions:**

In phase 1 we moved some classes to different layers to better adhere to the Clean Architecture, we also deleted
a few classes and functionality(specifically the delivery function) to narrow down our project scope.

In phase 2 we renamed some of our classes to better fit their functions. We also extracted some parts of the controller 
classes into data access classes and presenters, because we used to have controllers doing String output and manipulation, and 
file reading and writing, which does not adhere to single responsibility principle and clean architecture. We also 
changed our text file location. They used to be under the "java" folder, but since they don't have java codes, so we 
moved them elsewhere.


**Clean Architecture:**

In phase 1, we moved some classes into different layers to better adhere to Clean Architecture, but
we had controller classes writing and reading from database which is a violation. In phase 2, we 
extracted the file writing and reading parts into DataAccess classes in the most outer layer, and have their
interfaces at the use case layer, and let controllers use these interfaces, which is essentially a dependency
inversion technique. You can see 
this in [Pull request 75](https://github.com/CSC207-UofT/course-project-group-047-1/pull/75/files). Now
we no longer have dependency towards outside, we checked this through our imports and intellij dependency diagrams,
now all dependencies are from low level modules to high level modules,
no high level modules imports and uses low level modules. We also included a UML diagram under the phase 2 folder.


**SOLID Principles:**

Single Responsibility Principle:

As mentioned above, in phase 1 we have controllers combined with gateway and presenters, but now in phase 2 we 
fixed this and all our classes have only one responsibility, one reason to change. We also documented the
responsibility for each class so that anyone can understand what each class does.

Open/Close Principle:

For project extension, we have interfaces at the use case level to extend for. For example, if one wants to add
a delivery function to our program they can add a new use case class called DeliveryAccount and let it 
extend the Account interface, and Add the corresponding Data Access concrete class and interface, and the 
corresponding controller and presenter. None of these actions will alter the existing classes.

Liskov Substitution Principle:

Every subclass or class that implements an interface in our program overrides the corresponding methods in
parent classes and contains more methods. So replacing a parent class with a subclass will not change the 
program's functionality. This is also demonstrated by our Controller classes, each of them uses a
Data Access interface at the use case level, but in actual usage, we use the "Main" class to pass a concrete class 
that implements the interface to those controller classes.

Interface Segregation Principle:

All interfaces in our program are small as possible, they all contain only the 
necessary methods. No classes contain features they don't need, and all concrete classes that implement an
interface override and use the corresponding methods.

Dependency Inversion Principle:

As we mentioned in Clean Architecture we used Dependency Inversion in our Data Access classes, these concrete
classes are in the most outer layer and their interfaces are in the use case layer so that our controllers and 
use case classes can use these data access classes without violating the dependency rule.


**Design Pattern:**

We used Iterator Pattern in our three Presenter classes, 
see [Pull request 91](https://github.com/CSC207-UofT/course-project-group-047-1/pull/91)
and [Pull request 96](https://github.com/CSC207-UofT/course-project-group-047-1/pull/96)
in a combination of while loops to iterate through our database. The advantage of this while loop and an
iterator over for loop is it occupies less memory in our computer, especially when our database is large, also
it has lower time complexity.

We also used Dependency Injection Pattern in our controller classes. For example, our addAccount 
method in CustomerAccountController
does not initiate CustomerAccount, instead, another class will create an Account and pass that account to the
controller. The advantage is this can remove a hard dependency between the two classes, making each module
easier to use and to be tested separately.


**Package Strategy & Codes refactoring:**

We put our classes into packages by four layers, from high level to low level: entity, use_case, interface_adapter, 
and external_interface, and another folder 'file' is to store text files under the database. We think this is easy 
for us to locate a class file or a text file, and if anyone wants to extend our project by adding new classes they 
know where to put these classes. This also helps us to be clear on which class belongs to which layer so 
that we don't accidentally violate the clean architecture. Throughout the project, we constantly checked
for code smells and bad coding styles and fix them as we see them. For example, we combined 
classes with the same responsibility, see 
[Pull request 22](https://github.com/CSC207-UofT/course-project-group-047-1/pull/22). We also
tried to shorten long methods, for example 
in [pull request 46](https://github.com/CSC207-UofT/course-project-group-047-1/pull/46).


**Progress report:**

Open questions:

1: How to test the UI with user input?

What has worked well:

1: Our program is working well as we expected.

2: Our group is working well together, we communicate efficiently, and we shared work equally.

Contributions:

Yicong Luo: Has been working on UI and some part of data access,
[Pull request 107](https://github.com/CSC207-UofT/course-project-group-047-1/pull/107/files), 
[Pull request 101](https://github.com/CSC207-UofT/course-project-group-047-1/pull/101/files), in these two pull
requests a lot of features in UI were added.

Khloe Tsang: Has been working on testing, [Pull request 113](https://github.com/CSC207-UofT/course-project-group-047-1/pull/113/files), 
[Pull request 50](https://github.com/CSC207-UofT/course-project-group-047-1/pull/50/files), in these two pull requests
a lot of tests were added.

Wenzhen Wang: Has been working on entity classes,
[Pull request 62](https://github.com/CSC207-UofT/course-project-group-047-1/pull/62/files),
[Pull request 114](https://github.com/CSC207-UofT/course-project-group-047-1/pull/114/files),
in these two pull requests
a lot of entity codes and tests were added.

Peijun Lu: Has been working on use case classes and some part of data access,
[Pull request 79](https://github.com/CSC207-UofT/course-project-group-047-1/pull/79/files), 
[Pull request 77](https://github.com/CSC207-UofT/course-project-group-047-1/pull/77/files),
in these two pull requests
the clean architecture violation by controllers reading file was fixed.

Qin Xu: Has been working on testing, [Pull request 110](https://github.com/CSC207-UofT/course-project-group-047-1/pull/110/files),
[Pull request 119](https://github.com/CSC207-UofT/course-project-group-047-1/pull/119/files),
in these two pull requests
a lot of tests were added.

Zhaoyu Yan: Has been working on interface adapter classes and design pattern, 
[Pull request 85](https://github.com/CSC207-UofT/course-project-group-047-1/pull/85/files),
[Pull request 93](https://github.com/CSC207-UofT/course-project-group-047-1/pull/93/files),
in these two pull requests
design pattern and a lot of codes in controllers were added.
