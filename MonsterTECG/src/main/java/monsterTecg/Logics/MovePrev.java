package monsterTecg.Logics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import monsterTecg.Interface.AppInterface;

/**
 *
 * @author Anthony Chaves
 */
public class MovePrev implements ActionListener{
    
    private AppInterface frame;
    public MovePrev(AppInterface frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PlayerManager pm = PlayerManager.getInstance();
        if ((pm.selectedIndex - 1) == -1){
            pm.selectedIndex = pm.getHand().getSize()-1;
            pm.selected = pm.getHand().getByIndex(pm.getHand().getSize()-1);
        }else{
            pm.selectedIndex -= 1;
            pm.selected = pm.getHand().getByIndex(pm.selectedIndex);
        }
        pm.updateCurrent();
    }
}
