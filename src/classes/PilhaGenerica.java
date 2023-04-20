package classes;

import java.util.Vector;

public class PilhaGenerica<T> {
    private int n;
    private Vector<T> vetor;
    private int topo;

    public PilhaGenerica(int tamanho) {
        n = tamanho;
        vetor = new Vector<T>(tamanho);
        topo = -1;
    }

    public boolean vazia() {
        return topo == -1;
    }

    public boolean cheia() {
        return topo == n - 1;
    }

    public T pop() {
        T elemento;

        if (!this.vazia()) {
            elemento = vetor.get(topo--);
            return elemento;
        } else {
            //Impressão para fins didáticos
            System.out.println("Pilha vazia: pop nao funcionou.");
            return null;
        }
    }

    public boolean push(T elemento) {
        if (!this.cheia()) {
            vetor.add(++topo, elemento);
            return true;
        } else {
            //Impressão para fins did�ticos
            System.out.println("Pilha cheia: push nao funcionou.\n");
            return false;
        }
    }


    // mudei o código aqui. Retorna nulo se a estiver vazio
    public T retornaTopo() {
        T elemento = null;
        if (!this.vazia()) {
            elemento = vetor.get(topo);
        }
        return elemento;
    }

    // novidade também
    public int tamanho() {
        return n;
    }

    // criei este toString() para facilitar o print na questão 3
    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i <= topo; i++)
            string += vetor.get(i) + (i == topo ? "." :", ");
        return string;
    }
    /*
    * O uso estrito de pilha para fazer o toString() envolveria a criação de uma pilha auxiliar,
    * dar pop() em cada elemento da instância em que estamos, dar push desse resultado em na pilha auxiliar,
    * e fazer outro loop como pop na pilha auxiliar, adicionando o resultado à String string e dando push na instância atual
    * */
}