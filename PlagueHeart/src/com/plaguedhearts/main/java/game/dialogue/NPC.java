package main.java.game.dialogue;

import java.util.Random;

public class NPC {
    public static String[] characters = {"Sir Reginald", "Lady Elara", "Barkeep", "Bard"};
    public static String[] locations = {"in a dimly lit tavern", "by the roaring fireplace", "under the flickering candlelight"};
    public static String[] actions = {"says", "asks", "shouts", "whispers"};
    public static String[] drinks = {"Ol'Copper", "Devil's Breath", "Groslux Special", "Nurgle's Nectar", "Pestilence's Promise", "Remedy Rum"};
    public static String[] topics = {
        "The dragon's hoard in the nearby cave",
        "The mysterious disappearance of the town's blacksmith",
        "A haunting tale of a ghost in the forest",
        "The latest rumors from the kingdom's court",
        "The quality of the ale in this tavern"
    };
    
    public String[] drinkQuestions = {
        "What's the finest ale you have on tap?",
        "Do you have any special brews today?",
        "Can you recommend a drink to warm the bones on a cold night?",
        "Tell me, what's the secret recipe of your famous mead?"
    };

    
     // Questions || Barkeep (why didn't i just initialize this locally?)

     public static String[] questions = {
        "Which family wields the ability 'ROT' granted by Nurgle?",
        "What is the unique ability possessed by the Maladictus family?",
        "What noble family founded the Pestisdictus Hospitals Foundation?",
        "What kind of discharge do Viruliths release using their 'ROT' ability?",
        "Who can reverse the chaotic effects caused by the 'FRENZY' ability of the Maladictus family?",
        "What is the primary focus of the Morbidius family's contributions to Pestisdictus?",
        "What is the unique power granted by the 'BLIGHT' ability of the Morbidius family?"
        // Add more questions here...
    };

    public static String[] answers = {
        "Virulith",
        "FRENZY",
        "Morbidius",
        "Infectious diseases causing rapid decay",
        "Few individuals from the Morbidius family",
        "Advancing medicine and human biology, founding hospitals",
        "Transmuting living organisms with infectious bacteria"
        // Add corresponding answers here...
    };

    private Random random;

    public NPC() {
        random = new Random();
    }

    public String generateRandomDialogue() {
        String character = characters[random.nextInt(characters.length)];
        String location = locations[random.nextInt(locations.length)];
        String action = actions[random.nextInt(actions.length)];

        // Check if the character is the barkeep, and if so, ask a drink-related question
        String topic;
        if (character.equals("Barkeep")) {
            topic = drinkQuestions[random.nextInt(drinkQuestions.length)];
        } else {
            topic = topics[random.nextInt(topics.length)];
        }

        return character + " " + action + " at the " + location + ": \"" + topic + "\"";
    }

    public static void main(String[] args) {
        NPC generator = new NPC();
        for (int i = 0; i < 5; i++) {
            String dialogue = generator.generateRandomDialogue();
            System.out.println(dialogue);
        }
    }
}