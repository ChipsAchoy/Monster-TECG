package monsterTecg.Logics;

import monsterTecg.Logics.Comms.MessageReceiver;
import monsterTecg.Logics.Comms.SendTurn;
import javax.swing.ListSelectionModel;
import monsterTecg.Interface.AppInterface;
import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.DesignPatterns.DeckGenerator;
import monsterTecg.Logics.DesignPatterns.Turn;
import monsterTecg.Logics.absDataTypes.CircularList;
import monsterTecg.Logics.absDataTypes.Stack;

/**
 *
 * @author Anthony Chaves
 */
public class PlayerManager {
    
    private int mana = 500;
    private Stack deck;
    private CircularList hand = new CircularList();
    private int health = 1000;
    private int availableTurns = 1;
    private int inPort;
    private boolean locked = true;
    private AppInterface frame;
    
    public Card selected;
    
    private static PlayerManager instance = null;
    
    private PlayerManager(int inPort, AppInterface frame){
        this.frame = frame;
        
        this.inPort = inPort;
        
        
        GrabCard newone = new GrabCard(frame);

        this.frame.boton2.addActionListener(newone);

        SendTurn evento = new SendTurn(frame, "127.0.0.1", 12002);

        this.frame.miboton.addActionListener(evento);

        ListReact lr = new ListReact(frame);

        this.frame.listaCards.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.frame.listaCards.addListSelectionListener(lr);
        
    }
    
    public static PlayerManager getInstance(int inPort, AppInterface frame){
        if (instance == null){
            
            instance = new PlayerManager(inPort, frame);
            
            MessageReceiver messages = new MessageReceiver(inPort, frame);
        }
        return instance;
    }
    
    public static PlayerManager getInstance(){
        return instance;
    }
    
    public void setTurns(int turns){
        this.availableTurns = turns;
    }
    
    public void updateMana(int cost){
        this.mana -= cost;
        this.mana += 250;
        if (this.mana > 1000){
            this.mana = 1000;
        }
    }
    
    public void setDeck(){
        DeckGenerator playerDeck = new DeckGenerator();
        this.deck = playerDeck.playerDeck();
        this.deck.printS();
    }
    
    public void setHand(){
        for(int i=0; i<4; i++){
            this.hand.addLast(deck.pop());
        }
        this.deck.printS();
        this.hand.printC();
        
        this.frame.listaCards.setListData(this.hand.toArray());
    }
    
    public CircularList getHand(){
        return this.hand;
    }
    
    public CircularList getHandUpdate(){
        this.hand.addLast(this.deck.pop());
        return this.hand;
    }
    
    public void updateHealth(int dmgDone){
        this.health -= dmgDone;
    }
    
    public int getTurns(){
        return this.availableTurns;
    }
    
    public int getMana(){
        return this.mana;
    }
    
    public void gameOver(){
        
        System.out.println("You lost");
    }
    
    public boolean alive(){
        return this.health > 0;
    }
    
}
