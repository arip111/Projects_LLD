package projects.parkingLot;

import projects.parkingLot.controller.InItController;
import projects.parkingLot.controller.TicketController;
import projects.parkingLot.enums.VehicleType;
import projects.parkingLot.models.Ticket;
import projects.parkingLot.models.Vehicle;
import projects.parkingLot.repository.*;
import projects.parkingLot.service.InitializationService;
import projects.parkingLot.service.TicketService;

import java.util.Scanner;

public class ParkingLotMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository =new TicketRepository();

        InitializationService initializationService = new InitializationService(
                parkingLotRepository,
                parkingFloorRepository,
                parkingSpotRepository,
                gateRepository
        );
        InItController inItController = new InItController(initializationService);
        System.out.println("Parking Lot data initialize starts");
        inItController.inIt();
        System.out.println("Parking Lot Data initialize Ends");

        TicketService ticketService = new TicketService(ticketRepository,parkingLotRepository,gateRepository,parkingSpotRepository);
        TicketController ticketController = new TicketController(ticketService);
        System.out.println("Choose a Option : 1.Enter Parking Lot, 2.Exit Parking Lot");
        int option = sc.nextInt();
        while(true)
        {
            if(option == 1)
            {
                Vehicle vehicle = new Vehicle();
                System.out.println("Welcome to our Parking Lot");
                System.out.println("Please Enter Vehicle Number");
                String number = sc.next();
                vehicle.setVehicleNumber(number);
                System.out.println("Enter the Vehicle Color");
                String color = sc.next();;
                vehicle.setColor(color);
                System.out.println("Please choose Vehicle Type: 1.Car, 2.Bike");
                int type = sc.nextInt();
                if(type==1)
                {
                    vehicle.setVehicleType(VehicleType.FOUR_WHEELER);
                }
                else
                {
                    vehicle.setVehicleType(VehicleType.TWO_WHEELER);
                }
                System.out.println("Please enter the Parking Lot Id");
                int parkingId = sc.nextInt();
                System.out.println("Please enter the gate Id");
                int gateId=sc.nextInt();
                Ticket ticket = ticketController.generateTicket(vehicle,gateId,parkingId);
                System.out.println("Ticket Details "+ticket);
            }
            else if (option == 2)
            {

            }
            else
            {
                System.out.println("Thanks");
                break;
            }
        }




    }
}
