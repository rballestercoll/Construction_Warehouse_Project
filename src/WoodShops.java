import java.util.ArrayList;

/**
 *  WoodShop class
 */


public class WoodShops {

    /**
     * constructor
     * @param ID
     * @param Name
     * @ stores = new ArrayList();
     * @ Suppliers =  new ArrayList();
     * @ products = new ArrayList();
     */

    private String ID;
    private String name;


    private ArrayList<Store> stores;
    private ArrayList<Supplier> suppliers;
    private ArrayList<Product> products;
    private ArrayList <Customer> customers;



    public WoodShops(String ID, String name) {

        this.ID = ID;
        this.name = this.name;

        stores = new ArrayList();
        suppliers =  new ArrayList();
        products = new ArrayList();
        customers = new ArrayList();
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

    public ArrayList<Store> getStores() {
        return stores;
    }

    public void setStores(ArrayList<Store> stores) {
        this.stores = stores;
    }

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }


    /**
     * @return customer
     */
    public ArrayList<Customer> getCustomer() {
        return customers;
    }

    /**
     * @param customer set customer
     */
    public void setCustomer(ArrayList<Customer> customer) {
        this.customers = customer;
    }

    /**
     * @return toString
     */

    @Override
    public String toString() {
        return "WoodShops{" + "ID=" + ID + ", name=" + name + ", stores=" + stores + ", suppliers=" + suppliers + ", products=" + products + '}';
    }
    /**
     *
     * @param supplier method for add
     */

    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }
    /**
     *
     * @param product method for add
     */
    public void addProduct(Product product) {
        products.add(product);
    }
    /**
     *
     * @param store method for add
     */

    public void addStore (Store store) {
        stores.add(store);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}
