package visitor;

import dndRace.CharacterRace;
import dndClass.CharacterClass;
import character.Character;
import character.Stats;

import java.util.TreeMap;

public interface DataElementsVisitor {
    TreeMap visit(Character character);
    TreeMap visit(CharacterRace characterRace);
    TreeMap visit(CharacterClass characterClass);
    TreeMap visit(Stats stats);

}
