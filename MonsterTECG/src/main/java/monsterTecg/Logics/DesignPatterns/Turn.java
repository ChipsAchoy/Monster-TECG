package monsterTecg.Logics.DesignPatterns;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import monsterTecg.Logics.PlayerManager;

/**
 * Clase para enviar un turno al otro jugador
 * @author Anthony Chaves
 */
public class Turn {
    
    private Card card;
    
    /**
     * Constructor de la clase
     * @param card carta que será enviada
     */
    public Turn(Card card){
        this.card = card;
    }
    
    /**
     * Envia un JSON al otro jugador
     * @param ip dirección ip a la que se envía la carta
     * @param port ´puerto al que se envía la carta
     * @throws JsonProcessingException 
     */
    public void SendJSON(String ip, int port) throws JsonProcessingException{
        OwnEffect own = new OwnEffect(this.card.getType());
        if (own.hasOwnEffect()){
            own.Effect();
        }
        
        if (PlayerManager.getInstance().getTurns()>=0){
            PlayerManager.getInstance().updateStats();
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(this.card);
            System.out.println(json);

            //Card card2 = objectMapper.readValue(json, Card.class);
            //System.out.println(card2);

            Socket socketOut = null;
            
            try {

                socketOut = new Socket(ip, port);
                ObjectOutputStream dataSend = new ObjectOutputStream(socketOut.getOutputStream());
                objectMapper.writeValue((OutputStream)dataSend, this.card);
                
                
                //dataSend.writeObject(pk);
            }catch(Exception e){

                System.out.println(e.getMessage());
            }
            
        }else{
            System.out.println("No hay turnos");
        }
        
        
    }
   
    
}
