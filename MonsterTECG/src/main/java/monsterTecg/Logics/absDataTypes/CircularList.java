package monsterTecg.Logics.absDataTypes;

import monsterTecg.Logics.DesignPatterns.Card;

/**
 *
 * @author Anthony Chaves
 */
public class CircularList {
    private Node last;
    private int largo;
    
    /**
     * Constructor de la clase
     */
    public CircularList(){
        this.largo = 0;
        this.last = null;
    }
    
    public int getSize(){
        return this.largo;
    }
    
    /**
     * Agrega un elemento al final de la lista
     * @param card Carta que se agregara a la mano del jugador
     */
    public void addLast(Card card){
        this.largo ++;
        if (this.last == null){
            this.last = new Node(card);
            this.last.setNext(this.last);
            this.last.setPrev(this.last);
        }
        else{
            Node tmp = this.last;
            this.last = new Node(card);
            this.last.setNext(tmp.getNext());
            this.last.setPrev(tmp);
            tmp.setNext(this.last);
        }
    }
    /**
     * Muestra los elementos de la lista
     */
    public void printC(){
        System.out.println();
        Node tmp = this.last.getNext();
        while (tmp != this.last){
            System.out.print("<"+tmp.getData().getType()+">");
            tmp = tmp.getNext();
        }
        System.out.println("<"+this.last.getData().getType()+">");
        System.out.println(this.largo);
    }
    /**
     * Obtiene una carta segun su posicion en la lista
     * @param index posicion de la carta
     * @return carta encontrada en dicha posicion (retorna null si la posicion deseada es mayor al largo)
     */
    public Card getByIndex(int index){
        
        if((this.largo == 0)||(index >= this.largo)){
            return null;
        }
        
        else if(index == this.largo -1){
            return this.last.getData();
        }
        else{
            int position = 0;
            Node ref = this.last.getNext();
            while (position < index){
                if (position == index){
                    break;
                }
                position ++;
                ref = ref.getNext();
            }
            return ref.getData();
        }
    }
    
    /**
     * Elimina un nodo segun su posicion
     * @param index La posicion del nodo a eliminar
     */
    public void deleteByIndex(int index){
        if ((this.largo == 0)||(index >= this.largo)){
            System.out.println("Fuera de rango");
        }
        else if (index == 0){
            this.last.setNext(this.last.getNext().getNext());
            this.last.getNext().setPrev(this.last);
            this.largo --;
        }
        else if(index == this.largo-1){
            Node tmp = this.last;
            this.last = this.last.getPrev();
            this.last.setNext(tmp.getNext());
            this.largo --;
        }
        else{
            int position = 0;
            Node tmp = this.last.getNext();
            while (position < index){
                if (position == index-1){
                    break;
                }
                tmp = tmp.getNext();
                position ++;
            }
            tmp.setNext(tmp.getNext().getNext());
            tmp.getNext().getNext().setPrev(tmp);
            this.largo --;
        }
    }
    
    public Card[] toArray(){
        Card[] array = new Card[this.largo];
        Node tmp = this.last.getNext();
        int counter = 0;
        while (tmp != this.last){
            array[counter] = tmp.getData();
            tmp = tmp.getNext();
            counter++;
        }
        array[counter] = this.last.getData();
        System.out.println(array);
        return array;
    }
    
}
