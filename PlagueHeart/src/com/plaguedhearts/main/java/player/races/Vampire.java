package main.java.player.races;

import main.java.gameSys.Max;
import main.java.player.character.Health;
import main.java.player.character.Mana;
import main.java.player.character.Stamina;

public class Vampire {
    // [PASSIVES]
    Max mx = new Max(Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE);

    
    /* 
     * Dmg Buff = *0.4
     * Health Buff = *∞
     * Mana Buff = *10.0
     * Stamina Buff = *∞
     * [
        *  Strengths: Health (They're undead), Mana, Stamina (They're undead, did your forget?)
        *  Weaknesses: Dmg (pesky little claws), weak to sunlight and church
     * ]
     */
    
    public static int healthPassive = ( (int) (Health.health * 10.5) );
    public static int manaPassive = ((int) (Mana.mana * 500) );
    public static int staminaPassive = ((int) (Stamina.stamina * 100) );
    public static boolean isThyGood = true; // counter, to kill vamps under specific conditions, [holy and fire dmg]

    public static void main(String [] args) {
        System.out.println("Health: " + healthPassive);
        System.out.println("Mana: " + manaPassive);
        System.out.println("Stamina: " + staminaPassive);
    }
}
