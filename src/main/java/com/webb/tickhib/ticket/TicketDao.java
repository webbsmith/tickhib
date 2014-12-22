package com.webb.tickhib.ticket;

import java.util.List;

/**
 * Created by webbs_000 on 12/22/2014.
 */
public interface TicketDao {
    public void add(Ticket ticket);
    public void edit(Ticket ticket);
    public Ticket getTicket(int id);
    public List<Ticket> getAllTickets();
}
