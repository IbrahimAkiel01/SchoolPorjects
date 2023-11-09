package model;
/**
 * AlcoholicBeverages klassen är en subklass till Drinks klass.
 * Här kollar vi om en drycka är alkoholhaltig eller ej
 * @author Ömer & Ibrahim
 */
public class AlcoholicBeverages extends Drinks{
    private final double percentageOfAlcohol;

    /**
     * Här skapar vi konstruktor med objekts som
     * dryckens pris, namn och alkoholprocent
     * @param name
     * @param price
     * @param percentageOfAlcohol
     */
    public AlcoholicBeverages(String name, double price, double percentageOfAlcohol) {
        super(name,price);
        this.percentageOfAlcohol = percentageOfAlcohol;
    }

    /**
     * Här skapar vi en metod för att definiera dryckan och returnerar
     * @return som double
     */
    public double getPercentOfAlcohol() {
        return percentageOfAlcohol;
    }

    /**
     * @return som sträng med dryckens pris, namn och alkoholprocent
     */
    public String toString(){
        String textOut = super.toString() + ", " + " is " +  percentageOfAlcohol + "%" ;
        return textOut;
    }
}
