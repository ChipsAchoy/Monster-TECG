package monsterTecg.Logics.Comms;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import monsterTecg.Interface.AppInterface;
import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.DesignPatterns.Turn;
import monsterTecg.Logics.PlayerManager;

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
        if (!pm.locked){
            
            if (pm.getMana() - selected.getCost() >= 0){
                PlayerManager.getInstance().locked = true;
                Turn turn = new Turn(selected); //aca va la carta seleccionada
                
                pm.playedTurns.addLast(selected);
                
                if (!selected.equals("Win")){
                    this.frame.textArea.append("Turno jugado: " + "Tipo: "+ selected.getType()+ "\nDaño: "+ Integer.toString(selected.getDmg()) + "\nManá: "+ Integer.toString(selected.getCost()) +"\n");
                }else{
                    this.frame.textArea.append("Usted pierde");
                }
                pm.updateMana(selected.getCost());
                this.frame.info1.setText("Turno del rival");
                if (!selected.getType().equals("None")){
                    if (pm.getHand().getSize()-1 == 0){
                        pm.getHandUpdate().deleteByIndex(pm.selectedIndex);
                    }else{
                        pm.getHand().deleteByIndex(pm.selectedIndex);
                    }   
                }
                
                pm.selected = pm.getHand().getByIndex(0);
                pm.selectedIndex = 0;
                pm.updateCurrent();
                
                //this.frame.listaCards.setListData(PlayerManager.getInstance().getHand().toArray());
                
                
                try {
                    turn.SendJSON(this.ipRival, this.portRival);
                } catch (JsonProcessingException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            else{
                this.frame.info2.setText("No hay maná suficiente");
            }
        }
    }
}
