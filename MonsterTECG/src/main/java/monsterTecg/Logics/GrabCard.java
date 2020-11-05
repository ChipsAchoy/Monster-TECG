package monsterTecg.Logics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import monsterTecg.Interface.AppInterface;

/**
 * ActionListener del boton para agarrar una carta
 * @author Anthony Chaves
 */
public class GrabCard implements ActionListener {
    private AppInterface frame;
    
    /**
     * Constructor de la clase
     * @param frame interfaz de juego
     */
    public GrabCard(AppInterface frame){
        this.frame = frame;
    }
    
    /**
     * Actualiza la mano de cartas tomando una del deck
     * @param e evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if ((PlayerManager.getInstance().getHand().getSize()<10)&&(PlayerManager.getInstance().deckSize > 0)){
            PlayerManager.getInstance().deckSize -= 1;
            this.frame.deckC.setText(Integer.toString(PlayerManager.getInstance().deckSize));
            PlayerManager.getInstance().getHandUpdate();
            PlayerManager pm = PlayerManager.getInstance();
            pm.selected = pm.getHand().getByIndex(pm.getHand().getSize()-1);
            pm.selectedIndex = pm.getHand().getSize()-1;
            pm.updateCurrent();
        }
        else if (PlayerManager.getInstance().getHand().getSize()==10){
            this.frame.info2.setText("Su mano está llena");
        }
        else if (PlayerManager.getInstance().getInstance().deckSize==0){
            this.frame.info2.setText("Su mano está llena");
        }
    }
    
}
