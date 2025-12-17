import exceptions.InaccurateVehicleDataException;

public class Vehicle {
    private String plate; 
    private String size; 

    // Constructor
    public Vehicle(String plate, String size) {
    try {
        InaccurateVehicleDataException.VehicleDataValidation(plate);
    }
    catch (InaccurateVehicleDataException e) {
        System.err.println(e.getMessage());
    }   
        this.plate = plate;
        this.size = size;
    }

    // Getters (OOP encapsulation)
    public String getPlate() {
        return plate;
    }

    public String getSize() {
        return size;
    }
}
