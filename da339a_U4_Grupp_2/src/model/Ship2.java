package model;

public class Ship2 extends Ship {

    /**
     * <p>  Konstruktor som vi använder för att skapa en Torpedbåtar.
     * </p>
     * @param shipName: namn på båten
     * @param shipLength: längden på båten
     * @param gameMapp: eftersom vi har 3 stykent mappar för spelet.
     */
    public Ship2(String shipName, int shipLength, GameMapp gameMapp) {
        super("Torpedbåt", 2, gameMapp);
    }
}




