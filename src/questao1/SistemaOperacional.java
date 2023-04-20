package questao1;

import classes.GenericQueue;

public class SistemaOperacional {

    private GenericQueue<Processo> filaDeProcessos;

    public SistemaOperacional(int nProcessos) {
        filaDeProcessos = new GenericQueue<>(nProcessos);
    }

    public boolean inserirProcesso(Processo processo) {
        return filaDeProcessos.insert(processo);
    }

    public Processo encerrarProcesso() {
        return filaDeProcessos.remove();
    }

    @Override
    public String toString() {
        return filaDeProcessos.toString();
    }
}
