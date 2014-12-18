/**
 * Created by webbs_000 on 12/13/2014.
 */
public enum TicketStatus {
    CLOSED(0),
    OPEN(1);

    int code;

    TicketStatus(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "TicketStatus{" +
                "code=" + code +
                '}';
    }
}
