package projects.parkingLot.models;

import projects.parkingLot.enums.ParkingLotStatus;
import projects.parkingLot.enums.VehicleType;
import projects.parkingLot.service.strategy.billCalculationStartegy.BillCalculationStrategy;
import projects.parkingLot.service.strategy.spotAllocationStrategy.SpotAllocationStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot extends BaseModel{
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private ParkingLotStatus parkingLotStatus;
    private List<VehicleType> vehicleTypeSupported;
    private int capacity;
    private BillCalculationStrategy billCalculationStrategy;
    private SpotAllocationStrategy spotAllocationStrategy;

    public ParkingLot() {
    }

    public ParkingLot(String name, String address, List<ParkingFloor> parkingFloors, ParkingLotStatus parkingLotStatus, int capacity, BillCalculationStrategy billCalculationStrategy, SpotAllocationStrategy spotAllocationStrategy) {
        this.name = name;
        this.address = address;
        this.parkingFloors = parkingFloors;
        this.parkingLotStatus = parkingLotStatus;
        this.vehicleTypeSupported = new ArrayList<>();
        this.capacity = capacity;
        this.billCalculationStrategy = billCalculationStrategy;
        this.spotAllocationStrategy = spotAllocationStrategy;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public List<VehicleType> getVehicleTypeSupported() {
        return vehicleTypeSupported;
    }

    public int getCapacity() {
        return capacity;
    }

    public BillCalculationStrategy getBillCalculationStrategy() {
        return billCalculationStrategy;
    }

    public SpotAllocationStrategy getSpotAllocationStrategy() {
        return spotAllocationStrategy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public void setVehicleTypeSupported(List<VehicleType> vehicleTypeSupported) {
        this.vehicleTypeSupported = vehicleTypeSupported;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setBillCalculationStrategy(BillCalculationStrategy billCalculationStrategy) {
        this.billCalculationStrategy = billCalculationStrategy;
    }

    public void setSpotAllocationStrategy(SpotAllocationStrategy spotAllocationStrategy) {
        this.spotAllocationStrategy = spotAllocationStrategy;
    }
}
