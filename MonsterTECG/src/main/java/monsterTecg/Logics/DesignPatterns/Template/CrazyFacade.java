package monsterTecg.Logics.DesignPatterns.Template;

import java.awt.event.ActionEvent;
import java.util.Random;
import monsterTecg.Logics.PlayerManager;

/**
 *
 * @author Anthony Chaves
 */
public class CrazyFacade extends FacadePerformer{

    @Override
    public void makeChanges(int dmg) {
        Random rand = new Random();
        int rnd = rand.nextInt(PlayerManager.getInstance().getHand().getSize());
        PlayerManager.getInstance().selected = PlayerManager.getInstance().getHand().getByIndex(rnd);
        ActionEvent e = null;
        PlayerManager.getInstance().sendturn.actionPerformed(e);
    }
    
}
