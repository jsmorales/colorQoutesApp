package com.example.johanmorales.colorquotes;

import java.util.Random;

public class UtilitiesColor {

    public static int getRandomNumberCita(int max){
        Random random = new Random();
        random.setSeed(System.currentTimeMillis()); //seed based on time system
        int numeroRandom = random.nextInt(max); //return int based on the max number
        return numeroRandom;
    }
}
