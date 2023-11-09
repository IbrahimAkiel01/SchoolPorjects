package view;
/**
 * Här vi skapar vår panel vilket spel kommer ske här.
 * vi har 2 näslade loppar.
 * @author Ömer & Ibrahim
 */

import javax.swing.*;
import java.awt.*;
public class LeftPanel extends JPanel {

    private int width;
    private int height;
    private MainFrame mainFrame;

    /**
     * vi deklarerar 2 variabler width och height vilka är
     *  * höjden och bredden. Mainframe är för att hämta info
     *  från mainframe.
     * @param width
     * @param height
     * @param mainFrame
     */

    public LeftPanel(int width, int height, MainFrame mainFrame){
        this.mainFrame = mainFrame;
        this.width = width;
        this.height= height;
        this.setSize(width,height);
        setLocation(0,0);
        this.setLayout(new GridLayout(10, 10));
        for (int x = 0; x < 10; x++) {
            for (int y= 0; y <10; y++){
               ButtonType buttonType= new ButtonType(width/11, height/11);
                int fctrx = x;
                int fctry = y;
                buttonType.addActionListener(l -> mainFrame.boardButtonPressed(fctrx, fctry, buttonType));
                this.add(buttonType);
            }
        }
    }
}









