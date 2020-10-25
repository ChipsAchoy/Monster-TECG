package monsterTecg.Logics.DesignPatterns;

import java.io.FileReader;
import monsterTecg.Logics.absDataTypes.CircularList;
import monsterTecg.Logics.absDataTypes.Stack;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Random; 

/**
 *
 * @author Anthony Chaves
 */
public class DeckGenerator {
    
    private Stack playerDeck;
    private CircularList minionsGen = new CircularList();
    private CircularList spellsGen = new CircularList();
    private CircularList trapsGen = new CircularList(); 
    
    public DeckGenerator(){
        
        JSONParser parser = new JSONParser();
        
        try {
            Object obj1 = parser.parse(new FileReader("minions.json"));
            JSONObject jsnobj1 = (JSONObject)obj1;
            System.out.println("JSON leido"+jsnobj1);
            
            Object obj2 = parser.parse(new FileReader("spells.json"));
            JSONObject jsnobj2 = (JSONObject)obj2;
            System.out.println("JSON leido"+jsnobj2);
            
            Object obj3 = parser.parse(new FileReader("traps.json"));
            JSONObject jsnobj3 = (JSONObject)obj3;
            System.out.println("JSON leido"+jsnobj3);
            
            JSONArray arrayminions = (JSONArray) jsnobj1.get("minions");
            JSONArray arrayspells = (JSONArray) jsnobj2.get("spells");
            JSONArray arraytraps = (JSONArray) jsnobj3.get("traps");
            
            for(int i=0; i<arrayminions.size(); i++){
                JSONObject current = (JSONObject) arrayminions.get(i);
                Card card = new Card(current.get("type").toString(), Integer.parseInt(current.get("damage").toString()), Integer.parseInt(current.get("cost").toString()));
                minionsGen.addLast(card);
            }
            
            for(int i=0; i<arrayspells.size(); i++){
                JSONObject current = (JSONObject) arrayspells.get(i);
                Card card = new Card(current.get("type").toString(), Integer.parseInt(current.get("damage").toString()), Integer.parseInt(current.get("cost").toString()));
                spellsGen.addLast(card);
            }
            
            for(int i=0; i<arraytraps.size(); i++){
                JSONObject current = (JSONObject) arraytraps.get(i);
                Card card = new Card(current.get("type").toString(), Integer.parseInt(current.get("damage").toString()), Integer.parseInt(current.get("cost").toString()));
                trapsGen.addLast(card);
            }
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    

    public Stack playerDeck(){
        //Idea
        //Tomar un valor random de las listas de arriba
        //Obtener la carta, eliminarla de la lista, resto 1 al maximo index
        //Sumar 6 cartas de cada tipo y pasar al siguiente
        //retornar el deck
        
        minionsGen.printC();
        spellsGen.printC();
        trapsGen.printC();
        
        playerDeck = new Stack();
        
        Random rand = new Random();
        int limit = 8;
        int selector = 0;
        for (int i=0; i<20; i++){
            
            if (selector == 0){
                int rnd = rand.nextInt(minionsGen.getSize());
                playerDeck.push(minionsGen.getByIndex(rnd));
            }
            else if(selector == 1){
                int rnd = rand.nextInt(spellsGen.getSize());
                playerDeck.push(spellsGen.getByIndex(rnd));
            }
            else{
                int rnd = rand.nextInt(trapsGen.getSize());
                playerDeck.push(trapsGen.getByIndex(rnd));
            }
            selector++;
            if (selector == 3){
                selector = 0;
            }
        }
        
        
        return playerDeck;
    }
}
