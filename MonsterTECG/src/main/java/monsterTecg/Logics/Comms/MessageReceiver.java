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
import monsterTecg.Logics.PlayerManager;

/**
 * Clase que permite correr un hilo para recibir mensajes
 * @author Anthony Chaves Achoy
 */
public class MessageReceiver implements Runnable{
    
    private int portIn;
    private AppInterface frame;
    
    /**
     * Constructor de la clase
     * @param portIn puerto en el que se recibe
     * @param frame interfaz de juego
     */
    public MessageReceiver(int portIn, AppInterface frame){
        this.frame = frame;
        this.portIn = portIn;
        
        Thread th = new Thread(this);
        th.start();
    }
    
    /**
     * Metodo asociado al thread que espera por mensajes
     */
    @Override
    public void run() {
        while (true) { //Tries to connect to the first available port
            Socket socketIn = null;
            try {
                ServerSocket servidor = new ServerSocket(this.portIn);
                PlayerManager.getInstance().inPort = this.portIn;
                System.out.println(this.portIn);
                ObjectMapper json = new ObjectMapper().configure(Feature.AUTO_CLOSE_SOURCE, false);
                
                while (true) { //Checks out if a message has been received
                    socketIn = servidor.accept();
                    InputStream cardrec = new ObjectInputStream(socketIn.getInputStream());
                    
                    Card response = json.readValue(cardrec, Card.class);
                    System.out.println(response.getType() + ","+response.getDmg());
                    
                    
                    if (response.getType().equals("Start")){
                        System.out.println("Recibido, abriendo puerto");
                        PlayerManager.getInstance().ipSend = socketIn.getLocalAddress().toString().substring(1);
                        
                        PlayerManager.getInstance().portSend = response.getDmg();
                        System.out.println(PlayerManager.getInstance().portSend+PlayerManager.getInstance().ipSend);
                        
                        PlayerManager.getInstance().initPort();
                    }else{
                        TurnProcessor turn = new TurnProcessor(response);
                        turn.PerformFacade();
                    }
                    
                    if (!(response.getType().equals("freeze")||response.getType().equals("electrocute")||response.getType().equals("crazy"))){
                        this.frame.info1.setText("Es su turno");
                    }
                    
                    if (!response.getType().equals("Win")){
                        this.frame.textArea.append("Turno Rival: \n" + "Tipo: "+ response.getType()+ "\nDaño: "+ Integer.toString(response.getDmg())+ "\nManá: "+ Integer.toString(response.getCost()) + "\n\n");
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
            
        }
    }
    
}
