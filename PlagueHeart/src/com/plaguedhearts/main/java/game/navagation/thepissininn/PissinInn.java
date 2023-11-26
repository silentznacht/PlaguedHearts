package main.java.game.navagation.thepissininn;

import java.util.*;
import main.java.game.dialogue.NPC;
import main.java.gamesys.Bank;

public class PissinInn extends Bank {
    /*
     *              Day Quota
     *       Attend to 5 customers, and reach 100 coins by the end of day 1
     * 
     *       [MENU] 
     *   OL'Copper : 4 Coins
     *   Devil's Breath: 6 Coins
     *   Groslux Special: 10 Coins
     *   Nurgles Nectar: 5 Coins
    *   Pesilence's Promise: 20 Coins
     *   Remedy Rum: 15 Coins
     *   
     * 
     * TODO: Create an array of objects from customer class, all objects pertain to drinks section
     * TODO: Use switch case to sort out user input
     */
    
     public PissinInn(int userBalance, int userCredits, int userPoints, int userOverallBalance) {
        super(userBalance, userCredits, userPoints, userOverallBalance);
        //TODO Auto-generated constructor stub
     }
    
     // Prices 
     private static int olCopperPrice = 4;
     private static int devilsBreathPrice = 6;
     private static int grosluxSpecialPrice = 10;
     private static int nurglesNectorPrice = 5;
     private static int pesilencePromisePrice = 20;
     private static int remedyRumPrice = 15;

     // Scanner & characters, drinks, actions, questions, answers, etc (randomized)
     private static Random random = new Random();
     private static Scanner tavernScan = new Scanner(System.in);
     private static String [] drinks  = NPC.drinks;
     private static String [] characters = NPC.characters;
     private static String [] actions = NPC.actions;
     private static String [] questions = NPC.questions;
     private static String [] answers = NPC.answers;
     private static String [] mixBook = NPC.mixBook;
     private static String [] mixBookAnswers = NPC.mixBookAnswera;
     private static String [] insults = NPC.drinkRelatedInsults;
 
     // Profits || Currency
     private static int balance = Bank.userBalance;
     private static int remainingBalance;
//_______________________________________________________________________________________________________________
   
    static String customerDialogue() {
        // randomly generated
        String character = characters[random.nextInt(characters.length)];
        String drink = drinks[random.nextInt(drinks.length)];
        String action = actions[random.nextInt(actions.length)];
        String dialogue = character + ": "  +  " " + action + " " + drink;

        return dialogue;
    }

    static void displayDrinks(int k) {
            System.out.println("\n        [Ale Menu]\n"); 
            int drinksPrices [] = {
                olCopperPrice, devilsBreathPrice, 
                grosluxSpecialPrice, nurglesNectorPrice,
                pesilencePromisePrice, remedyRumPrice
            };


            String [] drink = NPC.drinks;
            while(k <= drink.length) {if (k >= drinks.length) break; System.out.println(k + ")" + " [Drink]: " + drink[k].trim() + " (Price): " + drinksPrices[k]); k++;}
        
    }

    static void displayDrinkMenuMix(int drinkCount) {
        System.out.println("\n        [Mix Book: Drinks]\n");
        for (String drink : drinks) {
            drinkCount ++;
            System.out.println(drinkCount + ") " + "(" + drink + ")"); // 1) (drink)
        }
    }

    static void tavernGameInstructions() {
        System.out.println(
            """
                        [Mini Game: Ready the Mix!]      
            (Instructions: Below) 
                - Guess the correct mix
                - Choose an appropriate option from the choice 
                - (Nacht was too lazy to implment a search algorithm for pure input)
                - Must get proper mix correct 3 times a row to gain a point (3 points to win)
            """
        );
    }
    
    static void drinkSelector(String foundDrinkStr) {
        String drinkFound;
        for (int i = 0; i < drinks.length; i++) {
                if (drinks[i].contains(foundDrinkStr)) { // searches for foundDrinkStr within drinks arr, then assigns the index of the element within the arr to a var
                    drinkFound = drinks[i];
                    System.out.println("Test1: " + drinkFound);
                } 
        }
    }

    static void tavernGame(String foundDrinkStr) {
        tavernGameInstructions();
        System.out.println("\n[Enter Correct Mix Here ( H for help) ]");  
        boolean gameInProgress = true;
        String gameInput = tavernScan.nextLine();
                // mini-game logic
                    while (gameInProgress) { // while true (exits when user chooses to end game and turns gameInProgress false)
                            if (gameInput.equalsIgnoreCase("h") || gameInput.equalsIgnoreCase("help")) {
                                displayDrinkMenuMix(0);
                            }

                            //drinkSelector(foundDrinkStr);
                            
                    }
    }


    static void gameHandler (String foundDrinkStr) { // all same parameters (gameHandeler called in tavernJob, passes foundDrink, then passes same val to called drinkSelector)
        //drinkSelector(foundDrinkStr);
        tavernGame(foundDrinkStr);
    }


