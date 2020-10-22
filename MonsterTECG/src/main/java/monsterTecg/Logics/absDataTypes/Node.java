package monsterTecg.Logics.absDataTypes;

import monsterTecg.Logics.DesignPatterns.Card;

/**
 *
 * @author Anthony Chaves
 */
public class Node {
    private Card card;
    private Node next;
    private Node prev;
    
    /**
     * Constructor de la clase
     * @param card 
     */
    public Node(Card card){
        this.card = card;
        this.next = null;
        this.prev = null;
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
    /**
     * Retorna la carta que se encuentra en el nodo
     * @return La carta asociada
     */
    public Card getData(){
        return this.card;
    }
    
    /**
     * Cambia el valor de la referencia al nodo anterior
     * @param prev nodo anterior
     */
    public void setPrev(Node prev){
        this.prev = prev;
    }
    
    /**
     * Devuelve la referencia al nodo anterior
     * @return Nodo anterior
     */
    public Node getPrev(){
        return this.prev;
    }
}
