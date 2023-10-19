package main.java.gamesys;

public class Bank {
    protected static int userBalance;
    protected static int userCredits;
    protected static int userPoints;

    public Bank(int userBalance, int userCredits, int userPoints) {
        Bank.userBalance = userBalance;
        Bank.userCredits = userCredits;
        Bank.userPoints = userPoints;
    }
    
}
