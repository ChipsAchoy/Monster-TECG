package monsterTecg.Logics;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import monsterTecg.Logics.Comms.MessageReceiver;
import monsterTecg.Logics.Comms.SendTurn;
import javax.swing.ListSelectionModel;
import monsterTecg.Interface.AppInterface;
import monsterTecg.Interface.MenuWindow;
import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.DesignPatterns.DeckGenerator;
import monsterTecg.Logics.DesignPatterns.Turn;
import monsterTecg.Logics.absDataTypes.CircularList;
import monsterTecg.Logics.absDataTypes.DoubleLinkedList;
import monsterTecg.Logics.absDataTypes.Stack;

/**
 *
 * @author Anthony Chaves
 * Implementacion de un singleton que maneja los distintos atributos del jugador
 * Proporciona un acceso global
 */
public class PlayerManager {
    
    private int mana = 200;
    private Stack deck;
    private CircularList hand = new CircularList();
    private int health = 1000;
    private int availableTurns = 1;
    public int deckSize = 16;
    public boolean locked;
    public DoubleLinkedList playedTurns = new DoubleLinkedList();
    private AppInterface frame;
    
    public int inPort;
    public int portSend = 12002;
    public String ipSend = "127.0.0.1";
    public SendTurn sendturn;
    
    public Card selected;
    public int selectedIndex; 
    
    //Instancia unica de la clase
    private static PlayerManager instance = null;
    private MenuWindow mw;
    
    /**
     * Constructor de la clase
     * @param inPort puerto inicial de la busqueda
     * @param frame interfaz del juego
     * @param lock variable que indica el turno
     * @param mw ventana del cliente
     */
    private PlayerManager(int inPort, AppInterface frame, boolean lock, MenuWindow mw){
        this.frame = frame;
        
        this.mw = mw;
        
        this.inPort = inPort;
        
        this.locked = lock;
        
        if (!this.locked){
            this.frame.info1.setText("Es su turno");
        }else{
            this.frame.info1.setText("Turno del rival");
        }
        
        GrabCard newone = new GrabCard(frame);

        this.frame.deck.addActionListener(newone);

        ListReact lr = new ListReact(frame);

        this.frame.listaCards.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.frame.listaCards.addListSelectionListener(lr);
        
        MoveNext mn = new MoveNext(frame);

        this.frame.right.addActionListener(mn);
        
        MovePrev mp = new MovePrev(frame);

        this.frame.left.addActionListener(mp);
        
        SendNone sn = new SendNone(frame);

        this.frame.pass.addActionListener(sn);
        
    }
    
    /**
     * Metodo estatico para obtener la instancia con sus atributos
     * @param inPort puerto inicial de la busqueda
     * @param frame interfaz del juego
     * @param lock variable que indica el turno
     * @param mw ventana del cliente
     * @return la instancia unica de la clase
     */
    public static PlayerManager getInstance(int inPort, AppInterface frame, boolean lock, MenuWindow mw){
        if (instance == null){
            
            instance = new PlayerManager(inPort, frame, lock, mw);
            
            MessageReceiver messages = new MessageReceiver(inPort, frame);
        }
        return instance;
    }
    
    /**
     * 
     * @return 
     */
    public static PlayerManager getInstance(){
        return instance;
    }
    
    public void initPort(){
        
        this.mw.dispose();
        
        SendTurn evento = new SendTurn(this.frame, this.ipSend, this.portSend);
        
        this.sendturn = evento;

        this.frame.carta.addActionListener(evento);
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
    
    public void updateStats(){
        this.frame.hp.setText("HP: "+Integer.toString(this.health));
        this.frame.mana.setText("Mana: "+Integer.toString(this.mana));
    }
    
    public void updateCurrent(){
        this.frame.icon = new ImageIcon(this.selected.getImg());
        this.frame.carta.setIcon(this.frame.icon);
    }
    
    public void setDeck(){
        DeckGenerator playerDeck = new DeckGenerator();
        this.deck = playerDeck.playerDeck();
        //this.deck.printS();
        this.frame.deckC.setText(Integer.toString(this.deckSize));
    }
    
    public void setHand(){
        for(int i=0; i<4; i++){
            this.hand.addLast(deck.pop());
        }
        this.deck.printS();
        this.hand.printC();
        
        this.frame.listaCards.setListData(this.hand.toArray());
    }
    
    public Stack getDeck(){
        return this.deck;
    }
    
    public CircularList getHand(){
        return this.hand;
    }
    
    public CircularList getHandUpdate(){
        this.hand.addLast(this.deck.pop());
        return this.hand;
    }
    
    public int getHealth(){
        return this.health;
    }
    
    public void setHealth(int hp){
        this.health = hp;
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
        
        ActionEvent e = null;
        this.selected = new Card("Win", 0,0,"");
        this.sendturn.actionPerformed(e);
        this.locked = true;
    }
    
    public void Winner(){
        this.locked = true;
    }
    
    public boolean alive(){
        return this.health > 0;
    }
    
    
}
