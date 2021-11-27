Design document 

\
Specification:

Our project domain is a grocery order reservation app. 
We are designing a program for grocery stores like Walmart or T&T. In phase 0, the program allows users to register and 
login. Now in phase 1, users can view and order groceries from the store. Customers are able to see the id, name, price, 
and quantity in stock of each item. Each user has their own shopping cart, and they can add items to their shopping 
cart, or remove items. At any time, users can view the items in their shopping cart. When they are satisfied, they can 
check out. On the checkout page, users will be asked to confirm if they picked up their items. At this point, users can 
choose to exit the program and go pick up their stuff. When they rerun the program and login back into their 
customerAccount, 
the program will stop them from continuing shopping until they confirmed that they picked up their order.

\
A general walk through:

A user runs the program by running the **"Main"** class, then they can create an **"CustomerAccount"**, and 
the **"Main"** 
class will call the **"CustomerAccountManager"** class to store this **"CustomerAccount"** into the 
**"CustomerAccounts.txt"** file.
Then, 
the user will be brought to a login page. After login, the **"Main"** class will initiate a **"ShoppingCart"** for 
this **"Customer"**. The user can now choose to exit the program or start shopping. While shopping, the user can add 
**"GroceryItem"** into their **"ShoppingCart"** by specifying the **"id"** and **"quantity"** of the item. When they 
do that, the **"Main"** class will call the **"GroceryInventory"** class to remove those **"GroceryItems"** from the 
**"inventory.txt"** and add them to the user's **"ShoppingCart"**. The user can view what's in their **"ShoppingCart"**, 
and remove items from it. When the user is satisfied, they can check out, which will create an **"Order"** with an 
**"open"** status. The **"OrderManager"** will add this **"Order"** into the **"Orders.txt"** file. The user will be 
asked to confirm if they picked up their order. After they confirmed, the **"OrderManager"** will set the order's 
status to **"closed"**, and write that change into the **"Orders.txt"** file.

\
Design Decisions:

After receiving feedback from phase 0, we realized that our project structure does not adhere to clean architecture 
because some of our higher-level classes have a dependency on lower-level classes. Our TA also pointed out that our 
controller classes should not interact on the same level since we are using a higher-order class to coordinate. So in 
pull request #10, we changed our project structure by adjusting class level and removing inappropriate imports so that 
our future implementations adhere to clean architecture. We also put our file into different folders so that our codes 
are more organized and easier for us to work with. And we deleted a few classes and functionalities (specifically the 
delivery system) from our program as our TA pointed out that our project scope is too large, and we should make it 
smaller so that our project can be more useful.

\
SOLID & Clean Architecture:

During our implementations we have noticed some violations, for example, we tried to implement a Strategy pattern in 
pull request #18. But later we found out that **"GroceryItem"**, which is an entity, imports classes in the external 
interface level, which clearly is a violation of both the Clean Architecture and the SOLID principles. So in pull
request #28, we fixed it. During our implementations, we also consistently check imports in classes we wrote to ensure that 
there are no dependencies on the same level and to ensure that higher-level modules do not depend on lower modules. 
We also have a UML diagram under phase 1 folder to demonstrate Clean Architecture.
For Single responsibility principle, we
ensured that each class has only one responsibility, for example, we have three different file writing classes
for three different objects stored in three different text file. We also documented the responsibilities for every 
class in our program, making our program easier to understand and extend. Our program have an abstract class
**"UserAccount"**, so in phase 2 when we extend our project we might want to bring back the delivery system, then we can 
create a new class called DeliveryAccount that extend this abstract class.
We can also create a new corresponding Controller class for it, neither action will change the existing classes
which adheres to Open/Close principle. We also ensured that the interfaces in our program are small as possible. For 
example, we have an **"Account"** interface which only have two necessary getter methods so that we are adhering
to the Interface Segregation Principle. We also ensured our subclass like **"CustomerAccount"** overrides all 
methods that it inherits, which adheres to Liskov Substitution Principle. And
finally as explained before, we are adhering Clean Architecture
like our higher level modules do not depend on lower modules, and there is no dependencies between
same level modules, so we are also following the Dependency Inversion Principle.


