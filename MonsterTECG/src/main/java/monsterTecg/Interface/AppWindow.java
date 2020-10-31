package monsterTecg.Interface;

import javax.swing.*;
import monsterTecg.Logics.PlayerManager;

/**
 * 
 * AppWindow defines the size of the display window and calls the GUI managment class
 * 
 */

public class AppWindow extends JFrame {

    public AppWindow() {

        setBounds(600, 500, 300, 400);

        AppInterface interfaz = new AppInterface();

        PlayerManager pm = PlayerManager.getInstance(12003, interfaz);
        
        pm.setDeck();
        pm.setHand();

        add(interfaz);

        setVisible(true);
    }

}

