package monsterTecg.Logics.absDataTypes;

import monsterTecg.Logics.DesignPatterns.Card;

/**
 *
 * @author Anthony Chaves
 */
public class Node {
    private Card card;
    private Node next;
    
    /**
     * Constructor de la clase
     * @param card 
     */
    public Node(Card card){
        this.card = card;
        this.next = null;
    }
    /**
     * Metodo get del atributo next
     * @return el nodo siguiente 
     */
    public Node getNext(){
        return this.next;
    }
    /**
     * Metodo set del atributo next
     * @param next Nodo siguiente
     */
    public void setNext(Node next){
        this.next = next;
    }
    
    public Card getData(){
        return this.card;
    }
}
