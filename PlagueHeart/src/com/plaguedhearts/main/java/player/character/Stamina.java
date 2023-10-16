package main.java.player.character;

import main.java.player.Attributes;

public class Stamina extends Attributes {
    public static int stamina = ((int) (Attributes.stamina + 1));

    public Stamina(int health, int charisma, int mana, int stamina) {
        super(health, charisma, mana, stamina);
        Stamina.stamina = stamina;
    }
    
}