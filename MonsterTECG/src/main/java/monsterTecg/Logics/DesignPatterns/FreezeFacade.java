package monsterTecg.Logics.DesignPatterns;

import monsterTecg.Logics.PlayerManager;

/**
 *
 * @author Anthony Chaves
 */
public class FreezeFacade implements FacadePerformer{
    @Override
    public void makeChanges(int dmg) {
        PlayerManager.setTurns(0);
    }
    
}
