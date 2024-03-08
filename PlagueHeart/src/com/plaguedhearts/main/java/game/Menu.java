package main.java.game;

import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Menu implements Runnable {

    public static ArrayList <String> nameList = new ArrayList<String>();
    static Scanner scan = new Scanner(System.in);

    private static boolean containsIllegalCharacters(String input) { // illegal character check
        String[] illegalCharacters = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "=", "[", "]", "{", "}", ";", ":", "'", "<", ">", ",", ".", "?", "/", "\\", "|", "`", "~"};

        for (String illegalChar : illegalCharacters) {
            if (input.contains(illegalChar)) {
                return true;
            }
        }

        return false;
    }

    private static String nameSelect() {
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
                         chosenName = nameSelected;
                         nameList.add(chosenName);
                         fin(chosenName);
                         falseName = true; // exits loop
                  }
            }
        return chosenName;
    }


    static void fin(String name) { // finishing character creation options
        System.out.print("\n[Finalize]" + "\n[(Y/N)]: ");
        String proceed = scan.nextLine();
        boolean endLoop = false;

        while (!endLoop) {
            if (proceed.equalsIgnoreCase("Yes") || proceed.equalsIgnoreCase("Y")) { // if user chooses to save
                System.out.print("[Warning]" + "[Are you sure?]: ");
                String finChoice = scan.nextLine();
                    
                    if (finChoice.equalsIgnoreCase("Y") || finChoice.equalsIgnoreCase("Yes")) {
                        outputInfo(name);
                        entrySaveLog(name);
                        endLoop = true;
                    } else if (finChoice.equalsIgnoreCase("N") || finChoice.equalsIgnoreCase("No")) {
                        nameSelect();
                        endLoop = true;
                    } else {
                        System.out.print("\n[Sorry, Invalid Response]");
                    }

            } else if (proceed.equalsIgnoreCase("No") || proceed.equalsIgnoreCase("N")) { // if user chooses not to save (losing all progress)
                    System.out.print("[Warning]" + "[Are Sure? ALL SAVED Data will be lost](Y/N): ");
                    String finChoice = scan.nextLine();

                        if (finChoice.equalsIgnoreCase("Y") || finChoice.equalsIgnoreCase("Yes")) {
                            outputInfo(name);
                            endLoop = true;
                        } else if (finChoice.equalsIgnoreCase("N") || finChoice.equalsIgnoreCase("No")) {
                            
                        } else {
                            System.out.print("\n[Sorry, Invalid Response]");
                        }
            } else {
                System.out.print("\n[Sorry, Invalid Response]");
            }
        }

    }

    static String outputInfo(String name) {
            return "Name: " + name;
    }

    
    /*
     *                      TODO
        *         [Redo Menu]
        *              - new game -> character creation
        *              - continue -> saved data
        *              - exit -> exit game()
        *              - settings -> adjust enemy difficulties
     */
    private static void entrySaveLog (String name) {
        // Formats Time (For user entry log)
         LocalDateTime currentDateTime = LocalDateTime.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy h:mm a");
         String formattedDateTime = currentDateTime.format(formatter);
        
        // Saves user name/choices and time to entry logs
        String filePath = "PlagueHeart/src/com/plaguedhearts/main/java/savedlogs/entry.txt";
        String entry = name + " :" + formattedDateTime;

         try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(entry);
            System.out.println("[ALERT]: File created successfully at: " + filePath);
         } catch (IOException e) {
            System.out.println("Error occurred while creating the file: " + e.getMessage());
         }
    }

    private static void menu () {
        System.err.println
        (
            """
                            [   MENU    ]

                    1. [New Game]
                    2. [Continue...]
                    3. [Settings]
                    4. [Exit]
            """
        );

        int userInput = scan.nextInt();
        scan.nextLine(); // consumes new line

            try {
                switch (userInput) {
                    case 1:
                        nameSelect();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("[Invalid Option, Choose From The Menu]");
                System.err.println(e);
            }

    }   
    
    public static void main(String[] args) {
        menu();
    }
    @Override
    public void run() {
        menu();
    }
    
}