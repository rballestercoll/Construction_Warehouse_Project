/**
 * abstract class Product
 */
public abstract class Product {
    private String code;
    private String description;
    private float pvp;
    private int stock;

    private Supplier supplier;
    /**
     *
     * @param code
     * @param description
     * @param supplier
     * @param pvp
     * @param stock
     */
    public Product(String code, String description, Supplier supplier, float pvp, int stock) {
        this.code = code;
        this.description = description;
        this.supplier = supplier;
        this.pvp = pvp;
        this.stock = stock;
    }

    /**
     *
     * @return getters/setters
     */
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public float getPvp() {
        return pvp;
    }

    public void setPvp(float pvp) {
        this.pvp = pvp;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    /**
     *
     * @param product
     * @return product copy
     */
    public abstract Product copy(Product product);
    /**
     * @return toString
     */
    @Override
    public String toString() {
        return "Product{" + "code=" + code + ", description=" + description + ", supplier=" + supplier + ", pvp=" + pvp + ", stock=" + stock + '}';
    }

}


