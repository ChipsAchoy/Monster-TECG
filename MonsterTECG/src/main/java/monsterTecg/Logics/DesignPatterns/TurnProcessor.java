package monsterTecg.Logics.DesignPatterns;

import monsterTecg.Logics.DesignPatterns.Template.BleedFacade;
import monsterTecg.Logics.DesignPatterns.Template.BreakerFacade;
import monsterTecg.Logics.DesignPatterns.Template.CrazyFacade;
import monsterTecg.Logics.DesignPatterns.Template.DeleteFacade;
import monsterTecg.Logics.DesignPatterns.Template.ElectrocuteFacade;
import monsterTecg.Logics.DesignPatterns.Template.FreezeFacade;
import monsterTecg.Logics.DesignPatterns.Template.FacadePerformer;
import monsterTecg.Logics.DesignPatterns.Template.HealFacade;
import monsterTecg.Logics.DesignPatterns.Template.MagicFacade;
import monsterTecg.Logics.DesignPatterns.Template.ManaCounterFacade;
import monsterTecg.Logics.DesignPatterns.Template.MinionFacade;
import monsterTecg.Logics.DesignPatterns.Template.MixFacade;
import monsterTecg.Logics.DesignPatterns.Template.StealFacade;
import monsterTecg.Logics.DesignPatterns.Template.WinFacade;
import monsterTecg.Logics.DesignPatterns.Template.WindFacade;
import monsterTecg.Logics.PlayerManager;
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
        PlayerManager.getInstance().locked = false;
        this.type = this.card.getType();
        this.dmg = this.card.getDmg();
        
        
        PlayerManager.getInstance().playedTurns.addLast(this.card);
        
        
        FacadePerformer facade = null;
        if ((this.type.equals("minion"))||(this.type.equals("fireball"))){
            facade = new MinionFacade();
        }
        else if(this.type.equals("freeze")){
            facade = new FreezeFacade();
        }//Agregar los otros facades
        else if(this.type.equals("heal")){
            facade = new HealFacade();
        }
        else if(this.type.equals("steal")){
            facade = new StealFacade();
        }
        else if(this.type.equals("electrocute")){
            facade = new ElectrocuteFacade();
        }
        else if(this.type.equals("wind")){
            facade = new WindFacade();
        }
        else if(this.type.equals("crazy")){
            facade = new CrazyFacade();
        }
        else if(this.type.equals("delete")){
            facade = new DeleteFacade();
        }
        else if(this.type.equals("manacounter")){
            facade = new ManaCounterFacade();
        }
        else if(this.type.equals("magic")){
            facade = new MagicFacade();
        }
        else if(this.type.equals("bleed")){
            facade = new BleedFacade();
        }
        else if(this.type.equals("breaker")){
            facade = new BreakerFacade();
        }
        else if(this.type.equals("mix")){
            facade = new MixFacade();
        }
        else if(this.type.equals("Win")){
            facade = new WinFacade();
        }
        
        if (!this.type.equals("None")){
            facade.showCard(this.card);
            facade.makeChanges(this.dmg);
        }

        System.out.println("HP: "+PlayerManager.getInstance().getHealth());
        System.out.println("Mana: "+PlayerManager.getInstance().getMana());
        
        
        
        if (!PlayerManager.getInstance().alive()){
            PlayerManager.getInstance().setHealth(0);
            PlayerManager.getInstance().gameOver();
        }
        
        PlayerManager.getInstance().updateStats();
    }
}
