package main.java.game.navagation.thepissininn;

import static org.junit.Assert.fail;

import java.util.*;
import main.java.game.dialogue.NPC;
import main.java.gamesys.Bank;

public class PissinInn {
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

    static void tavernJob(int custCount) { // TODO: Allows user to give customers requested drinks, and earn coin
       int randomIndex = random.nextInt(questions.length);
       int questCount = 0;
       int dayCount = 0;
       int dexCount = 0;
       int mx = (int) Integer.MAX_VALUE;

       String customers = PissinInn.customerDialogue();
       String currentQuestion = questions[randomIndex];
       String answer = answers[randomIndex];

       boolean cycle = false;
       boolean questionForward = false; // will enable when user chooses to leave activity or not
       //tavernScan.nextLine();   

            while (dayCount <= mx) {
                    dayCount++; // days in progress ( count )
                    while (!cycle) { // TODO: come up with a game for user 
                        custCount ++;
                        dexCount++;
                        System.out.println("Customer (" + custCount + ") " + customers);
                        System.out.println("\n          [Mini Game]\n\n");
                            for (int i = 0; i < answers.length; i++) { // Outputs answer choices
                                questCount ++; // counts amount of quests attempted ie for probablity rate later
                                System.out.println("[Question]: " + " (" + currentQuestion + ")");
                                System.out.println(answers[i]);
                                int userChoice = tavernScan.nextInt();
                                int answerChosen = userChoice;


                                        if (answerChosen != dexCount) { // LOGIC: Answer doesn't match Question index -> wrong ? right
                                            System.out.println("[Alert: Sorry Incorrect Answer]");
                                        } else {
                                            System.out.println("[HAZRAAARRRJRJR]");
                                        }
                            }
                    } 
            }
           
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

                case 3:
                    tavernJob(0);

                case 4:
                    System.exit(0);


            }



    }
     public static void main(String [] args) { 
        tavernJob(0);
     }

}
