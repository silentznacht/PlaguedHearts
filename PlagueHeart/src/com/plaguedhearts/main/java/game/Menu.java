package main.java.game;

import java.util.*;

public class Menu {

    /**
     *                                  [ISSUE]
     * 
     *  Static scanner causing input to intervene with other sources, (needed fix)
     *  Static global variables raceCompleted , and nameCompleted, both are not being updated
     *  must find another solution to create a perfected sequential loop for character creation
     * 
     */

    public static ArrayList <String> raceList = new ArrayList<String>();
    public static ArrayList <String> nameList = new ArrayList<String>();

    public static boolean humanRace = false;
    public static boolean vampireRace = false;
    public static boolean beastFolkRace = false;

    private static boolean raceMethodComplete = false;
    private static boolean nameMethodComplete = false;

    
    static Scanner scan = new Scanner(System.in);
    public static void main(String [] args) {
         System.out.println ("---[PLAGUED HEARTS MENU]---");
         System.out.println("\n1. [Character Creation]");
         int userInput = scan.nextInt();
         scan.nextLine(); // consumes new line

            switch(userInput) { // in progress
                case 1:
                    sequenceBuddy();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid input.");
            }

        

    }

    public static String nameSelect() {
        // Asks user to name character, if the input has invalid characters or numbers it will warn the user
        boolean falseName = false;
        String chosenName = "";
        String[] illegalCharacters = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "=", "[", "]", "{", "}", ";", ":", "\'", "<", ">", ",", ".", "?", "/", "\\", "|", "`", "~"};
            
        while (!falseName) {
                  System.out.println("[Name Selection]" + "\nPlease Enter Name Of Choosing: ");
                  String nameSelected = scan.nextLine();

                  if (Arrays.asList(illegalCharacters).contains(nameSelected) || (containsIllegalCharacters(nameSelected))) {
                        System.out.println( "[Sorry Invalid Characters Inputted, Try Again]");
                  } else {
                         nameMethodComplete = true;
                         chosenName = nameSelected;
                         nameList.add(chosenName);
                         falseName = true;
                  }
            }
        return chosenName;
    }

    private static boolean containsIllegalCharacters(String input) { // illegal character check
        String[] illegalCharacters = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "=", "[", "]", "{", "}", ";", ":", "'", "<", ">", ",", ".", "?", "/", "\\", "|", "`", "~"};

        for (String illegalChar : illegalCharacters) {
            if (input.contains(illegalChar)) {
                return true;
            }
        }

        return false;
    }

    public static void save() { // TODO: Add chosen name to arraylist
        // Allows user to change later on
        ArrayList<String> name = nameList;
    }
    
    static void sequenceBuddy() {
            if (raceMethodComplete == true) nameSelect();
            if (nameMethodComplete == true) fin();

    }


    static void fin() {
        System.out.print("\n[Finalize]" + "\n[(Y/N)]: ");
        String proceed = scan.nextLine();
        boolean endLoop = false;

        while (!endLoop) {
            if (proceed.equalsIgnoreCase("Yes") || proceed.equalsIgnoreCase("Y")) { // if user chooses to save
                System.out.print("[Warning]" + "[Are you sure?]: ");
                String finChoice = scan.nextLine();
                    
                    if (finChoice.equalsIgnoreCase("Y") || finChoice.equalsIgnoreCase("Yes")) {
                            endLoop = true;
                            // in progress
                        } else if (finChoice.equalsIgnoreCase("N") || finChoice.equalsIgnoreCase("No")) {
                            // in progress uwu
                        } else {
                            System.out.print("\n[Sorry, Invalid Response]");
                        }

            } else if (proceed.equalsIgnoreCase("No") || proceed.equalsIgnoreCase("N")) { // if user chooses not to save (losing all progress)
                    System.out.print("[Warning]" + "[Are Sure? ALL SAVED Data will be lost](Y/N): ");
                    String saveChoice = scan.nextLine();

                        if (saveChoice.equalsIgnoreCase("Y") || saveChoice.equalsIgnoreCase("Yes")) {
                            endLoop = true;
                            sequenceBuddy();
                        } else if (saveChoice.equalsIgnoreCase("N") || saveChoice.equalsIgnoreCase("No")) {
                            // in progress uwu
                        } else {
                            System.out.print("\n[Sorry, Invalid Response]");
                        }
            } else {
                System.out.print("\n[Sorry, Invalid Response]");
            }
        }

    }
    
}