package monsterTecg.Logics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import monsterTecg.Interface.AppWindow;
import monsterTecg.Interface.MenuInterface;
import monsterTecg.Interface.MenuWindow;

/**
 * ActionListener del boton para hostear
 * @author Anthony Chaves
 */
public class HostMatch implements ActionListener{
    private MenuInterface panel;
    private MenuWindow frame;
    
    /**
     * Constructor de la clase
     * @param menu interfaz del menu
     * @param mw ventana del menu
     */
    public HostMatch(MenuInterface menu, MenuWindow mw){
        this.panel = menu;
        this.frame = mw;
    }
    
    /**
     * Metodo que se activa al tocar el boton de host
     * @param e evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        AppWindow window = new AppWindow(false, "", 0, this.frame);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel.info.setText("Esperando en 127.0.0.1:"+Integer.toString(PlayerManager.getInstance().inPort));
    }
    
}
