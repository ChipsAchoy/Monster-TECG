package monsterTecg.Logics;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import monsterTecg.Interface.AppInterface;
import monsterTecg.Logics.DesignPatterns.Card;

/**
 * Listener para la JList de la interfaz
 * @author Anthony Chaves
 */
public class ListReact implements ListSelectionListener{
    private AppInterface frame;
    public int currentIndex;
    
    /**
     * Constructor de la clase
     * @param frame interfaz de juego
     */
    public ListReact(AppInterface frame){
        this.frame = frame;
    }
    
    /**
     * Metodo que actua al cambiar la lista 
     * @param e evento
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!this.frame.listaCards.isSelectionEmpty()) {
            this.currentIndex = this.frame.listaCards.getSelectedIndex();
            
            PlayerManager.getInstance().selected = (Card)this.frame.listaCards.getSelectedValue();
            PlayerManager.getInstance().selectedIndex = this.currentIndex;
            System.out.println(PlayerManager.getInstance().selected.getType());
        }        
    }
    
}
