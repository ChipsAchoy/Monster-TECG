package monsterTecg.Logics.DesignPatterns.Template;

import monsterTecg.Logics.PlayerManager;

/**
 *
 * @author Anthony Chaves
 */
public class BleedFacade extends FacadePerformer{

    @Override
    public void makeChanges(int dmg) {
        PlayerManager pm = PlayerManager.getInstance();
        if (pm.getHealth() < 500){
            pm.updateHealth(dmg+pm.getHealth()/10);
        }else{
            pm.updateHealth(dmg);
        }
    }
    
}
