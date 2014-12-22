package com.webb.tickhib.menu;

/**
 * Created by webbs_000 on 12/13/2014.
 */
public interface Menu {
    abstract void run();
    abstract void exit();
    abstract void createTicket();
    abstract void showTicket();
    abstract void listTickets();
    abstract void editTicket();
    abstract void closeTicket();
    abstract void reopenTicket();
}
