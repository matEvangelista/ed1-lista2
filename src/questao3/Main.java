package questao3;

/*
 * Vou usar as classes GenericQueue e PilhaGenerica para fazer esta questão.
 * Os objetos utilizados no exemplo são instâncias de String, mas também funcionam com qualquer outra classe
 * Os arrays na main são apenas para facilitar, não serão usados para outra coisa além de armazenar as strings
 */

import classes.GenericQueue;
import classes.PilhaGenerica;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // serão utilizados para fila de pilhas e pilha de pilhas
        String[] array1 = {"Miles Davis", "John Coltrane", "Billie Holliday"};
        String[] array2 = {"John Petrucci", "Jimi Hendrix", "Steve Vai", "Wes Montgomery"};
        String[] array3 = {"Milton Nascimento", "João Gilberto"};

        // serão utilizados para fila de filas e pilha de filas
        String[] array4 = {"Machado de Assis", "Lima Barreto", "Ruy Castro"};
        String[] array5 = {"Jane Austen", "José Saramago"};
        String[] array6 = {"Mateus", "Marcos", "Lucas", "João"};


        // Fila de pilhas
        GenericQueue<PilhaGenerica> filaDePilhas = new GenericQueue<>(3);
        filaDePilhas.insert(pilhaDeString(array1));
        filaDePilhas.insert(pilhaDeString(array2));
        filaDePilhas.insert(pilhaDeString(array3));
        System.out.println("Fila de pilhas. Cada linha representa um elemento da fila, que" +
                " separa seus elementos por uma vírgula dentro de uma mesma linha");
        System.out.println(filaDePilhas + "\n");
        System.out.println("Removendo a primeira pilha da fila...");
        filaDePilhas.remove();
        System.out.println(filaDePilhas + "\n\n");

        // Fila de filas
        System.out.println("Fila de filas. Cada fila termina com um ponto.");
        GenericQueue<GenericQueue<String>> filaDeFilas = new GenericQueue<>(3);
        filaDeFilas.insert(filaDeStrings(array4));
        filaDeFilas.insert(filaDeStrings(array5));
        filaDeFilas.insert(filaDeStrings(array6));
        System.out.println(filaDeFilas);
        System.out.println("\n" + "Removendo a primeira fila da fila...");
        filaDeFilas.remove();
        System.out.println(filaDeFilas);

        //Pilha de pilhas;
        System.out.println("\n\nPilha de pilhas. Cada pilha termina com um ponto.");
        PilhaGenerica<PilhaGenerica<String>> pilhaDePilhas = new PilhaGenerica<>(3);
        pilhaDePilhas.push(pilhaDeString(array1));
        pilhaDePilhas.push(pilhaDeString(array2));
        pilhaDePilhas.push(pilhaDeString(array3));
        System.out.println(pilhaDePilhas);
        System.out.println("\nRemovendo a última pilha da pilha...");
        pilhaDePilhas.pop();
        System.out.println(pilhaDePilhas);

        // pilha de filas
        System.out.println("\n\nPilha de filas. Cada pilha termina com um ponto, cada fila fica entre dois pontos");
        PilhaGenerica<GenericQueue<String>> pilhaDeFilas = new PilhaGenerica<>(3);
        pilhaDeFilas.push(filaDeStrings(array4));
        pilhaDeFilas.push(filaDeStrings(array5));
        pilhaDeFilas.push(filaDeStrings(array6));
        System.out.println(pilhaDeFilas);
        System.out.println("\nRemovendo a última fila da pilha...");
        pilhaDeFilas.pop();
        System.out.println(pilhaDeFilas);

    }

    // vou gerar pilhas e filas aqui para não poluir a main

    /* pilha normal, será usada como fila de pilhas e pilha de pilhas
       Apenas coloca os elementos de um array numa pilha*/
    public static PilhaGenerica<String> pilhaDeString(String[] strings) {
        PilhaGenerica<String> pilhaGenerica = new PilhaGenerica<>(strings.length);
        for (String string : strings)
            pilhaGenerica.push(string);
        return pilhaGenerica;
    }

    /*Será usado para exemplificar pilha de filas e fila de filas
      Apenas coloca os elementos de um array numa pilha*/
    public static GenericQueue<String> filaDeStrings(String[] strings) {
        GenericQueue<String> filaGenerica = new GenericQueue<>(strings.length);
        for (String string : strings)
            filaGenerica.insert(string);
        return filaGenerica;
    }

    /* como java não aceita arrays de T, seria necessário colocar em um arrayList.
     * só estou colocando como exemplo para mostrar como seria feita uma pilha de qualquer classe,
     * apesar de ter exemplificado apenas com String
    */
    public static <T> PilhaGenerica<T> pilhaDeGenerics(ArrayList<T> arrayList) {
        PilhaGenerica<T> pilhaGenerica = new PilhaGenerica<>(arrayList.size());
        for (T t : arrayList)
            pilhaGenerica.push(t);
        return pilhaGenerica;
    }

    // mesma explicação
    public static <T> GenericQueue<T> filaDeGenerics(ArrayList<T> arrayList) {
        GenericQueue<T> filaGenerica = new GenericQueue<>(arrayList.size());
        for (T t : arrayList)
            filaGenerica.insert(t);
        return filaGenerica;
    }

}
