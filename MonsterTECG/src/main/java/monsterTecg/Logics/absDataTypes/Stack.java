package monsterTecg.Logics.absDataTypes;

import monsterTecg.Logics.DesignPatterns.Card;

/**
 *
 * @author Anthony Chaves
 */
public class Stack {
    private SimpleList list;
    /**
     * Agrega un nuevo elemento a la pila
     * @param card Carta que se coloca en el top
     */
    public void push(Card card){
        this.list.addFirst(card);
        
    }
    /**
     * Retorna el elemento en el top sin eliminarlo
     * @return La ultima carta que se agrega
     */
    public Card peek(){
        return this.list.getHead().getData();
    }
    /**
     * Elimina el elemento en el top
     * @return La carta que se encuentra en el top para luego eliminarla
     */
    public Card pop(){
        Node actualHead = this.list.getHead();
        this.list.deleteFirst();
        return actualHead.getData();
    }
    /**
     * Muestra los valores de la pila
     */
    public void printS(){
        this.list.printL();
    }
}
