package main.java.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    private static ArrayList<String> raceList = new ArrayList<>();
    private static ArrayList<String> nameList = new ArrayList<>();
    private static String displayName;
    private static String displayRace;
    private static boolean humanRace = false;
    private static boolean vampireRace = false;
    private static boolean beastFolkRace = false;
    private static boolean raceMethodComplete = false;
    private static boolean nameMethodComplete = false;

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("---[GRIMORE MENU]---");
        System.out.println("\n1. [Character Creation]");
        int userInput = scan.nextInt();
        scan.nextLine(); // Consume newline character

        switch (userInput) {
            case 1:
                sequenceBuddy();
                break;
            case 2:
                // Handle case 2
                break;
            case 3:
                // Handle case 3
                break;
            default:
                System.out.println("Invalid input.");
        }
    }

    public static void userHandler() {
        // Your user handling code here
    }

    public static String raceSelect() {
        String[] races = {"Beastfolk", "Human", "Vampire"};

        System.out.println("[RACES]\n");
        for (String race : races) {
            System.out.println(race);
        }

        boolean validRace = false;
        String chosenRace = "";

        while (!validRace) {
            System.out.println("\nEnter your preferred race of choosing?: ");
            String selectRace = scan.nextLine();

            if (Arrays.asList(races).contains(selectRace) || Arrays.stream(races).map(String::toLowerCase).anyMatch(selectRace::equalsIgnoreCase)) {
                raceMethodComplete = true;
                chosenRace = selectRace;
                raceList.add(chosenRace);
                validRace = true;
            } else {
                System.out.println("[Sorry Invalid Race Inputted, Try Again]");
            }
        }

        switch (chosenRace) {
            case "Human" -> humanRace = true;
            case "Vampire" -> vampireRace = true;
            case "Beastfolk" -> beastFolkRace = true;
        }

        return displayRace = chosenRace;
    }

    public static String nameSelect() {
        boolean validName = false;
        String chosenName = "";
        String[] illegalCharacters = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "=", "[", "]", "{", "}", ";", ":", "'", "<", ">", ",", ".", "?", "/", "\\", "|", "`", "~"};

        while (!validName) {
            System.out.println("[Name Selection]\nPlease Enter Name Of Choosing: ");
            String nameSelected = scan.nextLine();

            if (Arrays.stream(illegalCharacters).noneMatch(nameSelected::contains)) {
                nameMethodComplete = true;
                chosenName = nameSelected;
                nameList.add(chosenName);
                validName = true;
            } else {
                System.out.println("[Sorry Invalid Characters Inputted, Try Again]");
            }
        }
        return displayName = chosenName;
    }

    private static void save() {
        ArrayList<String> race = raceList;
        ArrayList<String> name = nameList;
        // Your save logic here
    }

    static void sequenceBuddy() {
        raceSelect();
        if (raceMethodComplete) {
            nameSelect();
        }
        if (nameMethodComplete) {
            fin();
        }
    }

    static void fin() {
        System.out.print("\n[Finalize]\n[(Y/N)]: ");
        String proceed = scan.nextLine();
        boolean endLoop = false;

        while (!endLoop) {
            if (proceed.equalsIgnoreCase("Yes") || proceed.equalsIgnoreCase("Y")) {
                System.out.print("[Warning] [Are you sure?]: ");
                String finChoice = scan.nextLine();

                if (finChoice.equalsIgnoreCase("Y") || finChoice.equalsIgnoreCase("Yes")) {
                    endLoop = true;
                    // Your logic for finalizing here
                } else if (finChoice.equalsIgnoreCase("N") || finChoice.equalsIgnoreCase("No")) {
                    // Your logic for not finalizing here
                } else {
                    System.out.print("\n[Sorry, Invalid Response]");
                }

            } else if (proceed.equalsIgnoreCase("No") || proceed.equalsIgnoreCase("N")) {
                System.out.print("[Warning] [Are You Sure? ALL SAVED Data will be lost] (Y/N): ");
                String saveChoice = scan.nextLine();

                if (saveChoice.equalsIgnoreCase("Y") || saveChoice.equalsIgnoreCase("Yes")) {
                    endLoop = true;
                    sequenceBuddy();
                } else if (saveChoice.equalsIgnoreCase("N") || saveChoice.equalsIgnoreCase("No")) {
                    // Your logic for not saving here
                } else {
                    System.out.print("\n[Sorry, Invalid Response]");
                }
            } else {
                System.out.print("\n[Sorry, Invalid Response]");
            }
        }
    }
}
