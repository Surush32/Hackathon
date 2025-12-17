public class ParkingSpot {
    private String id;         
    private String size;          
    private boolean available;    
    private Vehicle currentVehicle; 

    // Constructor
    public ParkingSpot(String id, String size) {
        this.id = id;
        this.size = size;
        this.available = true;       
        this.currentVehicle = null;   
    }

   
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public Vehicle getCurrentVehicle() { return currentVehicle; }
    public void setCurrentVehicle(Vehicle vehicle) { this.currentVehicle = vehicle; }
    public String getId() { return id; }
    public String getSize() { return size; }
}
