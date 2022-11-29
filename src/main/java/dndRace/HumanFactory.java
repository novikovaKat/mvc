package dndRace;

import character.Stats;

public class HumanFactory implements RaceAbstractFactory{
    @Override
    public CharacterRace create() {
        return new Human("Human", new Stats(1, 1, 1, 1, 1, 1));
    }
}
