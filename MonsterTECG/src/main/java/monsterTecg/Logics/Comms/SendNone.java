package monsterTecg.Logics.Comms;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import monsterTecg.Interface.AppInterface;
import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.DesignPatterns.Turn;
import monsterTecg.Logics.PlayerManager;

/**
 * ActionListener del boton para saltar el turno
 * @author Anthony Chaves Achoy
 */
public class SendNone implements ActionListener{
    private AppInterface frame;
    /**
     * Constructor de la clase
     * @param frame interfaz de la clase
     */
    public SendNone(AppInterface frame){
        this.frame = frame;
    }
    /**
     * Envia un turno nulo al otro jugador
     * @param e evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        PlayerManager.getInstance().selected = new Card("None",0,0,"");
        PlayerManager.getInstance().sendturn.actionPerformed(e);
    }
    
}
