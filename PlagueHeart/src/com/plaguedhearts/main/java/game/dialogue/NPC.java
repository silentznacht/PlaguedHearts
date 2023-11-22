package main.java.game.dialogue;

import java.util.Random;

public class NPC {
    private Random random;
    public static String[] characters = {"Sir Reginald", "Lady Elara", "Barkeep", "Bard", "Winston", "Minerva", "Beatrix", "Severus"};
    public static String[] locations = {"in a dimly lit tavern", "by the roaring fireplace", "under the flickering candlelight", "under your mums tits"};
    public static String[] actions = {"says", "asks", "shouts", "whispers", "whales", "begs for a"};
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
        "Which family wielded the perilous ability known as 'ROT'?",
        "What ability did the Maladictus family inherit?",
        "What did the Morbidius family found during the early days of Groslux?",
        "What did the ability 'BLIGHT' enable the Morbidius clan to do?"
    };

    public static String[] answers = {
        "Virulith",
        "FRENZY",
        "Pestisdictus Hospitals Foundation",
        "Transmute living organisms and heal"
    };

    
    public static String [] mixBookAnswera = {
        "1) Green + Grey",
        "2) Devil's Breath: Orange + Purple", 
        "3) Groslux Special: Green + Red", 
        "4) Nurgle's Nectar: Green + Blue", 
        "5) Pestilence's Promise: Black + Green", 
        "6) Remedy Rum: Brown + Yellow"
    };
    public static String [] mixBook = {
        "Ol'Copper: Green + Grey",
        "Devil's Breath: Orange + Purple", 
        "Groslux Special: Green + Red", 
        "Nurgle's Nectar: Green + Blue", 
        "Pestilence's Promise: Black + Green", 
        "Remedy Rum: Brown + Yellow"
    };

    public static String[] drinkRelatedInsults = {
        "Thou shalt sup on naught but water from a stagnant pond!",
        "Verily, thou art denied the nectar of thine desire!",
        "Ye shall thirst like a parched desert wanderer!",
        "Thou art deprived of the sweet ambrosia that quenches!",
        "Mayest thou sip only from the chalice of disappointment!",
        "Thou shalt taste the bitter draught of denial!",
        "Thine cup runneth empty, forsooth!",
        "Denied the brew of choice, thou art left to languish!"
    };
    

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