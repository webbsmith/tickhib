import java.util.*;
import java.io.*;

/**
 * Created by webbs_000 on 12/13/2014.
 */
public class MenuCommandLine implements Menu {

    Map<Integer, String> actionMap;
    BufferedReader reader;
    
    final static int EXIT = 0;
    final static int CREATE_TICKET = 1;
    final static int SHOW_TICKET = 2;
    final static int LIST_TICKETS = 3;
    final static int EDIT_TICKET = 4;
    final static int CLOSE_TICKET = 5;
    final static int REOPEN_TICKET = 6;

    public MenuCommandLine() {
        actionMap = new LinkedHashMap<>();
        actionMap.put(CREATE_TICKET, "Create Ticket");
        actionMap.put(SHOW_TICKET, "Show Ticket");
        actionMap.put(LIST_TICKETS, "List Tickets");
        actionMap.put(EDIT_TICKET, "Edit Ticket");
        actionMap.put(CLOSE_TICKET, "Close Ticket");
        actionMap.put(REOPEN_TICKET, "Reopen Ticket");
        actionMap.put(EXIT, "Exit");
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        while (true) {
            displayActions();
            selectAction();
        }
    }

    private void displayActions() {

        Map<Integer, String> leftColumnMap = new LinkedHashMap<>();
        Map<Integer, String> rightColumnMap = new LinkedHashMap<>();

        byte entryCount = 0;
        for (Map.Entry<Integer, String> entry : actionMap.entrySet()) {

            if (entryCount++ < (int)Math.ceil(actionMap.size()/2.0))
                leftColumnMap.put(entry.getKey(), entry.getValue());
            else
                rightColumnMap.put(entry.getKey(), entry.getValue());
        }
        Iterator<Map.Entry<Integer, String>> leftColumn = leftColumnMap.entrySet().iterator();
        Iterator<Map.Entry<Integer, String>> rightColumn = rightColumnMap.entrySet().iterator();
        System.out.printf("\n%s\n", "Ticketing Menu");
        while (leftColumn.hasNext()) {
            Map.Entry<Integer, String> leftEntry = leftColumn.next();
            if (rightColumn.hasNext()) {
                Map.Entry<Integer, String> rightEntry = rightColumn.next();
                System.out.printf("  %d: %-14s  %d: %-14s\n",
                        leftEntry.getKey(), leftEntry.getValue(),
                        rightEntry.getKey(), rightEntry.getValue());
            } else {
                System.out.printf("  %d: %-14s\n",
                        leftEntry.getKey(), leftEntry.getValue());
            }
        }
    }

    private void selectAction() {
        boolean validChoice = false;
        Integer selectedAction = null;
        while (!validChoice) {
            try {
                selectedAction = promptUserForInteger("Select an action");
                if (actionMap.get(selectedAction) == null)
                    throw new IOException();
                validChoice = true;
            } catch (IOException | NumberFormatException e) {
                System.out.printf("Invalid input.\n");
            }
        }
        performAction(selectedAction);
    }
    
    public void performAction(int actionCode) {
        switch(actionCode) {
            case EXIT:
                exit(); break;
            case CREATE_TICKET:
                createTicket(); break;
            case SHOW_TICKET:
                showTicket(); break;
            case LIST_TICKETS:
                listTickets(); break;
            case EDIT_TICKET:
                editTicket(); break;
            case CLOSE_TICKET:
                closeTicket(); break;
            case REOPEN_TICKET:
                reopenTicket(); break;
        }
    }

    public void exit() {
        System.exit(0);
    }

    public void createTicket() {
        String content = promptUserForString("Enter the ticket's content");
        Ticket ticket = new Ticket(content);
        DbPlaceholder.addToDb(ticket);
    }

    public void showTicket() {
        int ticketId = promptUserForTicketId();
        Ticket ticket = DbPlaceholder.getFromDb(ticketId);
        System.out.printf(
                "Ticket # %d\n status: %s\n content: %s\n",
                ticket.getId(),
                ticket.getStatus().name(),
                ticket.getContent()
        );
    }

    public void listTickets() {
        List<Ticket> tickets = DbPlaceholder.getListOfAllTickets();
        System.out.printf("\nAll Tickets\n");
        for (Ticket ticket : tickets) {
            System.out.printf("  %s\n", ticket.toStringBrief());
        }
    }

    public void editTicket() {
        int ticketId = promptUserForTicketId();
        System.out.printf("Method not complete.");
    }

    public void closeTicket() {
        int ticketId = promptUserForTicketId();
        System.out.printf("Method not complete.");
    }

    public void reopenTicket() {
        int ticketId = promptUserForTicketId();
        System.out.printf("Method not complete.");
    }

    private Integer promptUserForTicketId() {
        return promptUserForInteger("Enter the ticket id");
    }

    private String promptUserForString(String prompt) {
        return (String) promptUserForInput(prompt, false);
    }

    private Integer promptUserForInteger(String prompt) {
        return (Integer) promptUserForInput(prompt, true);
    }

    private Object promptUserForInput(String prompt, boolean shouldBeAnInt) {
        Object userInput = null;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.printf("%s> ", prompt);
            try {
                userInput = reader.readLine();
                if (shouldBeAnInt)
                    userInput = Integer.parseInt((String)userInput);
                validChoice = true;
            } catch (IOException | NumberFormatException e) {
                System.out.printf("Invalid input. Try again.\n");
            }
        }
        return userInput;
    }

}
