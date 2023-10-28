package main.java.gamesys.economy.bank;

import java.util.*;
import main.java.gamesys.Bank;

public class Deposit extends Bank {

    private static int balance = userBalance;
    public static int userOverallB = userOverallBalance;
    private static Scanner userInput = new Scanner(System.in);

    public Deposit(int userBalance, int userCredits, int userPoints, int userOverallBalance) {
        super(userBalance, userCredits, userPoints, userOverallBalance);
        //TODO Auto-generated constructor stub
    }

    public static void withdraw() {
        String chosen;
        int depositRequest;
        boolean cycleLoop = false;
        boolean securityPass = false;
    
        while (!cycleLoop) {
            System.out.println("\n[Bank Of Groslux]\n[Clerk: Would you like to proceed?]: ");
            chosen = userInput.nextLine();
    
            if (chosen.equalsIgnoreCase("Yes") || chosen.equalsIgnoreCase("y")) {
                while (!securityPass) {
                    System.out.println("\n[Clerk: Please Enter Preferred Amount to Deposit]: ");
                    depositRequest = userInput.nextInt();
    
                    if (depositRequest <= balance) {
                        depositRequest += userOverallBalance;
                        securityPass = true;
                        cycleLoop = true;
                        System.out.println("\n[Clerk: Deposit successful. Your new balance is " + balance);
                    } else {
                        System.out.println("\n[Clerk: Sorry, Insufficient Funds. Please Try Again]");
                    }
                }
            } else if (chosen.equalsIgnoreCase("No") || chosen.equalsIgnoreCase("N")) {
                System.out.println("\n[Clerk: Very Well! You may leave now, You Sorry Wretch]");
                cycleLoop = true;
            } else {
                System.out.println("\n[Sorry, Invalid Response]");
            }
        }
    }
    
    public static void main(String[] args) {
        Withdraw.withdraw();
    }  
}
