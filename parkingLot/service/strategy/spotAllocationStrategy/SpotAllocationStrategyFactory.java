package projects.parkingLot.service.strategy.spotAllocationStrategy;

public class SpotAllocationStrategyFactory {

    public static SpotAllocationStrategy spotAllocationStrategy()
    {
        return new LinearSpotAllocationStrategy();
    }
}
