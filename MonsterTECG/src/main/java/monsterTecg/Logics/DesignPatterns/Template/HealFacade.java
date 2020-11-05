package monsterTecg.Logics.DesignPatterns.Template;

import monsterTecg.Logics.DesignPatterns.Template.FacadePerformer;

/**
 * Implementación de un caso particular para la carta heal
 * @author Anthony Chaves
 */
public class HealFacade extends FacadePerformer{
    /**
     * Facade que realiza los cambios en el jugador
     * @param dmg daño de la carta
     */
    @Override
    public void makeChanges(int dmg) {
        
        System.out.println("El rival se curo");
        
    }
    
}
