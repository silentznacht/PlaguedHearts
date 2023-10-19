package main.java.gamesys.economy.bank;

import main.java.gamesys.Bank;

public class Withdraw extends Bank {
    private static int balance = Bank.userBalance;
    private static int withdrawAmount;
    private static int withDrawRequest = ((int) (balance - withdrawAmount));

    public Withdraw(int userBalance, int userCredits, int userPoints) {
        super(userBalance, userCredits, userPoints);
        Withdraw.balance = userBalance;
    }
}
