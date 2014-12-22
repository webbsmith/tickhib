package com.webb.tickhib.ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by webbs_000 on 12/22/2014.
 */
public class TicketDaoNoPersistence implements TicketDao {

    private static List<Ticket> ticketDb = new ArrayList<>();

    @Override
    public void add(Ticket ticket) {
        ticketDb.add(ticket);
        ticket.setId(ticketDb.indexOf(ticket));
    }

    @Override
    public void edit(Ticket ticket) {
        ticketDb.set(ticket.getId(), ticket);
    }

    @Override
    public Ticket getTicket(int id) {
        return new Ticket(ticketDb.get(id));
    }

    @Override
    public List<Ticket> getAllTickets() {
        return new ArrayList<>(ticketDb);
    }
}
