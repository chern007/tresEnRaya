package com.example.carlos.tresenraya;

/**
 * Created by Carlos on 11/12/2017.
 */



public class IA {

    public static int tiradas = 0;

    /*Árboles para los movimientos del Triqui.*/
    class Casilla {

        /*Mejor movimiento.*/
        int mejorMovimiento;
        /*Nodos hijos.*/
        Casilla nodos[];
        /*Tablero del juego.*/
        public int tablero[];
        /*Turno de la computadora.*/
        boolean miTurno = false;
        /*Indice de la pocision.*/
        int indice;
        /*Ganador.*/
        int ganador = 0;

        /*Constructor.*/
        Casilla() {

            /*Inicializamos las variables.*/
            tablero = new int[9];

        }
    }
    /*Raíz del árbol*/
    Casilla arbol = new Casilla();
    /*Atributos.*/
    int[] tablero;
    /*Mi ficha.*/
    public final int miFICHA = 2;

    /*Método que nos devuelve los espacios disponibles.*/
    public int movDisponibles(int[] tablero) {
        int mov = 0;

        for (int i = 0; i < 9; i++) {
            if (tablero[i] == 0) {
                mov++;
            }
        }

        return mov;
    }

    /*Método que nos devuelve los indices del tablero de las pocisiones vacías.*/
    public int[] posVacias(int[] tablero) {
        /*Creamos el vector con los índices.*/
        int[] indices = new int[movDisponibles(tablero)];
        int indice = 0;

        /*Recorremos y guardamos los indices.*/
        for (int i = 0; i < 9; i++) {
            if (tablero[i] == 0) {
                indices[indice] = i;
                indice++;
            }
        }
        return indices;
    }

    /*Metodo que recibe el tablero actual.*/
    public int movimiento(int[] tablero) {
        /*Asignamos el tablero.*/
        this.tablero = tablero;
        tiradas++;

        /*Copiamos el tablero a nuestro nodo raíz.*/
        for (int i = 0; i < 9; i++) {
            this.arbol.tablero[i] = this.tablero[i];
        }

        /*Calcular el mejor movimiento del árbol, desde las hojas hasta la raiz.*/
        movComputadora(arbol);

        /*Devuelve el mejor movimiento.*/
        return arbol.mejorMovimiento;
    }

    //metodo recursivo, generará tantos nodos hijo por cada nodo padre como movimientos disponibles haya
    public void movComputadora(Casilla raiz) {

        //calculamos el numero de movimientos que podemos realizar
        int movimientos = movDisponibles(raiz.tablero);
        //hallamos las posiciones donde se presenta el valor 0 (celda vacia)
        int indices[] = posVacias(raiz.tablero);
        int Max, Min;


        //creamos un nodo hijo por cada posible movimiento y lo metemos en el atributo nodo del nodo padre
        //mas abajo los inicializaremos si no hay ganadores
        raiz.nodos = new Casilla[movimientos];

        //comprobamos si en esta iteracion hay ya ganador
        int ganador = terminado(raiz.tablero);
        if (ganador == 1) {
            ganador = -1;
        } else if (ganador == 2) {
            ganador = 1;
        }

        //vemos si hemos llegado a la ultima iteracion y comprobamos si hay ganador
        if (ganador != 0 || movimientos == 0) {
            raiz.ganador = ganador;

            //en el caso de que no estemos en caso de empate y no haya ganador aun
        } else {

            /*Crea los datos de cada hijo.*/
            for (int i = 0; i < movimientos; i++) {

                /*Inicializa los nodos hijos del árbol.*/
                raiz.nodos[i] = new Casilla();

                //le pasamos el tablero al nuevo nodo hijo (uno por cada hijo)
                for (int j = 0; j < 9; j++) {
                    raiz.nodos[i].tablero[j] = raiz.tablero[j];
                }

                //por cada nodo probamos una posicion => SON LAS DIFERENTES OPCIONES QUE EXISTEN
                if (raiz.miTurno) {
                    raiz.nodos[i].tablero[indices[i]] = 1;// ficha (O)
                } else {
                    raiz.nodos[i].tablero[indices[i]] = 2;// ficha (X)
                }

                //cambiamos de turno en los nodos hijos
                raiz.nodos[i].miTurno = !raiz.miTurno;


                //guarda la casilla que ha marcado este jugador
                raiz.nodos[i].indice = indices[i];

                //Volvemos a llamar a la misma funcion para que examine los hijos del hijo
                movComputadora(raiz.nodos[i]);

            }

            /*Minimax*/
            if (!raiz.miTurno) {
                raiz.ganador = Max(raiz);
            } else {
                raiz.ganador = Min(raiz);
            }

        }

    }

    /*Método que calcula el MÁXIMO de los nodos hijos de MIN*/
    public int Max(Casilla raiz) {
        int Max = -111;
        /*Máximo para la computadora, buscamos el valor donde gane.*/
        for (int i = 0; i < raiz.nodos.length; i++) {
            /*Preguntamos por un nodo con un valor alto MAX*/
            if (raiz.nodos[i].ganador > Max) {
                /*Lo asignamos y pasamos el mejor movimiento a la raíz.*/
                Max = raiz.nodos[i].ganador;
                raiz.mejorMovimiento = raiz.nodos[i].indice;
                /*Terminamos de buscar.*/
                if (Max == 1) {
                    break;
                }
            }
        }

        /*Borramos los nodos.*/
        raiz.nodos = null;
        return Max;
    }

    /*Método que calcula el MÍNIMO de los nodos hijos de MAX.*/
    public int Min(Casilla raiz) {
        int Min = 111;

        /*Mínimo para el jugador*/
        for (int i = 0; i < raiz.nodos.length; i++) {
            if (raiz.nodos[i].ganador < Min) {
                Min = raiz.nodos[i].ganador;
                raiz.mejorMovimiento = raiz.nodos[i].indice;
                if (Min == -1) {
                    break;
                }
            }
        }
        // Borra Los Nodos
        raiz.nodos = null;
        return Min;
    }

    /*Método que dice si el juego está terminado.*/
    /*Regresa 0 si nadie gana, 1 si gana jugador 1 y 2 si gana jugador 2*/
    public int terminado(int[] tablero) {
        /*Comprobamos si el juego terminó.*/



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

//    /*Método si gana la computadora.*/
//    public boolean puedoGanar(int[] tablero) {
//        return terminado(tablero) == 2;
//    }
//
//    /*Método pierde computadora.*/
//    public boolean puedoPerder(int[] tablero) {
//        return terminado(tablero) == 1;
//    }
//
//    /*Mëtodo que imprime un vector como un Triqui. xD*/
//    public void imprime(int[] triqui) {
//        for (int i = 0; i < 9; i++) {
//            System.out.print(triqui[i] + "");
//            if (i == 2 || i == 5) {
//                System.out.println();
//            }
//        }
//
//        System.out.println("\r\n");
//    }
}
