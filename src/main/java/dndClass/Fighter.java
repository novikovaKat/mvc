package dndClass;

public class Fighter extends CharacterClass {
    private String perk;

    public Fighter() {
        name = "Fighter";
        initialHP = 10;
        perk = "Extra Attack";
    }

    @Override
    public void printMagica() {
        System.out.println("Perk: "+ perk);
    }
}
