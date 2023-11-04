package main.java.game.navagation.kravenwares;

import java.util.Scanner;

import main.java.gamesys.economy.merchant.inventory.*;
import main.java.gamesys.economy.merchant.inventory.armor.HeavySteel;
import main.java.gamesys.economy.merchant.inventory.armor.LightLeather;
import main.java.gamesys.economy.merchant.inventory.armor.ScholarsRobes;

public class KravenWares {

    static Scanner sc = new Scanner(System.in);
    // Armors -> Heavy
    private static int hArmorVal = HeavySteel.armorVal;
    private static int hArmorRating = HeavySteel.armorRating;
    private static double hArmorH = (int) HeavySteel.armorHPB;
    
    // Armors -> ScholarsRobes
    private static int sRobesVal = ScholarsRobes.armorVal;
    private static int sRobesRating = ScholarsRobes.armorRating;
    private static double sRobesM = (int) ScholarsRobes.manaRating;

    // Armors -> LightLeather
    private static int lightLVal = LightLeather.armorVal;
    private static int lightLRating = LightLeather.armorRating;
    private static int lightLStamina = (int) LightLeather.armorSTB;

    static String heavySteel() {
        int hAV = hArmorVal;
        int hAR = hArmorRating;
        int hAH = (int) hArmorH;

        return "\nHeavy Steel Armor" + "\nPrice: " + hAH + "\nBase: " + hAR + "\nBuffs (Health): " + hAH;
    }

    static String scholarRobes() {
        int sRV = sRobesVal;
        int sRR = sRobesRating;
        int sRM = (int) sRobesM;

        return "\n\nScholars Robes" + "\nPrice: " + sRV + "\nBase: " + sRR + "\nBuffs (Mana): " + sRM;
    }

    static String lightLeather() {
        int lV = lightLVal;
        int lR = lightLRating;
        int lS = lightLStamina;

        return "\nLight Leather Armor" + "\nPrice: " + lV + "\nBase: " + lR + "\nBuffs (Stamina): " + lS; 
    }

    static void displayArmors() {
        heavySteel();
        scholarRobes();
        lightLeather();
    }

    public static void main(String [] args) {
        System.out.println (
            """
                                    [Kraven's Wares] 
            
            Kraven: Oi chum, what ya in forya?

            1. [Inventory]
            2. [Sell]
            3. [Exit]

            [Enter Below]: 
            """
        );

        boolean continueLoop = false;
        int userChoice = sc.nextInt();

        if (userChoice > 3 || userChoice <= 0) { // If invalid option shown
             while (!continueLoop) {
                    System.out.println (
                        """
                            [Invalid Option]
                            [Enter Below]:   
                        """
                    );

                        switch (userChoice) {
                            case 1:
                                continueLoop = true;
                                displayArmors();
                            case 2:
                                // TODO: method nested here to handle transactions (SELL)
                            case 3:
                                System.exit(0);
                        }

                    }
                } 

        switch(userChoice) {
                case 1:
                    continueLoop = true;
                    displayArmors();
                case 2:
                    // TODO: method nested here to handle transactions (SELL)
                case 3:
                    System.exit(0);
            }
    }
}
