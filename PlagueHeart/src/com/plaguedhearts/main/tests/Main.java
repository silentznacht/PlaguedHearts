package main.tests;


import java.util.*;
import java.util.jar.Attributes;

import main.java.gamesys.economy.merchant.inventory.armor.HeavySteel;

class Student {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        idk();

    }

    static void idk () {
        Student student = new Student("Alice", 20);
        System.out.println(student.getAge());
        System.out.println(student.getName());
    }
}
