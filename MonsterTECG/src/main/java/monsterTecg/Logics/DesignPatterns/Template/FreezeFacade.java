package monsterTecg.Logics.DesignPatterns.Template;

import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.DesignPatterns.Template.FacadePerformer;
import monsterTecg.Logics.PlayerManager;

/**
 *
 * @author Anthony Chaves
 */
public class FreezeFacade extends FacadePerformer{
    @Override
    public void makeChanges(int dmg) {
        PlayerManager.getInstance().selected = new Card("None",0,0);
        PlayerManager.getInstance().setTurns(0);
        
    }
    
}
