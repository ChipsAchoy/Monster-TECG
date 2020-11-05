package monsterTecg.Logics.DesignPatterns;

import monsterTecg.Logics.PlayerManager;

/**
 * Clase para validar si la carta tiene efectos sobre el jugador
 * @author Anthony Chaves
 */
public class OwnEffect {
    //public hasowwnEfect
    //getinstance and apply
    
    private String type;
    
    /**
     * Constructor de la clase
     * @param type tipo de la carta
     */
    public OwnEffect(String type){
        this.type = type;
    }
    
    /**
     * Valida si la carta tiene un efecto sobre el jugador
     * @return un boolean que indica si hay efectos en el jugador
     */
    public boolean hasOwnEffect(){
        if ((this.type.equals("heal"))/*||(this.type == "steal")*/){
            //Lanzar la carta que robo
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Realiza el efecto sobre el jugador
     */
    public void Effect(){
        //Condicional de si tiene vida maxima
        if (PlayerManager.getInstance().getHealth() + 300 >= 1000){
            PlayerManager.getInstance().setHealth(1000);
        }else{
            PlayerManager.getInstance().updateHealth(-300);
        }
        

    }
}
