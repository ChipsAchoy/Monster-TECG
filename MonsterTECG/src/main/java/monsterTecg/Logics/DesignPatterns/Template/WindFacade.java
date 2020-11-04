package monsterTecg.Logics.DesignPatterns.Template;

import monsterTecg.Logics.PlayerManager;

/**
 *
 * @author Anthony Chaves
 */
public class WindFacade extends FacadePerformer{

    @Override
    public void makeChanges(int dmg) {
        if (PlayerManager.getInstance().getHand().getSize() - 1 > 0){
            PlayerManager.getInstance().getHand().deleteByIndex(0);
            
        }else{
            PlayerManager.getInstance().getHand().deleteByIndex(0);
            PlayerManager.getInstance().getHandUpdate();
        }
        PlayerManager.getInstance().selected = PlayerManager.getInstance().getHand().getByIndex(0);
        PlayerManager.getInstance().selectedIndex = 0;
        PlayerManager.getInstance().updateCurrent();
    }
    
}
