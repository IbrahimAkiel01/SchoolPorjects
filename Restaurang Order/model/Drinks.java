package model;

/**
 * Drinks klassen är en subklass till Product klass.
 * @author Ömer & Ibrahim
 */
public class Drinks extends model.Product {
    /**
     * Här skapar vi konstruktor med objekts som
     * drykens namn och pris
     * @param name
     * @param price
     */
    public Drinks(String name, double price) {
        super(name, price);
    }

    /**
     * Här skapar vi en metod (string) av drinks och returnerar string av dryckens namn och pris
     * @return
     * @author Ömer & Ibrahim
     */
    public String toString() {
        String s = super.toString();
        return s;
    }
}