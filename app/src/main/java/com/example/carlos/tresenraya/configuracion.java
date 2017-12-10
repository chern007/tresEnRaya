package com.example.carlos.tresenraya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class configuracion extends MainActivity {

    public static boolean multijuador = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        setTitle("Configuración");
    }
}
