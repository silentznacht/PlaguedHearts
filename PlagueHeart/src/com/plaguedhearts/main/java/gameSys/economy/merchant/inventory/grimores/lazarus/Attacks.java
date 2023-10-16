package main.java.gameSys.economy.merchant.inventory.grimores.lazarus;

import java.util.*;

public class Attacks {

    public int atk1 = (int) 250;
    public int atk2 = (int) 300;
    public int atk3 = (int) 150;
    public int atk4 = (int) 5000;

    public Attacks (int atk1, int atk2, int atk3, int atk4) {
        this.atk1 = atk1;
        this.atk2 = atk2;
        this.atk3 = atk3;
        this.atk4 = atk4;
    }

    public static String displayBook() { //TODO: Implement future deckhands by using 2-d arrays
         String [] lazAtks = {
            "The Gospel of John", "RESURRECT(ONE A DAY)",
            "Divinity", "ULTIMATE SKILL: LAZARUS"
        };

        return Arrays.toString(lazAtks);
    } 

}