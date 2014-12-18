import java.util.LinkedHashMap;
import java.util.Map;
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
        actionMap.put(EXIT, "Exit");
        actionMap.put(CREATE_TICKET, "Create Ticket");
        actionMap.put(SHOW_TICKET, "Show Ticket");
        actionMap.put(LIST_TICKETS, "List Tickets");
        actionMap.put(EDIT_TICKET, "Edit Ticket");
        actionMap.put(CLOSE_TICKET, "Close Ticket");
        actionMap.put(REOPEN_TICKET, "Reopen Ticket");
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void displayActions() {
        System.out.printf("%s\n", "Ticketing Menu");
        for (Map.Entry<Integer, String> entry : actionMap.entrySet()) {
            System.out.printf("  %d: %s\n", entry.getKey(), entry.getValue());
        }
    }

    public void selectAction() {
        boolean validChoice = false;
        Integer selectedAction = null;
        while (!validChoice) {
            System.out.printf("Select an action \n");
            try {
                selectedAction = promptUserForInteger();
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
                exit();
            case CREATE_TICKET:
                createTicket();
            case SHOW_TICKET:
                showTicket();
            case LIST_TICKETS:
                listTickets();
            case EDIT_TICKET:
                editTicket();
            case CLOSE_TICKET:
                closeTicket();
            case REOPEN_TICKET:
                reopenTicket();
        }
    }

    public void exit() {
        System.exit(0);
    }

    public void createTicket() {
        System.out.printf("Enter the ticket's content\n");
    }

    public void showTicket() {
        int ticketId = promptUserForTicketId();
    }

    public void listTickets() {
        System.out.printf("PLACEHOLDER\n");
    }

    public void editTicket() {
        int ticketId = promptUserForTicketId();
    }

    public void closeTicket() {
        int ticketId = promptUserForTicketId();
    }

    public void reopenTicket() {
        int ticketId = promptUserForTicketId();
    }

    private Integer promptUserForTicketId() {
        System.out.printf("Enter the ticket id\n");
        return promptUserForInteger();
    }

    private String promptUserForString() {
        return (String) promptUserForInput(false);
    }

    private Integer promptUserForInteger() {
        return (Integer) promptUserForInput(true);
    }

    private Object promptUserForInput(boolean shouldBeAnInt) {
        Object userInput = null;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.printf("> ");
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
