package questao2;

public class Fila {
    /* Atributos protected para serem usados na subclasse. */
    protected int tamanho;    /* Tamanho do vetor */
    protected int[] vetor;    /* Vetor de elementos */
    protected int ini;    /* Posicao do proximo elemento a ser retirado */
    protected int n;    /* Numero de elementos na fila */

    public Fila(int tam) {
        tamanho = tam;
        vetor = new int[tamanho];
        ini = 0;
        n = 0;
    }

    public boolean vazia() {
        return (n == 0);
    }

    public boolean cheia() {
        return (n == tamanho);
    }

    //Retiramos o elemento do in�cio da fila
    public int remove() {
        int elemento = Integer.MIN_VALUE;

        if (!this.vazia()) {
            elemento = vetor[ini];
            ini = (ini + 1) % tamanho;
            n--;
        }

        return elemento;
    }

    //Inserimos o elemento no final da fila
    public boolean insere(int elemento) {
        int fim;

        if (!cheia()) {
            fim = (ini + n) % tamanho;
            vetor[fim] = elemento;
            n++;
            return true;
        } else
            return false;
    }

    public void combinaFilas(Fila f1, Fila f2) {
        // enquanto as duas filas não estiverem vazias
        while (!(f1.vazia() && f2.vazia())) {
            int temp1 = f1.remove();
            int temp2 = f2.remove();
            // valor de controle definido pelo professor
            if (temp1 != Integer.MIN_VALUE)
                insere(temp1);
            if (temp2 != Integer.MIN_VALUE)
                insere(temp2);
        }
    }
}