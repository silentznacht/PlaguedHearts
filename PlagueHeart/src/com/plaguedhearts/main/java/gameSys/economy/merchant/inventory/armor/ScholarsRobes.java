package main.java.gamesys.economy.merchant.inventory.armor;

import main.java.gamesys.Armor;
import main.java.player.character.Health;

public class ScholarsRobes extends Armor {

    // Sets stats & values of piece of armor, info is passed into the super constructor

    private static int health = Health.health;
    public static int armorRating = ((int) (Armor.armorRating + 20) + health);
    private static double partBoost = 30.7202020;
    
    public static int armorVal = ((int) Armor.armorVal + 150);
    public static double manaRating = ((double) (((partBoost / armorRating) * 100) + armorRating));

    public ScholarsRobes(int armorRating, int armorVal, int armorBonusesMP, int armorBonusesHP, int armorBonusesST,int armorBonusesCH, double manaRating) {
        super(armorRating, armorVal, armorBonusesMP, armorBonusesHP, armorBonusesST, armorBonusesCH);
        ScholarsRobes.armorRating = armorRating;
        ScholarsRobes.armorVal = armorVal;
        ScholarsRobes.manaRating = manaRating;
    }
    
}
