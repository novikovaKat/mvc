package dndRace;

import character.Stats;
import visitor.DataElement;
import visitor.DataElementsVisitor;

import java.util.Set;
import java.util.TreeMap;

public abstract class CharacterRace implements DataElement {
    protected String name;
    protected Stats bonuses;

    public CharacterRace(String name, Stats bonuses) {
        this.name = name;
        this.bonuses = bonuses;
    }

    public Stats getBonuses(){
        return bonuses;
    }

    public String getName() {
        return name;
    }

    public void printBonuses(){
        Set<String> keys = this.bonuses.getAttributes().keySet();

        System.out.println("-------Bonuses-------");

        for (String title: keys) {
            if(bonuses.getAttributes().get(title)!=0){
                System.out.println(title + ": " + bonuses.getAttributes().get(title));
            }
        }

        System.out.println("---------------------");
    }

    public void saySMTH() {

    }

    @Override
    public String toString() {
        return name;
    }

    
    @Override
    public TreeMap access(DataElementsVisitor visitor) {
        return visitor.visit(this);
    }
}
