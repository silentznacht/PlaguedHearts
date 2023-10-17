package main.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSSerializer;

import main.java.gamesys.economy.merchant.inventory.swords.Frostmourne;

public class FrostT {
    // assertsEquals -> compares two values (must be the same type or will get error)
    // assertsTrue -> checks boolean 
    // FrostMourne dmg tester
    @Test
    public void dmgFrostTester() { 
        /*
            dmgFrost equals to final dmg in frostmourne class, result will compare dmgTesterF methods conditional 
            with dmgFrost value, then asserts true checks with returning true or false 
        */
        double dmgFrost = Frostmourne.finalDmg;
        boolean result = dmgTesterF(dmgFrost);
        assertTrue(result);
    }

    // Helper method for testing Frost damage
    private boolean dmgTesterF(double dmgFrost) { // if dmg returns above 500 -> true, else -> false
        return dmgFrost > 500;
    }

}