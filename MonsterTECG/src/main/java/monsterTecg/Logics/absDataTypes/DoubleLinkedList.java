package monsterTecg.Logics.absDataTypes;

import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.DesignPatterns.Turn;

/**
 * Implementacion de una lista doblemente enlazada
 * @author Anthony Chaves
 */
public class DoubleLinkedList {
    private Node first;
    private Node last;
    private int largo;
    
    /**
     * Constructor de la clase
     */
    public DoubleLinkedList(){
        this.first = null;
        this.last = null;
        this.largo = 0;
    }
    
    /**
     * Agrega un nodo al final de la lista
     * @param card carta que sera asociado al nodo
     */
    public void addLast(Card card){
        this.largo++;
        if (this.first == null){
            this.first = new Node(card);
            this.last = this.first;
        }else{
            Node tmp = this.last;
            this.last = new Node(card);
            tmp.setNext(this.last);
            this.last.setPrev(tmp);
        }
    }
    /**
     * Muestra los datos de la lista
     */
    public void printD(){
        Node tmp = this.first;
        while (tmp != null){
            System.out.print("<"+tmp+">");
            tmp = tmp.getNext();
        }
        System.out.println();
        System.out.println(this.largo);
    }
    /**
     * getByIndex permite obtener un valor de la lista segun su posicion
     * @param index posicion en la lista
     * @return valor deseado (en este caso un turno)
     */
    public Card getByIndex(int index){
        if((this.largo == 0)||(index >= this.largo)){
            return null;
        }
        
        else if (index == this.largo -1){
            return this.last.getData();
        }
        else{
            int position = 0;
            Node tmp = this.first;
            while (position < index){
                if (position == index){
                    break;
                }
                tmp = tmp.getNext();
                position++;
            }
            return tmp.getData();
        }
    }
    
    /**
     * Elimina un elemnto de la lista segun su posicion
     * @param index posicion del elemento a eliminar
     */
    public void deleteByIndex(int index){
        if((this.largo == 0)||(index >= this.largo)){
            System.out.println("Out of range");
        }
        else if(index == 0){
            this.first = this.first.getNext();
            this.first.setPrev(null);
        }
        else if (index == this.largo -1){
            this.last = this.last.getPrev();
            this.last.setNext(null);
            this.largo--;
        }
        else{
            int position = 0;
            Node tmp = this.first;
            while (position < index){
                if (position == index){
                    break;
                }
                tmp = tmp.getNext();
                position++;
            }
            tmp.getPrev().setNext(tmp.getNext());
            tmp.getNext().setPrev(tmp.getPrev());
            this.largo--;
        }
    }
}
