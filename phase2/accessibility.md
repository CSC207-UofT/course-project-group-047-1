**Universal Design Principles:**

Equitable Use:

All users use our program in the same way that we do not differentiate users through any means. In the future, we can
design a GUI to make our program more appealing.

Flexibility in Use:

Our program can only be used in the command line, and thus cannot provide more ways to use the program or adapt to the
user's pace. But in the future, we can add a GUI to implement this principle.

Simple and Intuitive Use:

Our program is easy to use since the only thing that the user needs to do is to input integers. Our in-app instructions 
are clear, short, and easy to understand.

Perceptible Information:

Our messages have different colors so that users can easily distinguish different information. For example, in default
color settings, we have warning messages in red and welcome messages in green. Users can also change their color 
settings.

Tolerance for Error:

In phase 2, we implemented a lot of tolerance for error. For example, if users input a string in where they are supposed
to input an integer, then our program will not crash but a warning message will be sent out. Similarly, if a user try to
do insensible actions like adding negative balance, then the user will be warned.

Low Physical Effort:

As mentioned above, our program is easy to use, with only integer input. We also have serialization for color settings, 
so users will only have to change their color settings once. Every time they log in to the UI, it automatically changes 
color, so they don't have to repeat.

Size and Space for Approach and Use:

Our program cannot implement this principle because it uses a command line, but in the future, we can have a GUI and
give enough space to click so that users can use the program easily.


**Marketing:**

Our market targets are Grocery Stores and Supermarkets where they have a lot of users and with different kinds 
of customers, and are looking for a simple and easy-to-use program to facilitate their business.
Since our program is following the Clean Architecture and SOLID principles, it can be easily
maintained or extended by programmers who have only basic knowledge of java. For example, if the store
wants to add more items for sale, then they don't have to change any existing codes but add this item into the
"Inventory.txt" file, and our gateway class will automatically detect this item. 
Our program also suites stores with a lot of long-term customers. Since it can store and load accounts, users only 
have to create their accounts once. Our program is easy to use so even old people can use it without problems.
Our program can also be used by small stores that are in shortage of supply or are very popular, because our program 
can load and save orders and every purchase by an account will be stored, users can safely order items their want.

Our program is less likely to be used by stores that accept only cash. Although the payment system can be deleted but 
normally if a store does not accept online payment, then most likely they will not need a software like this. 
We are also not expecting stores that do not have long-term users to use our program. Like a small computer store,
most people buy a laptop and use it for over years, so there is no point to create an account and use a 
system like this to purchase a laptop. Also, most people want to take a look at the laptop that they want to buy in
person, so they don't need such software.
