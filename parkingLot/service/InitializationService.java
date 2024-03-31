package projects.parkingLot.service;

import java.util.ArrayList;
import java.util.List;

import projects.parkingLot.enums.*;
import projects.parkingLot.models.Gate;
import projects.parkingLot.models.ParkingFloor;
import projects.parkingLot.models.ParkingLot;
import projects.parkingLot.models.ParkingSpot;
import projects.parkingLot.repository.GateRepository;
import projects.parkingLot.repository.ParkingFloorRepository;
import projects.parkingLot.repository.ParkingLotRepository;
import projects.parkingLot.repository.ParkingSpotRepository;

public class InitializationService {
    //Build our Entire DateSet for Working
    private ParkingLotRepository parkingLotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private GateRepository gateRepository;

    public InitializationService(ParkingLotRepository parkingLotRepository, ParkingFloorRepository parkingFloorRepository, ParkingSpotRepository parkingSpotRepository, GateRepository gateRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.gateRepository = gateRepository;
    }

    public void inIt()
    {
        System.out.println("***** Starting Initialization *****");
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("JK Parking Center");
        parkingLot.setAddress("Near Baroda Chowkan");
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setCapacity(100);
        List<VehicleType> vehicleTypes = new ArrayList<>(List.of(VehicleType.TWO_WHEELER,VehicleType.FOUR_WHEELER));
        parkingLot.setVehicleTypeSupported(vehicleTypes);

        List<ParkingFloor> floors = new ArrayList<>();
        for(int i=1;i<=10;i++)
        {
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setFloorNumber(i);
            parkingFloor.setParkingFloorStatus(ParkingFloorStatus.AVAILABLE);
            List<ParkingSpot> spots = new ArrayList<>();
            for(int j=1;j<=10;j++)
            {
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setNumber(i*100+j);
                parkingSpot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
                parkingSpot.setVehicleType(VehicleType.FOUR_WHEELER);
                spots.add(parkingSpot);
                parkingSpotRepository.put(parkingSpot);
            }
            parkingFloor.setParkingSpots(spots);
            Gate entryGate = new Gate();
            entryGate.setId(i*1000+1);
            entryGate.setGateNumber(i*100+1);
            entryGate.setGateStatus(GateStatus.OPEN);
            entryGate.setOperatorName("Operator "+i+1);
            entryGate.setGateType(GateType.ENTRY);
            parkingFloor.setEntryGate(entryGate);
            gateRepository.put(entryGate);


            Gate exitGate = new Gate();
            exitGate.setId(i*1000+2);
            exitGate.setGateNumber(i*100+2);
            exitGate.setGateStatus(GateStatus.OPEN);
            exitGate.setOperatorName("Operator "+i+2);
            exitGate.setGateType(GateType.EXIT);
            parkingFloor.setExitGate(exitGate);
            gateRepository.put(exitGate);

            floors.add(parkingFloor);
            parkingFloorRepository.put(parkingFloor);
        }
        parkingLot.setParkingFloors(floors);
        parkingLotRepository.put(parkingLot);
    }
}
