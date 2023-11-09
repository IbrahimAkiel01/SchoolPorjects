package model;

import java.io.Serializable;
import javax.swing.*;

/**
 * Här player klassen implementerar av seralizable och comparable</Player> eftersom vi måste
 * jämföra score och player.
 * vi har 2 variabler playersName och playerScore
 * @author Ibrahim & Ömer
 */
public class Player implements Serializable, Comparable<Player> {
    private String playersName;
    private int playersScore = 0;

    public Player() {// sonradan ekledim silinebilir...

    }

    /**
     * Här vi skapar en konstruktor genom att använda 2 parameter
     * och initierar player klassen.
     * 
     * @param nickName:  namn .
     * @param highscore: antal clicks.
     *
     */
    public Player(String nickName, int highscore) {
        this.playersName = nickName;
        this.playersScore = highscore;
    }

    /**
     * Här vi använder set
     * @param playersName
     */
    public void setPlayersName(String playersName) {
        this.playersName = playersName;
    }

    /**
     * toString metod för att få nickname och Score is.
     * @return
     */
    @Override
    public String toString() {

        return "Nickname is: " + playersName + " Score is: " + playersScore;
    }

    /**
     * Här vi använder operationen compareTo för jämföra playersscore
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Player o) {

        if (playersScore < o.playersScore) {
            return -1;
        } else if (playersScore > o.playersScore) {
            return 1;
        } else {
            return 0;
        }

    }

    /**
     * set metod för att använda setScore
     * @param totalShots
     */

    public void setScore(int totalShots) {
        this.playersScore = totalShots;
    }

    /**
     * get metod
     * @return
     */

    public int getPlayersScore() {
        return playersScore;
    }
}
