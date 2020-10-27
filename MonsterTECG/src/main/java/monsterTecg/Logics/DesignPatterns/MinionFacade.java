package monsterTecg.Logics.DesignPatterns;

import monsterTecg.Logics.PlayerManager;

/**
 *
 * @author Anthony Chaves
 */
public class MinionFacade implements FacadePerformer{

    @Override
    public void makeChanges(int dmg) {
        PlayerManager.getInstance().updateHealth(dmg);
        
    }
    
}
