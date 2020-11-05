package monsterTecg.Interface;

import javax.swing.*;
import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.PlayerManager;

/**
 * 
 * AppWindow defines the size of the display window and calls the GUI managment class
 * 
 */

public class AppWindow extends JFrame {

    public AppWindow(boolean turn, String ip, int port, MenuWindow mw) {
        //this.setLayout(null);
        
        setSize(800, 700);
        
        AppInterface interfaz = new AppInterface("Bg.png");

        PlayerManager pm = PlayerManager.getInstance(12002, interfaz, turn, mw);
        
        pm.setDeck();
        pm.setHand();
        pm.selected = pm.getHand().getByIndex(0);
        pm.selectedIndex = 0;
        pm.updateCurrent();
        
        if (turn){
            pm.ipSend = ip;
            pm.portSend = port;
            pm.initPort();
            pm.locked = false;
            pm.selected = new Card("Start",pm.inPort,0,"");
            pm.sendturn.actionPerformed(null);
            pm.locked = true;
        }
        
        

        add(interfaz);
        
        setResizable(false);   
        
        setVisible(true);
    }

}

