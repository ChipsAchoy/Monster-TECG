/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterTecg.Logics.DesignPatterns;

/**
 *
 * @author Anthony Chaves
 */
public class AttackTurn extends Turn{
    
    public AttackTurn(int dmg, int cost){
        super(dmg, cost);
    }
    
    @Override
    public String generateJSON() {
        return "Working on";
    }
    
}
