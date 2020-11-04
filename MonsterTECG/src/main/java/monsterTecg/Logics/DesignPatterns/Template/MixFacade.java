package monsterTecg.Logics.DesignPatterns.Template;

import java.util.Random;
import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.PlayerManager;

/**
 *
 * @author Anthony Chaves
 */
public class MixFacade extends FacadePerformer{

    @Override
    public void makeChanges(int dmg) {
        while (PlayerManager.getInstance().getHand().getSize() < 10){
            PlayerManager.getInstance().getHandUpdate();
        }
        
        while (PlayerManager.getInstance().getHand().getSize() != 4){
            Random rand = new Random();
            int rnd = rand.nextInt(PlayerManager.getInstance().getHand().getSize());
            Card current = PlayerManager.getInstance().getHand().getByIndex(rnd);
            PlayerManager.getInstance().getDeck().push(current);
            PlayerManager.getInstance().getHand().deleteByIndex(rnd);
        }
        
        
    }
    
}
