package monsterTecg.Logics;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import monsterTecg.Interface.AppInterface;
import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.DesignPatterns.Turn;

/**
 *
 * @author Anthony Chaves Achoy
 */
public class SendNone implements ActionListener{
    private AppInterface frame;
    public SendNone(AppInterface frame){
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        PlayerManager.getInstance().selected = new Card("None",0,0,"");
        PlayerManager.getInstance().sendturn.actionPerformed(e);
    }
    
}
