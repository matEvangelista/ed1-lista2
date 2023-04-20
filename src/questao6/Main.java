package questao6;

import classes.FilaDupla;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número (não muito grande, de preferência): ");
        int num = scanner.nextInt();

        FilaDupla filaDupla = new FilaDupla(numeroAlgarismos(num, 0));
        filaDupla.insere(0); // naturalmente

        for (int i = 0; i < num; i++) {
            filaDupla = soma1(filaDupla, new FilaDupla(filaDupla.getTamanho()), 1);
            System.out.printf("%d: %s\n", i + 1, filaDupla); // uso do toString
        }
    }

    // número de algarismos que o número em decimal tem em binário
    public static int numeroAlgarismos(int num, int contador) {
        if (num == 0)
            return contador;
        return numeroAlgarismos(num / 2, ++contador);
    }

    public static FilaDupla soma1(FilaDupla filaDupla, FilaDupla resultado, int carry) {
        if (filaDupla.vazia()) {
            if (carry == 1)
                resultado.insereInicio(1);
            return resultado;
        }
        int soma = carry + filaDupla.removeFim();
        if (soma == 1) {
            resultado.insereInicio(1);
            carry = 0;
        } else if (soma == 2) {
            resultado.insereInicio(0);
            carry = 1;
        } else {
            resultado.insereInicio(0);
            carry = 0;
        }
        return soma1(filaDupla, resultado, carry);

    }


}
