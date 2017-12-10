package com.example.carlos.tresenraya;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Carlos on 08/12/2017.
 */

public class logica_juego extends Activity {

    public static int[] tablero = new int[9];

    public static int turnoUsuario = 1;


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

    private static void resetearTablero(int[] tablero) {

        //reseteamos el tablero
        tablero[0] = tablero[1] = tablero[2] = tablero[3] = tablero[4] = tablero[5] = tablero[6] = tablero[7] = tablero[8] = 0;

    }


    public static int movimientoMaquina (){
        int casillaElegida;

        do {
            casillaElegida = new Random().nextInt(9);

        }while(tablero[casillaElegida]== 1 || tablero[casillaElegida]== 2);

    return casillaElegida;
    }

}
