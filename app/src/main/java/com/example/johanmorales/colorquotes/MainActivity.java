package com.example.johanmorales.colorquotes;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    public static final String TAG = MainActivity.class.getSimpleName(); //gets the name of the app

    //Declare variables of the same type
    private TextView citaTextView, autorTextView;
    private Button nuevaCitaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //main method

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         *Relate the elements of the activity main xml
         * */
        citaTextView = findViewById(R.id.citaTextView); //R = File generated automatic
        autorTextView = findViewById(R.id.autorTextView);
        nuevaCitaButton = findViewById(R.id.nuevaCitaButton);

        //starts a quote
        nuevaCitaButton.callOnClick();

        /*
        * Attach the click listener on the code
        * nuevaCitaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                citaTextView.setText("Esta es una cita aleatoria.");
                autorTextView.setText("N.N.");

                //log method
                Log.i(TAG,"Imprimiendo algo en la pantalla");

            }
        });
        * */
    }

    //Define the method for XML onClick Method
    public void nuevaCita(View view){

        GeneradorCitas gener = new GeneradorCitas();

        gener.GeneradorDeCitas();

        Cita cita = gener.obtenerCita();

        citaTextView.setText(cita.getTexto());
        autorTextView.setText(cita.getAutor());

        citaTextView.setTextColor(cita.getColor());
        autorTextView.setTextColor(cita.getColor());
        nuevaCitaButton.setBackgroundColor(cita.getColor());

        //GERENTE DE TECNOLOGÍA E INFORMATICA
        //GERENCIA DE TECNOLOGÍA E INFORMATICA
        //ADMON
    }

}
