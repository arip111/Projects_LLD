package projects.parkingLot.service;

import projects.parkingLot.enums.ParkingSpotStatus;
import projects.parkingLot.models.*;
import projects.parkingLot.repository.GateRepository;
import projects.parkingLot.repository.ParkingLotRepository;
import projects.parkingLot.repository.ParkingSpotRepository;
import projects.parkingLot.repository.TicketRepository;
import projects.parkingLot.service.strategy.spotAllocationStrategy.SpotAllocationStrategy;
import projects.parkingLot.service.strategy.spotAllocationStrategy.SpotAllocationStrategyFactory;

import java.time.LocalDateTime;

public class TicketService {
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;
    private GateRepository gateRepository;
    private ParkingSpotRepository spotRepository;

    public TicketService(TicketRepository ticketRepository, ParkingLotRepository parkingLotRepository, GateRepository gateRepository, ParkingSpotRepository spotRepository) {
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
        this.spotRepository = spotRepository;
    }

    public Ticket generateTicket(Vehicle vehicle, int gateId, int parkingLotId)
    {
        SpotAllocationStrategy spotAllocationStrategy = SpotAllocationStrategyFactory.spotAllocationStrategy();
        ParkingLot parkingLot = parkingLotRepository.getParkingLot(parkingLotId);
        ParkingSpot parkingSpot = spotAllocationStrategy.getSpotForVehicle(vehicle,parkingLot);
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        parkingSpot.setVehicle(vehicle);
        spotRepository.put(parkingSpot);

        Gate gate = gateRepository.getGate(gateId);
        Ticket ticket =new Ticket();
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setVehicle(vehicle);
        ticket.setParkingSpot(parkingSpot);
        ticket.setEntryGate(gate);
        return ticketRepository.put(ticket);
    }
}
