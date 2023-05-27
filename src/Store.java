import java.util.ArrayList;

/**
 * classe Store
 */
public class Store {
    private String address;
    private String population;

    private ArrayList<Product> products;
    private ArrayList<Sales_ticket> tickets;

    /**
     *
     * @param address
     * @param population
     * products = new ArrayList();
     */
    public Store(String address, String population) {
        this.address = address;
        this.population = population;

        products = new ArrayList();
        tickets = new ArrayList();
    }
    /**
     *
     * @return getters/setter
     */
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    /**
     * @return tickets
     */
    public ArrayList<Sales_ticket> getTickets() {
        return tickets;
    }
    /**
     * @param tickets set tickets
     */
    public void setTickets(ArrayList<Sales_ticket> tickets) {
        this.tickets = tickets;
    }
    /**
     * @return toString
     */



    Iterable<Product> getProdts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return "store [address=" + address + ", population=" + population + ", products=" + products + ", tickets="
                + tickets + "]";
    }
    public void addProduct(Product product){
        products.add(product);
    }

    public void addTicket(Sales_ticket ticket) {
        tickets.add(ticket);
    }
}

