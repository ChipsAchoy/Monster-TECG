package monsterTecg.Logics.DesignPatterns.Template;

import java.awt.event.ActionEvent;
import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.PlayerManager;

/**
 * Implementación de un caso particular para la carta electrocute
 * @author Anthony Chaves
 */
public class ElectrocuteFacade extends FacadePerformer{
    /**
     * Facade que realiza los cambios en el jugador
     * @param dmg daño de la carta
     */
    @Override
    public void makeChanges(int dmg) {
        PlayerManager.getInstance().updateHealth(dmg);
        PlayerManager.getInstance().selected = new Card("None", 0,0, "");
        ActionEvent e = null;
        PlayerManager.getInstance().sendturn.actionPerformed(e);
    }
    
}
