/**
 * Class Board extends Product
 */
public class Board extends Product {
    /**
     * @enum  MDF, PLYWOOD, CHIPBOARD
     */
    public enum BoardType {
        MDF, PLYWOOD, CHIPBOARD
    };

    private int width;
    private int high;

    private BoardType boardType;

    /**
     * Constructor
     * @param code
     * @param description
     * @param supplier
     * @param pvp
     * @param stock
     */
    public Board(String code, String description, Supplier supplier, float pvp, int stock) {
        super(code, description, supplier, pvp, stock);

    }
    /**
     * Constructor
     * @param width
     * @param high
     * @param boardType
     * @param code
     * @param description
     * @param supplier
     * @param pvp
     * @param stock
     */
    public Board(int width, int high, BoardType boardType, String code, String description, Supplier supplier, float pvp, int stock) {
        super(code, description, supplier, pvp, stock);
        this.width = width;
        this.high = high;
        this.boardType = boardType;
    }
    /**
     *
     * @return getters/setters
     */
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public BoardType getBoardType() {
        return boardType;
    }

    public void setBoardType(BoardType boardType) {
        this.boardType = boardType;
    }
    /**
     * @return toString
     */
    @Override
    public String toString() {
        return "Board{" + "width=" + width + ", high=" + high + ", boardType=" + boardType + '}';
    }

    @Override
    public Product copy(Product p) {
        Board t = (Board) p;
        Board copy = new Board(t.getHigh(), t.getWidth(), t.getBoardType(), t.getCode(), t.getDescription(), t.getSupplier(), t.getPvp(), t.getStock());
        return copy;

    }
}

