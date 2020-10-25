package monsterTecg.Logics.DesignPatterns;

import monsterTecg.Logics.PlayerManager;

/**
 *
 * @author Anthony Chaves
 */
public class Turn {
    
    private String type;
    private int dmg;
    private int cost;
    
    public Turn(String type,int dmg, int cost){
        this.type = type;
        this.dmg = dmg;
        this.cost = cost;
    }
    
    public void updateMana(){
        PlayerManager.updateMana(this.cost);
    }
    
    public String generateJSON(){
        return "Working on";
    }
    
}
