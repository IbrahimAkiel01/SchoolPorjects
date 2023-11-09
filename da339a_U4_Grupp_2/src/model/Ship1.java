package model;

public class Ship1 extends Ship {

    /**
     * <p>  Konstruktor som vi använder för att skapa en U-båt.
     * </p>
     * @param shipName: namn
     * @param shipLenght: längden för båten
     * @param gameMapp: eftersom vi har 3 stykent mappar för spelet.
     */
    public Ship1(String shipName, int shipLenght, GameMapp gameMapp) {
        super("U-Båt", 1, gameMapp);
    }
}
