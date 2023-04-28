package questao6;

import classes.FilaDupla;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número (não muito grande, de preferência): ");
        int num = scanner.nextInt();

        FilaDupla filaDupla = new FilaDupla(numeroAlgarismos(num));
        filaDupla.insere(0); // naturalmente

        for (int i = 0; i < num; i++) {
            filaDupla = soma1(filaDupla);
            System.out.printf("%d: %s\n", i + 1, filaDupla); // uso do toString
        }
    }

    // número de entradas que o número em decimal tem em binário
    public static int numeroAlgarismos(int num) {
        int contador = 0;
        while (num > 0) {
            num /= 2;
            contador++;
        }
        return contador;
    }

    public static FilaDupla soma1(FilaDupla filaDupla, FilaDupla resultado, int carry) {
        if (filaDupla.vazia()) {
            if (carry == 1) resultado.insereInicio(1); // Se sobrou algum número 1 da soma. Por ex: 1111 + 1
            return resultado;
        }
        int soma = carry + filaDupla.removeFim();
        if (soma == 1) {
            resultado.insereInicio(1);
            carry = 0;
        } else if (soma == 2) {
            resultado.insereInicio(0);
            carry = 1;
        } else { // soma == 0
            resultado.insereInicio(0);
            carry = 0;
        }
        return soma1(filaDupla, resultado, carry);

    }

    public static FilaDupla soma1(FilaDupla filaDupla) {
        return soma1(filaDupla, new FilaDupla(filaDupla.getTamanho()), 1);
    }

}
