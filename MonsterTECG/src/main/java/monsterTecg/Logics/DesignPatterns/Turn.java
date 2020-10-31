package monsterTecg.Logics.DesignPatterns;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import monsterTecg.Logics.PlayerManager;

/**
 *
 * @author Anthony Chaves
 */
public class Turn {
    
    private Card card;
    
    public Turn(Card card){
        this.card = card;
    }
    
    
    public void SendJSON(String ip, int port) throws JsonProcessingException{
        /**
         * https://www.baeldung.com/jackson-object-mapper-tutorial
         * http://tutorials.jenkov.com/java-json/jackson-objectmapper.html
         */
        OwnEffect own = new OwnEffect(this.card.getType());
        if (own.hasOwnEffect()){
            own.Effect();
        }
        
        if (PlayerManager.getInstance().getTurns()>0){
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
