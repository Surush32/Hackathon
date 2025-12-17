import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import exceptions.InaccurateSpotDataException;
import exceptions.SpotNotAvailableException;

public class ParkingLot {

    private List<ParkingSpot> spots;

    public ParkingLot(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    // Assign parking spot to a vehicle
    public void assignSpot(Vehicle vehicle) {

        if (vehicle == null) {
            System.out.println("Invalid vehicle.");
            return;
        }
        if (getParkedCars().contains(vehicle.getPlate())) {
            System.out.println("Vehicle " + vehicle.getPlate() + " is already parked.");
            return;
        }
        // Parallel check for available spot
        Optional<ParkingSpot> spotOpt = spots.parallelStream()
                .filter(s -> s.isAvailable() && canFit(vehicle, s))
                .findFirst();
        try {
             if (spotOpt.isPresent()) {
            ParkingSpot spot = spotOpt.get();
            synchronized (spot) { // only one thread can assign this spot at a time
                if (spot.isAvailable()) { // double-check inside synchronized
                    spot.setCurrentVehicle(vehicle);
                    spot.setAvailable(false);
                    System.out.println("Vehicle " + vehicle.getPlate() +
                            " parked at spot " + spot.getId());
                }
            }
        } 
        throw new SpotNotAvailableException("No available parking spot for vehicle "+ vehicle.getPlate());
 
        } catch (SpotNotAvailableException e) {
            System.err.println(e.getMessage());
        }
    
    }

    // Release a parking spot
    public void releaseSpot(String plateNumber) {

        if (plateNumber == null || plateNumber.isEmpty()) {
            System.out.println("Invalid plate number.");
            return;
        }
        try {
            InaccurateSpotDataException.SpotDataValidation(plateNumber);
        for (ParkingSpot spot : spots) {
            if (!spot.isAvailable()
                    && spot.getCurrentVehicle().getPlate().equals(plateNumber)) {

                spot.setCurrentVehicle(null);
                spot.setAvailable(true);

                System.out.println("Vehicle " + plateNumber
                        + " left spot " + spot.getId());
                return;
            }
        }
        System.out.println("Vehicle not found in parking lot.");
            
        } catch (InaccurateSpotDataException e) {
            System.out.println(e.getMessage());
        }
       
  

    }

    // Size compatibility check
    private boolean canFit(Vehicle vehicle, ParkingSpot spot) {
        String vSize = vehicle.getSize();
        String sSize = spot.getSize();

        if (vSize == null || sSize == null) {
            return false;
        }

        if (vSize.equals("small"))
            return true;
        if (vSize.equals("compact") && !sSize.equals("small"))
            return true;
        if (vSize.equals("large") && sSize.equals("large"))
            return true;

        return false;
    }

    public List<String> getParkedCars() {
        List<String> parkedCars = new ArrayList<>();
        for (ParkingSpot spot : spots) {
            if (!spot.isAvailable()) {
                parkedCars.add(spot.getCurrentVehicle().getPlate());
            }
        }
        return parkedCars;
    }

    public void printStatus() {

        // Print all parked vehicles
        List<String> parkedCars = getParkedCars();
        System.out.println("\nParked vehicles:");
        if (parkedCars.isEmpty()) {
            System.out.println("None");
        } else {
            for (String plate : parkedCars) {
                System.out.println("- " + plate);
            }
        }
    }
}
