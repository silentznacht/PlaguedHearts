package main.java.game.navagation.thepissininn;

import java.util.*;
import main.java.game.dialogue.NPC;
import main.java.gamesys.Bank;

public class PissinInn extends Bank {
    /*
     *              Day Quota
     *       Attend to 5 customers, and reach 100 coins by the end of day 1
     * 
     *       [MENU] 
     *   OL'Copper : 4 Coins
     *   Devil's Breath: 6 Coins
     *   Groslux Special: 10 Coins
     *   Nurgles Nectar: 5 Coins
     *   Pesilence's Promise: 20 Coins
     *   Remedy Rum: 15 Coins
     *   
     * 
     * TODO: Create an array of objects from customer class, all objects pertain to drinks section
     * TODO: Use switch case to sort out user input
     */
    
     public PissinInn(int userBalance, int userCredits, int userPoints, int userOverallBalance) {
        super(userBalance, userCredits, userPoints, userOverallBalance);
        //TODO Auto-generated constructor stub
     }
    
     // Prices 
     private static int olCopperPrice = 4;
     private static int devilsBreathPrice = 6;
     private static int grosluxSpecialPrice = 10;
     private static int nurglesNectorPrice = 5;
     private static int pesilencePromisePrice = 20;
     private static int remedyRumPrice = 15;

     // Scanner & characters, drinks, actions, questions, answers, etc (randomized)
     private static Random random = new Random();
     private static Scanner tavernScan = new Scanner(System.in);
     private static String [] drinks  = NPC.drinks;
     private static String [] characters = NPC.characters;
     private static String [] actions = NPC.actions;
     private static String [] questions = NPC.questions;
     private static String [] answers = NPC.answers;
     private static String [] mixBook = NPC.mixBook;
     private static String [] mixBookAnswers = NPC.mixBookAnswera;
     private static String [] insults = NPC.drinkRelatedInsults;
 
     // Profits || Currency
     private static int balance = Bank.userBalance;
     private static int coinEarned = 0;
     private static int userProfits = coinEarned + balance;

     static String customerDialogue() {
        // randomly generated
        String character = characters[random.nextInt(characters.length)];
        String drink = drinks[random.nextInt(drinks.length)];
        String action = actions[random.nextInt(actions.length)];
        String dialogue = character + ": "  +  " " + action + " " + drink;

        return dialogue;
    }

    static void displayDrinks(int k) {
            System.out.println("\n        [MENU]\n"); 
            int drinksPrices [] = {
                olCopperPrice, devilsBreathPrice, 
                grosluxSpecialPrice, nurglesNectorPrice,
                pesilencePromisePrice, remedyRumPrice
            };


            String [] drink = NPC.drinks;
            while(k <= drink.length) {if (k >= drinks.length) break; System.out.println("[Drink]: " + drink[k].trim() + " (Price): " + drinksPrices[k]); k++;}
        
    }
    
    static void tranHandler() { // TODO: Handles user transactions (drink, coin from tavern job)

    }

    static void tavernJob() { // Handles tavern job -> sends user to handle drinks, and display drinks
        System.out.println("\n        [Mini Game]\n\n");
        Scanner tavernScan = new Scanner(System.in);
        
        boolean servingDrinks = true;
    
        while (servingDrinks) {
            System.out.println("[ORDER]: " + PissinInn.customerDialogue());
            System.out.println("[Answer(Mix) -> (What drink did the customer ask for?) Use H for help]: ");
    
            String userAnswer = tavernScan.nextLine();
    
            if (userAnswer.equalsIgnoreCase("help") || userAnswer.equalsIgnoreCase("h")) { // help menu
                displayDrinkMenu();
            } else { 
                handleDrinkOrder(userAnswer);
            }
    
            System.out.println("Do you want to continue serving drinks (Y/N)?");
            String continueOption = tavernScan.nextLine();
            if (!continueOption.equalsIgnoreCase("Y")) { // means continueOption stays false when user input is anything other than "Y", thus ending the loop
                servingDrinks = false;                                 // Y -> exit (stop serving drinks)
            }
        }
    
        tavernScan.close();
    }
    
    static void displayDrinkMenu() {
        System.out.println("\n        [Mix Book: Drinks]\n");
        for (String drink : drinks) {
            System.out.println("(" + drink + ")");
        }
    }
    
    static void handleDrinkOrder(String userAnswer) {
        boolean drinkFound = false;
    
        for (String drink : drinks) { // if the user matches the customers requested drink then it will move onto the tavern mini game 
            if (userAnswer.equalsIgnoreCase(drink)) {
                drinkFound = true;
                System.out.println("[Now Enter The Proper Mix For " + drink + " (Use H for help)]: ");
                // Implement logic for mixing the drink here
                tavernMiniGame();
                break;
            }
        }
    
        if (!drinkFound) {
            System.out.println("\n[Alert: Sorry Invalid Answer]\n");
        }
    }
    
    static void tavernMiniGame() {
        // Implement your mini-game logic here

        
    }
    
    static void sellTrans() {

    }
    
    static void menu() {
        System.out.println (
            """
                                    [The Pissin' Inn] 
            
            Harold(Barkeep): Oi boy, what ya spicin for?

            1. [Drinks]
            2. [Sell]
            3. [Work: Extra Coin]
            4. [Exit]

            [Enter Below]: 
            """
        );

        int menuChoice = tavernScan.nextInt();
        boolean loopCheck = false;
            switch(menuChoice) {
                case 1:
                    displayDrinks(0);
                    tranHandler();
                    loopCheck = true;
                    break;
                case 2:
                    //
                case 3:
                    tavernJob();
                    break;
                case 4:
                    System.exit(0);
            }



    }
     public static void main(String [] args) { 
            tavernJob();
     }

}
