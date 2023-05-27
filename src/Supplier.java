/**
 * Class supplier
 */

public class Supplier {
    private String ID;
    private String name;
    /**
     * @Constructor
     * @param ID
     * @param name
     */
    public Supplier(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }
    /**
     *
     * @return getters/setter
     */
    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return toString
     */
    @Override
    public String toString() {
        return "Supplier{" + "ID=" + ID + ", name=" + name + '}';
    }


}

