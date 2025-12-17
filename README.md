**Hackathon**
Fall 2025 Advanced Programming Language Concepts (CMPP-3020-BSA)

//Team members//

**Kedir Rahmet** 
**Princess Blessing** 
**Surush Azaryun**

//Project description//

**Smart Parking Allocation System**

This application is designed to manage parking lot operations efficiently. The system handles car parking assignment, spot release and overflow detection. In same time, the system ensures thread-safe operations by parallel processing.  

//Language Justification//

**Type saftey**     Java has strong static typing that helps catching errors early which improves code quality and readability. 
**Cross Platform**  JVM ensures that the application runs consistantly across Multiple operating systems. 
**Strong OOP Support** | Java's class-based object-oriented paradigm allows clean separation of concerns with Vehicle, ParkingSpot, and ParkingLot classes.
And lastly, most of our team members were comfortable coding in Java. 


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



# Instructions to Run the Program

## Prerequisites
- Java Development Kit (JDK) 8 or higher installed

## Steps to Run

1. **Open terminal/command prompt and navigate to the source folder:**
```bash
cd hackathon_project/src
```

2. **Compile the exception classes:**
```bash
javac exceptions/*.java
```

3. **Compile the main classes:**
```bash
javac *.java
```

4. **Run the application:**
```bash
java App
```

## Using an IDE (IntelliJ, Eclipse, VS Code)
1. Open `hackathon_project` folder
2. Set `src` as source root
3. Run `App.java`