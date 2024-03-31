package projects.parkingLot.models;

import projects.parkingLot.enums.VehicleType;

public class Vehicle extends BaseModel{

    private String vehicleNumber;
    private VehicleType vehicleType;
    private String color;

    public Vehicle() {
    }

    public Vehicle( String vehicleNumber, VehicleType vehicleType, String color) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.color = color;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
