package main.java.gamesys.economy.bank;

import java.util.Scanner;

import main.java.gamesys.Bank;

public class Withdraw extends Bank {
    private static int balance = Bank.userBalance;
    private static int withdrawAmount;
    private static int withDrawRequest = ((int) (balance - withdrawAmount));
    public static int userOverallB = userOverallBalance;
    public static Scanner userInput = new Scanner(System.in);

    public Withdraw(int userBalance, int userCredits, int userPoints, int userOverallBalance) {
        super(userBalance, userCredits, userPoints, userOverallBalance);
        Withdraw.userOverallBalance = userOverallBalance;
    }
    
    public static void withdraw() {
        String chosen;
        int withdrawRequest;
        boolean cycleLoop = false;
        boolean securityPass = false;

        while (!cycleLoop) {
            System.out.println("\n[Bank Of Groslux]\n[Clerk: Would you like to proceed?]: ");
            chosen = userInput.nextLine();
    
            if (chosen.equalsIgnoreCase("Yes") || chosen.equalsIgnoreCase("y")) {
                while (!securityPass) {
                    System.out.println("\n[Clerk: Please Enter Preferred Withdrawal Amount]: ");
                    withdrawRequest = userInput.nextInt();
    
                    if (withdrawRequest <= balance) {
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
}
