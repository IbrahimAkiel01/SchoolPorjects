package model;

import java.util.Arrays;

/**
 * Pizza klassen är en subklass till Product klass.
 * @author Ömer & Ibrahim
 */
public class Pizza extends Product{
    /**
     * Här skapar vi konstruktor med objekts som
     * namn av pizzan, pris av pizzan och toppings vilken är enum.
     * @param name
     * @param price
     * @param toppings
     * @author Ömer & Ibrahim
     */
    public Pizza(String name, int price, model.ToppingsPizza[] toppings) {
        super(name, price);
        this.toppings = toppings;
    }
    private final model.ToppingsPizza[] toppings;

    /**
     * Här skapar vi en metod (string) av pizza och returnerar string av pizzas namn,pris och enum toppings
     * @return
     * @author Ömer & Ibrahim
     */
    public String toString(){
        return String.format((super.toString()+ " Toppings" + Arrays.toString(toppings)));
    }

}

