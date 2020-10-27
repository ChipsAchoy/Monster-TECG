package monsterTecg.Logics;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.DesignPatterns.TurnProcessor;

/**
 *
 * @author Anthony Chaves Achoy
 */
public class MessageReceiver implements Runnable{
    
    private int portIn;
    
    public MessageReceiver(int portIn){
        this.portIn = portIn;
        
        Thread th = new Thread(this);
        th.start();
    }
    
    @Override
    public void run() {
        while (true) { //Tries to connect to the first available port
            Socket socketIn = null;
            try {
                ServerSocket servidor = new ServerSocket(this.portIn);
                System.out.println(this.portIn);
                ObjectMapper json = new ObjectMapper();
                while (true) { //Checks out if a message has been received
                    socketIn = servidor.accept();
                    ObjectInputStream cardrec = new ObjectInputStream(socketIn.getInputStream());
                    Card response = json.readValue((InputStream)cardrec, Card.class);
                    TurnProcessor turn = new TurnProcessor(response);
                    turn.PerformFacade();
                    PlayerManager.getInstance().playTurn(socketIn.getInetAddress().toString(), socketIn.getPort());
                }   
            }catch(Exception e){
                this.portIn++;
            }
            finally{
                if (socketIn != null){
                    try{
                        socketIn.close();
                    }
                    catch (IOException e4){ // This exception detects if the socket didn't close,so it writes it in the .txt.
                        
                    }
                }
            }
        }
    }
    
}
