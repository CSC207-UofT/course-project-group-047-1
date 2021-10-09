__Below are the info that our specs and CRC model will be built on. Please share your ideas/concerns by editing the following:__

Requirements: A reasonable CRC model that satisfies your specification should consist of
* entity classes:
    * customer
        * 2 types of customers: customer with user account and without account, the latter may choose to create account or go to check out directly
        * Parameters (customer with account): name, payment info, email, delivery address,.etc
        * For customer without account, they will enter all the necessary info when checking out  (orderArrangeSystem) and the info is temporary and never stored
    * groceryItems (abstract)
        * items have many subclass (or do interface label maybe) that represents different types of groceries (fresh veges, frozen foods, snacks,.etc)
        * parameters: item_name, price, quantity_in_stock,.etc
    * deliveryPeople
        * parameters: name, delivery_area(only downtown, both downtown & GTA,.etc), delivery_schedule(some sort of lists that stores which time slots on the day/next day is occupied/unavailable and which are available for arranging a delivery)

* use case classes:
    * shoppingCart
        * interact with customer and groceryItems
    * customerAccountManager (could be an interface implemented by customer class to deal with customer with account)
        * Manage customer accounts: create account, save payment methods,.etc
    * deliveryMatchingSystem
        * interact with deliveryPeople and match a delivery man with the order sent from orderArrangeSystem
    * order
        * stores info on an order(order_number, status, estimated delivery time)
        * collect customer info: for customer with an account, collect info through customerAccountManager, for customer without account, collect info through keyboard
        * collect shoppingCart info: calculate the total cost of items in the cart

* controller:
    * orderArrangeSystem
        * ask the deliveryMatchingSystem to match a delivery man for the order
        * send transaction request to the bank (don’t know how to do this yet) and validate if the transaction went through, if not the order is cancelled
        * if the order is successful: send confirmation email to the customer, ask the inventoryManager to update current quantity_in_stock for purchased items
    * orderTrackingSystem (opt, implementing this may take a lot of effort)
* basic command line interface
    * (not sure what it is yet)
* presenter
    * TBA

potential problems and solutions:
* We might need a presenter (the presenter have the job of acting as a mediator between UseCases and UI, as a data dispatcher) so that customers are able to navigate the app (ex. see their shoppingCart (with images and quantities of items added to the cart) on their phone screen), but I'm not sure how to approach this
* add your insights here

