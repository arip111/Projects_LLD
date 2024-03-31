package projects.parkingLot.repository;

import projects.parkingLot.exceptions.TicketNotFoundException;
import projects.parkingLot.models.Ticket;

import java.util.HashMap;

public class TicketRepository {

    private HashMap<Integer, Ticket> tickets;

    public TicketRepository() {
        this.tickets = new HashMap<>();
    }

    public Ticket getTicket(int ticketId)
    {
        Ticket ticket = tickets.get(ticketId);
        if(ticket == null)
        {
            throw new TicketNotFoundException("Ticket not Found "+ticketId);
        }
        return ticket;
    }
    public void put(Ticket ticket)
    {
        tickets.put(ticket.getId(), ticket);
        System.out.println("Ticket has been Added Successfully");
    }
}
