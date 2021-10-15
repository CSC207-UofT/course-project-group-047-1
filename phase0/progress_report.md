Our project domain is a mix of Inventory System and Delivery Service App.

our program is designed for grocery stores like Walmart or T&T. Our CRC model includes 12 classes, together they allow users to perform different tasks, such as creating account, and edit personal information. This function is supported by classes Customer and  CustomerAccountManager. Customers can also view different items, and put their prefered items in a shopping cart. The information about items in store are associated with several classes including Menu, GroceryItem, and GroceryInventory. For the function of ordering, we have classes Order, OrderArrangeSystem, and OrderTrackingSystem.

After the customers made the payment, their orders will be finalized and the DeliveryMatchingSystem class will match order to a delivery man. When the delivery man delivers the ordered items to the delivery address, they can make a confirmation through the OrderArrangeSystem class. The whole shopping process is trackable by the customers through our program.

The program also allows its users to sign up as delivery man to accept and deliver orders. Delivery men can choose their preferred working slot, and they can choose whether they want to deliver a certain order. 

For the scenario walk-through, we have a simple set up as a new customer creating an account, login, and view a list of items in stock. Our skeleton code supports a user to perform all these tasks, just run the store.java file, and there will be instructions. So far we have a few hundred lines of code that sticks to our CRC model.

We also realize that there are potential problems to be solved and extensions to be made:

1. We might need a presenter (the presenter have the job of acting as a mediator between UseCases and UI, as a data dispatcher) so that customers are able to navigate the app (ex. see their shoppingCart (with images and quantities of items added to the cart) on their phone screen), but we are not sure how to approach this.

2. We also might add a payment system to make our program more realistic.

3. We might create more classes and methods as we proceed.

4. We can add a store manager account to top up the store's inventory.

Fortunately, our skeleton codes are working well, they can support users to perform some simple task, and so far we have not encounterd big issues.

Group member & responsibilities

* Yicong Luo
  * Skeleton code: Grocery Inventory, Store, Menu, AccountManager, Customer, GroceryItem
  * Will be focusing on class Menu in the future

* Khole Tsang
  * Skeleton code: AccountManager

* Wenzhen Wang
  * finalizing CRC model with added details (CRC folder)

* Yiyu Li
  * basics for CRC model(thoughts.md)
  * progress report(progress_report.md)

* Peijun Lu
  * scenario walk-through (walkthrough.md)

* Qin Xu
  * progress report(progress_report.md)

* Zhaoyu Yan
  * unittest for GroceryItem class


