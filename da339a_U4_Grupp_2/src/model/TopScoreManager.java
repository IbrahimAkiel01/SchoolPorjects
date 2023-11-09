package model;

import controller.Controller;

import javax.sound.midi.MidiFileFormat;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class TopScoreManager {
    private ArrayList<Player> highScore;
    private ArrayList<Player> topPlayersScore;
    private Controller controller;
    private Player player;


    /**
     * Konstruktorn för att skapa en ArrayList (highScore) använder sig av objekt av typen Player,
     * som innehåller information om den nuvarande spelaren. Denna ArrayList används för att hålla
     * reda på de högsta poängen från spelaren. En annan ArrayList (topPlayersScore) lagrar all
     * information från en .dat-fil och lägger till den nuvarande spelaren om dennes poäng är högre
     * än spelaren på plats 9 i listan. Detta gör det möjligt att hålla reda på de högsta poängen genom
     * tiderna. För att kunna hämta den nuvarande spelarens poäng behöver konstruktorn också ta emot en
     * parameter för att ha tillgång till controllern som håller reda på den nuvarande spelarens poäng.
     * Denna controller används för att hämta den aktuella spelarens poäng och jämföra den med de tidigare
     * högsta poängen i listan. Sammantaget gör konstruktorn det möjligt att hålla reda på de högsta poängen
     * från spelaren genom tiderna, samt att lägga till den nuvarande spelaren i listan om deras poäng är
     * högre än de tidigare högsta poängen.
     * @throws IOException
     * @throws FileNotFoundException
     * @author Ömer & Ibrahim
     */
    public TopScoreManager(Controller controller) throws FileNotFoundException, IOException {
        highScore = new ArrayList<>();
        topPlayersScore = new ArrayList<>(10);
        this.controller = controller;

    }
    public boolean compareScore() {

        if (topPlayersScore.size() == 0) {
            String playersName = JOptionPane.showInputDialog(null, "Enter your Nickname");
            this.player = controller.getPlayer();
            player.setPlayersName(playersName);
            topPlayersScore.add(player);
            return true;
        }
        if ((topPlayersScore.get(0) != null && topPlayersScore.get(0) instanceof Player) || topPlayersScore.isEmpty()
                || (player.getPlayersScore() < topPlayersScore.get(9).getPlayersScore())) {
            String playersName = JOptionPane.showInputDialog(null, "Enter your Nickname");
            this.player = controller.getPlayer();
            player.setPlayersName(playersName);
            topPlayersScore.add(player);
            Collections.sort(topPlayersScore);
            return true;

        } else {
            System.out.println("Better luck next time");
            return false;
        }

    }

    /**
     * här vi lagrar information av score
     * @return
     */
    public String[] AllScoreInfo() {
        String[] stringArrayAllScores = new String[topPlayersScore.size()];
        for (int i = 0; i < stringArrayAllScores.length; i++) {
            stringArrayAllScores[i] = topPlayersScore.get(i).toString();
        }
        return stringArrayAllScores;
    }

    /**
     * här vi lägger vår information av spelaer till list filen
     */

    public void writeToFile() {
        try (FileOutputStream fis = new FileOutputStream("list.dat", true)) {
            ObjectOutputStream oos = new ObjectOutputStream(fis);
            for (int i = 0; i < topPlayersScore.size(); i++) {
                oos.writeObject(topPlayersScore.get(i));
                oos.flush();
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * här vi kan läsa filen som vi skapade
     */
    public void readFromFile() {
        String path = "list.dat";
        try {
            FileInputStream fis = new FileInputStream("list.dat");

            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                Player p = (Player) ois.readObject();
                topPlayersScore.add(p);
            }

        } catch (Exception ex) {
            System.out.println(topPlayersScore.toString());
            Collections.sort(topPlayersScore);

        }
    }
}
