package main.java.player.character;

import main.java.player.Attributes;

public class Mana extends Attributes {
    public static int mana = ((int) (Attributes.mana + 1));
    
    public Mana(int health, int charisma, int mana, int stamina) {
        super(health, charisma, mana, stamina);
        Mana.mana = mana;
    }
    
}