package monsterTecg.Logics;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import monsterTecg.Interface.AppInterface;
import monsterTecg.Logics.DesignPatterns.Card;

/**
 *
 * @author Anthony Chaves
 */
public class ListReact implements ListSelectionListener{
    private AppInterface frame;
    public int currentIndex;
    public ListReact(AppInterface frame){
        this.frame = frame;
    }
    
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
