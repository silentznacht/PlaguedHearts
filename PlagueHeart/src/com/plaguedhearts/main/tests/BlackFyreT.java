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

import main.java.gamesys.economy.merchant.inventory.swords.BlackFyre;

public class BlackFyreT {
    @Test 

    public void dmgBFyreTest() {
        double finalDmg = BlackFyre.finalDmg;
        boolean result = dmgTesterB(finalDmg);
        assertTrue(result);
    }
 
    public boolean dmgTesterB (double finalDmg) {
        return finalDmg > 500;
    }
}
