package monsterTecg.Logics.DesignPatterns.Template;

import monsterTecg.Logics.DesignPatterns.Template.FacadePerformer;
import monsterTecg.Logics.PlayerManager;

/**
 *
 * @author Anthony Chaves
 */
public class MinionFacade extends FacadePerformer{

    @Override
    public void makeChanges(int dmg) {
        
        PlayerManager.getInstance().updateHealth(dmg);
        
    }
    
}
