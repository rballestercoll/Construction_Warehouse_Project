public class Ticket_line {

    private Product product;
    private int quantity;

    /**
     * @param product
     * @param quantity
     */
    public Ticket_line(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Ticket_line [product=" + product + ", quantity=" + quantity + ", getProduct()=" + getProduct()
                + ", getQuantity()=" + getQuantity() + "]";
    }




}
