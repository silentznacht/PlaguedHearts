package main.java.gamesys;

public class Potion {
    public static int value;
    public static double healthRecov;
    public static double manaRecov;
    public static double staminaRecov;
    public static double charismaRecov;

    public Potion(int value, double manaRecov, double healthRecov, double staminaRecov, double charismaRecov) {
            Potion.value = value;
            Potion.healthRecov = healthRecov;
            Potion.manaRecov = manaRecov;
            Potion.staminaRecov = staminaRecov;
            Potion.charismaRecov = charismaRecov;
    }
}
