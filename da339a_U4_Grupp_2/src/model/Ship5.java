package model;

public class Ship5 extends Ship {

    /**
     * <p>  Konstruktor som vi använder för att skapa en Slagskepp.
     * </p>
     * @param shipName: namn på båten
     * @param shipLenght: längden på båten
     * @param gameMapp: eftersom vi har 3 stykent mappar för spelet.
     */
    public Ship5(String shipName, int shipLenght, GameMapp gameMapp) {
        super("Slagskepp", 5, gameMapp);
    }
}
