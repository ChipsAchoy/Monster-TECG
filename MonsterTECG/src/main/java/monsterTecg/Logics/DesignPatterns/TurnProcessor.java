package monsterTecg.Logics.DesignPatterns;

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
        this.readJSON();
        FacadePerformer facade = null;
        if (this.type.equals("minion")){
            facade = new MinionFacade();
        }
        else if(this.type.equals("freeze")){
            facade = new FreezeFacade();
        }//Agregar los otros facades
        facade.makeChanges(this.dmg);
    }
}
