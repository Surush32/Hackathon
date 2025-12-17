package exceptions;
public class ParkingOverflowException extends ParkingException {
    public ParkingOverflowException(String message) {
        super(message);
    }

    public static void ParkingOverflowValidation(int capacity, int currentOccupancy)
        throws ParkingOverflowException {

    if (capacity < 0) {
        throw new ParkingOverflowException("Capacity cannot be negative.");
    }
    if (currentOccupancy < 0) {
        throw new ParkingOverflowException("Current occupancy cannot be negative.");
    }
    if (currentOccupancy > capacity) {
        throw new ParkingOverflowException(
                "Current occupancy cannot exceed capacity.");
    }
}

}
// in allocateParking(Vehicle vehicle) method
// ParkingOverflowException.ParkingOverflowValidation(capacity, currentOccupancy);