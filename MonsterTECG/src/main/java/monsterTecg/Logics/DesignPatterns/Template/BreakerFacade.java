package monsterTecg.Logics.DesignPatterns.Template;

import monsterTecg.Logics.PlayerManager;

/**
 *
 * @author Anthony Chaves
 */
public class BreakerFacade extends FacadePerformer{

    @Override
    public void makeChanges(int dmg) {
        PlayerManager pm = PlayerManager.getInstance();
        if (pm.getHealth() > 500){
            pm.updateHealth(pm.getHealth()/5);
        }else{
            if (pm.getHealth() +(pm.getHealth()/10) >= 1000){
                pm.setHealth(1000);
            }
            else{
                pm.updateHealth(-(pm.getHealth()/10));
            }
        }
    }
    
}
