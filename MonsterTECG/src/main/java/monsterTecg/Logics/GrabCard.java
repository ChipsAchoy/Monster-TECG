package monsterTecg.Logics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import monsterTecg.Interface.AppInterface;

/**
 *
 * @author Anthony Chaves
 */
public class GrabCard implements ActionListener {
    private AppInterface frame;
    
    public GrabCard(AppInterface frame){
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (PlayerManager.getInstance().getHand().getSize()<10){
            PlayerManager.getInstance().deckSize -= 1;
            this.frame.deckC.setText(Integer.toString(PlayerManager.getInstance().deckSize));
            PlayerManager.getInstance().getHandUpdate();
            PlayerManager pm = PlayerManager.getInstance();
            pm.selected = pm.getHand().getByIndex(pm.getHand().getSize()-1);
            pm.selectedIndex = pm.getHand().getSize()-1;
            pm.updateCurrent();
        }
        else{
            this.frame.info2.setText("Su mano está llena");
        }
    }
    
}
