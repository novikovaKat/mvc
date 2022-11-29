package dndRace;

import character.Stats;

public class DragonbornFactory implements RaceAbstractFactory{
    @Override
    public CharacterRace create() {
        return new Dragonborn("Dragonborn", new Stats(2, 0, 0, 0,0 , 1));
    }
}
