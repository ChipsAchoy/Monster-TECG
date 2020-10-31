package monsterTecg.Logics.DesignPatterns;

import monsterTecg.Logics.DesignPatterns.Template.FreezeFacade;
import monsterTecg.Logics.DesignPatterns.Template.FacadePerformer;
import monsterTecg.Logics.DesignPatterns.Template.MinionFacade;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Anthony Chaves
 */
public class TurnProcessor {
    //Procesa los turnos del jugador
    
    private String type;
    private int dmg;
    private Card card;
    
    public TurnProcessor(Card card){
        this.card = card;
    }
    
    private void readJSON(){
        JSONParser parser = new JSONParser();
    }
    
    public void PerformFacade(){
        //this.readJSON();
        this.type = this.card.getType();
        this.dmg = this.card.getDmg();
        
        FacadePerformer facade = null;
        if ((this.type.equals("minion"))||(this.type.equals("fireball"))){
            facade = new MinionFacade();
        }
        else if(this.type.equals("freeze")){
            facade = new FreezeFacade();
        }//Agregar los otros facades
        
        facade.showCard(this.card);
        facade.makeChanges(this.dmg);
    }
}
