package main.java.player.races;

import main.java.gameSys.Max;
import main.java.player.character.Health;
import main.java.player.character.Mana;
import main.java.player.character.Stamina;

public class BeastFolk {
    // [PASSIVES]
    
    
    Max mx = new Max(Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE);
    /* 
     * Health Buff = *3
     * Mana Buff = 0
     * Stamina Buff = *4
     * [
        *  Strengths: Dmg, Health, Stamina (All Physical)
        *  Weaknesses: Mana (Spell Casting), Charisma...etc
     * ]
     */
    
    public static int healthPassive = ( (int) (Health.health * 10.5) );
    public static int manaPassive = ((int) (Mana.mana * 20) );
    public static int staminaPassive = ((int) (Stamina.stamina * 150.5) );

    public static void main(String [] args) {
        System.out.println("Health: " + healthPassive);
        System.out.println("Mana: " + manaPassive);
        System.out.println("Stamina: " + staminaPassive);
    }

} 