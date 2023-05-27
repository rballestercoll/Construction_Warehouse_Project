import java.time.LocalDate;
import java.util.ArrayList;

public class Sales_ticket {

    private int number;
    private LocalDate date;
    private Customer customer;
    private ArrayList<Ticket_line> lines;
    /**
     * @param number
     * @param date
     * @param customer
     */
    public Sales_ticket(int number, LocalDate date, Customer customer) {
        super();
        this.number = number;
        this.date = date;
        this.customer = customer;
        lines = new ArrayList();
    }
    /**
     * @return number
     */
    public int getNumber() {
        return number;
    }
    /**
     * @param number create number
     */
    public void setNumber(int number) {
        this.number = number;
    }
    /**
     * @return date
     */
    public LocalDate getDate() {
        return date;
    }
    /**
     * @param date set date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }
    /**
     * @return customer
     */
    public Customer getCustomer() {
        return customer;
    }
    /**
     * @param customer set customer
     */
    public void setCliente(Customer customer) {
        this.customer = customer;
    }
    /**
     * @return lines
     */
    public ArrayList<Ticket_line> getLines() {
        return lines;
    }
    /**
     * @param lines set lines
     */
    public void setLineas(ArrayList<Ticket_line> lines) {
        this.lines = lines;
    }
    @Override
    public String toString() {
        return "Sales_ticket [number=" + number + ", date=" + date + ", customer=" + customer + ", lines=" + lines
                + ", getNumber()=" + getNumber() + ", getDate()=" + getDate() + ", getCustomer()=" + getCustomer()
                + ", getLines()=" + getLines() + "]";
    }

    public void addLine(Ticket_line line) {
        lines.add(line);
    }

}

