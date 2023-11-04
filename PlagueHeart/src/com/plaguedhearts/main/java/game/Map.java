package main.java.game;

public class Map {

    /*
        Y
        |
        |
        |
        |
        |
        |
        |
        |
        |
        |  
        -------------------------------- X
     */

    // User Location
    protected static int userLocationX = 0;
    protected static int userLocationY = 0;

    // Kraven's Wares Location (x,y) -> ()
    protected static int kWaresLocationX = 5;
    protected static int kWaresLocationY = 2;

    // The Pissin' Inn Location
    protected static int pInnLocationX = 3;
    protected static int pInnLocationY = 5;

    public Map(int userLocationX, int userLocationY, int kWaresLocationX, int kWaresLocationY, int pInnLocationX, int pInnLocationY) {
            Map.userLocationX = userLocationX;
            Map.kWaresLocationY = userLocationY;
            Map.kWaresLocationX = kWaresLocationX;
            Map.kWaresLocationY = kWaresLocationY;
            Map.pInnLocationX = pInnLocationX;
            Map.pInnLocationY = pInnLocationY;
    }
    
}
