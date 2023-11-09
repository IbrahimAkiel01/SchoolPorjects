package model;

/**
 *
 */
public interface RestaurantItems {
    double price = 0;
    String name = null;

    /**
     * getPrice är en metod för att få priset
     * @return
     */
    double getPrice();

    /**
     * getName är en metod för att få namnet
     * @return
     */

    String getName();

    /**
     * en metod som gör retur till strängen
     * @return
     */
    String toString();
}
