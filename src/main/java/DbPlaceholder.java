import java.util.ArrayList;
import java.util.List;

/**
 * Created by webbs_000 on 12/18/2014.
 */
public class DbPlaceholder {
    private static List<Ticket> ticketDb = new ArrayList<>();
    
    public static void addToDb(Ticket ticket) {
        ticketDb.add(ticket);
        ticket.setId(ticketDb.indexOf(ticket));
    }

    public static Ticket getFromDb(int ticketId) {
        return ticketDb.get(ticketId);
    }

    public static List<Ticket> getListOfAllTickets() {
        List<Ticket> tickets = new ArrayList<>(ticketDb);
        return tickets;
    }




}
