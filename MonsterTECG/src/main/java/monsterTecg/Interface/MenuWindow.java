package monsterTecg.Interface;

import javax.swing.JFrame;

/**
 *
 * @author Anthony Chaves
 */
public class MenuWindow extends JFrame{
    
    public MenuWindow(){
        
        setSize(400, 400);
        
        MenuInterface interfaz = new MenuInterface("Bg2.png", this);
        
        add(interfaz);
        
        setResizable(false);   
        
        setVisible(true);
        
    }
}
