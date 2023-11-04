package main.java.game.navagation.kravenwares;

import java.util.Scanner;

import main.java.game.Map;
import main.java.gamesys.economy.merchant.inventory.*;
import main.java.gamesys.economy.merchant.inventory.armor.HeavySteel;
import main.java.gamesys.economy.merchant.inventory.armor.LightLeather;
import main.java.gamesys.economy.merchant.inventory.armor.ScholarsRobes;

public class KravenWares extends Map{


    public KravenWares(int userLocationX, int userLocationY, int kWaresLocationX, int kWaresLocationY,
            int pInnLocationX, int pInnLocationY) {
        super(userLocationX, userLocationY, kWaresLocationX, kWaresLocationY, pInnLocationX, pInnLocationY);
        //TODO Auto-generated constructor stub
    }

    // Location
    private static int locationX = kWaresLocationX;
    private static int locationY = kWaresLocationY;
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
        System.out.println(heavySteel());
        System.out.println(scholarRobes());
        System.out.println(lightLeather());
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
        
            switch (userChoice) {
                case 1:
                    continueLoop = true;
                    displayArmors();
                case 2:
                    // TODO: Handle transactions here
                case 3:
                    System.exit(0); // tempoary
            }

            while(!continueLoop) {
                 System.out.println (
                        """
                        
                        [ERROR : INVALID ANSWER]
                        1. [Inventory]
                        2. [Sell]
                        3. [Exit]

                        [Enter Below]: 
                        """
                    );

                userChoice = sc.nextInt();
                 switch (userChoice) {
                        case 1:
                            continueLoop = true;
                            displayArmors();
                }
        }
    }
}
