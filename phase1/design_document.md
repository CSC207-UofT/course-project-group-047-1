Design document 

\
Specification:


Our project domain is a grocery order reservation app. 
We are designing a program for grocery stores like Walmart or T&T. In phase 0 the program 
allows users to register, login. Now in phase 1, users can view and order groceries from the
store. The customers are able to see the id, name, price, and quantity in stock of each item.
Each user has their own shopping cart, they can add items into their shopping cart, or remove
items. At any time, users can view the items in their shopping cart. When they are satisfied, they can check out, 
in the checkout page users will be asked to confirm if they pick up their items. At this point, users can choose to exit
the program and go to pick up their stuffs, when they come back and run the program and login back to their accounts,
the program will stop them from continue shopping, until they confirmed that they pick up their stuffs.

\
A general walk through:

a user run the program by running **"Main"** class, then they can create an "Account", the **"Main"** class will 
call **"AccountManager"** class to store this **"Account"** to **"Accounts.txt"** file. Then the user will be brought to 
a login page, after login the **"Main"** class will initiate a **"ShoppingCart"** for this **"Customer"**. The user can 
now choose to exit the program or start shopping. While shopping, the user can add **"GroceryItem"** into their
**"ShoppingCart"** by specifying the **"id"** and **"quantity"** of the items they want, when they do that the**"Main"** class
will call **"GroceryInventory"** class to remove those **"GroceryItems"** from **"inventory.txt"** and add them to user's
**"ShoppingCart"**. The user can view what's in their **"ShoppingCart"**, and remove items from it. When the user is 
satisfied, they can go to checkout, which will create an **"Order"** with an **"open"** status, and **"OrderManager"** will
add this **"Order"** into **"Orders.txt"** file. the user will be asked to confirm if they picked up their order, after
they confirmed, **"OrderManager"** will set the order's status to **"closed"**, and write that change into **"Orders.txt"**
file.

\
Design Decisions:

After receiving feedbacks from phase 0 we realized that our project structure does not adhere to clean
architecture because some of our higher level classes have dependency on lower level classes, our TA also
pointed out that our controller classes should not interact on the same level since we are using
a higher order class to coordinate. So in pull request 10 we
changed our project structure by adjusting class level, and remove inappropriate imports so that our 
future implementations adheres clean architecture. We also put our files into different folders so that our codes
are more organised and easier for everyone in our team to work with. We also canceled a few classes and 
functionalities(specifically delivery function) from our program as 
our TA pointed out that our project scope is too large, and we should make it smaller so that our 
project can be more useful.

\
SOLID & Clean Architecture:

During our implementations we have noticed some violations, for example, We tried to implement a Strategy
pattern in pull request 18. But later we found out that **"GroceryItem"** which is an entity imports classes on
external interface level, which clearly violation both Clean Architecture and SOLID principles, so in pull request
28 we fixed it, and we included a class diagram under phase 1 folder to remind us the relationship between
each class. During our implementations we also consistently check imports in classes we wrote to ensure that there 
are no dependencies on same level, and to ensure that higher level modules do not depend on lower modules. We
also ensured that each class has only one responsibility, for example we have three different file
writing classes for three different objects stored in three different txt files, and we document the responsibility
for every class in our program, making our project easier for extension. One problem with our current design is that 
we are using **"Main"** class to coordinate everything, this reduces the dependencies between other classes but 
increase the complexity of **"Main"** class. For example, if someone wants to introduce a new entity in our program
then he/she might also have to add and modify methods in **"Main"** class, instead of extending it,
which might violate the Open/Close Principle. But to help others to understand the **"Main"** class we included a 
diagram under phase 1 folder that tells the relationship between each method in **"Main"** class.

\
Design Pattern:

For design pattern we are using Dependency Injection Pattern in **"AccountManager"** and **"OrderManager"** classes,
and this is also another effort we made to ensure our program adheres to Clean Architecture. This pattern says that
instead of using the "new" keyword to create an object inside a method in another class, we should pass the object
as a parameter to that method. For example, in **"AccountManager"** class there is a **"addAccount"** method, which 
adds an **"Account"** into **"Accounts.txt"** file, an **"Account"** has a username and a pin,
"before using this pattern we were passing the username and the pin as parameters into **"addAccount"** method, and 
create an **"Account"** inside this method. This creates a hard dependency between **"AccountManager"**  and 
**"Account"**, which makes each module harder to test. Instead, using Dependency Injection pattern we pass an
**"Account"** as a parameter to **"addAccount"** method (see pull request 48), and let **"Main"** class to create 
this account.
As we mentioned in the paragraph above, this complicates **"Main"** class but the advantage is that this will remove
a hard dependency between **"AccountManager"** and **"Account"**, making each module easier to test and easier to use
independently. In the future, we will probably continue to use this pattern as we extend our project.

\
Package Strategy & Codes refactoring & Organization:

We put our classes into packages by four layers, from high level to low level: entity, use_case, controller, 
external_interface, and another folder for txt files. We think this is easy for anyone to locate a class file 
or txt file, and if anyone who wants to extend our project by adding new classes they know where to put these
classes. During our implementations we consistently checked for codes smells and bad coding styles. For example,
we used to have a class called **"storeManager"**, but later we found that it has the same responsibility with
anther class called **"GroceryInventory"**, so we combined these two classes in pull request 22, which 
also helped us to adhere to Single Responsibility Principle. We also tried 
to shorten long methods, for example in pull request 46 we extracted a method from another 
method in **"Main"** class. Our **"Main"** class involves user inputs and switching cases 
which makes it hard to test, but still our tests managed to cover most of our methods. We also documented 
every method and class in our program to ensure that anyone can understand what our codes are doing.

\
Progress report:

open questions:

1: the two issues listed on issues page on GitHub

2: What other design patterns our codes can implement? We have been struggling about this for a while, we tried to
Strategy pattern in pull request 18 but, it turns out violating Clean Architecture. You are welcome to give advice.

what has worked well:

1: Our program is working well as we expected.

2: Our group is working well together, we communicate efficiently, and we shared work equally

Contributions:

Unfortunately our teammate Yiyu Li dropped the course

* Yicong Luo
    * Working on Main class, design documents, code refactoring
    * Will be focusing on class External_Interface.Main in the future

* Khloe Tsang
    * Working on Testing, Main class
    * Will be focusing on Testing in the future

* Wenzhen Wang
    * Working on AccountManager class, GroceryInventory class, 
    * Will be focusing on the file writing classes in the future

* Peijun Lu
    * Working on ShoppingCart class, design pattern
    * Will be focusing on design pattern in the future

* Qin Xu
    * Working on Account, Customer, Main class, and testing
    * Will be focusing on testing and Main class in the future

* Zhaoyu Yan
    * Working on GroceryItem, Order, OrderManager classes
    * Will be focusing on OrderManager Class in the future






