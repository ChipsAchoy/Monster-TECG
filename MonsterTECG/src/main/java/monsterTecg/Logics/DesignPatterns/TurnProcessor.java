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
    
    public TurnProcessor(){
        
    }
    
    private void readJSON(String json){
        JSONParser parser = new JSONParser();
    }
    
    public void PerformFacade(String json){
        this.readJSON(json);
        FacadePerformer facade = null;
        if (this.type.equals("minion")){
            facade = new MinionFacade();
        }
        else if(this.type.equals("freeze")){
            facade = new FreezeFacade();
        }
        facade.makeChanges(this.dmg);
    }
}
