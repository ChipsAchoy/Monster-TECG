package monsterTecg.Logics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import monsterTecg.Interface.AppWindow;
import monsterTecg.Interface.MenuInterface;
import monsterTecg.Interface.MenuWindow;

/**
 *
 * @author Anthony Chaves
 */
public class HostMatch implements ActionListener{
    private MenuInterface panel;
    private MenuWindow frame;
    
    public HostMatch(MenuInterface menu, MenuWindow mw){
        this.panel = menu;
        this.frame = mw;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        AppWindow window = new AppWindow(false, "", 0, this.frame);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel.info.setText("Esperando en el puerto 12002");
    }
    
}
