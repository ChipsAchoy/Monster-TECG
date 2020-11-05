package monsterTecg.Logics.DesignPatterns.Template;

import monsterTecg.Logics.PlayerManager;

/**
 * Implementación de un caso particular para la carta manacounter
 * @author Anthony Chaves
 */
public class ManaCounterFacade extends FacadePerformer{
    /**
     * Facade que realiza los cambios en el jugador
     * @param dmg daño de la carta
     */
    @Override
    public void makeChanges(int dmg) {
        PlayerManager pm = PlayerManager.getInstance();
        if (pm.getMana() < 600){
            pm.updateHealth(pm.getMana());
        }
    }
    
}
