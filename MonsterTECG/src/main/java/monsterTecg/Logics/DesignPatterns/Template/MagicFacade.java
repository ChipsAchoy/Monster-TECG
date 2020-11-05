package monsterTecg.Logics.DesignPatterns.Template;

import java.awt.event.ActionEvent;
import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.PlayerManager;

/**
 * Implementación de un caso particular para la carta magic
 * @author Anthony Chaves
 */
public class MagicFacade extends FacadePerformer{
    /**
     * Facade que realiza los cambios en el jugador
     * @param dmg daño de la carta
     */
    @Override
    public void makeChanges(int dmg) {
        PlayerManager pm = PlayerManager.getInstance();
        Card found = null;
        for (int i=0; i<pm.getHand().getSize(); i++){
            String current = pm.getHand().getByIndex(i).getType();
            if (current.equals("fireball")||current.equals("electrocute")||current.equals("freeze")){
                found = pm.getHand().getByIndex(i);
                break;
            }
        }
        if (found != null){
            pm.selected = found;
            ActionEvent e = null;
            pm.sendturn.actionPerformed(e);
        }
    }
    
}
