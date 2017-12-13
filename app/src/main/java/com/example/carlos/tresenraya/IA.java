package com.example.carlos.tresenraya;

/**
 * Created by Carlos on 11/12/2017.
 */

//algoritmo recursivo MINMAX

public class IA {

    public static int tiradas = 0;

    //objeto nodo con la info des estado actual del tablero para cada "nodo actual"
    class Casilla {

        //tablero del nodo actual
        public int[] tablero;

        //nodos hijos
        Casilla[] nodos;

        //mejor casilla para marcar
        int mejorMovimiento;

        //guardaremos el numero del jugador que gana
        int ganador = 0;

        //estado del turno de la máquia
        boolean miTurno = false;

        //indice de la posicion (0-8)
        int indice;


        //constructor
        Casilla() {

            //iniciamos el array de int que forman el tablero
            tablero = new int[9];

        }
    }

    //nodo INICIAL del arbol
    Casilla arbol = new Casilla();

    //tablero INICIAL
    int[] tablero;

    //ficha jugador
    public final int miFICHA = 2;

    //metodo que retorna el numero de casillas sin marcar
    public int movDisponibles(int[] tablero) {
        int mov = 0;

        for (int i = 0; i < 9; i++) {
            if (tablero[i] == 0) {
                mov++;
            }
        }

        return mov;
    }

    //Método que nos devuelve un array con las posiciones del tablero que no estan marcadas
    public int[] posVacias(int[] tablero) {
        //iniciamos el array de indices del tablero
        int[] indices = new int[movDisponibles(tablero)];
        int indice = 0;

        //recorremos y guardamos los indices que no están marcados con 1 o 2
        for (int i = 0; i < 9; i++) {
            if (tablero[i] == 0) {
                indices[indice] = i;
                indice++;
            }
        }
        return indices;
    }

    //METODO PRINCIPAL QUE NOS DEVOLVERA PA POSICION OPTIMA
    public int movimiento(int[] tablero) {
        //asignamos el tablero
        this.tablero = tablero;
        tiradas++;

        //asignamos los valores del indice de tablero del nodo INICIAL
        for (int i = 0; i < 9; i++) {
            this.arbol.tablero[i] = this.tablero[i];
        }

        //llamamos al metodo recursivo que calcula la mejor posicion
        movComputadora(arbol);

        //devolvemos la mejor posicion
        return arbol.mejorMovimiento;
    }

    //metodo recursivo, generará tantos nodos hijo por cada nodo padre como movimientos disponibles haya
    public void movComputadora(Casilla actual) {

        //calculamos el numero de movimientos que podemos realizar
        int movimientos = movDisponibles(actual.tablero);
        //hallamos las posiciones donde se presenta el valor 0 (celda vacia)
        int[] indices = posVacias(actual.tablero);
        int Max, Min;


        //creamos un nodo hijo por cada posible movimiento y lo metemos en el atributo nodo del nodo padre
        //mas abajo los inicializaremos si no hay ganadores
        actual.nodos = new Casilla[movimientos];

        //comprobamos si en esta iteracion hay ya ganador
        int ganador = terminado(actual.tablero);
        if (ganador == 1) {
            ganador = -1;
        } else if (ganador == 2) {
            ganador = 1;
        }

        //vemos si hemos llegado a la ultima iteracion y comprobamos si hay ganador
        if (ganador != 0 || movimientos == 0) {
            actual.ganador = ganador;

            //en el caso de que no estemos en caso de empate y no haya ganador aun
        } else {

            //bucle para asignar las propiedades de cada nodo hijo
            for (int i = 0; i < movimientos; i++) {

                //inicializamos los nodos hijos
                actual.nodos[i] = new Casilla();

                //le pasamos el tablero al nuevo nodo hijo (uno por cada hijo)
                for (int j = 0; j < 9; j++) {
                    actual.nodos[i].tablero[j] = actual.tablero[j];
                }

                //por cada nodo probamos una posicion => SON LAS DIFERENTES OPCIONES QUE EXISTEN
                if (actual.miTurno) {
                    actual.nodos[i].tablero[indices[i]] = 1;// ficha (O) JUGADOR
                } else {
                    actual.nodos[i].tablero[indices[i]] = 2;// ficha (X) MAQUINA
                }

                //cambiamos de turno en los nodos hijos
                actual.nodos[i].miTurno = !actual.miTurno;


                //guarda la casilla que ha marcado este jugador
                actual.nodos[i].indice = indices[i];

                //Volvemos a llamar a la misma funcion para que examine los hijos del hijo (bajamos un nivel del arbol)
                movComputadora(actual.nodos[i]);

            }

            //calculamos el minimo y el maximo de cada escenario alternando los jugadores
            if (!actual.miTurno) {
                actual.ganador = Max(actual);//maquina
            } else {
                actual.ganador = Min(actual);//jugador
            }

        }

    }

    //metodo para calcular el maximo que recogen los nodo hijos del nodo padre
    public int Max(Casilla actual) {
        int MAX = -111;
        //buscamos la puntuacion maxima para el jugador 2 (la máquina)
        for (int i = 0; i < actual.nodos.length; i++) {
            //vemos si mejora al maximo de la iteracion anterior
            if (actual.nodos[i].ganador > MAX) {
                //guardamos la mejor casilla para retornarla y la guardamos en el nodo actual
                MAX = actual.nodos[i].ganador;
                actual.mejorMovimiento = actual.nodos[i].indice;

                if (MAX == 1) {
                    break;
                }
            }
        }

        //borramos los nodos ya que no los vamos a utilizar más
        actual.nodos = null;
        return MAX;
    }

    //metodo para calcular el mínimo que recogen los nodo hijos del nodo padre
    public int Min(Casilla actual) {
        int MIN = 111;

        //buscamos la puntuacion minima para el jugador 1
        for (int i = 0; i < actual.nodos.length; i++) {
            //vemos si empeora al minimo de la iteracion anterior
            if (actual.nodos[i].ganador < MIN) {
                //guardamos la peor casilla para retornarla y la guardamos en el nodo actual
                MIN = actual.nodos[i].ganador;
                actual.mejorMovimiento = actual.nodos[i].indice;
                if (MIN == -1) {
                    break;
                }
            }
        }
        //borramos los nodos ya que no los vamos a utilizar más
        actual.nodos = null;
        return MIN;
    }

    //examina si el juego a terminado y puntua 0 si nadie ha ganado, 1 si gana el jugador en curso y 2 si gana el contrario (MAQUINA)
    public int terminado(int[] tablero) {

        if (tablero[0] == tablero[1] && tablero[0] == tablero[2] && tablero[0] != 0) {
            return tablero[0];
        } else if (tablero[3] == tablero[4] && tablero[3] == tablero[5] && tablero[3] != 0) {
            return tablero[3];
        } else if (tablero[6] == tablero[7] && tablero[6] == tablero[8] && tablero[6] != 0) {
            return tablero[6];
        } else if (tablero[0] == tablero[3] && tablero[0] == tablero[6] && tablero[0] != 0) {
            return tablero[0];
        } else if (tablero[1] == tablero[4] && tablero[1] == tablero[7] && tablero[1] != 0) {
            return tablero[1];
        } else if (tablero[2] == tablero[5] && tablero[2] == tablero[8] && tablero[2] != 0) {
            return tablero[2];
        } else if (tablero[0] == tablero[4] && tablero[0] == tablero[8] && tablero[0] != 0) {
            return tablero[0];
        } else if (tablero[2] == tablero[4] && tablero[2] == tablero[6] && tablero[2] != 0) {
            return tablero[2];
        }
        return 0;
    }


}
