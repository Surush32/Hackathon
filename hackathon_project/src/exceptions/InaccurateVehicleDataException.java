package exceptions;
public class InaccurateVehicleDataException extends ParkingException {
    public InaccurateVehicleDataException(String message) {
        super(message);
    }

    public static void VehicleDataValidation(String vehicleData)
        throws InaccurateVehicleDataException {

    if (vehicleData == null || vehicleData.trim().isEmpty()) {
        throw new InaccurateVehicleDataException(
                "Vehicle data cannot be null or empty.");
    }
    if (!vehicleData.matches("[A-Z0-9-]+")) {
        throw new InaccurateVehicleDataException(
                "Vehicle data contains invalid characters.");
    }
    if (vehicleData.length() < 5 || vehicleData.length() > 15) {
        throw new InaccurateVehicleDataException(
                "Vehicle data length must be between 5 and 15 characters.");
    }
}

}
//InaccurateVehicleDataException.VehicleDataValidation(plate);
