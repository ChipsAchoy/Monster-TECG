package monsterTecg.Logics.DesignPatterns.Template;

import monsterTecg.Logics.PlayerManager;

/**
 *
 * @author Anthony Chaves
 */
public class WindFacade extends FacadePerformer{

    @Override
    public void makeChanges(int dmg) {
        PlayerManager.getInstance().getHand().deleteByIndex(0);
    }
    
}
