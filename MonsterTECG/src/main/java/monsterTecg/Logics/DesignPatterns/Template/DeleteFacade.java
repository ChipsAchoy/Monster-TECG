package monsterTecg.Logics.DesignPatterns.Template;

import monsterTecg.Logics.PlayerManager;

/**
 *
 * @author Anthony Chaves
 */
public class DeleteFacade extends FacadePerformer{

    @Override
    public void makeChanges(int dmg) {
        PlayerManager pm = PlayerManager.getInstance();
        if (pm.getHand().getSize() > 5){
            for (int i=0; i<3; i++){
                pm.getHand().deleteByIndex(0);
            }
            pm.selected = PlayerManager.getInstance().getHand().getByIndex(0);
            pm.selectedIndex = 0;
            pm.updateCurrent();
        }
    }
    
}
