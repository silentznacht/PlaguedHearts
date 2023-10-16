package main.java.gameSys.economy.merchant.inventory.armor;

import main.java.gameSys.economy.merchant.inventory.Armor;
import main.java.player.character.Health;

public class ScholarsRobes extends Armor {

    // Sets stats & values of piece of armor, info is passed into the super constructor

    private static int health = Health.health;
    public static int armorRating = ((int) (Armor.armorRating + 20) + health);
    public static int armorVal = ((int) Armor.armorVal + 150);

    public ScholarsRobes(int armorRating, int armorVal, int armorBonusesMP, int armorBonusesHP, int armorBonusesST,int armorBonusesCH) {
        super(armorRating, armorVal, armorBonusesMP, armorBonusesHP, armorBonusesST, armorBonusesCH);
        
    }
    
}
