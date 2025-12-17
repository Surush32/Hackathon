import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // Creating parking spots
        List<ParkingSpot> spots = new ArrayList<>();
        spots.add(new ParkingSpot("P1", "compact"));
        spots.add(new ParkingSpot("P2", "large"));
        spots.add(new ParkingSpot("P3", "small"));

        // Create parking lot
        ParkingLot parkingLot = new ParkingLot(spots);

        // Create vehicles
        Vehicle v1 = new Vehicle("ABC123", "compact");
        Vehicle v2 = new Vehicle("XYZ789", "large");
        Vehicle v3 = new Vehicle("LMNO999", "large"); // overflow test
        Vehicle v4 = new Vehicle("RSTU999", "small");
        Vehicle v5 = new Vehicle("VWXZ999", "small");

        // Assign spots
        parkingLot.assignSpot(v1);
        parkingLot.assignSpot(v2);
        parkingLot.assignSpot(v3); // size mismatch test
        parkingLot.assignSpot(v4);
        parkingLot.assignSpot(v5); // triggering overflow
        parkingLot.assignSpot(v1); // already parked test
        System.out.println();

        // Release a spot
        parkingLot.releaseSpot("ABC123");

        System.out.println();

        // Try parking again after release
        parkingLot.assignSpot(v5);

        parkingLot.printStatus();

    }
}
