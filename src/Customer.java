/**
 * @category Customer class
 */
public abstract class Customer {
    private String ID;
    private String name;

    /**
     *
     * @param ID
     * @param name
     */
    public Customer(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }
    /**
     *
     * @return getters/setters
     */
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return toString
     *  */
    @Override
    public String toString() {
        return "Customer [ID=" + ID + ", name=" + name + ", getID()=" + getID() + ", getName()=" + getName()
                + "]";
    }

}
