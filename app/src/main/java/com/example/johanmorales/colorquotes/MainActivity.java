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

    //primer estado del ciclo de vida de la actividad, viene con el bundle savedInstanceState
    //con los estados guardados previamente
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

        //charge the estate on create method
        /*
        if(savedInstanceState != null){

            citaTextView.setText(savedInstanceState.getString("cita"));
            autorTextView.setText(savedInstanceState.getString("autor"));

            int color = savedInstanceState.getInt("color");

            citaTextView.setTextColor(color);
            autorTextView.setTextColor(color);
            nuevaCitaButton.setBackgroundColor(color);
        }*/

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

    //sigue el ciclo onStart, casi nunca se utiliza

    //continua onResume se ejecuta cuando la actividad esta lista para el ususario
    //se puede usar para inicializar animaciones o musica

    //En este punrto la actividad se esta ejecutando en el top de la pila

    //si el usuario sale se ejecuta
    //OnPause() --> en este metodo se paran animaciones o musica y se pueden guardar datos en la bd
    //OnStop() --> se llama cuando la actividad ya no es visible al usuario y queda pendiente para su destruccion
    //OnDestroy() --> destruye la actividad por completo

    //si una actividad esta OnStop() y se reanuda se ejecita el metodo OnRestart()
    //la cual vuelve a ejecitar el metodo OnStart()

    //para finalmente darla por terminada



    //see this methods pressing ctrl+o

    //for save the state of our main activity overrides the method:
    //guarda estados
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Bundle is an object can save a key and a value
        //on this case we save the cita, autor and the color
        //"cita" deberia ser una constante como TAG --> CITA
        outState.putString("cita",citaTextView.getText().toString());
        outState.putString("autor",autorTextView.getText().toString());
        outState.putInt("color", citaTextView.getCurrentTextColor());
    }

    //for restore the state saved previously
    //carga estados
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        citaTextView.setText(savedInstanceState.getString("cita"));
        autorTextView.setText(savedInstanceState.getString("autor"));

        int color = savedInstanceState.getInt("color");

        citaTextView.setTextColor(color);
        autorTextView.setTextColor(color);
        nuevaCitaButton.setBackgroundColor(color);
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
