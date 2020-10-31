package monsterTecg.Logics.DesignPatterns.Template;

import monsterTecg.Logics.DesignPatterns.Template.FacadePerformer;

/**
 *
 * @author Anthony Chaves
 */
public class HealFacade extends FacadePerformer{

    @Override
    public void makeChanges(int dmg) {
        
        System.out.println("El rival se curo");
        
    }
    
}
