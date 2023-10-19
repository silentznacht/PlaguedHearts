package main.java.gamesys.economy.bank;

import java.util.*;
import main.java.gamesys.Bank;

public class Deposit extends Bank {
    private static int balance = userBalance;
    private static Scanner userInput = new Scanner(System.in);

    public Deposit(int userBalance, int userCredits, int userPoints) {
        super(userBalance, userCredits, userPoints);
        Deposit.balance = userBalance;
    }

    public void depo(boolean passCheck, String chosen, int numCount, int depositRequest) {
        chosen = userInput.nextLine();
        depositRequest = userInput.nextInt();
        boolean cycleLoop = false;
        boolean securityPass = false;
            while (!cycleLoop) {
                System.out.println("\n            [Bank Of Groslux]" +  "\n\n[Clerk: Would you like to proceed?]: ");
                userInput.nextLine(); // eats extra line
                if (chosen.equalsIgnoreCase("Yes") || chosen.equalsIgnoreCase("y")) {
                       while (!securityPass) { // loops until user passes security i.e (amount to deposit is true)
                            userInput.nextLine();
                            System.out.println("\n[Clerk: Please Enter Preferred Amount to Deposit]: ");
                                if (chosen.equalsIgnoreCase(chosen)) { // checks current balance from user inventory, and deposit amount
                                    int numDepositAmount = Integer.parseInt(chosen);
                                    boolean amountTrue = false;
                                        if (balance >= numDepositAmount) { //  if deposit amount is available
                                            amountTrue = true;
                                            if (amountTrue == true) { // if deposit amount is true
                                                balance += numDepositAmount;
                                                securityPass = true;
                                                cycleLoop = true;
                                            } else {
                                                System.out.println("\n[Clerk: Sorry Insufficient Funds Please Try Again]");
                                            }
                                        } 
                                }
                        }
                       
                } else if (chosen.equalsIgnoreCase("No") || chosen.equalsIgnoreCase("N")) {
                    System.out.println("\n[Clerk: Very Well You Sorry Wretch, Begone!]");
                } else {
                    System.out.println("\n[Sorry Invalid Response]");
                }
        } 
    }

}
