package exceptions;

public class InaccurateSpotDataException extends ParkingException {
    public InaccurateSpotDataException(String message) {
        super(message);
    }

    public static void SpotDataValidation(String spotData)
            throws InaccurateSpotDataException {

        if (spotData == null || spotData.trim().isEmpty()) {
            throw new InaccurateSpotDataException(
                    "Spot data cannot be null or empty.");
        }

        if (!spotData.matches("[A-Z0-9-]+")) {
            throw new InaccurateSpotDataException(
                    "Spot data contains invalid characters.");
        }

        if (spotData.length() < 3 || spotData.length() > 10) {
            throw new InaccurateSpotDataException(
                    "Spot data length must be between 3 and 10 characters.");
        }
    }
}
