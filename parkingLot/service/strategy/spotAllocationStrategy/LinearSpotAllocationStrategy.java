package projects.parkingLot.service.strategy.spotAllocationStrategy;

import projects.parkingLot.enums.ParkingSpotStatus;
import projects.parkingLot.enums.VehicleType;
import projects.parkingLot.exceptions.ParkingSpotNotFoundForVechile;
import projects.parkingLot.models.ParkingFloor;
import projects.parkingLot.models.ParkingLot;
import projects.parkingLot.models.ParkingSpot;
import projects.parkingLot.models.Vehicle;

import java.util.List;

public class LinearSpotAllocationStrategy implements SpotAllocationStrategy{
    @Override
    public ParkingSpot getSpotForVehicle(Vehicle vehicle, ParkingLot parkingLot) {
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        for(ParkingFloor parkingFloor : parkingFloors)
        {
            for(ParkingSpot parkingSpot : parkingFloor.getParkingSpots())
            {
                if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY) &&
                    parkingSpot.getVehicleType().equals(vehicle.getVehicleType()) )
                {
                    return parkingSpot;
                }
            }
        }
        throw  new ParkingSpotNotFoundForVechile("Not Available for this Vehicle");
    }

}
