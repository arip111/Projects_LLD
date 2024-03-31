package projects.parkingLot.repository;

import projects.parkingLot.exceptions.ParkingLotNotFoundException;
import projects.parkingLot.models.ParkingLot;
import projects.parkingLot.models.Ticket;

import java.util.HashMap;
public class ParkingLotRepository {

    private HashMap<Integer, ParkingLot> parkingLotMap;
    private static int idCounter=0;

    public ParkingLotRepository() {
        this.parkingLotMap = new HashMap<>();
    }

    public ParkingLot getParkingLot(int parkingLotId)
    {
        ParkingLot parkingLot = parkingLotMap.get(parkingLotId);
        if(parkingLot == null)
        {
            throw new ParkingLotNotFoundException("parkingLot not Found "+parkingLotId);
        }
        return parkingLot;
    }
    public void put(ParkingLot parkingLot)
    {
        parkingLot.setId(++idCounter);
        parkingLotMap.put(parkingLot.getId(), parkingLot);
        System.out.println("ParkingLot has been added Successfully");
    }
}
