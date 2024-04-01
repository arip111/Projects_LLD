package projects.parkingLot.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket extends BaseModel{

    private LocalDateTime entryTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private Gate entryGate;

    public Ticket() {
    }

    public Ticket(LocalDateTime entryTime, Vehicle vehicle, ParkingSpot parkingSpot, Gate entryGate) {
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryGate = entryGate;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "Ticket_Id = "+ getId() +
                ", entryTime = " + DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(entryTime) +
                ", vehicle_Number = " + vehicle.getVehicleNumber() +
                ", parkingSpot = " + parkingSpot.getNumber() +
                ", entryGate = " + entryGate.getGateNumber() +
                '}';
    }
}
