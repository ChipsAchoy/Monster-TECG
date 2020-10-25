package monsterTecg.Logics.DesignPatterns;

/**
 *
 * @author Anthony Chaves Achoy
 */
public class Card {
    
    private String type;
    private int dmg;
    private int cost;
    
    /**
     * Constructor de la clase para cartas
     * @param type tipo de carta
     * @param dmg daño realizado
     * @param cost coste de mana
     */
    public Card(String type, int dmg, int cost){
        this.type = type;
        this.dmg = dmg;
        this.cost = cost;
    }
    
    /**
     * Genera un reporte del turno
     * @return el turno efectuado
     */
    public Turn perform(){

        //if (this.type == "minion"){
        return new Turn(this.type, this.dmg, this.cost);
        //}
        /*
        else if (this.type == "freeze"){
            return new FreezeTurn(this.dmg, this.cost)
        }
        */
    }
    
    public String getType(){
        return this.type;
    }
    public int getDmg(){
        return this.dmg;
    }

}
