package main.java.player.character;

import main.java.player.Attributes;

public class Charisma extends Attributes {

    public static int charisma = ((int) (Attributes.charisma + 1)); // one is easy to manipulate for future race passive multipliers

    public Charisma(int health, int charisma, int mana, int stamina) {
        super(health, charisma, mana, stamina);
        Charisma.charisma = charisma;
    }
    
}