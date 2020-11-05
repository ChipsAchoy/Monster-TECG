package monsterTecg.Logics.DesignPatterns.Template;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.DesignPatterns.Template.FacadePerformer;
import monsterTecg.Logics.DesignPatterns.Turn;
import monsterTecg.Logics.PlayerManager;

/**
 * Implementación de un caso particular para la carta freeze
 * @author Anthony Chaves
 */
public class FreezeFacade extends FacadePerformer{
    /**
     * Facade que realiza los cambios en el jugador
     * @param dmg daño de la carta
     */
    @Override
    public void makeChanges(int dmg) {
        PlayerManager.getInstance().selected = new Card("None",0,0, "");
        ActionEvent e = null;
        PlayerManager.getInstance().sendturn.actionPerformed(e);
        
    }
    
}
