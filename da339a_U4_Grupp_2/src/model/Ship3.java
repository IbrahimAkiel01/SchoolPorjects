package model;

public class Ship3 extends Ship {
    /**
     * <p>  Konstruktor som vi använder för att skapa en Jagare.
     * </p>
     * @param shipName: namn på båten
     * @param shipLenght: längden på båten
     * @param gameMapp:eftersom vi har 3 stykent mappar för spelet.
     */
    public Ship3(String shipName, int shipLenght, GameMapp gameMapp) {
        super("Jagare", 3, gameMapp);
    }
}
