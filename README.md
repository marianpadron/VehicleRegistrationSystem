## Vehicle Registration System

A **JAVA** vehicle registration system that maintains a log of indivdual vehicle registrations. 
Each registration represents a different vehicle and all its attributes, as well as its owner and owner’s information, and the vehicle’s jurisdiction information. 
The registration system was designed using **SOLID** design practices and was delivered as part of an **OBJECT-ORIENTED DESIGN** class. 
It utilizes proper encapsulation practices such as a **singleton class** to represent the registration system and establishes class protocols through 
**interfaces** to improve reusability. The system also implements Java **HIGHER-ORDER FUNCTIONS** to enable filtering of the different vehicle registrations.

System tests were ran using **JUNIT** following a specific rubric. Tests can be found in the [test](/test) directory.

### Overview
- [RegistrationSystem](/src/registration/RegistrationSystem.java): Singleton class that represents a registration system that holds a collection of different vehicle registrations and uses **higher-order functions** to enable filtering.
- [Registration](/src/registration/Registration.java): An individual vehicle registration. Holds vehicle, jurisdiction, and owner objects, as well as registration information.
- [Vehicle](/src/registration/Vehicle.java): Extends vehicle interface to represent a type of vehicle as well as its corresponding information.
- [Red](/src/registration/RedJurisdiction.java)/[Blue](/src/registration/BlueJurisdiction.java)/[Green](/src/registration/GreenJurisdiction.java) Jurisdiction: Classes that represent different vehicle jurisdiction and use **dynamic dispatch** to return specific tax information per jurisdiction.
- [Person](/src/registration/Person.java): Class that represents a person and their personal information for the vehicle registration.

All other files are interfaces, enums, or abstract classes utilized or extended by the concrete classes mentioned above.
