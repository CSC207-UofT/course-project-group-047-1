Our project domain is InventorySystem

We are designing a program for our store, it allows someone to create an account and order items from the store. Ideally the program allows the customer to view the name,
the price and the quantity in stock of each item. Each customer has their shopping cart, customers can add, and delete items from it, customers can also view the total price
of items in the cart. When customer finalize what they want they can place their order and the program will arrange a deliveryman to send their stuffs to them. At each stage, 
a customer can choose to exit the program.

Ideally the program should also allow a user to sign up as a deliveryman to accept and deliver orders.

list of classes:

Entities: Customer GroceryItem DeliveryPeople

Use case: CustomerAccountManager Order DeliveryMatchingSystem ShoppingCart GroceryInventory

controller: OrderArrangeSystem OrderTrackingSystem Menu

command line interface: Store

potential problems and potential extensions to our program

1. We might need a presenter (the presenter have the job of acting as a mediator between UseCases and UI, as a data dispatcher) so that customers are able to navigate the app (ex. see their shoppingCart (with images and quantities of items added to the cart) on their phone screen), but we are not sure how to approach this

2. We also might add a payment system to make our program more realistic.

3. We might create more classes and methods as we proceed.

4. We can add a storeowner account to top up the store's inventory.
