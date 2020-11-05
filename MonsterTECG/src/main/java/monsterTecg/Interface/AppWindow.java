package monsterTecg.Interface;

import javax.swing.*;
import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.PlayerManager;

/**
 * 
 * Define el tamaño de la pantalla y crea una instancia para un jugador
 * 
 */

public class AppWindow extends JFrame {
    /**
     * Constructor de la clase
     * @param turn inidicador de turno inicial
     * @param ip direccion ip del jugador
     * @param port puerto inicial para el jugador
     * @param mw ventana del cliente
     */
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

