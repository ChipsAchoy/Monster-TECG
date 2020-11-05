package monsterTecg.Interface;

import javax.swing.JFrame;

/**
 * Ventana del cliente de juego
 * @author Anthony Chaves
 */
public class MenuWindow extends JFrame{
    /**
     * Constructor de la clase
     */
    public MenuWindow(){
        
        setSize(400, 400);
        
        MenuInterface interfaz = new MenuInterface("Bg2.png", this);
        
        add(interfaz);
        
        setResizable(false);   
        
        setVisible(true);
        
    }
}
