package controller;

import model.*;
import view.ButtonType;
import view.ButtonEnum;
import view.MainFrame;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

/**
 * Controller är logiken på MVC. Genom controller väljer användaren
 * vilken karta man ska välja, information av spelet.
 * @author Ömer & Ibrahim
 */

public class Controller {
    private MainFrame mainFrame;
    private boolean shotsTracking[][];
    private TopScoreManager scoreHistory;
    private Player player;
    private int totalShotsTaken;
    private int numberOfMisses;
    private int numberOfShipsDestroyed;
    private int numberOfHits;
    private GameMapp gameMapp;

    /**
     * I den här konstruktorn kallar vi på metoden som initierar spelet.
     */
    public Controller() {
        // try {
        // scoreHistory = new TopScoreManager(this);
        // } catch (FileNotFoundException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // // scoreHistory.writePlayerToFile(new Player("David", 20));
        // // scoreHistory.getTopScoreList().add(new Player("Albert", 15));

        beginGame();

    }

    /**
     * Metoden ansvarar för att sätta upp alla nödvändiga inställningar och
     * variabler för att spelet ska kunna startas. Detta kan innefatta att skapa
     * spelplanen, ladda in grafik, samt att placera ut spelfigurer på rätt ställen.
     * När metoden har avslutats är spelet redo att spelas.
     * Här vi skapar alternative för mappar
     * Sen sätter vi in höjden och bredden för mappen
     */
    private void beginGame() {
        player = new Player(null, 0);
        try {
            scoreHistory = new TopScoreManager(this);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // try {
        // scoreHistory.writePlayerToFile(player);
        // } catch (Exception e) {
        // System.out.println("Added if printed size");
        // }

        JOptionPane.showMessageDialog(null,
                "Welcome to Battleship! Sink your opponent's ships and emerge victorious! Good luck and have fun!\" \n"
                        + "                Creators: Ömer and Ibrahim");
        String[] choicesOfMaps = new String[] { "Battlefield 1", "Battlefield 2", "Battlefield 3" };
        int attackOutcome = JOptionPane.showOptionDialog(null,
                "Select your battlefield! Choose from a variety of maps to plan your strategy and dominate the seas.",
                "Battlefield", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, choicesOfMaps,
                choicesOfMaps[0]);
        this.mainFrame = new MainFrame(750, 750, this);

        totalShotsTaken = 0;
        numberOfHits = 0;
        numberOfMisses = 0;
        shotsTracking = new boolean[10][10];
        if (attackOutcome == 0) {
            gameMapp = new GameMapp(attackOutcome);
        } else if (attackOutcome == 1) {
            gameMapp = new GameMapp(attackOutcome);
        }
        scoreHistory.readFromFile();
        mainFrame.populateRPanel(scoreHistory.AllScoreInfo());

        /**
         * vi har en operator som har parameter x, y och buttonType
         * vi sätter in hits, totalstrikes, misses och attack genom att få
         * info från kordinater från användaren.
         */

    }

    /**
     * Här vi får kordinater och buttontyper.
     * här vi bestämmer vad som händer när användaren clicker på en ruta
     * och vad rutan ger för action som miss, hit, attack,.
     * @param x
     * @param y
     * @param buttonType
     */
    public void selectedCoordinate(int x, int y, ButtonType buttonType) {

        if (shotsTracking[x][y]) {
            int option = 1;
            String shipName = "Ömer";
            mainFrame.updateMessage(option, shipName);
        } else {
            totalShotsTaken++;
            int updatedValue = totalShotsTaken;
            mainFrame.updateMainPanel("totalStrikes", updatedValue);
            shotsTracking[x][y] = true;
            Ship ship = gameMapp.getCoordinates(x, y);

            if (ship == null) {
                numberOfMisses++;
                buttonType.hitButtonType(ButtonEnum.hitnull);
                updatedValue = numberOfMisses;
                mainFrame.updateMainPanel("miss", updatedValue);
            } else {
                int options = 2;
                String shipName = ship.getShipName();
                mainFrame.updateMessage(options, shipName);
                ship.hit();
                numberOfHits++;
                updatedValue = numberOfHits;
                mainFrame.updateMainPanel("attack", updatedValue);
                // mainFrame.updateMainPanel("attack",updatedValue);
                buttonType.hitButtonType(ButtonEnum.attack);

                if (ship.isShipDead()) {
                    System.out.println("ship is dead");// kontroll
                    ship.dead();
                    options = 3;
                    shipName = ship.getShipName();
                    mainFrame.updateMessage(options, shipName);
                    numberOfShipsDestroyed++;

                    updatedValue = numberOfShipsDestroyed;
                    mainFrame.updateMainPanel("destroyed", updatedValue);

                    if (gameMapp.areAllTheShipsDead()) {
                        // System.out.println("all the ship are dead");// kontroll
                        // scoreHistory.toTextFile();
                        options = 4;
                        shipName = "Ömer";
                        mainFrame.updateMessage(options, shipName);
                        player.setScore(totalShotsTaken);
                        // System.out.println("out "); //kontroll
                        if (scoreHistory.compareScore()) {
                            scoreHistory.writeToFile();
                            // System.out.println("reach to this");
                            mainFrame.populateRPanel(scoreHistory.AllScoreInfo());

                        } else {
                            JOptionPane.showMessageDialog(null, "Your result did not meet the standards");
                        }

                        String[] option2 = new String[] { "Yes", "No" };
                        int reply = JOptionPane.showOptionDialog(null, "Would you like to play another round?",
                                "Game is Over", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option2,
                                option2[0]);
                        if (reply == 0) {
                            mainFrame.hideFrame();
                            beginGame();
                        } else {
                            mainFrame.closeFrame();
                        }
                    }

                }

            }
        }
    }

    /**
     * här vi får players info
     * @return
     */
    public Player getPlayer() {
        return player;
    }
}
