Design document 

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
Package Strategy & Code refactoring:

We put our classes into packages by four layers, from high level to low level: entity, use_case, controller, 
external_interface, and another folder for txt files. We think this is easy for anyone to locate a class file 
or txt file, and if anyone who wants to extend our project by adding new classes they know where to put these
classes. During our implementations we consistently checked for codes smells and bad coding styles. For example,
we used to have a class called **"storeManager"**, but later we found that it has the same responsibility with
anther class called **"GroceryInventory"**, so we combined these two classes in pull request 22, which 
also helped us to adhere to Single Responsibility Principle. We also tried 
to shorten long methods, for example in pull request 46 we extracted a method from another 
method in **"Main"** class. We also documented every method and class in our program to ensure that anyone
can understand what our codes are doing

\
Progress report:

open questions:

1: the two issues listed on issues page on GitHub

2: What other design patterns our codes can implement? We have been struggling about this for a while, we tried to
Strategy pattern in pull request 18 but, it turns out violating Clean Architecture. You are welcome to give advice.

what has worked well:

1: Our program is working well and is quite useful as we expected, lots of features like colorful text.

2: Our group is working well together, we communicate efficiently

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






