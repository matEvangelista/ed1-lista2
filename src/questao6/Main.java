package questao6;

import classes.FilaDupla;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número (não muito grande, de preferência): ");
        int num = scanner.nextInt();
        int digitos = numeroAlgarismos(num, 0);
        FilaDupla filaDupla = new FilaDupla(numeroAlgarismos(num, 0));
        filaDupla.insere(0); // naturalmente
        for (int i = 0; i < num; i++) {
            filaDupla = soma1(filaDupla);
            System.out.printf("%d: %s\n", i + 1, filaDupla); // uso do toString
        }
        /*
        FilaDupla resultado = new FilaDupla(filaDupla.getTamanho()); // apenas para inicializar
        for (int i = 0; i < num; i++) {
            resultado = soma1(filaDupla, resultado, 1);
            System.out.printf("%d: %s\n", i, resultado); // uso do toString
        }*/

    }

    // número de algarismos que o número em decimal tem em binário
    public static int numeroAlgarismos(int num, int contador) {
        if (num == 0)
            return contador;
        return numeroAlgarismos(num / 2, ++contador);
    }

    // tentando com recursividade
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

    // soma 1. Anda com a fila dupla, se necessário
    public static FilaDupla soma1(FilaDupla filaDupla) {

        int carry = 1; // como sempre se soma 1, o carry começa com um
        FilaDupla  resultado = new FilaDupla(filaDupla.getTamanho()); // objeto em que serão colocados os dígitos de solução
        while (!filaDupla.vazia()) {
            int soma = carry + filaDupla.removeFim();
            if (soma == 1) {
                resultado.insereInicio(1);
                carry = 0;
            } else if (soma == 2) {
                resultado.insereInicio(0);
                carry = 1;
            }
            // caso em que soma = 0
            else {
                resultado.insereInicio(0);
                carry = 0;
            }
        }
        if (carry == 1)
            resultado.insereInicio(1);

        return resultado;

    }

}
