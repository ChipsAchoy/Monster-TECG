package monsterTecg.Logics.DesignPatterns.Template;

import java.util.Random;
import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.PlayerManager;

/**
 * Implementación de un caso particular para la carta mix
 * @author Anthony Chaves
 */
public class MixFacade extends FacadePerformer{
    /**
     * Facade que realiza los cambios en el jugador
     * @param dmg daño de la carta
     */
    @Override
    public void makeChanges(int dmg) {
        int currentCards = PlayerManager.getInstance().getHand().getSize();
        if (currentCards + PlayerManager.getInstance().deckSize >= 10){
            while (PlayerManager.getInstance().getHand().getSize() < 10){
                PlayerManager.getInstance().getHandUpdate();
            }

            while (PlayerManager.getInstance().getHand().getSize() != currentCards){
                Random rand = new Random();
                int rnd = rand.nextInt(PlayerManager.getInstance().getHand().getSize());
                Card current = PlayerManager.getInstance().getHand().getByIndex(rnd);
                PlayerManager.getInstance().getDeck().push(current);
                PlayerManager.getInstance().getHand().deleteByIndex(rnd);
            }
        }
        
    }
    
}
