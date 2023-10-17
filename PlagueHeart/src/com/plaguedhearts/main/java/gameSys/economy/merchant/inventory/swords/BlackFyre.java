package main.java.gamesys.economy.merchant.inventory.swords;

import java.util.WeakHashMap;

import main.java.gamesys.Weapon;

public class BlackFyre extends Weapon {

    private static double weaponDmg = (double) 350;
    private static double fireBonus = (double) 40.7;
    private static double bloodBonus = (double) 70.8;
    private static double darkBonus = (double) 50.9;
    
    public static double finalDmg = ((int) (((fireBonus + bloodBonus + darkBonus) / weaponDmg) * 100) + weaponDmg);
    public static int coinVal = 10450;


    public BlackFyre(int coinVal, double dmg, double bloodDmg, double holyDmg, double fireDmg, double soulDmg, double darkDmg, double finalDmg, double frostDmg) {
        super(dmg, bloodDmg, holyDmg, fireDmg, soulDmg, darkDmg, finalDmg);
        BlackFyre.finalDmg = finalDmg;
        BlackFyre.coinVal = coinVal;
    }
    
}