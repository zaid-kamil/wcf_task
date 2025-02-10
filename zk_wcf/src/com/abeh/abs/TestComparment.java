package com.abeh.abs;
import java.util.Random;

class TestCompartment {
    public static void main(String[] args) {
        Compartment[] compartments = new Compartment[10];
        Random rand = new Random();

        for (int i = 0; i < compartments.length; i++) {
            int randomNum = rand.nextInt(4) + 1;
            switch (randomNum) {
                case 1 -> compartments[i] = new FirstClass();
                case 2 -> compartments[i] = new Ladies();
                case 3 -> compartments[i] = new General();
                case 4 -> compartments[i] = new Luggage();
            }
        }

        for (Compartment compartment : compartments) {
            System.out.println(compartment.notice());
        }
    }
}