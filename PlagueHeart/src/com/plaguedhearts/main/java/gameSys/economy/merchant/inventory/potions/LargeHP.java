package main.java.gamesys.economy.merchant.inventory.potions;

import main.java.gamesys.economy.merchant.inventory.Potion;
import main.java.player.character.*;

public class LargeHP extends Potion {

    // Test vars
    private static int health = Health.health;
    public static int value = Potion.value + 100; // inital value is 0, this adds 100 to items value
    public static double healthRecov = (((int) Potion.healthRecov + health) * (health / 2) / 100); // extra 50 points to hp

    public static void main(String [] args) { // tests values within class
        System.out.println(value);
        System.out.println(healthRecov);
    }

    public LargeHP(int value, double manaRecov, double healthRecov, double staminaRecov, double charismaRecov) {
        super(value, manaRecov, healthRecov, staminaRecov, charismaRecov);
        LargeHP.value = value;
        LargeHP.healthRecov = healthRecov;
    }

}