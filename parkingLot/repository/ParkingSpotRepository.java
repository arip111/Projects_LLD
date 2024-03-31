package projects.parkingLot.repository;

import projects.parkingLot.exceptions.ParkingLotNotFoundException;
import projects.parkingLot.exceptions.ParkingSpotNotFoundException;
import projects.parkingLot.models.ParkingFloor;
import projects.parkingLot.models.ParkingSpot;

import java.util.HashMap;

public class ParkingSpotRepository {

    private HashMap<Integer, ParkingSpot> parkingSpotMap;

    public ParkingSpotRepository() {
        this.parkingSpotMap = new HashMap<>();
    }

    public ParkingSpot getParkingSpot(ParkingSpot parkingSpotId) {
        ParkingSpot parkingSpot = parkingSpotMap.get(parkingSpotId);
        if(parkingSpot == null)
        {
            throw new ParkingSpotNotFoundException("Parking Spot Not Found "+parkingSpotId);
        }
        return parkingSpot;
    }
    public void put(ParkingSpot parkingSpot)
    {
        parkingSpotMap.put(parkingSpot.getId(),parkingSpot);
        System.out.println("ParkingSpot Added Successfully");
    }
}
