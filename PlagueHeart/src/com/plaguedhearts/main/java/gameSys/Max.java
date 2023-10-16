package main.java.gameSys;

public class Max {
    // Max of anything in-game
    
    public long maxDmg = Long.MAX_VALUE;
    public long maxHealth = Long.MAX_VALUE;
    public long maxMana = Long.MAX_VALUE; 
    public long maxStamina = Long.MAX_VALUE;

    public Max (long maxDmg, long maxHealth, long maxMana, long maxStamina) {
        this.maxDmg = maxDmg;
        this.maxHealth = maxHealth;
        this.maxMana = maxMana;
        this.maxStamina = maxStamina;
    }
}
