package monsterTecg.Logics.DesignPatterns.Template;

import monsterTecg.Logics.PlayerManager;

/**
 * Implementación de un caso particular para la carta bleed
 * @author Anthony Chaves
 */
public class BleedFacade extends FacadePerformer{
    /**
     * Facade que realiza los cambios en el jugador
     * @param dmg daño de la carta
     */
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
