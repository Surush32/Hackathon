**Hackathon**
Fall 2025 Advanced Programming Language Concepts (CMPP-3020-BSA)
Team members ( Kedir Rahmet) (Princess Blessing) (Surush Azaryun)

**Smart Parking Allocation System**
The goal is to create a system that asigm parking spot for cars based on Size, Availability and Arrival order. 

We have decided to code this system in Java, mainly becasue it is an object orianted programing language which is a better option to code our program. 
Secondly, most of the team mambers are comfortable coding in Java. 

**Main features**
1: Automatic spot assignment---------# **Assigns Parking spot for cars based on size and compatibility**
2: Spot Release Managment------------# **The spot which cars are parked will get asigned to other cars if the that spot gets available**
3: Overflow detection ---------------# **This Validate parking Capacity to prevent over allocation**
4: Parallel Availability Checks------# **Java parallel stream which search for parking spot more efficiently**
5: Validation steps------------------# **This validate vehicle and parking spot data with custome exceptions**



**Class Responsibilities**

Class            | Responsibility 

**Vehicle**      | Represents a vehicle with plate number and size (small/compact/large) |
**ParkingSpot**  | Represents a parking spot with ID, size, availability status, and current vehicle |
**ParkingLot**   | Manages collection of spots, handles assignment/release operations, enforces size compatibility |
**App**          | Application entry point for running demonstrations |
