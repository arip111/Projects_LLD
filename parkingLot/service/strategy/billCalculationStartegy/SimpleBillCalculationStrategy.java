package projects.parkingLot.service.strategy.billCalculationStartegy;

import projects.parkingLot.enums.BillStatus;
import projects.parkingLot.models.Bill;
import projects.parkingLot.models.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class SimpleBillCalculationStrategy implements BillCalculationStrategy{
    @Override
    public Bill generateBill(Ticket ticket) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        long numberOfSec = ChronoUnit.SECONDS.between(entryTime,entryTime);
        long amount = numberOfSec;
        Bill bill = new Bill();
        bill.setAmount(amount);
        bill.setTicket(ticket);
        bill.setExitTime(exitTime);
        bill.setId(exitTime.hashCode());
        bill.setStatus(BillStatus.UNPAID);
        return bill;
    }
}
