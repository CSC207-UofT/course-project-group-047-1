**Specification:**

Our project domain is a grocery order reservation app. We are designing a program for grocery stores like Walmart or 
T&T. In phase 0, the program allows users to register and login. 

As of phase 1, users can view and order groceries
from the store. users can see the id, name, price, and quantity in stock of each item. Each user has their
own shopping cart, and they can add items to their shopping cart, or remove items. At any time, users can view the 
items in their shopping cart. When they are satisfied, they can check out. On the checkout page, users will be asked
to confirm if they picked up their items. 

As of phase 2, users can change their username and pin through the
program, we also added a payment and credit system. Each user will be rewarded with credit when they purchase
items and confirm their orders, and their balance will be deducted after they purchase items. At any time users 
can top up their balance through the program. We also included color settings to better adhere the Universal
Design Principles, users can choose three types of color setting, default, inverted, and all black.


**A general walk through:**

A user runs the program by running the "Main" class, then they can create an "CustomerAccount", and the "Main" 
class will call the "CustomerAccountController" class to store this "CustomerAccount" into the "CustomerAccounts.txt"
file. Then, the user will be brought to a login page. After login, the "Main" class will initiate a "ShoppingCart" 
for this user. While shopping, "InventoryPresenter" will display all the items we have in the 
store, and the user can
add "GroceryItem" into their "ShoppingCart" by specifying the "id" and "quantity" of the item. When they do that,
the "Main" class will call the "InventoryController" class to remove those "GroceryItems" from the "inventory.txt" and 
add them to the user's "ShoppingCart". The user can view what's in their "ShoppingCart", and remove items from it.
When the user is satisfied, they can check out, which will create an "Order" with an "open" status. The 
"OrderController" will add this "Order" into the "Orders.txt" file. The user will be asked to confirm if they picked
up their order. After they confirmed, the "OrderController" will set the order's status to "closed", and write that 
change into the "Orders.txt" file. When the user goes back and check his account's order history, "OrderPresenter"
will display this user's past orders.


**Design Decisions:**

In phase 2 We renamed some of our classes to better fit their functions, we also extracted some parts of controller
classes into gateways and presenters because we
used to have controllers doing String output and manipulation, and file reading and writing
which does not adhere to single Responsibility and clean architecture. We also changed our text file location, 
they used to be under "java" folder, but since they don't 
have java codes, so we moved them into elsewhere.


**Clean Architecture:**

In phase 1 we have controller classes writing and reading from database which is a violation. In phase 2 we 
extracted the file writing and reading parts into DataAccess classes in the most outer layer, and have their
interfaces at the use case layer, and let controllers use these interfaces, which is essentially Dependency
inversion technique. You can see 
this in [Pull request 75](https://github.com/CSC207-UofT/course-project-group-047-1/pull/75/files). Now
we no longer have dependency towards outside, all dependency are from low level modules to high level modules,
no high level modules imports and uses low level modules. We also included a UML diagram under phase 2 folder.


**SOLID Principles:**

Single Responsibility Principle:

Like mentioned above, in phase 1 we have controllers combined with gateway and presenters, but now in phase 2 we 
fixed this and all our class have only one responsibility, one reason to change. We also documented the
responsibility for each class so that anyone can understand what each class does.

Open/Close Principle:

For project extension we have interfaces at use case level to extend for. For example, if one wants to add
a delivery function to our program they can add a new use case class called DeliveryAccount and let it 
extend the Account interface, and Add the corresponding Data Access concrete class and interface, and the 
corresponding controller and presenter. None of these actions will alter the existing classes.

Liskov Substitution Principle:

Every subclass or classes that implements an interface in our program overrides the corresponding methods in
parent classes and contains more methods. So replacing a parent class with a subclass will not change the 
program's functionality. This is also demonstrated by our Controller classes, each of them uses a
Data Access interface in use case level, but in actual usage we use "Main" class to pass a concrete class 
that implement the interface to those controller classes.

Interface Segregation Principle:

All interfaces in our program is small as possible, they all contain only the 
necessary methods. No classes contain features they don't need, and all concrete classes that implements an
interface override and use the corresponding methods.

Dependency Inversion Principle:

As we mentioned in Clean Architecture we used Dependency Inversion on our Data Access classes, these concrete
classes are in the most outer layer and their interface are in use case layer so that our controllers and 
use case classes can use these data access class without violating the dependency rule.


**Design Pattern:**

We used Iterator Pattern in our three Presenter classes, 
see [Pull request 91](https://github.com/CSC207-UofT/course-project-group-047-1/pull/91)
and [Pull request 96](https://github.com/CSC207-UofT/course-project-group-047-1/pull/96)
in combination of while loops to iterate through our database. The advantage of this while loop and 
iterator over for loop is it occupies less memory in our computer, especially when our database is large, also
it has lower time complexity.

We also used Dependency Injection Pattern in our controller classes. For example, our addAccount 
method in CustomerAccountController
does not initiate CustomerAccount, instead another class will create an Account and pass that account to the
controller. The advantage is this can remove a hard dependency between the two classes, making each module
easier to use and to be tested separately.


**Package Strategy & Codes refactoring & Organization:**

We put our classes into packages by four layers, from high level to low level: entity, use_case, interface_adapter, 
and external_interface, and another folder 'file' is to store text file under database. We think this is easy for us to 
locate a class file or a text file, and if anyone wants to extend our project by adding new classes they 
know where to put these classes. This also helps us to be clear on which class belongs to which layer so 
that we don't accidentally violate the clean architecture. Throughout the project constantly checked
for codes smells and bad coding styles and fix them as wee see them. For example, we combined 
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

Yicong Luo: [Pull request 107](https://github.com/CSC207-UofT/course-project-group-047-1/pull/107/files), 
[Pull request 101](https://github.com/CSC207-UofT/course-project-group-047-1/pull/101/files), in these two pull
requests I added a lot of features in UI.

Khloe Tsang: [Pull request 113](https://github.com/CSC207-UofT/course-project-group-047-1/pull/113/files), 
[Pull request 50](https://github.com/CSC207-UofT/course-project-group-047-1/pull/50/files), in these two pull requests
I added a lot of tests.

Wenzhen Wang: [Pull request 62](https://github.com/CSC207-UofT/course-project-group-047-1/pull/62/files),
[Pull request 114](https://github.com/CSC207-UofT/course-project-group-047-1/pull/114/files),
in these two pull requests
I added a lot of entity codes and tests.

Peijun Lu: [Pull request 79](https://github.com/CSC207-UofT/course-project-group-047-1/pull/79/files), 
[Pull request 77](https://github.com/CSC207-UofT/course-project-group-047-1/pull/77/files),
in these two pull requests
I fix the clean architecture violation by controllers reading file.

Qin Xu: [Pull request 110](https://github.com/CSC207-UofT/course-project-group-047-1/pull/110/files),
[Pull request 119](https://github.com/CSC207-UofT/course-project-group-047-1/pull/119/files),
in these two pull requests
I added a lot of tests.

Zhaoyu Yan: [Pull request 85](https://github.com/CSC207-UofT/course-project-group-047-1/pull/85/files),
[Pull request 93](https://github.com/CSC207-UofT/course-project-group-047-1/pull/93/files),
in these two pull requests
I added design pattern and added a lot of codes in controllers

Thank you.