\
Design Pattern:

For the design pattern, we are using the Dependency Injection Pattern in **"CustomerAccountManager"** and 
**"OrderManager"** 
classes, and this is also another effort we made to ensure our program adheres to Clean Architecture. 
This pattern says 
that instead of using the "new" keyword to create an object inside a method in another class, we should pass
the object 
as a parameter to that method. For example, in the **"CustomerAccountManager"** class there is an 
**"addAccount"** method, 
which adds an **"CustomerAccount"** into the **"CustomerAccounts.txt"** file. A **"CustomerAccount"** has a username 
and a pin. Before using 
this pattern we were passing the username and the pin as parameters into the **"addAccount"** method and created an 
**"CustomerAccount"** inside this method. This creates a hard dependency between 
**"CustomerAccountManager"** and **"CustomerAccount"**, which 
makes each module harder to test. By using the Dependency Injection pattern,
we pass a **"CustomerAccount"** as a parameter to 
the **"addAccount"** method (see pull request #48), and let the **"Main"** class creates this CustomerAccount. 
This complicates the **"Main"** class but the advantage is that this will remove a hard dependency between the 
**"CustomerAccountManager"** class and the **"CustomerAccount"** class, making each module easier to test and easier to use 
independently. In the future, we will probably continue to use this pattern as we extend our project.

\
Package Strategy & Codes refactoring & Organization:

We put our classes into packages by four layers, from high level to low level: entity, use_case, controller, and 
external_interface, and another folder 'file' is to store text file. We think this is easy for us to locate a class file or a 
text file, and if anyone wants to extend our project by adding new classes they know where to put these classes. This 
also helps us to be clear on which class belongs to which layer so that we don't accidentally violate the clean 
architecture. During our implementations, we consistently checked for codes smells and bad coding styles. For example, 
we had a class called **"storeManager"**, but then, we found that it has the same responsibility as another class 
called **"groceryInventory"**. So we combined these two classes in pull request #22, which also helped us to adhere 
to the Single Responsibility Principle. We also tried to shorten long methods, for example in pull request #46, we 
extracted a method from a method in the **"Main"** class. One problem with our current design is that we are
using the **"Main"** class to coordinate everything. This reduces the dependencies between other classes but increases
the size and complexity of the **"Main"** class. Our **"Main"** class also involves a lot of user inputs and switching 
cases which makes it hard to test, but our tests covers most of other methods. We also included a diagram under 
phase 1 folder, which tells the
relationship between each method in the **"Main"** class, to help others to understand the **"Main"** class, and
documented every 
method and class in our program to ensure that anyone can understand what our codes are doing.

\
Progress report:

Open questions:

1: The two issues listed on issues page on GitHub

2: What other design patterns can our codes implement? We have been struggling with this for a while, and we tried to 
use the Strategy pattern in pull request #18l, but it turns out violates the Clean Architecture. We hope to get some 
advice.

3: Main class is difficult to test, since it involves user's input, we tried to simulate those input but, they are 
not working and everytime we try to run we get no such element exception. We will do more research on this in phase 2.

What has worked well:

1: Our program is working well as we expected.

2: Our group is working well together, we communicate efficiently, and we shared work equally

Contributions:

Unfortunately our teammate Yiyu Li dropped the course

* Yicong Luo
    * Working on Main class, design documents, code refactoring
    * Will be focusing on Main class and code refactoring in the future

* Khloe Tsang
    * Working on Testing, Main class
    * Will be focusing on Testing in the future

* Wenzhen Wang
    * Working on CustomerAccountManager class, GroceryInventory class, 
    * Will be focusing on the file writing classes in the future

* Peijun Lu
    * Working on ShoppingCart class, design pattern
    * Will be focusing on design pattern in the future

* Qin Xu
    * Working on CustomerAccount, Customer, Main class, and testing
    * Will be focusing on testing and Main class in the future

* Zhaoyu Yan
    * Working on GroceryItem, Order, OrderManager classes
    * Will be focusing on OrderManager Class in the future






