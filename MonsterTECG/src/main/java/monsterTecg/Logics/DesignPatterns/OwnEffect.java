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
        if ((this.type == "heal")/*||(this.type == "steal")*/){
            //Lanzar la carta que robo
            return true;
        }
        else{
            return false;
        }
    }
    
    public void Effect(){
        
        PlayerManager.getInstance().updateHealth(-200);

    }
}
