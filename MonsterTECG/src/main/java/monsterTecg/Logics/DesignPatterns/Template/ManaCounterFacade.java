package monsterTecg.Logics.DesignPatterns.Template;

import monsterTecg.Logics.PlayerManager;

/**
 *
 * @author Anthony Chaves
 */
public class ManaCounterFacade extends FacadePerformer{

    @Override
    public void makeChanges(int dmg) {
        PlayerManager pm = PlayerManager.getInstance();
        if (pm.getMana() < 600){
            pm.updateHealth(pm.getMana());
        }
    }
    
}
