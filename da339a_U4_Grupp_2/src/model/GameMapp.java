package model;

/**
 * här vi skapar spel planen, namn på båter och längden av båter.
 * 
 * @author Ömer & Ibrahim
 */
public class GameMapp {

    private Ship[][] arrayOfShips;
    private Ship1 ship1 = new Ship1("U-Båt", 1, this);

    private Ship2 ship2 = new Ship2("Torpedbåt", 2, this);
    private Ship3 ship3 = new Ship3("Kryssare", 3, this);
    private Ship4 ship4 = new Ship4("Jagare", 4, this);
    private Ship5 ship5 = new Ship5("Slagskepp", 5, this);

    private int NumberOfShips = 5;

    /**
     * <p>
     * Konstruktor som vi använder för att skapa en spelplan.
     * </p>
     * 
     * @param option: val av bräda
     */
    public GameMapp(int option) {
        if (option == 0) {
            mapp();
        } else if (option == 1) {
            mapp2();
        } else {
            mapp3();
        }
    }

    public boolean areAllTheShipsDead() {
        return NumberOfShips == 0;
    }

    /**
     * här vi tar kordinaterna från användaren
     * 
     * @param x
     * @param y
     * @return
     */
    public Ship getCoordinates(int x, int y) {

        return arrayOfShips[x][y];
    }

    /**
     * Här vi skapar vår spel kartan genom att använda 2 dim array
     */
    public void mapp() {
        arrayOfShips = new Ship[][] {
                { ship2, ship2, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, ship3, ship3, ship3, null },
                { null, null, null, null, null, null, null, null, null, null },
                { ship1, null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, ship5, null },
                { null, null, ship4, null, null, null, null, null, ship5, null },
                { null, null, ship4, null, null, null, null, null, ship5, null },
                { null, null, ship4, null, null, null, null, null, ship5, null },
                { null, null, ship4, null, null, null, null, null, ship5, null },
        };// new Ship[][]{
          // {ship2, ship2, null, null, null, null, null, ship3, null, null},
          // {null, null, null, null, null, null, null, ship3, null, null},
          // {null, null, null, null, ship1, null, null, ship3, null, null},
          // {null, null, null, null, null, null, null, null, null, null},
          // {null, null, null, null, ship5, null, null, null, null, null},
          // {null, null, null, null, ship5, null, null, null, null, null},
          // {null, null, null, null, ship5, null, null, null, null, null},
          // {null, null, null, null, ship5, null, null, null, null, null},
          // {null, null, null, null, ship5, null, null, null, null, null},
          // {ship4, ship4, ship4, ship4, null, null, null, null, null, null},
          // };
    }

    public void mapp2() {
        arrayOfShips = new Ship[][] {
                { ship2, null, null, null, ship5, ship5, ship5, ship5, ship5, null },
                { ship2, null, null, null, null, null, null, null, null, null },
                { null, null, ship3, null, null, null, ship1, null, null, null },
                { null, null, ship3, null, null, null, null, null, null, null },
                { null, null, ship3, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null, null },
                { ship4, ship4, ship4, ship4, null, null, null, null, ship1, null },
                { null, null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null, null },
                { null, null, null, null, ship1, null, null, null, null, null },
        };
    }

    public void mapp3() {
        arrayOfShips = new Ship[][] {
                { ship1, null, ship5, null, null, null, null, null, null, null },
                { null, null, ship5, null, null, null, null, null, null, ship4 },
                { null, null, ship5, null, null, null, null, null, null, ship4 },
                { null, null, ship5, null, null, null, null, null, null, ship4 },
                { null, null, ship5, null, null, null, null, null, null, ship4 },
                { null, null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, ship1, null },
                { ship3, ship3, ship3, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null, null },
                { null, null, null, ship1, null, null, null, null, ship2, ship2 },
        };
    }

    /**
     * här vi minskar båter om en av dem dör :)
     */
    public void ReducingNumberOfShips() {
        NumberOfShips--;
    }
}
