package questao6;

import classes.Fila;
import classes.FilaDupla;

public class Main {
    public static void main(String[] args) {
        System.out.println(numeroAlgarismos(16, 0));
    }

    // número de algarismos que o número em decimal tem em binário
    public static int numeroAlgarismos(int num, int contador) {
        if (num == 0)
            return contador;
        return numeroAlgarismos(num / 2, ++contador);
    }

    // vou reaproveitar o método estático da questão 4

}
