package main.java.game.missions.week1;

import java.util.*;
import main.java.game.dialogue.NPC;
import main.java.gamesys.Bank;

public class Day1 {
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
    
     private static Scanner day1SC = new Scanner(System.in);
     private static String [] drinks  = NPC.drinks;
     private static String [] characters = NPC.characters;
     private static String [] actions = NPC.actions;

     private static int balance = Bank.userBalance;
     private static int coinEarned;
     private static int userProfits = coinEarned + balance;
     private static int customersSatisfied = 0;

     private static boolean customerEarned;
     private static Random random;


     static void menu() {
            for (int i = 0; i < drinks.length; i ++) {
                System.out.println(Arrays.toString(drinks));
            }
     }

     static String customerDialogue() {
            // randomly generated
            String character = characters[random.nextInt(characters.length)];
            String drink = drinks[random.nextInt(drinks.length)];
            String action = actions[random.nextInt(actions.length)];
            return character + ": "  +  " " + action + " " + drink;
        }
     public static void main(String [] args) { //TODO: Generate customers, when success customerCount will increase, and so will profit
            System.out.println("    [ Day1 : Tavern of Groslux ]");
            Day1 d1 = new Day1();
            
     }



}
