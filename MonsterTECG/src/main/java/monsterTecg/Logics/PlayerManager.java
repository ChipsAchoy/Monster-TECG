package monsterTecg.Logics;

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
    
    private int mana = 200;
    private Stack deck;
    private CircularList hand = new CircularList();
    private int health = 1000;
    private int availableTurns = 1;
    private int sendPort;
    
    private static PlayerManager instance = null;
    
    private PlayerManager(int sendPort){
        this.sendPort = sendPort;
        MessageReceiver messages = new MessageReceiver(this.sendPort);
    }
    
    public static PlayerManager getInstance(int sendPort){
        if (instance == null){
            instance = new PlayerManager(sendPort);
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
    }
    
    public void updateHealth(int dmgDone){
        this.health -= dmgDone;
    }
    
    public void gameOver(){
        
        System.out.println("You lost");
    }
    
    public boolean alive(){
        return this.health > 0;
    }
    
    public void listener(){
        //if received
        //new TurnProcessor t
        //t.PerformFacade(json)
        //check if alive
        //PlayerManager.playTurn
        //else
        //Player.Manager gameOver
    }
    
    public void playTurn(String ipRival, int portRival){ //Listener de un boton
        Card selected = new Card("minions", 250, 50);
        if (!(this.availableTurns > 0)){
            //thread del listener de la seleccion de la carta
        } 
        else if (this.mana - selected.getCost() >= 0){
            Turn turn = new Turn(selected); //aca va la carta seleccionada
            //this.unlockMoves
            /*
            if (selected.getType().equals("heal")){ //Se va a resumir en el OwnEffect
                this.health += 150;
            }
            */
            this.updateMana(selected.getCost());
            try{
                turn.SendJSON(ipRival, portRival);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    
    }
    
    
    
}
