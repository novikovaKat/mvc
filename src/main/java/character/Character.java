package character;


import visitor.DataElement;
import visitor.DataElementsVisitor;
import dndClass.CharacterClass;
import dndRace.CharacterRace;

import java.util.Set;
import java.util.TreeMap;

public class Character implements DataElement {
    private String name;
    private CharacterClass dndClass;
    private CharacterRace race;
    private Stats stats;
    private int health;

    public Character(String name, CharacterClass dndClass, CharacterRace race, Stats stats) {
        this.name = name;
        this.dndClass = dndClass;
        this.race = race;
        this.health = dndClass.getInitialHP();
        this.stats = stats;
    }
   
    public void addBonuses(){
        Set<String> keys = this.stats.getAttributes().keySet();
        for (String title: keys) {
            stats.getAttributes().put(title, stats.getAttributes().get(title) + race.getBonuses().getAttributes().get(title));
        }
        this.health+=Math.floor(this.stats.getAttributes().get("Constitution")/2 -5);
    }
    public String getName() {
        return name;
    }

    public CharacterClass getDndClass() {
        return dndClass;
    }

    public CharacterRace getRace() {
        return race;
    }

    public Stats getStats() {
        return stats;
    }

    public int getHealth() {
        return health;
    }
    
     public void setName(String name) {
        this.name = name;
    }

    public void setDndClass(CharacterClass dndClass) {
        this.dndClass = dndClass;
    }

    public void setAttributes(Stats attributes) {
        this.stats = attributes;
    }
    
     public void printSheet(){
        System.out.println("Name: " + name);
        System.out.println("Race: " + race.getName());
        stats.print();
    }

    @Override
    public TreeMap access(DataElementsVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Class: " + dndClass + ", Race: " + race + ", Health=" + health ;
    }
    
    
}
