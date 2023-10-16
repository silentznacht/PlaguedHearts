package main.java.gameSys.economy.merchant.inventory.potions;

import main.java.gameSys.economy.merchant.inventory.Potion;
import main.java.player.character.Mana;

public class LargeMP extends Potion {
    public static int mana = Mana.mana + 20; // a tempoary retainer till, future input from user to dictate stats
    public static int value = Potion.value + 80;
    public static double manaRecov = (((int) Potion.manaRecov + mana) * (mana / 2) / 100); // restores 1/10th of a users mp

    public static void main(String [] args) {
        System.out.println(value);
        System.out.println(manaRecov);
    }
    public LargeMP(int value, double manaRecov, double healthRecov, double staminaRecov, double charismaRecov) {
        super(value, manaRecov, healthRecov, staminaRecov, charismaRecov);
        LargeMP.value = value;
        LargeMP.manaRecov = manaRecov;
    }
    
}