package main.java.gamesys.economy.merchant.inventory.armor;

import main.java.gamesys.Armor;
import main.java.player.character.Health;

public class LightLeather extends Armor {

    // Sets stats & values of piece of armor, info is passed into the super constructor

    private static int health = Health.health;
    private static double partBoost = 30.7202020;

    public static int armorRating = ((int) (Armor.armorRating + 50) + health);
    public static double armorSTB = ((double) (((partBoost / armorRating) * 100) + armorRating)); // armor value after st passive
    public static int armorVal = ((int) Armor.armorVal + 150);

    public LightLeather(double armorSTB, int armorRating, int armorVal, int armorBonusesMP, int armorBonusesHP, int armorBonusesST, int armorBonusesCH) {
            super(armorRating, armorVal, armorBonusesMP, armorBonusesHP, armorBonusesST, armorBonusesCH);
            LightLeather.armorSTB = armorSTB;
            LightLeather.armorRating = armorRating;
            LightLeather.armorVal = armorVal;
    }
    
}
