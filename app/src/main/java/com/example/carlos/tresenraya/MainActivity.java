package com.example.carlos.tresenraya;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MenuItem botonHome;
   static  boolean interruptorHOME = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Tres en Raya");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.juego_menu, menu);

        //captiramos el boton de home y lo apagamos

        botonHome = (MenuItem) menu.findItem(R.id.mnHome);

        //invalidateOptionsMenu();
        if (interruptorHOME) {
            botonHome.setVisible(true);
        } else {
            botonHome.setVisible(false);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int opcion = item.getItemId();


        if (opcion == R.id.mnInstrucciones) {

            Toast.makeText(getApplicationContext(), "¿Cómo se juega?", Toast.LENGTH_SHORT).show();
            //startActivity(new Intent(this, instrucciones.class));

            //activamos el boton de home
            interruptorHOME = false;
            invalidateOptionsMenu();

            openInstrucciones();


        } else if (opcion == R.id.mnConfigurar) {

            Toast.makeText(getApplicationContext(), "Configura tu partida.", Toast.LENGTH_SHORT).show();
            //startActivity(new Intent(this, configuracion.class));

            //activamos el boton de home
            interruptorHOME = false;
            invalidateOptionsMenu();

            openConfiguracion();


        } else if (opcion == R.id.mnHome) {

            Toast.makeText(getApplicationContext(), "Pantalla de inicio.", Toast.LENGTH_SHORT).show();

            //apagamos el boton de home
            interruptorHOME = false;

            startActivity(new Intent(this, MainActivity.class));

        } else if (opcion == R.id.mnNuevo) {

            Toast.makeText(getApplicationContext(), "¡Vamos a jugar!", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, juego.class));

            //activamos el boton de home
            interruptorHOME = true;
            invalidateOptionsMenu();

        }


        return super.onOptionsItemSelected(item);
    }

    //metodo que muestra un dialogo en el que "infla" dialogo_instru.xml
    public void openInstrucciones() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.dialogo_instru, null);
        Button botonOK = (Button) mView.findViewById(R.id.dialog_ok);
        mBuilder.setView(mView);
        final AlertDialog dialogo = mBuilder.create();
        dialogo.show();

        botonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo.hide();
            }
        });
    }

    public void openConfiguracion() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.dialogo_confg, null);
        Button botonSAVE = (Button) mView.findViewById(R.id.btGuardar);
        mBuilder.setView(mView);
        final AlertDialog dialogo2 = mBuilder.create();
        dialogo2.show();

        botonSAVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton opt2 = (RadioButton) dialogo2.findViewById(R.id.btDosJugadores);

                //configuramos la variable para ver si jugamos en modo multijugador o contra la maquina
                if (opt2.isChecked()) {
                    logica_juego.multijuador = true;
                } else {
                    logica_juego.multijuador = false;
                }

                dialogo2.hide();//cerramos el dialogo de configuracion
            }
        });

    }


}








