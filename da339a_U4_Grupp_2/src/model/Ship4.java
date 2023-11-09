package model;

public class Ship4 extends Ship{

    /**
     * <p>  Konstruktor som vi använder för att skapa en Kryssare.
     * </p>
     * @param shipName: namn på båten
     * @param shipLength: längden på båten
     * @param gameMapp: eftersom vi har 3 stykent mappar för spelet.
     */
    public Ship4(String shipName, int shipLength, GameMapp gameMapp) {
        super("Kryssare", 4, gameMapp);
    }
}
