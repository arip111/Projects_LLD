package projects.parkingLot;

import projects.parkingLot.controller.InItController;
import projects.parkingLot.repository.GateRepository;
import projects.parkingLot.repository.ParkingFloorRepository;
import projects.parkingLot.repository.ParkingLotRepository;
import projects.parkingLot.repository.ParkingSpotRepository;
import projects.parkingLot.service.InitializationService;

public class ParkingLotMain {
    public static void main(String[] args) {

        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        GateRepository gateRepository = new GateRepository();

        InitializationService initializationService = new InitializationService(
                parkingLotRepository,
                parkingFloorRepository,
                parkingSpotRepository,
                gateRepository
        );
        InItController inItController = new InItController(initializationService);
        inItController.inIt();
        System.out.println("End");


    }
}
