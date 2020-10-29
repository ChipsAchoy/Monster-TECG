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
 * @author Anthony Chaves
 */
public class SendTurn implements ActionListener{
    private AppInterface frame;
    private int portRival;
    private String ipRival;
    
    public SendTurn(AppInterface frame,String ipRival,int portRival){
        this.ipRival = ipRival;
        this.portRival = portRival;
        this.frame = frame; 
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        PlayerManager pm = PlayerManager.getInstance();
        Card selected = pm.selected;
        if (!(pm.getTurns() > 0)){
            //thread del listener de la seleccion de la carta
            System.out.println("No hay mana suficiente");
        } 
        else if (pm.getMana() - selected.getCost() >= 0){
            Turn turn = new Turn(selected); //aca va la carta seleccionada
            //this.unlockMoves
            /*
            if (selected.getType().equals("heal")){ //Se va a resumir en el OwnEffect
                this.health += 150;
            }
            */
            frame.chat_space.append("Turno jugado: " + selected.getType() + "\n");
            pm.updateMana(selected.getCost());
            try {
                turn.SendJSON(this.ipRival, this.portRival);
            } catch (JsonProcessingException ex) {
                System.out.println(ex.getMessage());
            }
        }
        else{
            System.out.println("No hay mana suficiente");
        }
    }
    
}
