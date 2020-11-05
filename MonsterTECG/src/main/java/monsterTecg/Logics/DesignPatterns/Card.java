package monsterTecg.Logics.DesignPatterns;

/**
 * Implementacion para las cartas del jugador
 * @author Anthony Chaves Achoy
 */
public class Card {
    
    private String type;
    private int dmg;
    private int cost;
    private String img;
    
    /**
     * Constructor de la clase sin argumentos (necesario para Jackson)
     */
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
     * Devuelve el tipo de carta
     * @return String que contiene el tipo de carta
     */
    public String getType(){
        return this.type;
    }
    /**
     * Devuelve el daño que la carta puede realizar
     * @return valor numerico de daño
     */
    public int getDmg(){
        return this.dmg;
    }
    /**
     * Devuelve el costo de mana de la carta
     * @return valor del mana que gasta
     */
    public int getCost(){
        return this.cost;
    }
    /**
     * Devuelve la ruta donde se encuntra la imagen de la carta
     * @return String que contiene la ruta
     */
    public String getImg(){
        return this.img;
    }

}
