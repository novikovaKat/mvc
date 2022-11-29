package character;


import character.Dice;
import visitor.DataElement;
import visitor.DataElementsVisitor;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class Stats implements DataElement, Cloneable{
    private HashMap<String, Integer> attributes;

    public Stats(){
        attributes = new HashMap<>();
    }

    public HashMap<String, Integer> getAttributes() {
        return attributes;
    }

    public Stats(int strength, int dexterity, int constitution, int intellect, int wisdom, int charisma){
        this();
        attributes.put("Strength" , strength);
        attributes.put("Dexterity" , dexterity);
        attributes.put("Constitution" , constitution);
        attributes.put("Intellect" , intellect);
        attributes.put("Wisdom" , wisdom);
        attributes.put("Charisma" , charisma);
    }
    
   
    public static Stats copyStats(Stats stats){
        Stats copy = new Stats();
        copy.attributes.put("Strength" , stats.attributes.get("Strength"));
        copy.attributes.put("Dexterity" , stats.attributes.get("Dexterity"));
        copy.attributes.put("Constitution" , stats.attributes.get("Constitution"));
        copy.attributes.put("Intellect" , stats.attributes.get("Intellect"));
        copy.attributes.put("Wisdom" , stats.attributes.get("Wisdom"));
        copy.attributes.put("Charisma" , stats.attributes.get("Charisma"));
        return copy;
    }
    
    public void generate(){
        Dice dice = new Dice();

        attributes.put("Strength" , dice.rollStat());
        attributes.put("Dexterity" , dice.rollStat());
        attributes.put("Constitution" , dice.rollStat());
        attributes.put("Intellect" , dice.rollStat());
        attributes.put("Wisdom" , dice.rollStat());
        attributes.put("Charisma" , dice.rollStat());

    }

    public String print(){
        //System.out.println("Attributes:");
        String result="";
        Set<String> keys = this.attributes.keySet();
        for (String title: keys) {
            result+=title + ": " + attributes.get(title) + "\n";
        }
        return result;
    }

    @Override
    public TreeMap access(DataElementsVisitor visitor) {
       return visitor.visit(this);
    }
  
}
