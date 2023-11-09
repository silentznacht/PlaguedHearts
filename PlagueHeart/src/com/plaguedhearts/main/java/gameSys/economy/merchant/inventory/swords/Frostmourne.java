package main.java.gamesys.economy.merchant.inventory.swords;

import main.java.gamesys.Weapon;

public class Frostmourne extends Weapon {

    private static double weaponDmg = (double) 550;
    private static double darkBonus = (double) 90.8;
    private static double soulBonus = (double) 30.9;
    private static double frostBonus = (double) 100.10;
    
    public static double finalDmg = ((int) (((frostBonus + soulBonus + darkBonus) / weaponDmg) * 100) + weaponDmg);
    public static int coinVal = 20403;

    public Frostmourne(double dmg, double bloodDmg, double holyDmg, double fireDmg, double soulDmg, double darkDmg, double frostDmg, int coinVal, double finalDmg) {
        super(dmg, bloodDmg, holyDmg, fireDmg, soulDmg, darkDmg, darkDmg);
        Frostmourne.coinVal = coinVal;
        Frostmourne.finalDmg = finalDmg;
    }
    
}
