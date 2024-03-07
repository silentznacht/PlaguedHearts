package tests;


import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import main.java.gamesys.economy.merchant.inventory.swords.BlackFyre;

public class BlackFyreT {
    @Test 

    public void dmgBFyreTest() {
        double finalDmg = BlackFyre.finalDmg;
        boolean result = dmgTesterB(finalDmg);
        assertTrue(result);
    }
 
    public boolean dmgTesterB (double finalDmg) {
        return finalDmg < 500;
    }
}
