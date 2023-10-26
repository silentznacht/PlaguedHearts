package main.java.gamesys;

public class Bank {
    protected static int userBalance;
    protected static int userCredits;
    protected static int userPoints;
    protected static int userOverallBalance;

    public Bank(int userBalance, int userCredits, int userPoints, int userOverallBalance) {
        Bank.userBalance = userBalance;
        Bank.userCredits = userCredits;
        Bank.userPoints = userPoints;
        Bank.userOverallBalance = userOverallBalance;
    }
    
}
