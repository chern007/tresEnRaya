package com.example.carlos.tresenraya;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Tres en Raya");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.juego_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int opcion = item.getItemId();

        if (opcion == R.id.mnInstrucciones) {

            Toast.makeText(getApplicationContext(), "¿Cómo se juega?", Toast.LENGTH_LONG).show();
            //startActivity(new Intent(this, instrucciones.class));
            openInstrucciones();

        } else if (opcion == R.id.mnConfigurar) {

            Toast.makeText(getApplicationContext(), "Configura tu partida.", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, configuracion.class));

        } else if (opcion == R.id.mnHome) {

            Toast.makeText(getApplicationContext(), "Pantalla de inicio.", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivity.class));

        } else if (opcion == R.id.mnNuevo) {

            Toast.makeText(getApplicationContext(), "¡Vamos a jugar!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, juego.class));

        }


        return super.onOptionsItemSelected(item);
    }

    public void openInstrucciones() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.dialogo_config,null);
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




}








