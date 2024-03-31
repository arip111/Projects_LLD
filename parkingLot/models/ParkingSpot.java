package projects.parkingLot.models;

import projects.parkingLot.enums.ParkingSpotStatus;
import projects.parkingLot.enums.VehicleType;

public class ParkingSpot extends BaseModel{

    private int number;
    private VehicleType vehicleType;
    private ParkingSpotStatus parkingSpotStatus;
    private Vehicle vehicle;
    public ParkingSpot() {
    }
    public ParkingSpot(int number, VehicleType vehicleType, ParkingSpotStatus parkingSpotStatus, Vehicle vehicle) {
        this.number = number;
        this.vehicleType = vehicleType;
        this.parkingSpotStatus = parkingSpotStatus;
        this.vehicle = vehicle;
    }


    public int getNumber() {
        return number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
