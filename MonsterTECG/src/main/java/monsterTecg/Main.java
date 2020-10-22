package monsterTecg;

import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.absDataTypes.CircularList;
import monsterTecg.Logics.absDataTypes.LinkedList;
import monsterTecg.Logics.absDataTypes.Stack;

/**
 *
 * @author Anthony Chaves y Christopher Castro
 */
public class Main {
    public static void main(String[] args){
        CircularList c1 = new CircularList();
        
        
        
        c1.addLast(new Card());
        c1.addLast(new Card());
        
        Card cc = new Card();
        c1.addLast(cc);
        System.out.println(cc);
        
        c1.addLast(new Card());
        
        c1.printC();
        
        c1.deleteByIndex(3);
        
        c1.printC();
        
        System.out.println(c1.getByIndex(2));
    }
}
