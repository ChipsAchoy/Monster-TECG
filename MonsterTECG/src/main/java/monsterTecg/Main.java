package monsterTecg;

import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.absDataTypes.SimpleList;

/**
 *
 * @author Anthony Chaves y Christopher Castro
 */
public class Main {
    public static void main(String[] args){
        SimpleList l1 = new SimpleList();
        l1.addFirst(new Card());
        l1.addFirst(new Card());
        l1.addFirst(new Card());
        
        l1.printL();
        
        l1.deleteFirst();
        
        l1.printL();
    }
}
