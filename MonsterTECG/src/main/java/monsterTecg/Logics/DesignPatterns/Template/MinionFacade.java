package monsterTecg.Logics.DesignPatterns.Template;

import monsterTecg.Logics.DesignPatterns.Template.FacadePerformer;
import monsterTecg.Logics.PlayerManager;

/**
 * Implementación de un caso particular para la carta minion
 * @author Anthony Chaves
 */
public class MinionFacade extends FacadePerformer{
    /**
     * Facade que realiza los cambios en el jugador
     * @param dmg daño de la carta
     */
    @Override
    public void makeChanges(int dmg) {
        
        PlayerManager.getInstance().updateHealth(dmg);
        
    }
    
}
