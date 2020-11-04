package monsterTecg.Logics.DesignPatterns;

/**
 *
 * @author Anthony Chaves Achoy
 */
public class Card {
    
    private String type;
    private int dmg;
    private int cost;
    private String img;
    
    
    public Card(){
        
    }
    /**
     * Constructor de la clase para cartas
     * @param type tipo de carta
     * @param dmg daño realizado
     * @param cost coste de mana
     * @param img direccion de la imagen
     */
    public Card(String type, int dmg, int cost, String img){
        this();
        this.type = type;
        this.dmg = dmg;
        this.cost = cost;
        this.img = img;
    }
    
    /**
     * Genera un reporte del turno
     * @return el turno efectuado
     */
    public String getType(){
        return this.type;
    }
    public int getDmg(){
        return this.dmg;
    }
    public int getCost(){
        return this.cost;
    }
    public String getImg(){
        return this.img;
    }

}
