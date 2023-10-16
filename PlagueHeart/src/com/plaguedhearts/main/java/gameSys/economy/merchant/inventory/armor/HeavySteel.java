package main.java.gamesys.economy.merchant.inventory.armor;

import main.java.gamesys.economy.merchant.inventory.Armor;
import main.java.player.character.Health;

public class HeavySteel extends Armor {

    // Sets stats & values of piece of armor, info is passed into the super constructor

    private static int health = Health.health;
    private static double partBoost = 30.7202020;

    public static int armorRating = ((int) (Armor.armorRating + 250) + health); // base armor value
    public static double armorHPB = ((double) (((partBoost / armorRating) * 100) + armorRating)); // armor value after hp passive
    public static int armorVal = ((int) Armor.armorVal + 150);

    public HeavySteel(double armorHPB,int armorRating, int armorVal, int armorBonusesMP, int armorBonusesHP, int armorBonusesST, int armorBonusesCH) {
        super(armorRating, armorVal, armorBonusesMP, armorBonusesHP, armorBonusesST, armorBonusesCH);
            HeavySteel.armorHPB = armorHPB;
            HeavySteel.armorRating = armorRating;
            HeavySteel.armorVal = armorVal;
    }

    public static void main(String [] args) { // Test vals
        //System.out.print(armorHPB);
        System.out.print(armorRating);
    }
    
}
