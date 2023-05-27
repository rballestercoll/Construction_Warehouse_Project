/**
 * Class Items extends Product
 */

public class Items extends Product {
    /**
     * @enum TABLE, CHAIR, CUPBOARD, SHELF
     */
    public enum TypeItem {
        TABLE, CHAIR, SHELF, CUPBOARD
    };

    private TypeItem typeItem;
    /**
     * Constructor
     * @param code
     * @param description
     * @param supplier
     * @param pvp
     * @param stock
     */
    public Items(String code, String description, Supplier supplier, float pvp, int stock){
        super(code, description, supplier, pvp, stock);
    }
    /**
     * Constructor
     * @param typeItem
     * @param code
     * @param description
     * @param supplier
     * @param pvp
     * @param stock
     */
    public Items(TypeItem typeItem, String code, String description, Supplier supplier, float pvp, int stock) {
        super(code, description, supplier, pvp, stock);
        this.typeItem = typeItem;
    }

    /**
     *
     * @return getters/setters
     */
    public TypeItem getTypeItem() {
        return typeItem;
    }

    public void setTypeItem(TypeItem typeItem) {
        this.typeItem = typeItem;
    }
    /**
     * @return toString
     */
    @Override
    public String toString() {
        return "Items{" + "typeItem=" + typeItem + '}';
    }

    @Override
    public Product copy(Product p) {
        Items a = (Items) p;
        Items copy = new Items( a.getTypeItem(),a.getCode(), a.getDescription(), a.getSupplier(), a.getPvp(), a.getStock());
        return copy;

    }


}

