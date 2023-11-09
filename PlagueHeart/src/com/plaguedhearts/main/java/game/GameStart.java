package main.java.game;

public class GameStart implements Runnable {

    private static final String TITLE = "PlaguedHearts";
    private boolean running = false;
    private GameStart game;
    private Thread thread;

    public GameStart() {
        game = null; // Initialize game object
    }

    public void start() {
        if (running) return;
        running = true;
        thread = new Thread(this);

        System.out.println("Working!");
        thread.start(); // Start a new thread to execute the run method
    }

    public void stop() {
        if (!running) return;
        running = false;
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void run() {
        // Implement the game loop logic here
        
    }

    public static void main(String[] args) {
        GameStart game = new GameStart();
        System.out.print("Running....");
        game.start(); // Initialize and start the game
    }
}
