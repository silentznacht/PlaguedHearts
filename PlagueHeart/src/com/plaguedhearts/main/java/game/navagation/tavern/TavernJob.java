package main.java.game.navagation.tavern;

import java.util.*;
import main.java.game.dialogue.NPC;
import main.java.gamesys.Bank;

public class TavernJob {
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

     // Scanner & characters, drinks, actions (randomized)
     private static Scanner day1SC = new Scanner(System.in);
     private static String [] drinks  = NPC.drinks;
     private static String [] characters = NPC.characters;
     private static String [] actions = NPC.actions;

     // Profits
     private static int balance = Bank.userBalance;
     private static int coinEarned = 0;
     private static int userProfits = coinEarned + balance;
     private static int customersSatisfied = 0;

     // Reputation
     private static boolean customerEarned;
     private static Random random;


     static void menu() {
            for (int i = 0; i < drinks.length; i ++) {
                System.out.println(drinks[i]);
            }
     }

     static String customerDialogue() {
            // randomly generated
            String character = characters[random.nextInt(characters.length)];
            String drink = drinks[random.nextInt(drinks.length)];
            String action = actions[random.nextInt(actions.length)];
            String dialogue = character + ": "  +  " " + action + " " + drink;

            return dialogue;
        }

       
     public static void main(String [] args) { 
              System.out.println("    [ The Pissin' Inn ]");
              random = new Random();
              String customerDialogue = customerDialogue();
              System.out.println(customerDialogue);

              while (true) { // TODO: Implement question or task for user to earn customers coin
                    System.out.println(""); 
              }
              
     }



}
