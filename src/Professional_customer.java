public class Professional_customer extends Customer {

    private float discount;

    /**
     * @param ID
     * @param name
     * @param discount
     */
    public Professional_customer(String ID, String name, float discount) {
        super(ID, name);
        this.discount = discount;
    }

    /**
     * @return the discount
     */
    public float getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(float discount) {
        this.discount = discount;
    }
    /**
     * @return tostring
     */
    @Override
    public String toString() {
        return "Professional_customer [discount=" + discount + ", getDiscount()=" + getDiscount() + ", toString()="
                + super.toString() + "]";
    }

}
