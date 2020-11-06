package monsterTecg.Logics.DesignPatterns.Template;

import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.PlayerManager;

/**
 * Implementación de un template method que permite heredar a otros facades
 * @author Anthony Chaves
 */
public abstract class FacadePerformer {
    protected Card card;
    
    /**
     * Muestra la carta y actualiza los turnos
     * @param card carta a procesar
     */
    public void showCard(Card card){
        this.card = card;
        PlayerManager.getInstance().setTurns(1);
        System.out.println("Tipo"+card.getType()+"Dmg"+card.getDmg());
    }
    
    /**
     * Método abstracto que realiza cambios en el jugador
     * @param dmg daño de la carta
     */
    public abstract void makeChanges(int dmg);
}
