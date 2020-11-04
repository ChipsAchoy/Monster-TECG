package monsterTecg.Logics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import monsterTecg.Interface.AppInterface;

/**
 *
 * @author Anthony Chaves
 */
public class MoveNext implements ActionListener{
    
    private AppInterface frame;
    public MoveNext(AppInterface frame){
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        PlayerManager pm = PlayerManager.getInstance();
        if ((pm.selectedIndex + 1 )== pm.getHand().getSize()){
            pm.selectedIndex = 0;
            pm.selected = pm.getHand().getByIndex(0);
        }else{
            pm.selectedIndex += 1;
            pm.selected = pm.getHand().getByIndex(pm.selectedIndex);
        }
        pm.updateCurrent();
    }
    
}
