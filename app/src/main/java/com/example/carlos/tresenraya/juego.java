package com.example.carlos.tresenraya;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class juego extends MainActivity {

    public Button BT1;
    public Button BT2;
    public Button BT3;
    public Button BT4;
    public Button BT5;
    public Button BT6;
    public Button BT7;
    public Button BT8;
    public Button BT9;
    public Button[] TODOSBOTONES = new Button[9];

    private Drawable fondoBotones;
    public TextView pantallaInfo;
    
    private IA inteligenciaArtificial = new IA();

    long TInicio, TFin, tiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        setTitle("Jugando");

        //creamos los objetos boton para manejarlos
        BT1 = TODOSBOTONES[0] = (Button) findViewById(R.id.bt1);
        BT2 = TODOSBOTONES[1] = (Button) findViewById(R.id.bt2);
        BT3 = TODOSBOTONES[2] = (Button) findViewById(R.id.bt3);
        BT4 = TODOSBOTONES[3] = (Button) findViewById(R.id.bt4);
        BT5 = TODOSBOTONES[4] = (Button) findViewById(R.id.bt5);
        BT6 = TODOSBOTONES[5] = (Button) findViewById(R.id.bt6);
        BT7 = TODOSBOTONES[6] = (Button) findViewById(R.id.bt7);
        BT8 = TODOSBOTONES[7] = (Button) findViewById(R.id.bt8);
        BT9 = TODOSBOTONES[8] = (Button) findViewById(R.id.bt9);
        pantallaInfo = (TextView) findViewById(R.id.txtInfo);


        //definimos un nuevo fondo para los botones
        fondoInicialBotones(BT1, BT2, BT3, BT4, BT5, BT6, BT7, BT8, BT9);


        pantallaInfo.setText("COMIENZA EL JUEGO JUGADOR 1 (O)");


        BT1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (logica_juego.turnoUsuario == 1) {
                    BT1.setBackgroundResource(R.drawable.circulito);
                    logica_juego.tablero[0] = 1;
                    BT1.setEnabled(false);

                    if (compruebaGandor()) {
                        return;
                    }

                    logica_juego.turnoUsuario = 2;//pasamos al turno del siguiente usuario

                    if (logica_juego.multijuador) {

                        pantallaInfo.setText("TURNO DEL JUGADOR 2 (X)");
                    } else {

                        pantallaInfo.setText("PENSANDO...");

//                        TInicio = System.currentTimeMillis();
                        //int casillaIA = logica_juego.movimientoMaquinaIA();
                        int casillaIA = inteligenciaArtificial.movimiento(logica_juego.tablero);
//                        TFin = System.currentTimeMillis();
//                        tiempo = TFin - TInicio;

                        TODOSBOTONES[casillaIA].setBackgroundResource(R.drawable.crucecita);
                        logica_juego.tablero[casillaIA] = 2;
                        TODOSBOTONES[casillaIA].setEnabled(false);
                        if (compruebaGandor()) {
                            return;
                        }
                        pantallaInfo.setText("TURNO DEL JUGADOR 1 (O)");
                        logica_juego.turnoUsuario = 1;//pasamos al turno del siguiente usuario
                    }

                } else {
                    BT1.setBackgroundResource(R.drawable.crucecita);
                    logica_juego.tablero[0] = 2;
                    BT1.setEnabled(false);

                    if (compruebaGandor()) {
                        return;
                    }

                    logica_juego.turnoUsuario = 1;//pasamos al turno del siguiente usuario
                    pantallaInfo.setText("TURNO DEL JUGADOR 1 (O)");
                }
            }
        });


        BT2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (logica_juego.turnoUsuario == 1) {
                    BT2.setBackgroundResource(R.drawable.circulito);
                    logica_juego.tablero[1] = 1;
                    BT2.setEnabled(false);

                    if (compruebaGandor()) {
                        return;
                    }

                    logica_juego.turnoUsuario = 2;//pasamos al turno del siguiente usuario

                    if (logica_juego.multijuador) {

                        pantallaInfo.setText("TURNO DEL JUGADOR 2 (X)");
                    } else {

                        pantallaInfo.setText("PENSANDO...");
                        //int casillaIA = logica_juego.movimientoMaquinaIA();
                        int casillaIA = inteligenciaArtificial.movimiento(logica_juego.tablero);


                        TODOSBOTONES[casillaIA].setBackgroundResource(R.drawable.crucecita);
                        logica_juego.tablero[casillaIA] = 2;
                        TODOSBOTONES[casillaIA].setEnabled(false);
                        if (compruebaGandor()) {
                            return;
                        }
                        pantallaInfo.setText("TURNO DEL JUGADOR 1 (O)");
                        logica_juego.turnoUsuario = 1;//pasamos al turno del siguiente usuario
                    }
                } else {
                    BT2.setBackgroundResource(R.drawable.crucecita);
                    logica_juego.tablero[1] = 2;
                    BT2.setEnabled(false);
                    logica_juego.turnoUsuario = 1;//pasamos al turno del siguiente usuario
                    pantallaInfo.setText("TURNO DEL JUGADOR 1 (O)");
                }
            }
        });


        BT3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (logica_juego.turnoUsuario == 1) {
                    BT3.setBackgroundResource(R.drawable.circulito);
                    logica_juego.tablero[2] = 1;
                    BT3.setEnabled(false);

                    if (compruebaGandor()) {
                        return;
                    }

                    logica_juego.turnoUsuario = 2;//pasamos al turno del siguiente usuario

                    if (logica_juego.multijuador) {

                        pantallaInfo.setText("TURNO DEL JUGADOR 2 (X)");
                    } else {

                        pantallaInfo.setText("PENSANDO...");
                        //int casillaIA = logica_juego.movimientoMaquinaIA();
                        int casillaIA = inteligenciaArtificial.movimiento(logica_juego.tablero);


                        TODOSBOTONES[casillaIA].setBackgroundResource(R.drawable.crucecita);
                        logica_juego.tablero[casillaIA] = 2;
                        TODOSBOTONES[casillaIA].setEnabled(false);
                        if (compruebaGandor()) {
                            return;
                        }
                        pantallaInfo.setText("TURNO DEL JUGADOR 1 (O)");
                        logica_juego.turnoUsuario = 1;//pasamos al turno del siguiente usuario
                    }
                } else {
                    BT3.setBackgroundResource(R.drawable.crucecita);
                    logica_juego.tablero[2] = 2;
                    BT3.setEnabled(false);

                    if (compruebaGandor()) {
                        return;
                    }

                    logica_juego.turnoUsuario = 1;//pasamos al turno del siguiente usuario
                    pantallaInfo.setText("TURNO DEL JUGADOR 1 (O)");
                }
            }
        });


        BT4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (logica_juego.turnoUsuario == 1) {
                    BT4.setBackgroundResource(R.drawable.circulito);
                    logica_juego.tablero[3] = 1;
                    BT4.setEnabled(false);

                    if (compruebaGandor()) {
                        return;
                    }

                    logica_juego.turnoUsuario = 2;//pasamos al turno del siguiente usuario

                    if (logica_juego.multijuador) {

                        pantallaInfo.setText("TURNO DEL JUGADOR 2 (X)");
                    } else {

                        pantallaInfo.setText("PENSANDO...");
                        //int casillaIA = logica_juego.movimientoMaquinaIA();
                        int casillaIA = inteligenciaArtificial.movimiento(logica_juego.tablero);


                        TODOSBOTONES[casillaIA].setBackgroundResource(R.drawable.crucecita);
                        logica_juego.tablero[casillaIA] = 2;
                        TODOSBOTONES[casillaIA].setEnabled(false);
                        if (compruebaGandor()) {
                            return;
                        }
                        pantallaInfo.setText("TURNO DEL JUGADOR 1 (O)");
                        logica_juego.turnoUsuario = 1;//pasamos al turno del siguiente usuario
                    }
                } else {
                    BT4.setBackgroundResource(R.drawable.crucecita);
                    logica_juego.tablero[3] = 2;
                    BT4.setEnabled(false);

                    if (compruebaGandor()) {
                        return;
                    }

                    logica_juego.turnoUsuario = 1;//pasamos al turno del siguiente usuario
                    pantallaInfo.setText("TURNO DEL JUGADOR 1 (O)");
                }
            }
        });


        BT5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (logica_juego.turnoUsuario == 1) {
                    BT5.setBackgroundResource(R.drawable.circulito);
                    logica_juego.tablero[4] = 1;
                    BT5.setEnabled(false);

                    if (compruebaGandor()) {
                        return;
                    }

                    logica_juego.turnoUsuario = 2;//pasamos al turno del siguiente usuario

                    if (logica_juego.multijuador) {

                        pantallaInfo.setText("TURNO DEL JUGADOR 2 (X)");
                    } else {

                        pantallaInfo.setText("PENSANDO...");
                        //int casillaIA = logica_juego.movimientoMaquinaIA();
                        int casillaIA = inteligenciaArtificial.movimiento(logica_juego.tablero);


                        TODOSBOTONES[casillaIA].setBackgroundResource(R.drawable.crucecita);
                        logica_juego.tablero[casillaIA] = 2;
                        TODOSBOTONES[casillaIA].setEnabled(false);
                        if (compruebaGandor()) {
                            return;
                        }
                        pantallaInfo.setText("TURNO DEL JUGADOR 1 (O)");
                        logica_juego.turnoUsuario = 1;//pasamos al turno del siguiente usuario
                    }
                } else {
                    BT5.setBackgroundResource(R.drawable.crucecita);
                    logica_juego.tablero[4] = 2;
                    BT5.setEnabled(false);

                    if (compruebaGandor()) {
                        return;
                    }

                    logica_juego.turnoUsuario = 1;//pasamos al turno del siguiente usuario
                    pantallaInfo.setText("TURNO DEL JUGADOR 1 (O)");
                }
            }
        });


        BT6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (logica_juego.turnoUsuario == 1) {
                    BT6.setBackgroundResource(R.drawable.circulito);
                    logica_juego.tablero[5] = 1;
                    BT6.setEnabled(false);

                    if (compruebaGandor()) {
                        return;
                    }

                    logica_juego.turnoUsuario = 2;//pasamos al turno del siguiente usuario

                    if (logica_juego.multijuador) {

                        pantallaInfo.setText("TURNO DEL JUGADOR 2 (X)");
                    } else {

                        pantallaInfo.setText("PENSANDO...");
                        //int casillaIA = logica_juego.movimientoMaquinaIA();
                        int casillaIA = inteligenciaArtificial.movimiento(logica_juego.tablero);


                        TODOSBOTONES[casillaIA].setBackgroundResource(R.drawable.crucecita);
                        logica_juego.tablero[casillaIA] = 2;
                        TODOSBOTONES[casillaIA].setEnabled(false);
                        if (compruebaGandor()) {
                            return;
                        }
                        pantallaInfo.setText("TURNO DEL JUGADOR 1 (O)");
                        logica_juego.turnoUsuario = 1;//pasamos al turno del siguiente usuario
                    }
                } else {
                    BT6.setBackgroundResource(R.drawable.crucecita);
                    logica_juego.tablero[5] = 2;
                    BT6.setEnabled(false);

                    if (compruebaGandor()) {
                        return;
                    }

                    logica_juego.turnoUsuario = 1;//pasamos al turno del siguiente usuario
                    pantallaInfo.setText("TURNO DEL JUGADOR 1 (O)");
                }
            }
        });


        BT7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (logica_juego.turnoUsuario == 1) {
                    BT7.setBackgroundResource(R.drawable.circulito);
                    logica_juego.tablero[6] = 1;
                    BT7.setEnabled(false);

                    if (compruebaGandor()) {
                        return;
                    }

                    logica_juego.turnoUsuario = 2;//pasamos al turno del siguiente usuario

                    if (logica_juego.multijuador) {

                        pantallaInfo.setText("TURNO DEL JUGADOR 2 (X)");
                    } else {

                        pantallaInfo.setText("PENSANDO...");
                        //int casillaIA = logica_juego.movimientoMaquinaIA();
                        int casillaIA = inteligenciaArtificial.movimiento(logica_juego.tablero);


                        TODOSBOTONES[casillaIA].setBackgroundResource(R.drawable.crucecita);
                        logica_juego.tablero[casillaIA] = 2;
                        TODOSBOTONES[casillaIA].setEnabled(false);
                        if (compruebaGandor()) {
                            return;
                        }
                        pantallaInfo.setText("TURNO DEL JUGADOR 1 (O)");
                        logica_juego.turnoUsuario = 1;//pasamos al turno del siguiente usuario
                    }
                } else {
                    BT7.setBackgroundResource(R.drawable.crucecita);
                    logica_juego.tablero[6] = 2;
                    BT7.setEnabled(false);

                    if (compruebaGandor()) {
                        return;
                    }

                    logica_juego.turnoUsuario = 1;//pasamos al turno del siguiente usuario
                    pantallaInfo.setText("TURNO DEL JUGADOR 1 (O)");
                }
            }
        });


        BT8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (logica_juego.turnoUsuario == 1) {
                    BT8.setBackgroundResource(R.drawable.circulito);
                    logica_juego.tablero[7] = 1;
                    BT8.setEnabled(false);

                    if (compruebaGandor()) {
                        return;
                    }

                    logica_juego.turnoUsuario = 2;//pasamos al turno del siguiente usuario

                    if (logica_juego.multijuador) {

                        pantallaInfo.setText("TURNO DEL JUGADOR 2 (X)");
                    } else {

                        pantallaInfo.setText("PENSANDO...");
                        //int casillaIA = logica_juego.movimientoMaquinaIA();
                        int casillaIA = inteligenciaArtificial.movimiento(logica_juego.tablero);


                        TODOSBOTONES[casillaIA].setBackgroundResource(R.drawable.crucecita);
                        logica_juego.tablero[casillaIA] = 2;
                        TODOSBOTONES[casillaIA].setEnabled(false);
                        if (compruebaGandor()) {
                            return;
                        }
                        pantallaInfo.setText("TURNO DEL JUGADOR 1 (O)");
                        logica_juego.turnoUsuario = 1;//pasamos al turno del siguiente usuario
                    }
                } else {
                    BT8.setBackgroundResource(R.drawable.crucecita);
                    logica_juego.tablero[7] = 2;
                    BT8.setEnabled(false);

                    if (compruebaGandor()) {
                        return;
                    }

                    logica_juego.turnoUsuario = 1;//pasamos al turno del siguiente usuario
                    pantallaInfo.setText("TURNO DEL JUGADOR 1 (O)");
                }
            }
        });


        BT9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (logica_juego.turnoUsuario == 1) {
                    BT9.setBackgroundResource(R.drawable.circulito);
                    logica_juego.tablero[8] = 1;
                    BT9.setEnabled(false);

                    if (compruebaGandor()) {
                        return;
                    }

                    logica_juego.turnoUsuario = 2;//pasamos al turno del siguiente usuario

                    if (logica_juego.multijuador) {

                        pantallaInfo.setText("TURNO DEL JUGADOR 2 (X)");
                    } else {

                        pantallaInfo.setText("PENSANDO...");
                        //int casillaIA = logica_juego.movimientoMaquinaIA();
                        int casillaIA = inteligenciaArtificial.movimiento(logica_juego.tablero);


                        TODOSBOTONES[casillaIA].setBackgroundResource(R.drawable.crucecita);
                        logica_juego.tablero[casillaIA] = 2;
                        TODOSBOTONES[casillaIA].setEnabled(false);
                        if (compruebaGandor()) {
                            return;
                        }
                        pantallaInfo.setText("TURNO DEL JUGADOR 1 (O)");
                        logica_juego.turnoUsuario = 1;//pasamos al turno del siguiente usuario
                    }
                } else {
                    BT9.setBackgroundResource(R.drawable.crucecita);
                    logica_juego.tablero[8] = 2;
                    BT9.setEnabled(false);

                    if (compruebaGandor()) {
                        return;
                    }

                    logica_juego.turnoUsuario = 1;//pasamos al turno del siguiente usuario
                    pantallaInfo.setText("TURNO DEL JUGADOR 1 (O)");
                }
            }
        });
    }


    //listener del boton resetear
    public void reset(View view) {

        Toast.makeText(getApplicationContext(),"Juego reseteado.", Toast.LENGTH_SHORT).show();

        //reseteamos el tablero
        logica_juego.tablero[0] = logica_juego.tablero[1] = logica_juego.tablero[2] = logica_juego.tablero[3] = logica_juego.tablero[4] = logica_juego.tablero[5] = logica_juego.tablero[6] = logica_juego.tablero[7] = logica_juego.tablero[8] = 0;

        //ponemos el turno inicial como turno del jugador 1
        logica_juego.turnoUsuario = 1;

        //restauramos el fondo inicial de los botones para volver a jugar
        fondoInicialBotones(BT1, BT2, BT3, BT4, BT5, BT6, BT7, BT8, BT9);

        //volvemos a activar todos los botones
        BT1.setEnabled(true);
        BT2.setEnabled(true);
        BT3.setEnabled(true);
        BT4.setEnabled(true);
        BT5.setEnabled(true);
        BT6.setEnabled(true);
        BT7.setEnabled(true);
        BT8.setEnabled(true);
        BT9.setEnabled(true);

        pantallaInfo.setText("COMIENZA EL JUEGO JUGADOR 1 (O)");
    }


    private void fondoInicialBotones(Button BT1, Button BT2, Button BT3, Button BT4, Button BT5, Button BT6, Button BT7, Button BT8, Button BT9) {

        BT1.setBackgroundResource(android.R.drawable.btn_default);
        BT2.setBackgroundResource(android.R.drawable.btn_default);
        BT3.setBackgroundResource(android.R.drawable.btn_default);
        BT4.setBackgroundResource(android.R.drawable.btn_default);
        BT5.setBackgroundResource(android.R.drawable.btn_default);
        BT6.setBackgroundResource(android.R.drawable.btn_default);
        BT7.setBackgroundResource(android.R.drawable.btn_default);
        BT8.setBackgroundResource(android.R.drawable.btn_default);
        BT9.setBackgroundResource(android.R.drawable.btn_default);
    }

    private boolean compruebaGandor() {

        boolean empate = logica_juego.hasEmpatado(logica_juego.tablero);

        if (logica_juego.hasGanado(logica_juego.tablero, logica_juego.turnoUsuario) || empate ) {

            if (empate){
                pantallaInfo.setText("¡¡¡EMPATE. NINGÚN JUGADOR HA PODIDO GANAR!!!");
            }else {
                pantallaInfo.setText("¡¡¡EL JUGADOR " + logica_juego.turnoUsuario + " HA GANADO!!!");
            }

            BT1.setEnabled(false);
            BT2.setEnabled(false);
            BT3.setEnabled(false);
            BT4.setEnabled(false);
            BT5.setEnabled(false);
            BT6.setEnabled(false);
            BT7.setEnabled(false);
            BT8.setEnabled(false);
            BT9.setEnabled(false);

            logica_juego.alternaIA_Random=false;//reseteamos la variable de IA

            return true;
        } else {
            return false;
        }


    }


}
