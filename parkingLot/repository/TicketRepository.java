package projects.parkingLot.repository;

import projects.parkingLot.exceptions.TicketNotFoundException;
import projects.parkingLot.models.Ticket;

import java.util.HashMap;

public class TicketRepository {

    private HashMap<Integer, Ticket> tickets;
    private  static int idCounter=0;

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
    public Ticket put(Ticket ticket)
    {
        ticket.setId(++idCounter);
        tickets.put(ticket.getId(), ticket);
        System.out.println("Ticket has been Added Successfully");
        return tickets.get(idCounter);
    }
}
