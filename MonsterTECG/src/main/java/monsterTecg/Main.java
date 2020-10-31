package monsterTecg;

import javax.swing.JFrame;
import monsterTecg.Interface.AppWindow;
import monsterTecg.Logics.DesignPatterns.Card;
import monsterTecg.Logics.DesignPatterns.Turn;
import monsterTecg.Logics.PlayerManager;
import monsterTecg.Logics.absDataTypes.CircularList;
import monsterTecg.Logics.absDataTypes.DoubleLinkedList;
import monsterTecg.Logics.absDataTypes.LinkedList;
import monsterTecg.Logics.absDataTypes.Stack;

/**
 *
 * @author Anthony Chaves y Christopher Castro
 */
public class Main {
    public static void main(String[] args){
        AppWindow window = new AppWindow();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
