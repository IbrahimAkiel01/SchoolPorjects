package view;

import javax.swing.*;
import java.awt.*;

/**
 * Här vi skapar vår högrepanel och här sker information
 * om speler till exempel hur många skepp som dog eller
 * total hits på båter
 */

public class RightPanel extends JPanel {

    private JList <Object> objectJList;
    private JLabel labelAttackl;
    private JLabel labelMissl;
    private JLabel labelDestroyedShipsl;
    private JLabel labelTotal;
    private JLabel Labellist;

    private JTextField hitField;
    private JTextField missField;
    private JTextField destroyedField;
    private JTextField totalStrikesField;

    private int width;
    private int height;

    private String hits;
    private String misses;
    private String destroyed;
    private String totalStrikes;
    private MainFrame mainFrame;

    /**
     *
     * @param width
     * @param height
     * @param mainFrame
     */

    public RightPanel(int width, int height, MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height/2);
        setLocation(width, 0);
        setUp();

    }

    /**
     *Labelen av hits of ships
     */
    public void hitField() {

        labelAttackl = new JLabel("Hits of Ships");
        labelAttackl.setLocation(50, 50);
        labelAttackl.setSize(100, 100);
        this.add(labelAttackl);


        hits = "0";


        hitField = new JTextField("" + hits);
        hitField.setPreferredSize(new Dimension(50, 50));


        this.add(hitField);
        hitField.setText(String.valueOf(0));
    }

    /**
     * labelen av total misses på spelet
     */
    public void missField() {
        labelMissl = new JLabel("Total Misses");
        labelMissl.setLocation(50, 100);
        labelMissl.setSize(100, 100);
        this.add(labelMissl);
        misses = "0";
        missField = new JTextField("" + misses);
        missField.setLocation(50, 80);
        missField.setPreferredSize(new Dimension(50, 50));
        this.add(missField);
    }

    /**
     * labelen av total destroyed på spelet
     */
    public void destroyField() {
        labelDestroyedShipsl = new JLabel("Total Destroyed");
        labelDestroyedShipsl.setLocation(100, 150);
        labelDestroyedShipsl.setSize(100, 100);
        this.add(labelDestroyedShipsl);
        destroyed = "0";
        destroyedField = new JTextField("" + hits);
        destroyedField.setLocation(10, 80);
        destroyedField.setPreferredSize(new Dimension(50, 50));
        // destroyedField.setBounds(50,100,50,30);
        this.add(destroyedField);

    }

    /**
     * lbelen av total strikes på spelet
     */
    public void totalStrikesField() {
        labelTotal = new JLabel("Total Strikes");
        labelTotal.setLocation(50, 200);
        labelTotal.setSize(100, 100);
        this.add(labelTotal);
        totalStrikes = "0";
        totalStrikesField = new JTextField("" + hits);
        totalStrikesField.setLocation(50, 80);
        totalStrikesField.setPreferredSize(new Dimension(50, 50));
        this.add(totalStrikesField);
    }

    /**
     * labelen av score listan på spelet
     */
    public void createRightPanelList()
    {
        Labellist = new JLabel("HighScore list");
        Labellist.setLocation(50,600);
        Labellist.setSize(200,200);
        this.add(Labellist);
        objectJList = new JList<>();
        objectJList.setLocation(50,500);
        objectJList.setSize(100,100);
        this.add(objectJList);
    }

    /**
     * här vi får info från controller
     */
    private void setUp() {
        setLayout(new FlowLayout());
        hitField();
        missField();
        destroyField();
        totalStrikesField();
        createRightPanelList();

    }

    



    public void updateLabel(String str, int newValue) {

        switch (str) {
            case "attack":
                hitField.setText(String.valueOf(newValue));
                break;
            case "miss":
                missField.setText(String.valueOf(newValue));
                break;
            case "destroyed":
                destroyedField.setText(String.valueOf(newValue));
                break;
            case "totalStrikes":
                totalStrikesField.setText(String.valueOf(newValue));
                break;
        }


    }

    /**
     * uppdate messages när man trycker på rutan
     * @param choice
     * @param shipName
     */
    public void updateMessage(int choice, String shipName) {
        switch (choice){
            case 1:
                JOptionPane.showMessageDialog(null,"This square has already been targeted. Please select a different location.");
                break;
            case 2:
                JOptionPane.showMessageDialog(null,"You launch an assault on a " + shipName);
                break;
            case 3:
                JOptionPane.showMessageDialog(null,"You sink a " + shipName);
                break;
            case 4:
                JOptionPane.showMessageDialog(null,"Game is over!");
                break;
        }
    }

    public void populateList(String[] informationArray) {
        objectJList.setListData(informationArray);
    }
    protected JList<Object> getObjectJList()
    {
        return objectJList;
    }
}



