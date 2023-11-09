package view;
/**
 * här vi skapar vår MainFrame vilket vi ger namn på vårt spel
 * vi sätter in size och konnektionen till controller
 */

import controller.Controller;

import javax.swing.*;

public class MainFrame extends JFrame {

    private MainPanel mainPanel;
    private Controller controller;

    /**
     * en konstruktor med parametrar höjden, bredden och controller
     * @param width
     * @param height
     * @param controller
     */
        public MainFrame(int width, int height, Controller controller) {


        super("God Of War");
        this.controller = controller;
        this.setResizable(false);
        this.setSize(width,height);
        this.mainPanel = new MainPanel(width, height, this );
        this.setContentPane(mainPanel);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * här vi får kordinaterna och lägger in till mainpanel
     * @param x
     * @param y
     * @param button
     * @return
     */
    public void boardButtonPressed(int x, int y, ButtonType button) {

        controller.selectedCoordinate(x,y,button);
    }

    /**
     * vi skapar en updatemainpanel för att uppdatera info av spelet
     * @param str
     * @param newValue
     */

    public void updateMainPanel(String str, int newValue)
    {
        mainPanel.updateRpanel(str, newValue);
    }

    /**
     * meddelandet vi får när vi spelar spelet
     * @param choice
     * @param shipName
     */
    public void updateMessage(int choice, String shipName) {
        mainPanel.updateMessage(choice, shipName);
    }

    /**
     *
     * @param informationArray
     */
    public void populateRPanel(String[] informationArray) {
        mainPanel.getRightPanel().populateList(informationArray);
    }

    /**
     *
     */
    public void hideFrame() {
        setVisible(false);

    }

    /**
     * om man tryker på exit då slutar spelet.
     */
    public void closeFrame() {
        System.exit(0);
    }
}

