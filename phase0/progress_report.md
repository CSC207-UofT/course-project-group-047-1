Our project domain is a mix of Inventory System and Delivery Service App.

our program is designed for grocery stores like Walmart or T&T, which allows customers to create account and order groceries from the store. This function is supported by classes Customer and  CustomerAccountManager. The customers are able to view their personal information and set orders according to the items in store. The information about the items in store are associated with several classes including Menu, GroceryItem, and GroceryInventory. For the function of ordering, we designed classes Order, ShoppingCart, OrderArrangeSystem, and OrderTrackingSystem.

After the customers made the payment, their orders well be finalized and is matched to a delivery man. The delivery man delivers the ordered items to the delivery address during the customer's preferred delivery time slot. These functions will be handled by classes DeliveryPeople and DeliveryMatchingSystem

The whole shopping process is trackable by the customers through our app.

The program also allows its users to sign up as delivery man to accept and deliver orders. Delivery men will be able to choose their preferred working slot, and they can choose whether they accept to deliver a certain order. 

For the scenario walk-through, we have a simple set up as a new customer creating an account. The process will use class Customer and CustomerAccountManager.

For the skeleton program, we already finished the basic set-up for most of the classes except the ones that are related to Order. The tests for Customer and GroceryItem are tunning without error. We may add more classes or sub-classes for payment function.
