package questao5;

import classes.GenericQueue;

public class FilaLoja {
    private int tamanho; // tamanho máximo da fila para cada grupo de pessoas
    GenericQueue<GenericQueue<Cliente>> filaDeFilas;

    public FilaLoja(int tamanho) {
        filaDeFilas = new GenericQueue<>(2);
        filaDeFilas.insert(new GenericQueue<>(tamanho)); // número máximo de pessoas na fila de idosos
        filaDeFilas.insert(new GenericQueue<>(tamanho)); // na fila de pessoas
    }

    public boolean inserePessoa(Cliente cliente) {
        boolean resultado = false; // apenas inicializando
        GenericQueue<Cliente> filaIdoso = filaDeFilas.remove();
        GenericQueue<Cliente> filaAdulto = filaDeFilas.remove();

        if (cliente.isIdoso() && !filaIdoso.isFull()) {
            filaIdoso.insert(cliente);
            resultado = true;
        }
        else if (!cliente.isIdoso() && !filaAdulto.isFull()) {
            filaAdulto.insert(cliente);
            resultado = true;
        }

        filaDeFilas.insert(filaIdoso);
        filaDeFilas.insert(filaAdulto);

        return resultado;
    }

    // Se a fila anda, retorna true. False caso contrário
    public boolean atendeCliente() {
        boolean resultado = true;
        GenericQueue<Cliente> filaIdosos = filaDeFilas.remove();
        GenericQueue<Cliente> filaAdultos = filaDeFilas.remove();
        if (filaAdultos.isEmpty() && filaAdultos.isEmpty()) // se ambas filas estão vazias
            resultado = false;
        else if (!filaIdosos.isEmpty()) // idosos primeiro
            filaIdosos.remove();
        else filaAdultos.remove();
        filaDeFilas.insert(filaIdosos);
        filaDeFilas.insert(filaAdultos);
        return true;
    }

    @Override
    public String toString() {
        String string = "";
        GenericQueue<Cliente> filaIdoso = filaDeFilas.remove();
        GenericQueue<Cliente> filaAdulto = filaDeFilas.remove();
        string += "Número de idosos: " + filaIdoso.getN() + "\n";
        string += "Número de adultos: " + filaAdulto.getN() + "\n";
        filaDeFilas.insert(filaIdoso);
        filaDeFilas.insert(filaAdulto);
        return string;
    }

    public boolean estaVazia() {
        GenericQueue<Cliente> filaIdoso = filaDeFilas.remove();
        GenericQueue<Cliente> filaAdulto = filaDeFilas.remove();
        boolean vazio = filaAdulto.isEmpty() && filaIdoso.isEmpty();
        filaDeFilas.insert(filaIdoso);
        filaDeFilas.insert(filaAdulto);
        return vazio;
    }
}
