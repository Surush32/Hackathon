package exceptions;
public class SpotNotAvailableException extends ParkingException {
    public SpotNotAvailableException(String message) {
        super(message);
    }

    public static void SpotAvailabilityValidation(boolean isAvailable)
        throws SpotNotAvailableException {

    if (!isAvailable) {
        throw new SpotNotAvailableException(
                "The requested spot is not available.");
    }
}
}