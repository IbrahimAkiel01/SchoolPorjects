package view;

import javax.swing.*;

/**
 * Här vi har en bindning mellan R och L panel
 * Här vi ger storlek till båda paneler
 * @author Ömer & Ibrahim
 */
public class MainPanel extends JPanel {
    private LeftPanel leftPanel;
    private RightPanel rightPanel;

    /**
     * en konstruktor för att ge storleken till bredden och höjden
     * @param width
     * @param height
     * @param mainFrame
     */

    public MainPanel(int width, int height, MainFrame mainFrame) {
        super(null);
        this.setSize(width, height);

        leftPanel = new LeftPanel(width / 2, height/2, mainFrame);

        add(leftPanel);

        rightPanel = new RightPanel(width / 2, height, mainFrame);
        add(rightPanel);


    }

    /**
     * här uppdaterar R panelen
     * @param str
     * @param newValue
     */
    public void updateRpanel(String str, int newValue)
    {
        rightPanel.updateLabel(str, newValue);
    }

    protected RightPanel getRightPanel() {
        return rightPanel;
    }

    /**
     * uppdaterar messagen
     * @param choice
     * @param shipName
     */

    public void updateMessage(int choice, String shipName) {
        rightPanel.updateMessage(choice,shipName);
    }


}
