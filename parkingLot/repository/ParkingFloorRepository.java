package projects.parkingLot.repository;

import projects.parkingLot.exceptions.ParkingLotNotFoundException;
import projects.parkingLot.models.ParkingFloor;

import java.util.HashMap;

public class ParkingFloorRepository {

    private HashMap<Integer, ParkingFloor> parkingFloorMap;

    public ParkingFloorRepository() {
        this.parkingFloorMap = new HashMap<>();
    }

    public ParkingFloor getParkingFloor(ParkingFloor parkingFloorId) {
        ParkingFloor parkingFloor = parkingFloorMap.get(parkingFloorId);
        if(parkingFloor == null)
        {
            throw new ParkingLotNotFoundException("Parking Floor Not Found "+parkingFloorId);
        }
        return parkingFloor;
    }
    public void put(ParkingFloor parkingFloor)
    {
        parkingFloorMap.put(parkingFloor.getId(),parkingFloor);
        System.out.println("ParkingFloor Added Successfully");
    }
}
