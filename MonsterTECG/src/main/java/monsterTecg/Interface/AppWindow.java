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
        //this.setLayout(null);
        
        setSize(800, 700);
        
        AppInterface interfaz = new AppInterface("Bg.png");

        PlayerManager pm = PlayerManager.getInstance(12003, interfaz, true);
        
        pm.setDeck();
        pm.setHand();
        pm.selected = pm.getHand().getByIndex(0);
        pm.selectedIndex = 0;
        pm.updateCurrent();

        add(interfaz);
        
        setResizable(false);   
        
        setVisible(true);
    }

}

