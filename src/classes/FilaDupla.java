package classes;

public class FilaDupla extends Fila {
    public FilaDupla(int tam) {
        super(tam);
    }

    public boolean insereInicio(int elemento) {
        int prec;

        if (!cheia()) {
            /* Insere na posi��o precedente ao in�cio */
            prec = (ini - 1 + tamanho) % tamanho;
            vetor[prec] = elemento;
            ini = prec; /* Atualiza �ndice para in�cio */
            n++;
            return true;
        } else
            return false;
    }

    public int removeFim() {
        int elemento = Integer.MIN_VALUE;
        int ult;

        if (!this.vazia()) {
            /* Retira o �ltimo elemento */
            ult = (ini + n - 1) % tamanho;
            elemento = vetor[ult];
            n--;
        }

        return elemento;
    }

    // vai ser usado na questão 6
    @Override
    public String toString() {
        FilaDupla filaDupla = new FilaDupla(this.getTamanho());
        String string = "";
        while (!vazia()) {
            int temp = remove();
            filaDupla.insere(temp);
            string += temp;
        }
        while (!filaDupla.vazia())
            insere(filaDupla.remove());
        return string;
    }
}
