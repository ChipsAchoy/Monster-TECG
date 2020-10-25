package monsterTecg.Logics.DesignPatterns;

/**
 *
 * @author Anthony Chaves
 */
public class HealFacade implements FacadePerformer{

    @Override
    public void makeChanges(int dmg) {
        System.out.println("El rival se curo");
    }
    
}
