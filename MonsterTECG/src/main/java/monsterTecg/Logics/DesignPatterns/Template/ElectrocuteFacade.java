package monsterTecg.Logics.DesignPatterns.Template;

import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.PlayerManager;

/**
 *
 * @author Anthony Chaves
 */
public class ElectrocuteFacade extends FacadePerformer{

    @Override
    public void makeChanges(int dmg) {
        PlayerManager.getInstance().updateHealth(dmg);
        PlayerManager.getInstance().selected = new Card("None", 0,0);
        PlayerManager.getInstance().setTurns(0);
    }
    
}
