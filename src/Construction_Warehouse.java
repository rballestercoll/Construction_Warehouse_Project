

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Class Construction_Warehouse
 */

public class Construction_Warehouse {

    Scanner keyboard = new Scanner(System.in);
    WoodShops ws = new WoodShops("F38893642", "WoodShops");

    public static void main(String[] args) {
        Construction_Warehouse prg = new  Construction_Warehouse ();
        prg.home();
    }
    /**
     *
     * @return home()
     */
    Void home() {
        boolean exit = false;
        char option;
        do {
            System.out.println("A. Enter product");
            System.out.println("B. Show product");
            System.out.println("C. Add product in store");
            System.out.println("D. Show product in store");
            System.out.println("E. Show products in store by type");
            System.out.println("F. Show stock of products in all stores ");
            System.out.println("G. Load Data");
            System.out.println("H. Add Customer");
            System.out.println("I. Show Customer");
            System.out.println("J. Add Ticket");
            System.out.println("K. Show store tickets");
            System.out.println("L. Sales summary by store");
            System.out.println("0. EXIT");

            option = request_menu_option();
            switch (option) {
                case 'A':
                    addProduct();
                    break;
                case 'B':
                    showProducts();
                    break;
                case 'C':
                    addProductInStore();
                    break;
                case 'D':
                    listProductsStore();
                    break;
                case 'E':
                    listProductsStoreByType();
                    break;
                case 'F':
                    showProductStock();
                    break;
                case 'G':
                    loadData();
                    break;
                case 'H':
                    addCustomer();
                    break;
                case 'I':
                    showCustomers();
                    break;
                case 'J':
                    ticket();
                    break;
                case 'K':
                    listTickets();
                    break;
                case 'L':
                    salesOverview();
                    break;
                case '0':
                    exit = true;
            }
        }while (!exit);

        return null;

    }
    /**
     *
     * @return request_menu_option()
     */
    char request_menu_option(){
        String reply;
        keyboard = new Scanner(System.in);
        System.out.println("Choose an option (A,B,C,D,E,F,G,H,I,J,K,L o 0)");
        reply = keyboard.nextLine();
        if (reply.isEmpty()){
            reply = " ";
        }
        return reply.charAt(0);
    }
    /**
     * addProduct()
     */
    void addProduct() {
        System.out.println("Code: ");
        String code = keyboard.nextLine();

        if (productExists(code)){
            System.out.println("The Product already exists ");
            return;
        }
        System.out.println("Description:");
        String description = keyboard.nextLine();
        System.out.println("Supplier:");

        Supplier supplier = getsupplier();
        System.out.println("PVP:");
        float pvp = keyboard.nextFloat();
        System.out.println("stock:");
        int stock = keyboard.nextInt();
        String type;
        keyboard.nextLine();
        System.out.println(" (1) Board (2) Item (3) Varnish");
        do {
            type = keyboard.nextLine();
        }while (!"123".contains(type));

        switch (type) {
            case "1":
                Board board = new Board(code, description, supplier, pvp, stock);
                createBoard(board);
                break;
            case "2":
                Items items = new Items(code, description, supplier, pvp, stock);
                createItem(items);
                break;
            case "3":
                Varnish varnish = new Varnish(code, description, supplier, pvp, stock);
                createVarnish(varnish);

        }
        keyboard.nextLine();
    }
    /**
     *
     * @param varnish
     */
    void createVarnish(Varnish varnish) {
        String color;
        System.out.println("ml: ");
        int ml = keyboard.nextInt();
        keyboard = new Scanner(System.in);
        System.out.println("Color (1) COLORLESS (2) CAOBA (3) WALNUT (4) SATIN");
        do {
            color = keyboard.nextLine();
        }while(!"123".contains(color));
        varnish.setColor(Varnish.Color.values()[Integer.parseInt(color) - 1]);
        varnish.setMl(ml);
        ws.addProduct(varnish);
        keyboard.nextLine();
    }
    /**
     *
     * @param items
     */
    void createItem(Items items){
        String typeT;
        int i= 0;
        do {
            i = 0;
            for (Items.TypeItem type : Items.TypeItem.values()){
                System.out.println(i + "." + type);

            }
            typeT = keyboard.nextLine();
        }while (!"1234".contains(typeT));
        items.setTypeItem(Items.TypeItem.values()[Integer.parseInt(typeT) -1]);
        ws.addProduct(items);
        keyboard.nextLine();
    }
    /**
     *
     * @param code
     * @return check if product exists
     */
    boolean productExists(String code) {
        for (Product product : ws.getProducts()){
            if(product.getCode().equals(code)){
                return true;
            }
        }
        return false;
    }
    /**
     *
     * @param store
     * @param code
     * @return check if the product is available in the store
     */
    boolean productStoreExists(Store store, String code) {
        for (Product product : store.getProducts()){
            if (product.getCode().equals(code)){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param board
     */
    void createBoard(Board board) {
        String typeT;
        System.out.println("Width: ");
        int width = keyboard.nextInt();
        System.out.println("High: ");
        int high = keyboard.nextInt();
        keyboard.nextLine();
        do{
            System.out.println("1 MDF 2 PLYWOOD 3 AGGLOMERATE");
            typeT = keyboard.nextLine();
        }while (!"123".contains(typeT));

        board.setHigh(high);
        board.setWidth(width);
        board.setBoardType(Board.BoardType.values()[Integer.parseInt(typeT) -1]);
        ws.addProduct(board);
        keyboard.nextLine();
    }
    /**
     * showProducts()
     *  */
    void showProducts() {
        for (Product product : ws.getProducts()){
            System.out.println(product.toString());
        }
        keyboard.nextLine();
    }
    /**
     *
     * @return getSupplier()
     */
    Supplier getsupplier(){
        int i = 0;
        do{
            for (Supplier supplier : ws.getSuppliers()){
                i++;
                System.out.println(i + " " +  supplier.toString());
            }
            System.out.println("Choose supplier: ");
            i = keyboard.nextInt();
        }while (i <= 0 || i > ws.getSuppliers().size());
        return ws.getSuppliers().get(i - 1);

    }

    /**
     * addProductInStore()
     */
    void addProductInStore() {
        System.out.println("Product Lists");
        showProducts();
        String code;
        System.out.println("Choose the product code");
        code = keyboard.nextLine();
        Product product = searchProduct(code);
        if (product == null) {
            System.out.println("The product does not exist");
            return;
        }
        int storeIndex = showStores();
        System.out.println("Stock");
        int stock = keyboard.nextInt();
        if (productStoreExists(ws.getStores().get(storeIndex), product.getCode())){
            System.out.println("This product already exists in this store");
        }else {
            Product newProductStore = product.copy(product);
            newProductStore.setStock(stock);
            ws.getStores().get(storeIndex).addProduct(newProductStore);
        }
        keyboard.nextLine();
    }
    /**
     *
     * @return showStores()
     */
    int showStores() {
        int i = 0;
        System.out.println("Store list");

        do {
            i=0;
            for(Store store : ws.getStores()) {
                i++;
                System.out.println(i + " " + store.toString());
            }

            System.out.println("Choose Store: ");
            i = keyboard.nextInt();
        }while (i < 0 || i > ws.getStores().size());
        return i - 1;
    }
    /**
     *  listProductsStore()
     * */
    void listProductsStore() {
        int storeIndex = showStores();
        for (Product product : ws.getStores().get(storeIndex).getProducts()) {
            System.out.println(product.toString());
        }
        keyboard.nextLine();
    }
    /**
     *  listProductsStoreByType()
     * */
    void listProductsStoreByType(){
        String type;
        System.out.println("(1) BOARD (2) ITEM (3) VARNISH");
        do {
            type = keyboard.nextLine();

        }while (!"123".contains(type));

        int storeIndex = showStores();
        for (Product product : ws.getStores().get(storeIndex).getProducts()){
            switch (type) {
                case "1":
                    if (product instanceof Board){
                        System.out.println(product.toString());
                    }
                    break;
                case "2":
                    if (product instanceof Items){
                        System.out.println(product.toString());
                    }
                    break;
                case "3":
                    if (product instanceof Varnish){
                        System.out.println(product.toString());
                    }
                    break;
            }

        }
        keyboard.nextLine();
    }
    /**
     *
     * @param code
     * @return search for matching product
     */
    Product searchProduct(String code) {
        for (Product product : ws.getProducts()){
            if(product.getCode().equals(code)){
                return product;
            }
        }
        return null;

    }

    private void showProductStock() {
        System.out.println("Product list");
        showProducts();
        String code;
        System.out.println("Choose product code");
        code = keyboard.nextLine();
        for (Store store : ws.getStores()){
            System.out.println("Stores: " + store.getPopulation());
            for (Product product : store.getProducts()){
                if (product.getCode().equals(code)){
                    System.out.println(product.toString());
                }
            }

        }
        keyboard.nextLine();
    }

    void loadData(){
        Store store;
        store = new Store("Calle Emili Darder 68", "Palma de Mallorca");
        ws.addStore(store);
        store = new Store("Calle Soleana 148", "Sevilla");
        ws.addStore(store);
        store = new Store("Calle Obradores del Alto 92", "Coruña");
        ws.addStore(store);
        Supplier proveedor;
        proveedor = new Supplier("S1", "Supplier 1");
        ws.addSupplier(proveedor);
        proveedor = new Supplier("S2", "Supplier 2");
        ws.addSupplier(proveedor);
        proveedor = new Supplier("S3", "Supplier 2");
        ws.addSupplier(proveedor);


        //Clientes
        Customer cli;
        cli = new Professional_customer("B57325549", "Miguel", 77.30f);
        ws.addCustomer(cli);
        cli = new Professional_customer("Q99476334", "Alvaro",100.30f);
        ws.addCustomer(cli);

        cli = new WoodFriend("V66455366","Laura", 210);
        ws.addCustomer(cli);
        cli = new WoodFriend("P09563444","Antonia",3100);
        ws.addCustomer(cli);


        //Productos
        ws.addProduct(new Items("1", "Black Board", null, 10, 0));
        ws.addProduct(new Items("2", "Green Board", null, 20, 0));
        ws.addProduct(new Items("3", "Red Board", null, 18, 0));
        ws.addProduct(new Items("4", "Yellow Board", null, 19, 0));


        //Tienda add producto
        store = ws.getStores().get(0);
        store.addProduct(new Items("1", "Pliers", null, 10, 0));
        store.addProduct(new Items("2", "Hammer", null, 20, 0));
        store.addProduct(new Items("3", "Tweezers", null, 18, 0));
        store.addProduct(new Items("4", "Screwdriver", null, 19, 0));

        Sales_ticket ticket;
        ticket = new Sales_ticket(1, LocalDate.parse("03/05/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), getCustomer("9999"));
        Ticket_line tLine;
        tLine = new Ticket_line(getStoreProduct(store, "1"), 10);
        ticket.addLine(tLine);
        tLine = new Ticket_line(getStoreProduct(store, "2"), 11);
        ticket.addLine(tLine);
        tLine = new Ticket_line(getStoreProduct(store, "3"), 12);
        ticket.addLine(tLine);
        store.addTicket(ticket);
        showTicket(ticket);

        ticket = new Sales_ticket(2, LocalDate.parse("03/05/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), getCustomer("97779"));
        tLine = new Ticket_line(getStoreProduct(store, "1"), 10);
        ticket.addLine(tLine);
        tLine = new Ticket_line(getStoreProduct(store, "2"), 11);
        ticket.addLine(tLine);
        tLine = new Ticket_line(getStoreProduct(store, "3"), 12);
        ticket.addLine(tLine);
        store.addTicket(ticket);
        showTicket(ticket);

        //AA5
        store = ws.getStores().get(1);
        store.addProduct(new Items("1", "Saw", null, 11, 0));
        store.addProduct(new Items("2", "Magnifying glass", null, 21, 0));
        store.addProduct(new Items("3", "Rope", null, 15, 0));
        store.addProduct(new Items("4", "Drill", null, 13, 0));


        ticket = new Sales_ticket(1, LocalDate.parse("02/01/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), getCustomer("9999"));
        tLine = new Ticket_line(getStoreProduct(store, "1"), 10);
        ticket.addLine(tLine);
        tLine = new Ticket_line(getStoreProduct(store, "2"), 11);
        ticket.addLine(tLine);
        tLine = new Ticket_line(getStoreProduct(store, "3"), 13);
        ticket.addLine(tLine);
        store.addTicket(ticket);

        ticket = new Sales_ticket(1, LocalDate.parse("11/04/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), getCustomer("97779"));
        tLine = new Ticket_line(getStoreProduct(store, "1"), 10);
        ticket.addLine(tLine);
        tLine = new Ticket_line(getStoreProduct(store, "2"), 11);
        ticket.addLine(tLine);
        tLine = new Ticket_line(getStoreProduct(store, "3"), 13);
        ticket.addLine(tLine);
        store.addTicket(ticket);
        //listado

        ticket = new Sales_ticket(1, LocalDate.parse("15/03/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")),null);
        tLine = new Ticket_line(getStoreProduct(store, "1"), 10);
        ticket.addLine(tLine);
        tLine = new Ticket_line(getStoreProduct(store, "2"), 11);
        ticket.addLine(tLine);
        tLine = new Ticket_line(getStoreProduct(store, "3"), 13);
        ticket.addLine(tLine);
        store.addTicket(ticket);
    }

    /*
     * @function addCustumer
     * */


    //AA4
    void addCustomer() {
        String ID, name, type;
        System.out.println("ID: ");
        ID = keyboard.nextLine();
        if(customerExists(ID)) {
            System.out.println("The customer already exists");
            return;
        }
        System.out.println("name: ");
        name = keyboard.nextLine();
        System.out.println("(1) Premium (2) woodFriend");
        do {
            type = keyboard.nextLine();
        }while(!"12".contains(type));
        switch(type) {
            case "1":
                System.out.println("Discounts: ");
                Float Discounts = keyboard.nextFloat();
                Professional_customer cusP = new Professional_customer(ID,name,Discounts);
                ws.addCustomer(cusP);
                break;
            case "2":
                System.out.println("Customer number: ");
                int nPartner = keyboard.nextInt();
                WoodFriend cusWF = new WoodFriend (ID, name,nPartner);
                ws.addCustomer(cusWF);
                break;

        }

    }

    boolean customerExists(String nif) {
        for(Customer customer : ws.getCustomer()) {
            if(customer.getID().equals(nif)) {
                return true;
            }
        }
        return false;
    }

    void showCustomers() {
        System.out.println("listado de clientes: ");
        for (Customer customer : ws.getCustomer()) {
            System.out.println(customer.toString());
        }

    }


    void ticket( ) {
        Customer cus = null;
        Product product = null;
        Ticket_line tLine = null;
        String code = "";
        int quantity = 0;
        int storeIndex = showStores();

        Store store = ws.getStores().get(storeIndex);

        System.out.println("Ticket Number: ");
        int nTicket = keyboard.nextInt();
        keyboard = new Scanner(System.in);
        System.out.println("ID: ");
        String ID = keyboard.nextLine();
        if(!ID.isEmpty()) {
            if (!customerExists(ID)) {
                System.out.println("The customer does not exists");
                return;
            }else {
                cus = getCustomer(ID);
                System.out.println("name: "+ cus.getName());
            }
        }
        Sales_ticket ticket = new Sales_ticket(nTicket, LocalDate.now(), cus);
        do {
            keyboard = new Scanner(System.in);
            System.out.println("code: (* salir) ");
            code = keyboard.nextLine();
            if (productStoreExists(store, code)) {
                product = getStoreProduct(store, code);
                System.out.println(product.getDescription());
                System.out.println("quantity: ");
                quantity = keyboard.nextInt();
                tLine = new Ticket_line(product,quantity);
                ticket.addLine(tLine);
            }
        } while (!code.equals("*"));
        store.addTicket(ticket);
        showTicket(ticket);
    }

    Customer getCustomer(String ID) {
        for(Customer cus: ws.getCustomer()) {
            if(cus.getID().equals(ID)){
                return cus;
            }
        }
        return null;
    }

    Product getStoreProduct(Store store, String code) {
        for (Product product : store.getProducts()) {
            if(product.getCode().equals(code)) {
                return product;
            }
        }
        return null;
    }

    void showTicket(Sales_ticket ticket) {
        Customer cus = null;
        Product prod = null;
        float totalLine = 0;
        float sum = 0;
        float discountAmount, total;
        System.out.println(ticket.toString());
        for( Ticket_line tLine: ticket.getLines()) {
            prod = tLine.getProduct();
            totalLine = prod.getPvp() * tLine.getQuantity();
            sum += totalLine;
            System.out.println(prod.getDescription() + "\t" + tLine.getQuantity() + "\t" + tLine.getQuantity() + "\t" + prod.getPvp() + "\t" + totalLine);
        }
        System.out.println("Sum total:" + sum);
        cus = ticket.getCustomer();
        if(cus instanceof Professional_customer) {
            discountAmount = sum * ((Professional_customer) cus).getDiscount() /100;
            total = sum - discountAmount;
            System.out.println("% Discount: " + ((Professional_customer) cus).getDiscount());
            System.out.println("Total: " + total);
        }

    }


    void listTickets() {
        Customer cus = null;
        Product prod = null;
        float totalLine = 0;
        float sum = 0;
        float amountOfDiscount = 0, discount = 0, total=0;

        System.out.println("Start Date");
        String start = keyboard.nextLine();
        System.out.println("End Date");
        String end = keyboard.nextLine();

        LocalDate startDate = LocalDate.parse(start, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate endDate = LocalDate.parse(end, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int storeIndex = showStores();

        Store store = ws.getStores().get(storeIndex);

        for (Sales_ticket ticket: store.getTickets()) {
            if (ticket.getDate().isAfter(startDate.minusDays(1)) && ticket.getDate().isBefore(endDate.plusDays(1))) {
                System.out.println(ticket.toString());
                sum = 0;

                for (Ticket_line tLine : ticket.getLines()) {
                    prod = tLine.getProduct();
                    totalLine = prod.getPvp() * tLine.getQuantity();
                    sum += totalLine;
                }

                cus = ticket.getCustomer();

                if (cus instanceof Professional_customer) {
                    discount = ((Professional_customer) cus).getDiscount();
                    amountOfDiscount = sum * ((Professional_customer) cus).getDiscount() / 100;
                }

                total = sum - amountOfDiscount;
                System.out.print("sum: " + sum);
                System.out.print("\t% discount: " + discount);
                System.out.print("\tDiscount: " + amountOfDiscount);
                System.out.println("\tTotal " + total);

            }
        }


    }
    void salesOverview() {
        Customer cus = null;
        Product prod = null;
        float totalStore =0;
        float totalLine = 0;
        float sum = 0;
        float amountOfDiscount = 0, discount = 0, total=0;

        System.out.println("Start Date");
        String start = keyboard.nextLine();
        System.out.println("End Date");
        String end = keyboard.nextLine();

        LocalDate startDate = LocalDate.parse(start, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate endDate = LocalDate.parse(end, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        for (Store store : ws.getStores()) {
            totalStore= 0;
            for (Sales_ticket ticket: store.getTickets()) {
                if (ticket.getDate().isAfter(startDate.minusDays(1)) && ticket.getDate().isBefore(endDate.plusDays(1))) {
                    sum = 0;
                    discount =0;
                    total = 0;
                    amountOfDiscount =0;
                    for(Ticket_line tLine: ticket.getLines()) {
                        prod = tLine.getProduct();
                        totalLine = prod.getPvp() * tLine.getQuantity();
                        sum += totalLine;
                    }
                    cus = ticket.getCustomer();
                    if (cus instanceof Professional_customer) {
                        discount = ((Professional_customer) cus).getDiscount();
                        amountOfDiscount = sum * discount / 100;
                    }
                    total = sum - amountOfDiscount;
                    totalStore += total;
                }
            }
            System.out.println("Store" + "\t" + store.getAddress() + "\t" + store.getPopulation() + "\tTotal: " + totalStore);
        }
    }
}


