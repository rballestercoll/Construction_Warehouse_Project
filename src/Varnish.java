/**
 * Class Varnish extends Product
 */

public class Varnish extends Product {

    public enum Color {
        COLORLESS, CAOBA, WALNUT, SATIN
    };

    private Color color;
    private int ml;
    /**
     * Constructor
     * @param code
     * @param description
     * @param supplier
     * @param pvp
     * @param stock
     */
    public Varnish(String code, String description, Supplier supplier, float pvp, int stock){
        super(code, description, supplier, pvp, stock);
    }
    /**
     * Constructor
     * @param color
     * @param ml
     * @param code
     * @param description
     * @param supplier
     * @param pvp
     * @param stock
     */
    public Varnish(Color color, int ml, String code, String description, Supplier supplier, float pvp, int stock) {
        super(code, description, supplier, pvp, stock);
        this.color = color;
        this.ml = ml;
    }
    /**
     *
     * @return getters/setters
     */
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getMl() {
        return ml;
    }

    public void setMl(int ml) {
        this.ml = ml;
    }
    /**
     * @return toString
     */
    @Override
    public String toString() {
        return "Varnish{" + "color=" + color + ", ml=" + ml + '}';
    }

    public Product copy(Product p) {
        Varnish b = (Varnish) p;
        Varnish copy = new Varnish(b.getColor(), b.getMl(), b.getCode(), b.getDescription(), b.getSupplier(), b.getPvp(), b.getStock());
        return copy;

    }


}

