package monsterTecg.Logics.absDataTypes;

import monsterTecg.Logics.DesignPatterns.Card;

/**
 *
 * @author Anthony Chaves
 * Implementacion de una Lista simple enlazada cuyos objetos son de la clase Card
 */
public class LinkedList {
    
    private Node head;
    private int largo;
    
    /**
     * Constructor de la clase
     */
    public LinkedList(){
        this.head = null;
        this.largo = 0;
    }
    /**
     * addFirst permite agregar a la primera posicion de la lista
     * @param card Carta que se agrega como head
     */
    public void addFirst(Card card){
        this.largo ++;
        if (this.head == null){
            this.head = new Node(card);
        }
        else{
            Node tmp = this.head;
            this.head = new Node(card);
            this.head.setNext(tmp);
        }
    }
    /**
     * printL permite ver el contenido de la lista
     */
    public void printL(){
        Node tmp = this.head;
        while (tmp != null){
            System.out.print("<"+tmp+">");
            tmp = tmp.getNext();
        }
        System.out.println();
        System.out.println(this.largo);
    }
    /**
     * deleteFirst elimina el primer elemento de la lista y sustituye head
     */
    public void deleteFirst(){
        this.largo --;
        if (this.head != null){
            this.head = this.head.getNext();
        }
    }
    /**
     * Permite ver la primera posicion de la lista
     * @return la cabeza de la lista
     */
    public Node getHead(){
        return this.head;
    }
}
