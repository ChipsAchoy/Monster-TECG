package monsterTecg.Logics.DesignPatterns;

import monsterTecg.Logics.absDataTypes.DoubleLinkedList;
import monsterTecg.Logics.absDataTypes.Stack;

/**
 *
 * @author Anthony Chaves
 */
public class DeckGenerator {
    
    private String[] spells = {"freeze", "heal", "supreme", "steal", "burn"};
    private String[] traps = {"mana", "random"};
    
    private DoubleLinkedList minionsGen;
    private DoubleLinkedList spellsGen;
    private DoubleLinkedList trapsGen;
    
    public DeckGenerator(){
        //Idea
        //Generar 13 cartas de cada tipo con stats random
        //Guardar cada 13 en una de las listas de arriba
        
    }
    
    public Stack playerDeck(){
        //Idea
        //Tomar un valor random de las listas de arriba
        //Obtener la carta, eliminarla de la lista, resto 1 al maximo index
        //Sumar 6 cartas de cada tipo y pasar al siguiente
        //retornar el deck
        return null;
    }
}