    static void handleDrinkOrder(String userAnswer) { // handles customers request for drinks, mix game for user
        boolean drinkFound = false;
    
        for (String drink : drinks) { // if the user matches the customers requested drink then it will move onto the tavern mini game 
            if (userAnswer.equalsIgnoreCase(drink)) {
                drinkFound = true;
                System.out.println("[Now Enter The Proper Mix For " + drink + " (Use H for help)]: ");
                // Implement logic for mixing the drink here
                //tavernMiniGame();
                break;
            }
    }
    
        if (!drinkFound) {
            System.out.println("\n[Alert: Sorry Invalid Answer]\n");
        }
    }

    
    static void tavernJob() { // Handles tavern job -> sends user to handle drinks, and display drinks
        System.out.println("\n        [Tavern Job]\n\n");
        Scanner tavernScan = new Scanner(System.in);
        boolean servingDrinks = true;
    
        while (servingDrinks) { // will loop until servingDrinks booleans turns false
            String test = PissinInn.customerDialogue();
            // System.out.println("[ORDER]: " + test);
            // System.out.println(test);
            Scanner drinkSc = new Scanner(test);
            String foundDrinkStr;
            while (drinkSc.hasNext()) { // checks each word within customer dialogue, to make sure if a drink is detected
                String word = drinkSc.next();
                System.out.println("Word: " + word);
                // for loop works through one word each from the str var, due to while loop using scanner to loop through all strings in test var
                    for (String drinkStr : drinks) { // searchs for keywords to a drink (exmp: Rum (Remedy Rum))
                            if (drinkStr.contains(word)) {
                                String wordFound = word;
                                foundDrinkStr = wordFound;
                                //System.out.println("Found!: " + word);
                                // Note: foundDrinkStr is being initilized in drinKSelector method to execute switch case, this is because whatever value is used here (found word), will be substituted in the methods use when being called
                                gameHandler(foundDrinkStr);
                                break; // breaks for loop
                            }

                    }
                    //break; // breaks drinkSc while loop once conditional (if statement) is done
             }
             servingDrinks = false; // breaks serving drinks while loop, (user chooses to stop serving drinks)

            // System.out.println("[Answer(Mix) -> (Enter Any Input to Continue) Use H for help]: ");
    
            // String userAnswer = tavernScan.nextLine();
        
            //     if (userAnswer.equalsIgnoreCase("help") || userAnswer.equalsIgnoreCase("h")) { // help menu
            //         displayDrinkMenuMix(0);
            //     } else { 
            //         handleDrinkOrder(userAnswer);
            //     }
        
            // System.out.println("Do you want to continue serving drinks (Y/N)?");
            // String continueOption = tavernScan.nextLine();

            //     if (!continueOption.equalsIgnoreCase("Y")) { // means continueOption stays false when user input is anything other than "Y", thus ending the loop
            //         servingDrinks = false;                                 // Y -> exit (stop serving drinks)
            //     }
        }
    
        tavernScan.close();
    }
    
//_______________________________________________________________________________________________________________

    static void buyDrinks(int drinkChoice) {
        String chosenDrink = drinks[drinkChoice - 1]; // Adjust index by -1 since array index starts from 0
        boolean priceSearch = false;
                    System.out.println("Chosen Drink: " + chosenDrink);
                    priceSearch = true;
                        if (priceSearch = true) {
                            switch(chosenDrink) { // Assigns price reduction according to drink (userbalance - drinkPrice) -> remaining balance
                                case "Ol'Copper":
                                    remainingBalance = userBalance -= olCopperPrice;
                                    break;
                                case "Devil's Breath":
                                    remainingBalance = userBalance -= devilsBreathPrice;
                                    break;
                                case "Groslux Special":
                                    remainingBalance = userBalance -= grosluxSpecialPrice;
                                    break;
                                case "Nurgle's Nectar":
                                    remainingBalance = userBalance -= nurglesNectorPrice;
                                    break;
                                case "Pestilence's Promise":
                                    remainingBalance = userBalance -= pesilencePromisePrice;
                                    break;
                                case "Remedy Rum":
                                    remainingBalance = userBalance -= remedyRumPrice;
                                    break;
                            }
                            System.out.println("[Alert: (Remaining Balance): " + remainingBalance + " ]");
                        }
    }

    static void tranHandler(boolean loopCheck) {
        displayDrinks(0);
        System.out.println("[ Barkeep: So boy, what ale ye achin' for? (Enter Drink From Ale Menu Above) ] :");
        int drinkChoice;

            while (!loopCheck) { // if drinkChoice is lower than or greater than any index within the array of drinks -> drinkchosen not matched
                if (tavernScan.hasNextInt()) {
                        drinkChoice = tavernScan.nextInt();
                        if (drinkChoice <= 0 || drinkChoice > drinks.length) {// if userchoice is invalid || out of range from options
                            System.out.println("\n[Barkeep: Sorry mate that we don't serve that here, tell me another]: ");
                            drinkChoice = tavernScan.nextInt(); // Ask for input again 
                        } else { // restarts array to 0, to give user another chance, including making match process not bias
                                tavernScan.nextLine();
                                buyDrinks(drinkChoice); // drinkchoice (here) -> input indicator in other method
                                loopCheck = true;
                        } 

                } else {
                    System.out.println("\n[Alert]: Sorry, that wasn't a valid choice (Number from Menu) ");
                    tavernScan.nextLine(); // Clear the invalid input from the scanner buffer
                }
            }
    }
 
    
    static void menu() {
        System.out.println (
            """
                                    [The Pissin' Inn] 
            
            Harold(Barkeep): Oi boy, what ya spicin for?

            1. [Drinks]
            2. [Work: Extra Coin]
            3. [Exit]

            [Enter Below]: 
            """
        );

        int menuChoice = tavernScan.nextInt();
            switch(menuChoice) {
                case 1:
                    tranHandler(false);
                    break;
                case 2:
                    tavernJob();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }



    }
     public static void main(String [] args) { 
            menu();
     }

}
