package monsterTecg.Logics.DesignPatterns.Template;

import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.PlayerManager;

/**
 * Implementación de un caso particular para la carta steal
 * @author Anthony Chaves
 */
public class StealFacade extends FacadePerformer{
    /**
     * Facade que realiza los cambios en el jugador
     * @param dmg daño de la carta
     */
    @Override
    public void makeChanges(int dmg) {
        //PlayerManager.getInstance().setTurns(0);
        Card selected = PlayerManager.getInstance().getHand().getByIndex(0);
        //Mecanismo para recibir la carta robada
        PlayerManager.getInstance().getHand().deleteByIndex(0);
    }
    
}
