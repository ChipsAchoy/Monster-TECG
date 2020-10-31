package monsterTecg.Logics.DesignPatterns.Template;

import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.PlayerManager;

/**
 *
 * @author Anthony Chaves
 */
public abstract class FacadePerformer {
    protected Card card;
    public void showCard(Card card){
        this.card = card;
        PlayerManager.getInstance().setTurns(1);
        System.out.println("Tipo"+card.getType()+"Dmg"+card.getDmg());
    }
    
    public abstract void makeChanges(int dmg);
}
