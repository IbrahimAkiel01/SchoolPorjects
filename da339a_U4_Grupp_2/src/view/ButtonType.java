package view;

import javax.swing.*;
import java.awt.*;

public class ButtonType extends JButton {

    /**
     * Här skapar vi en konstruktor(ButtonType) vilket har
     * 2 parameter och vi sätter storlek på knappar med hjälp av
     * @param width: knappens bredd.
     * @param height: knappens höjd.
     */
    public ButtonType(int width, int height ){
        super();
        this.setEnabled(true);
        this.setSize(width, height);
        hitButtonType(ButtonEnum.water);
        this.setOpaque(true);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));


    }

    /**
     * Här vi ger emoji till de rutorna som finns i
     * vår mapp i spelet
     * @param buttonenum
     */
    public void hitButtonType(ButtonEnum buttonenum){
        switch (buttonenum) {
            case attack:
                setText("\uD83D\uDEA2");
                setBackground(Color.BLACK);
                break;

            case hitnull:
                setText("\uD83C\uDF0A");
                setBackground(Color.blue);
                break;

            case water:
                setText("\uD83D\uDD32");
                break;
        }
    }
}
