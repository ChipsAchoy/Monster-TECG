package monsterTecg.Logics;

import monsterTecg.Logics.DesignPatterns.DeckGenerator;
import monsterTecg.Logics.DesignPatterns.Turn;
import monsterTecg.Logics.absDataTypes.CircularList;
import monsterTecg.Logics.absDataTypes.Stack;

/**
 *
 * @author Anthony Chaves
 */
public class PlayerManager {
    private static int mana = 200;
    private static Stack deck;
    private static CircularList hand = new CircularList();
    private static int health = 1000;
    private static int availableTurns;
    
    
    public static void setTurns(int turns){
        availableTurns = turns;
    }
    
    public static void updateMana(int cost){
        mana -= cost;
    }
    
    public static void setDeck(){
        DeckGenerator playerDeck = new DeckGenerator();
        deck = playerDeck.playerDeck();
        deck.printS();
    }
    
    public static void setHand(){
        for(int i=0; i<4; i++){
            hand.addLast(deck.pop());
        }
        deck.printS();
        hand.printC();
    }
    
    public static void updateHealth(int dmgDone){
        health -= dmgDone;
    }
    
    public void gameOver(){
        
        System.out.println("You lost");
    }
    
    public static boolean alive(){
        return health > 0;
    }
    
    public static void listener(){
        //if received
        //new TurnProcessor t
        //t.PerformFacade(json)
        //check if alive
        //PlayerManager.playTurn
        //else
        //Player.Manager gameOver
    }
    
    public static void playTurn(){ //Listener de un boton
        if (availableTurns > 0){
            //thread del listener de la seleccion de la carta
        } 
        else{
            Turn turn = new Turn("None",0,0);
        }
    
    }
    
    public static void SelectionListener(){
        
    }
    
    
}
