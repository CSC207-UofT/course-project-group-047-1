Our project domain is a mix of Inventory System and Delivery Service App.

We are designing a program for grocery stores like Walmart or T&T. The program allows customers to create account and order groceries from the store. The customers are able to view the name, price and quantity in stock of each item. They can also access their shopping cart, which allows them to add or delete grocery items from the cart, as well as to view the total price of selected items. When customers decide to check out, they are required to provide their delivery info, including name, delivery address, phone number, payment method, preferred delivery time.etc. After the customers made the payment, their order is finalized and is matched to a delivery man. The delivery man delivers the ordered items to the delivery address during the customer's preferred delivery time slot. The customer is able to track the delivery process when it starts (optional).

The program also allows its users to sign up as delivery man to accept and deliver orders. Delivery man can provide their available time slot for the next few days, they receive the order if they are available during the customer's preferred time slot. Delivery man can choose whether to accept the order. They are required to report the order status (out for delivery, delivered,.etc) and the customer who made the order is able to access such information.

**List of Classes:**

* Entities: 
  * Customer
  * GroceryItem
  * DeliveryPeople

* Use_Case: 
  * Controllers.AccountManager
  * Order
  * DeliveryMatchingSystem
  * Controllers.ShoppingCart
  * GroceryInventory

* Controller:
  * OrderArrangeSystem
  * OrderTrackingSystem
  * External_Interface.Menu

* External_Interface: 
  * Store

**Potential problems and potential extensions to our program:**

1. We might need a presenter (the presenter have the job of acting as a mediator between UseCases and UI, as a data dispatcher) so that customers are able to navigate the app (ex. see their shoppingCart (with images and quantities of items added to the cart) on their phone screen), but we are not sure how to approach this

2. We also might add a payment system to make our program more realistic.

3. We might create more classes and methods as we proceed.

4. We can add a store manager account to top up the store's inventory.
