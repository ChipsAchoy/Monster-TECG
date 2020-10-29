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
            this.frame.listaCards.setListData(PlayerManager.getInstance().getHandUpdate().toArray());
        }
        else{
            System.out.println("Hand llena");
        }
    }
    
}
