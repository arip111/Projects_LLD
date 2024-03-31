package projects.parkingLot.service.strategy.billCalculationStartegy;

import projects.parkingLot.models.Bill;
import projects.parkingLot.models.Ticket;

public interface BillCalculationStrategy {
    Bill generateBill(Ticket ticket);
}
