package main.java.gameSys;

public class Weapon { // Abstract class for foundation 
    public static double dmg;
    public static double bloodDmg;
    public static double holyDmg;
    public static double fireDmg;
    public static double soulDmg;
    public static double darkDmg;

    public Weapon(double dmg, double bloodDmg, double holyDmg, double fireDmg, double soulDmg, double darkDmg) {
            Weapon.dmg = dmg;
            Weapon.bloodDmg = bloodDmg;
            Weapon.holyDmg = holyDmg;
            Weapon.fireDmg = fireDmg;
            Weapon.soulDmg = soulDmg;
            Weapon,darkDmg = darkDmg;
    }

}