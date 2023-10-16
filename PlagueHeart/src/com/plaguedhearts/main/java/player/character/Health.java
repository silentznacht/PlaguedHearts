package main.java.player.character;

import main.java.player.Attributes;

public class Health extends Attributes {
    public static int health = ((int)(Attributes.health + 100));

    public Health(int health, int charisma, int mana, int stamina) {
        super(health, charisma, mana, stamina);
        Health.health = health;
    }
    
}