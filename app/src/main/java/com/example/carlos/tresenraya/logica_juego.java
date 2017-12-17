package com.example.carlos.tresenraya;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Carlos on 08/12/2017.
 */

public class logica_juego extends Activity {

    public static int[] tablero = new int[9];

    public static int turnoUsuario = 1;

    public static boolean multijuador = false;

   public static boolean alternaIA_Random;//true=> IA ; false=> Random

    //funcion que comprobara si ha ganado el ususario en curso
    public static boolean hasGanado(int[] tablero, int valorUsuario) {

        if (tablero[0] == valorUsuario && tablero[1] == valorUsuario && tablero[2] == valorUsuario) {
            resetearTablero(tablero);
            return true;
        } else if (tablero[0] == valorUsuario && tablero[1] == valorUsuario && tablero[2] == valorUsuario) {
            resetearTablero(tablero);
            return true;
        } else if (tablero[3] == valorUsuario && tablero[4] == valorUsuario && tablero[5] == valorUsuario) {
            resetearTablero(tablero);
            return true;
        } else if (tablero[6] == valorUsuario && tablero[7] == valorUsuario && tablero[8] == valorUsuario) {
            resetearTablero(tablero);
            return true;
        } else if (tablero[0] == valorUsuario && tablero[3] == valorUsuario && tablero[6] == valorUsuario) {
            resetearTablero(tablero);
            return true;
        } else if (tablero[1] == valorUsuario && tablero[4] == valorUsuario && tablero[7] == valorUsuario) {
            resetearTablero(tablero);
            return true;
        } else if (tablero[2] == valorUsuario && tablero[5] == valorUsuario && tablero[8] == valorUsuario) {
            resetearTablero(tablero);
            return true;
        } else if (tablero[0] == valorUsuario && tablero[4] == valorUsuario && tablero[8] == valorUsuario) {
            resetearTablero(tablero);
            return true;
        } else if (tablero[2] == valorUsuario && tablero[4] == valorUsuario && tablero[6] == valorUsuario) {
            resetearTablero(tablero);
            return true;
        } else {
            return false;
        }

    }

    //funcion que comprobará si ha ganado el ususario en curso
    public static boolean hasEmpatado(int[] tablero) {

        //vemos si solo quedan dos casillas sin rellenar
        int casillasLibres = 0;
        for (int casilla : tablero) {
            if (casilla == 0) {
                casillasLibres++;
            }
        }


        List<int[]> combinacionesGanadoras = new ArrayList<int[]>();

        int[] combinacion1 = {tablero[0], tablero[1], tablero[2]};
        int[] combinacion2 = {tablero[3], tablero[4], tablero[5]};
        int[] combinacion3 = {tablero[6], tablero[7], tablero[8]};
        int[] combinacion4 = {tablero[0], tablero[3], tablero[6]};
        int[] combinacion5 = {tablero[1], tablero[4], tablero[7]};
        int[] combinacion6 = {tablero[2], tablero[5], tablero[8]};
        int[] combinacion7 = {tablero[0], tablero[4], tablero[8]};
        int[] combinacion8 = {tablero[2], tablero[4], tablero[6]};

        combinacionesGanadoras.add(combinacion1);
        combinacionesGanadoras.add(combinacion2);
        combinacionesGanadoras.add(combinacion3);
        combinacionesGanadoras.add(combinacion4);
        combinacionesGanadoras.add(combinacion5);
        combinacionesGanadoras.add(combinacion6);
        combinacionesGanadoras.add(combinacion7);
        combinacionesGanadoras.add(combinacion8);

        List<Boolean> alertas = new ArrayList<>();


        boolean combinacionDescartada;
        boolean hayX;
        boolean hayO;
        int casillasMarcadas;

        for (int[] combi : combinacionesGanadoras) {


            combinacionDescartada = false;
            hayX = false;
            hayO = false;
            casillasMarcadas=0;


            for (int i = 0; i < 3; i++) {

                int valor = combi[i];

                if (valor != 0) {

                    casillasMarcadas ++;//sumamos una casilla que esta marcada

                    if (valor == 1) {
                        hayX = true;
                    } else {
                        hayO = true;
                    }
                }
            }

            //si en la combinacion ganadora se presentan los dos tipos de ficha, se descarta


            if ((casillasLibres == 1 && casillasMarcadas==2 && hayO==false) || (casillasLibres == 1 && casillasMarcadas==2 && hayX==false)) {

                combinacionDescartada = true;

            } else if ((casillasLibres == 2 && casillasMarcadas==1)) {

                combinacionDescartada = true;

            } else if (hayX && hayO) {

                combinacionDescartada = true;

            }

            alertas.add(combinacionDescartada);
        }


        if (alertas.get(0) && alertas.get(1) && alertas.get(2) && alertas.get(3) && alertas.get(4) && alertas.get(5) && alertas.get(6) && alertas.get(7)) {
            resetearTablero(tablero);
            return true;
        } else {
            return false;
        }

    }

    private static void resetearTablero(int[] tablero) {

        //reseteamos el tablero
        tablero[0] = tablero[1] = tablero[2] = tablero[3] = tablero[4] = tablero[5] = tablero[6] = tablero[7] = tablero[8] = 0;

    }





}
