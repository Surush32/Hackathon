# Hackathon
**Fall 2025 Advanced Programming Language Concepts (CMPP-3020-BSA)**

---

## Team Members

- **Kedir Rahmet**
- **Princess Blessing**
- **Surush Azaryun**

---

## Project Description

### Smart Parking Allocation System

This application is designed to manage parking lot operations efficiently. The system handles car parking assignment, spot release and overflow detection. At the same time, the system ensures thread-safe operations by parallel processing.

---

## Language Justification

| Reason | Explanation |
|--------|-------------|
| **Type Safety** | Java has strong static typing that helps catching errors early which improves code quality and readability |
| **Cross Platform** | JVM ensures that the application runs consistently across multiple operating systems |
| **Strong OOP Support** | Java's class-based object-oriented paradigm allows clean separation of concerns with Vehicle, ParkingSpot, and ParkingLot classes |

And lastly, most of our team members were comfortable coding in Java.

---

## Main Features

| Feature | Description |
|---------|-------------|
| Automatic Spot Assignment | Assigns parking spot for cars based on size and compatibility |
| Spot Release Management | The spot which cars are parked will get assigned to other cars if that spot gets available |
| Overflow Detection | Validates parking capacity to prevent over allocation |
| Parallel Availability Checks | Java parallel stream which searches for parking spot more efficiently |
| Validation Steps | Validates vehicle and parking spot data with custom exceptions |

---

## Class Responsibilities

| Class | Responsibility |
|-------|----------------|
| **Vehicle** | Represents a vehicle with plate number and size (small/compact/large) |
| **ParkingSpot** | Represents a parking spot with ID, size, availability status, and current vehicle |
| **ParkingLot** | Manages collection of spots, handles assignment/release operations, enforces size compatibility |
| **App** | Application entry point for running demonstrations |

---

## System Design Overview

```
┌─────────────────────────────────────────────────────────────────────┐
│                           ParkingLot                                │
│─────────────────────────────────────────────────────────────────────│
│ - spots: List<ParkingSpot>                                          │
│─────────────────────────────────────────────────────────────────────│
│ + assignSpot(vehicle: Vehicle): void                                │
│ + releaseSpot(plateNumber: String): void                            │
│ + getParkedCars(): List<String>                                     │
│ - canFit(vehicle: Vehicle, spot: ParkingSpot): boolean              │
└─────────────────────────────────────────────────────────────────────┘
                                    │
                                    │ manages
                                    ▼
┌─────────────────────────────────────────────────────────────────────┐
│                           ParkingSpot                               │
│─────────────────────────────────────────────────────────────────────│
│ - id: String                                                        │
│ - size: String                                                      │
│ - available: boolean                                                │
│ - currentVehicle: Vehicle                                           │
│─────────────────────────────────────────────────────────────────────│
│ + isAvailable(): boolean                                            │
│ + setAvailable(available: boolean): void                            │
│ + getCurrentVehicle(): Vehicle                                      │
│ + setCurrentVehicle(vehicle: Vehicle): void                         │
│ + getId(): String                                                   │
│ + getSize(): String                                                 │
└─────────────────────────────────────────────────────────────────────┘
                                    │
                                    │ holds
                                    ▼
┌─────────────────────────────────────────────────────────────────────┐
│                             Vehicle                                 │
│─────────────────────────────────────────────────────────────────────│
│ - plate: String                                                     │
│ - size: String                                                      │
│─────────────────────────────────────────────────────────────────────│
│ + getPlate(): String                                                │
│ + getSize(): String                                                 │
└─────────────────────────────────────────────────────────────────────┘
```

## Parallel programming + exception handling + future improvements
## Parralel Programming
We used Java Parallel Streams to search for an available parking spot:

```
Optional<ParkingSpot> spotOpt = spots.parallelStream()
        .filter(s -> s.isAvailable() && canFit(vehicle, s))
        .findFirst();

```
Why parallel streams?

Instead of looping through parking spots one by one,
parallel streams allow the search to be split across multiple CPU cores

This improves performance when the number of parking spots increases

## Exception Handling

The system uses custom exceptions to handle errors, such as:

No available parking spot

Invalid vehicle data

Invalid spot data

Parking overflow

Try/catch blocks are used in the main logic to catch errors, show clear messages, and keep the program running without crashing.

## Future Improvements
Add a database to store parking information.
Adding a frontend to our project.
Adding a reservation system where customers can check before coming to the parking lot.
---

## Parallel programming + exception handling + future improvements


## Instructions to Run the Program

### Prerequisites
- Java Development Kit (JDK) 8 or higher installed

### Steps to Run

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

### Using an IDE (IntelliJ, Eclipse, VS Code)
1. Open `hackathon_project` folder
2. Set `src` as source root
3. Run `App.java`
