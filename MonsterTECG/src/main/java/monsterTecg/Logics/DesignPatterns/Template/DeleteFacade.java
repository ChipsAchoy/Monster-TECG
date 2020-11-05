package monsterTecg.Logics.DesignPatterns.Template;

import monsterTecg.Logics.PlayerManager;

/**
 * Implementación de un caso particular para la carta delete
 * @author Anthony Chaves
 */
public class DeleteFacade extends FacadePerformer{
    /**
     * Facade que realiza los cambios en el jugador
     * @param dmg daño de la carta
     */
    @Override
    public void makeChanges(int dmg) {
        PlayerManager pm = PlayerManager.getInstance();
        if (pm.getHand().getSize() > 5){
            for (int i=0; i<3; i++){
                pm.getHand().deleteByIndex(0);
            }
            pm.selected = PlayerManager.getInstance().getHand().getByIndex(0);
            pm.selectedIndex = 0;
            pm.updateCurrent();
        }
    }
    
}
