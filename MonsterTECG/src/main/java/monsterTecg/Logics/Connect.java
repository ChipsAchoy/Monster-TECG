package monsterTecg.Logics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import monsterTecg.Interface.AppWindow;
import monsterTecg.Interface.MenuInterface;
import monsterTecg.Interface.MenuWindow;

/**
 * Action listener para el boton de conexion del cliente
 * @author Anthony Chaves
 */
public class Connect implements ActionListener{
    private MenuInterface panel;
    private MenuWindow frame;
    
    /**
     * Constructor de la clase
     * @param menu interfaz del menu
     * @param mw ventana del menu
     */
    public Connect(MenuInterface menu, MenuWindow mw){
        this.panel = menu;
        this.frame = mw;
    }
    
    /**
     * Metodo que responde al boton del cliente de connect
     * @param e evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        AppWindow window = new AppWindow(true, this.panel.ip.getText(), Integer.parseInt(this.panel.port.getText()), this.frame);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel.info.setText("Conectando...");
        //this.frame.dispose();
    }
    
}
