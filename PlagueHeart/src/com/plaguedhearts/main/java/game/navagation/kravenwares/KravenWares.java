package main.java.game.navagation.kravenwares;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import main.java.game.WorldMaps;
import main.java.gamesys.economy.merchant.inventory.armor.HeavySteel;
import main.java.gamesys.economy.merchant.inventory.armor.LightLeather;
import main.java.gamesys.economy.merchant.inventory.armor.ScholarsRobes;
import main.java.gamesys.economy.merchant.inventory.swords.BlackFyre;
import main.java.gamesys.economy.merchant.inventory.swords.Frostmourne;
import main.java.gamesys.Bank;

public class KravenWares extends Bank {

    public KravenWares(int userBalance, int userCredits, int userPoints, int userOverallBalance) {
        super(userBalance, userCredits, userPoints, userOverallBalance);
        //TODO Auto-generated constructor stub
    }

    // Location
    static WorldMaps wM = new WorldMaps();
    private static int locationX = WorldMaps.kWaresLocationX;
    private static int locationY = WorldMaps.kWaresLocationY;
    static Scanner sc = new Scanner(System.in);

    // Sell & Buy (User Balance)

    private static int userBalance = Bank.userBalance;

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

    // Swords -> BlackFyre
    private static int blackFVal = BlackFyre.coinVal;
    private static int blackFDMG = (int) BlackFyre.finalDmg;

    // Swords -> Frostmourne
    private static int frostMVal = Frostmourne.coinVal;
    private static int frostMDMG = (int) Frostmourne.finalDmg;

    // Transactions 
    static Map<String, Integer> myInventory = new HashMap<>();
    static String itemNames [] = {
            "Heavy Steel Armor",
            "Scholar Robes Armor",
            "Light Leather Armor",
            "Blackfyre",
            "Frostmourne"
        };

    static Integer itemPrices [] = {
            hArmorVal, sRobesVal,
            lightLVal, blackFVal,
            frostMVal
        };

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

    static String blackFyre() {
        int bFV = blackFVal;
        int bFDMG = blackFDMG;

        return "\nBlackFyre " + "\nPrice: " + bFV + "\nOverall DMG: " + bFDMG;
    }

    static String frostmourne() {
        int fMV = frostMVal;
        int fMDMG = frostMDMG;

        return "\nFrostmourne " + "\nPrice: " + fMV + "\nOverall DMG: " + fMDMG;
    }

    static void displayArmors() {
        System.out.println("=====================ARMORS=====================");
        System.out.println(heavySteel());
        System.out.println(scholarRobes());
        System.out.println(lightLeather());
    }

    static void displaySwords() { // Implements swords next
        System.out.println("=====================SWORDS=====================");
        System.out.println(blackFyre());
        System.out.println(frostmourne());
    }

    static void handleTrans(boolean loopContinue) { 
        /*
         *
         *                                                            TODO:
         *      Implement hashmap, use for loop to loop through an array of string element (items), then assign it's key as a value
         *      Then create a search algorithm to find the item name and value according to the users input
         *      finally assign the purchased element to the users inventory
         */


        while (!loopContinue) {
             System.out.println("\n[Enter Wanted Item Name]: ");
             sc.nextLine(); // consumes remaining line
             String chosenItem = sc.nextLine();
             boolean itemFound = false;

                for (int i = 0; i < itemNames.length; i++) {
                    if (chosenItem.equalsIgnoreCase(itemNames[i])) {
                        // add balance checker next (subtracts user balance from coins / checks if user has enough funds)
                            if (userBalance >= itemPrices[i]) {
                                    System.out.println("You have purchased: " + chosenItem + " for " + itemPrices[i] + " coins.");
                                    myInventory.put(itemNames[i], itemPrices[i]); // updates the user's inventory or balance here.
                                       itemFound = true;
                                       loopContinue = true;
                                       break;
                            } else {
                                    System.out.println("\n[Sorry ol' Lad insufficient funds, Try a different item]");
                            }

                    }

                    // return to shop menu
                    if (chosenItem.equalsIgnoreCase("exit")) {
                        main(itemNames);
                        break;
                    }
                }

                if (!itemFound) {
                    System.out.println("\n[Item not found. Please enter a valid item name.]");
                }
        }
    }
    
    //  TEST
    
    static void sellTrans(boolean loopContinue) {
        //myInventory.put("test", blackFVal);
        System.out.println("\n[Enter Item To Sell]: ");
        sc.nextLine();
        String chosenItem = sc.nextLine();
        boolean itemFound = false;

        while (!itemFound) {
            if (myInventory.containsKey(chosenItem)) {
                    int itemValue = myInventory.get(chosenItem);
                    System.out.println("Item found! Item name: " + chosenItem + ", Value: " + itemValue);
                    System.out.println("\n[Do you wish to sell? (yes/no)]: ");
                    String userChoice = sc.nextLine().toLowerCase();  // Convert user input to lowercase for case-insensitive comparisons.
            
                            if (userChoice.equals("yes") || userChoice.equals("y")) {
                                // Sell the item and update the user balance.
                                userBalance += itemValue;
                                System.out.println("User's balance updated. New balance: " + userBalance);
                                itemFound = true;
                            } else if (userChoice.equals("no") || userChoice.equals("n")) {
                                // returns to menu
                                main(itemNames);
                            } else {
                                System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
                            }
            } else {
                System.out.println("Item not found in inventory.");
                // Handle the case where the item is not found.
                break;  // Exit the loop since the item was not found.
            }
        }
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
                    displayArmors();
                    displaySwords();
                    handleTrans(continueLoop);
                    continueLoop = true;
                case 2:
                    // TODO: Handle transactions here : test
                    sellTrans(continueLoop);
                    continueLoop = true;
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
