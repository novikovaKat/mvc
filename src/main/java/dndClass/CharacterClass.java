package dndClass;

import visitor.DataElement;
import visitor.DataElementsVisitor;

import java.util.TreeMap;

public abstract class CharacterClass implements DataElement {
    protected String name;
    protected int initialHP;

    public abstract void printMagica();

    public int getInitialHP() {
        return initialHP;
    }

    public String getName() {
        return name;
    }

    public String print(){
        return "Class: " + name + " uses " + initialHP + "D dice to roll up hp";

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
