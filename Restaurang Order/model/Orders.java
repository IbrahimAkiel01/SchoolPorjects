package model;

import java.util.ArrayList;

/**
 * Med hjälp av denna klass håller den koll på beställningar
 * med hjälp av objekt från Product. Skapar en ArrayList
 * med valda produkter
 */
public class Orders {
    ArrayList<Product> products = new ArrayList<>();
    private double price;
    private boolean ok = false;
    private int nbr;

    /**
     * Här skapar vi en konstrutor med parameter nbr
     * 
     * @param nbr
     */
    public Orders(int nbr) {
        price = 0;
        this.nbr = nbr;
    }

    public ArrayList<Product> getOrders() {
        return products;
    }

    /**
     * Här vi kollar om pizzan är bestäld eller inte
     * Genom denna metod man inte kan beställa bara dryckor
     * 
     * @return
     */
    public boolean isOk() {
        boolean ok1 = ok;
        return ok1;
    }

    /**
     * Här skapar vi en konstrutor med parameter nbr
     * 
     * @param nbr
     */
    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    /**
     * Här skapar vi en konstrutor med parameter product
     * 
     * @param product
     *                Denna metod ser till att en instans av pizza
     *                först finns med i order och sedan lägger till produkt
     *                och pris på produkten i en order
     */
    public void addProduct(Product product) {
        if (product instanceof Pizza) {
            ok = true;
        }
        this.products.add(product);
        price = price + product.getPrice();

    }

    /**
     * Vi skapar en metod för att får beställning
     * info som kan skrivas till Gui
     * 
     * @return
     */
    public String[] getInfoAboutOrder() {
        String[] strings = new String[products.size()];
        for (int i = 0; i < products.size(); i++) {
            strings[i] = products.get(i).toString();
        }
        return strings;
    }

    /**
     * Här skapar vi en metod för att få pris
     * 
     * @return
     */

    public double getPrice() {
        return price;
    }

    /**
     * Här skapar vi en metod för att se info av beställningen
     * som number of item och price
     * 
     * @return
     */
    public String toString() {
        String text = String.format("%s %s", nbr + ", ", price + "kr");
        System.out.println("text: " + text);
        return text;
    }

    public void add(Orders orders) {
    }

}
