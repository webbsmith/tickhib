/**
 * Created by webbs_000 on 12/13/2014.
 */
public class Ticket {
    int id;
    TicketStatus status;
    String content;

    public Ticket() {
        status = TicketStatus.OPEN;
    }

    public Ticket(String content) {
        this();
        setContent(content);
    }

    public String toStringBrief() {
        return "Ticket{" +
                "id=" + id +
                ", status=" + status.name() +
                '}';
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", status=" + status.name() +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;

        Ticket ticket = (Ticket) o;

        if (id != ticket.id) return false;
        if (!content.equals(ticket.content)) return false;
        if (status != ticket.status) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + status.hashCode();
        result = 31 * result + content.hashCode();
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
