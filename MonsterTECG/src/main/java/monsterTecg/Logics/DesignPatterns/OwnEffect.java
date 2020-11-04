package monsterTecg.Logics.DesignPatterns;

import monsterTecg.Logics.PlayerManager;

/**
 *
 * @author Anthony Chaves
 */
public class OwnEffect {
    //public hasowwnEfect
    //getinstance and apply
    
    private String type;
    public OwnEffect(String type){
        this.type = type;
    }
    
    public boolean hasOwnEffect(){
        if ((this.type.equals("heal"))/*||(this.type == "steal")*/){
            //Lanzar la carta que robo
            return true;
        }
        else{
            return false;
        }
    }
    
    public void Effect(){
        //Condicional de si tiene vida maxima
        if (PlayerManager.getInstance().getHealth() + 300 >= 1000){
            PlayerManager.getInstance().setHealth(1000);
        }else{
            PlayerManager.getInstance().updateHealth(-300);
        }
        

    }
}
