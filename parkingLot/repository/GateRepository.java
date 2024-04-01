package projects.parkingLot.repository;

import projects.parkingLot.exceptions.GateNotFoundException;
import projects.parkingLot.exceptions.ParkingSpotNotFoundException;
import projects.parkingLot.models.Gate;
import projects.parkingLot.models.ParkingSpot;

import java.util.HashMap;

public class GateRepository {
    private HashMap<Integer, Gate> gateMap;

    public GateRepository() {
        this.gateMap = new HashMap<>();
    }

    public Gate getGate(int gateId) {
        Gate gate = gateMap.get(gateId);
        if(gate == null)
        {
            throw new GateNotFoundException("Gate Not Found "+gateId);
        }
        return gate;
    }
    public void put(Gate gate)
    {
        gateMap.put(gate.getId(),gate);
        System.out.println("Gate Added Successfully");
    }
}
