package monsterTecg.Logics.Comms;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import monsterTecg.Interface.AppInterface;
import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.DesignPatterns.TurnProcessor;

/**
 *
 * @author Anthony Chaves Achoy
 */
public class MessageReceiver implements Runnable{
    
    private int portIn;
    private AppInterface frame;
    
    public MessageReceiver(int portIn, AppInterface frame){
        this.frame = frame;
        this.portIn = portIn;
        
        Thread th = new Thread(this);
        th.start();
    }
    
    @Override
    public void run() {
        //while (true) { //Tries to connect to the first available port
            Socket socketIn = null;
            try {
                ServerSocket servidor = new ServerSocket(this.portIn);
                System.out.println(this.portIn);
                ObjectMapper json = new ObjectMapper().configure(Feature.AUTO_CLOSE_SOURCE, false);
                
                while (true) { //Checks out if a message has been received
                    socketIn = servidor.accept();
                    InputStream cardrec = new ObjectInputStream(socketIn.getInputStream());
                    
                    Card response = json.readValue(cardrec, Card.class);
                    System.out.println(response.getType() + ","+response.getDmg());
                    TurnProcessor turn = new TurnProcessor(response);
                    turn.PerformFacade();
                    
                    this.frame.info1.setText("Es su turno");
                    
                    if (!response.getType().equals("Win")){
                        this.frame.textArea.append("Turno Rival: " + "Tipo: "+ response.getType()+ "\nDaño: "+ Integer.toString(response.getDmg())+ "\nManá: "+ Integer.toString(response.getCost()) + "\n");
                    }else{
                        this.frame.textArea.append("Usted gana!");
                        this.frame.info2.setText("Usted gana!");
                    }
                    socketIn.close();
                }   
            }catch(BindException e){
                this.portIn++;
                System.out.println(e);
            }
            catch (Exception e1){
                System.out.println(e1);
            }
            
        //}
    }
    
}