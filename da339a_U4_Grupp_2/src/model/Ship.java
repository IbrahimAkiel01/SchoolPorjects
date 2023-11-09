package model;

/**
 * här vi skapar klas för att ge namn längden till båter som vi använder
 * @author Ömer & ibrahim
 */
public abstract class Ship{

    private String shipName;
    private int length;
    private GameMapp gameMapp;

    private int hitsOfShips;

    /**
     * Här vi skapar konstruktor och parametrar av båter
     *
     * @param shipName: namn
     * @param lengthShip: längden
     * @param gameMapp: eftersom vi har 3 styken mappar för spelet.
     */

    public Ship(String shipName, int lengthShip, GameMapp gameMapp) {
        this.shipName = shipName;
        this.length = lengthShip;
        this.gameMapp = gameMapp;
    }

    /**
     * här vi använder hit++ när man träffar en båt
     */
    public void hit(){
        this.hitsOfShips++;
    }

    /**
     * isShipdead är när man förstör båten
     * @return
     */
    public boolean isShipDead(){
        return hitsOfShips == length;

    }

    /**
     * när en båt förstör då minskar antal båter på kartan
     */
    public void dead()
    {
        gameMapp.ReducingNumberOfShips();
    }

    /**
     * get metod
     * @return
     */
    public String getShipName() {
        return shipName;
    }

    /**
     * tostring metod
     * @return
     */
    public String toString() {
        return  shipName +", "+length+ " rectangles ";
    }
}


