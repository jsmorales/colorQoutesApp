package com.example.johanmorales.colorquotes;

import android.graphics.Color;
import android.util.Log;

public class GeneradorCitas {

    public static final String TAG = MainActivity.class.getSimpleName(); //gets the name of the app

    private Cita[] cita;
    private int[] colorsArray;

    public void GeneradorDeCitas(){

        cita = new Cita[4];
        colorsArray = new int[6];

        colorsArray[0] = Color.RED;
        colorsArray[1] = Color.GREEN;
        colorsArray[2] = Color.CYAN;
        colorsArray[3] = Color.MAGENTA;
        colorsArray[4] = Color.YELLOW;
        colorsArray[5] = Color.DKGRAY;

        cita[0] = new Cita();
        cita[0].setAutor("Walt Disney");
        cita[0].setTexto("Si tienes un sueño y crees en él, corres el riesgo de que se convierta en realidad");
        cita[0].setColor(colorsArray[0]);

        cita[1] = new Cita();
        cita[1].setAutor("Albert Einstein");
        cita[1].setTexto("El secreto de la creatividad es saber cómo esconder tus fuentes");
        cita[1].setColor(colorsArray[1]);

        cita[2] = new Cita();
        cita[2].setAutor("Steve Jobs");
        cita[2].setTexto("A veces cuando se innova, se cometen errores. Es mejor admitirlo rápidamente y continuar con otras innovaciones.");
        cita[2].setColor(colorsArray[2]);

        cita[3] = new Cita();
        cita[3].setAutor("Irving Berlin");
        cita[3].setTexto("Life is 10 percent what you make it and 90 percent how you take it.");
        cita[3].setColor(colorsArray[3]);
    }

    public Cita obtenerCita(){

        int numRam = UtilitiesColor.getRandomNumberCita(cita.length);

        int numRandomColor = UtilitiesColor.getRandomNumberCita(colorsArray.length - 1);

        Log.d(TAG, String.valueOf(numRam));
        Log.d(TAG, String.valueOf(numRandomColor));

        cita[numRam].setColor(colorsArray[numRandomColor]);

        return cita[numRam];
    }
}
