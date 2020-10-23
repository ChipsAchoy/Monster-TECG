package monsterTecg.Logics.DesignPatterns;

/**
 *
 * @author Anthony Chaves
 */
public abstract class Turn {
    
    private int dmg;
    private int cost;
    
    public Turn(int dmg, int cost){
        this.dmg = dmg;
        this.cost = cost;
    }
    public abstract String generateJSON();
    
}
