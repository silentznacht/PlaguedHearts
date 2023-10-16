package main.java.player.races;

import main.java.gameSys.Max;
import main.java.player.character.Health;
import main.java.player.character.Mana;
import main.java.player.character.Stamina;

public class Human {
    // [PASSIVES]
    Max mx = new Max(Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE);
    /*
     * Dmg Buff = *0.4
     * Health Buff = *2.0
     * Mana Buff = *0.5
     * Stamina Buff = *0.2
     * [
        * Strengths: Health, all other stats moderately balanced
        * Weaknesses: None, fleshy is thy race?
     * ]
     */

    public static int healthPassive = ( (int) (Health.health * 5.5) );
    public static int manaPassive = ((int) (Mana.mana * 100) );
    public static int staminaPassive = ((int) (Stamina.stamina * 75) );

    public static void main(String [] args) {
        System.out.println("Health: " + healthPassive);
        System.out.println("Mana: " + manaPassive);
        System.out.println("Stamina: " + staminaPassive);
    }
}
