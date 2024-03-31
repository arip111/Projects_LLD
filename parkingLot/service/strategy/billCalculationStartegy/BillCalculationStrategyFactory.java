package projects.parkingLot.service.strategy.billCalculationStartegy;

public class BillCalculationStrategyFactory {

    public  static BillCalculationStrategy getBill()
    {
        return  new SimpleBillCalculationStrategy();
    }
}
