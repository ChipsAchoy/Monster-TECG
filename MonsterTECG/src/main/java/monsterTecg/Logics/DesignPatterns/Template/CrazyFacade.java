package monsterTecg.Logics.DesignPatterns.Template;

import java.awt.event.ActionEvent;
import java.util.Random;
import monsterTecg.Logics.PlayerManager;

/**
 * Implementación de un caso particular para la carta crazy
 * @author Anthony Chaves
 */
public class CrazyFacade extends FacadePerformer{
    /**
     * Facade que realiza los cambios en el jugador
     * @param dmg daño de la carta
     */
    @Override
    public void makeChanges(int dmg) {
        Random rand = new Random();
        int rnd = rand.nextInt(PlayerManager.getInstance().getHand().getSize());
        PlayerManager.getInstance().selected = PlayerManager.getInstance().getHand().getByIndex(rnd);
        ActionEvent e = null;
        PlayerManager.getInstance().sendturn.actionPerformed(e);
    }
    
}
